package com.mine.warriorsservercommon.utils;

import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Security;
import java.util.Arrays;

/**
 * @program: warriors-party
 * @description: 微信小程序解密工具类
 * @author: Mine.Lee
 * @create: 2019-04-04 23:24
 * @version: v1.0
 * @remark: Expect no bugs
 */
public class WeChatUtil {

    private static final String WATERMARK = "watermark";

    private static final String APPID = "appid";

//    public static void main(String[] args) {
//        String appId = "wxb7c62aa0ac017b76";
//        String encryptedData = "2TyewyYpVUWB/Ea7WE8BVo5Gat19XTAnJ3CMwJspzDvOog9/PEqxTfHFWhOc2kjqrktT/8KTkEKDk/6a/HSavB11K5Hf/ktXp+vgVbqOisHD4dn1mRP2HlY1sQ7mtVWI28HbgiELJPJ8cE+xxELsD1jZLm/BrU+kiaa9QV1YhhHtF0ksk98pHBVH7H+x2V6oV1vqU6UHf9qJjYpDRCgfprKhHVYDCLhX38qhFPezcU4VYx/DOkpKIlCfvfvsDvvQiMxOa6Swr1998uVaWDYSqVR6nunl33dMAxETbIRIy3xoeYaSr8BHOTlIuODfbm10+kpbHCsq+lYW0SR9CMsF0p4Hyt282CqwTta6q205kH9azsGmeul3/C4yfbMZNIJ2QhGCSDNEZR55QkmJzmvYgvYj6C1486yzf8+c9Y2lL8kItWe4VXnekqG5rHtHfPAlIrgamKwbUjpVbui5kxOPSt3EK40ILvb+g9eQpKfFI8RMxuC4084jW99zJtzmbUzykWQrNaZUBp94LiGSD8iUJQ==";
//        String sessionKey = "9X4gdkjgjfE2qvj1c1K4Dg==";
//        String iv = "MyGdlWFWAc0gXSWPBPRWEQ==";
//        System.out.println(decrypt(appId, encryptedData, sessionKey, iv));
//    }

    /**
     * 解密数据
     *
     * @return
     * @throws Exception
     */
    public static String decrypt(String appId, String encryptedData, String sessionKey, String iv) {
        String result = "";
        try {
            AES aes = new AES();
            byte[] resultByte = aes.decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(sessionKey), Base64.decodeBase64(iv));
            if (null != resultByte && resultByte.length > 0) {
                result = new String(WxPKCS7Encoder.decode(resultByte));
                JSONObject jsonObject = JSONObject.fromObject(result);
                String decryptAppid = jsonObject.getJSONObject(WATERMARK).getString(APPID);
                if (!appId.equals(decryptAppid)) result = "";
            }
        } catch (Exception e) {
            result = "";
            e.printStackTrace();
        }
        return result;
    }
}

class WxPKCS7Encoder {

    private static final Charset CHARSET = Charset.forName("utf-8");

    private static final int BLOCK_SIZE = 32;

    /**
     * 获得对明文进行补位填充的字节.
     *
     * @param count 需要进行填充补位操作的明文字节个数
     * @return 补齐用的字节数组
     */
    public static byte[] encode(int count) {
        // 计算需要填充的位数
        int amountToPad = BLOCK_SIZE - (count % BLOCK_SIZE);
        if (amountToPad == 0) amountToPad = BLOCK_SIZE;
        // 获得补位所用的字符
        char padChr = chr(amountToPad);
        String tmp = new String();
        for (int index = 0; index < amountToPad; index++) {
            tmp += padChr;
        }
        return tmp.getBytes(CHARSET);
    }

    /**
     * 删除解密后明文的补位字符
     *
     * @param decrypted 解密后的明文
     * @return 删除补位字符后的明文
     */
    public static byte[] decode(byte[] decrypted) {
        int pad = decrypted[decrypted.length - 1];
        if (pad < 1 || pad > 32) pad = 0;
        return Arrays.copyOfRange(decrypted, 0, decrypted.length - pad);
    }

    /**
     * 将数字转化成ASCII码对应的字符，用于对明文进行补码
     *
     * @param a 需要转化的数字
     * @return 转化得到的字符
     */
    public static char chr(int a) {
        byte target = (byte) (a & 0xFF);
        return (char) target;
    }
}

class AES {

    public static boolean initialized = false;

    /**
     * AES解密
     *
     * @param content 密文
     * @return
     * @throws java.security.InvalidAlgorithmParameterException
     * @throws java.security.NoSuchProviderException
     */
    public byte[] decrypt(byte[] content, byte[] keyByte, byte[] ivByte) {
        initialize();
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            Key sKeySpec = new SecretKeySpec(keyByte, "AES");
            cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIV(ivByte));// 初始化
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void initialize() {
        if (initialized) return;
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }

    // 生成iv
    public static AlgorithmParameters generateIV(byte[] iv) throws Exception {
        AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
        params.init(new IvParameterSpec(iv));
        return params;
    }
}
