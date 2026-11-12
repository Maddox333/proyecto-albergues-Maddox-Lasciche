package albergues.persistencia;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Hash de claves con PBKDF2 (decisión DA-06; RNF-01): la base de datos nunca guarda la clave en claro.
 * Formato: pbkdf2$iteraciones$sal$hash, en Base64.
 */
public final class Claves {
    private static final int ITER = 120_000;
    private Claves() { }

    public static String hash(String clave) {
        byte[] sal = new byte[16];
        new SecureRandom().nextBytes(sal);
        return "pbkdf2$" + ITER + "$" + b64(sal) + "$" + b64(derivar(clave, sal, ITER));
    }

    public static boolean verificar(String clave, String guardado) {
        if (guardado == null) return false;
        String[] p = guardado.split("\\$");
        if (p.length != 4 || !p[0].equals("pbkdf2")) return false;
        byte[] esperado = Base64.getDecoder().decode(p[3]);
        byte[] real = derivar(clave, Base64.getDecoder().decode(p[2]), Integer.parseInt(p[1]));
        return java.security.MessageDigest.isEqual(esperado, real);
    }

    private static byte[] derivar(String clave, byte[] sal, int iter) {
        try {
            KeySpec spec = new PBEKeySpec(clave.toCharArray(), sal, iter, 256);
            return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();
        } catch (Exception e) { throw new IllegalStateException(e); }
    }

    private static String b64(byte[] b) { return Base64.getEncoder().encodeToString(b); }

    /** Utilidad para preparar datos iniciales: java albergues.persistencia.Claves &lt;clave&gt; */
    public static void main(String[] args) { System.out.println(hash(args[0])); }
}
