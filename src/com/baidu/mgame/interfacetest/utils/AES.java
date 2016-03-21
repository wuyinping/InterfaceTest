package com.baidu.mgame.interfacetest.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 测试用加/解密工具
 */
public class AES {

    // 加密key
    private SecretKey sSecretKey = null;
    // Cipher
    private Cipher sCipher = null;

    // 雷电sdk
    private static final String S_KEY_TRUNDER = "AKlMU89D3FchIkhK";

    // 游戏大厅
    private static final String S_KEY_GAMEHALL = "AKlMU89D3FchIkhK";

    // IOS SDK
    private static final String S_KEY_IOSYY = "L97fYJp1oPbSMV0n";

    // 争霸赛
    private static final String S_KEY_COMPETE = "AKlMU89D3FchIkhK";

    // 初始化对照关系
    public AES(String ios) {
        this(ios, false);
    }

    // 自动化测试使用
    public AES(String sKey, boolean isAuto) {
        String sKeyString = sKey;
        if (!isAuto) {
            if (sKey != null && "ios".equals(sKey)) {
                sKeyString = S_KEY_IOSYY;
            } else {
                sKeyString = S_KEY_COMPETE;
            }
        }

        try {
            /* AES算法 */
            this.sSecretKey = new SecretKeySpec(sKeyString.getBytes("UTF-8"), "AES");// 获得密钥
            /* 获得一个私鈅加密类Cipher，DESede-》AES算法，ECB是加密模式，PKCS5Padding是填充方式 */
            this.sCipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); // AES/CBC/NoPadding
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加密
     *
     * @param message
     * @return
     */
    public String aesEncrypt(String message) {
        String result = "";
        String newResult = "";
        try {
            this.sCipher.init(Cipher.ENCRYPT_MODE, this.sSecretKey);
            byte[] resultBytes = this.sCipher.doFinal(message.getBytes("UTF-8"));
            result = new String(Base64.encode(resultBytes, Base64.DEFAULT));
            newResult = filter(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newResult;
    }

    /**
     * 解密
     *
     * @param message
     * @return
     * @throws Exception
     */
    public String aesDecrypt(String message) {
        String result = "";
        try {
            byte[] messageBytes = Base64.decode(message, Base64.DEFAULT);
            this.sCipher.init(Cipher.DECRYPT_MODE, this.sSecretKey);
            byte[] resultBytes = this.sCipher.doFinal(messageBytes);
            result = new String(resultBytes, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *
     * @param str
     * @return
     */
    public static String filter(String str) {
        String output = "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            int asc = str.charAt(i);
            if (asc != 10 && asc != 13) {
                sb.append(str.subSequence(i, i + 1));
            }
        }
        output = new String(sb);
        return output;
    }

}