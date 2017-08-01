package cn.meijunjie.string;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    public static String Md5(String plainText) {
        String str = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5"); //获取MD5加密实例

            md.update(plainText.getBytes()); //获取字节码

            byte b[] = md.digest();
            int i;
            StringBuilder buf = new StringBuilder();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            str = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void  main(String[] args)
    {
        System.out.println(MD5.Md5("hello world"));
    }
}
