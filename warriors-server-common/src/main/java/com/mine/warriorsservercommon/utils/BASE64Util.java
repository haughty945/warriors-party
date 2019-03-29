package com.mine.warriorsservercommon.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @program: warriors-party
 * @description: base64 编码和解码
 * @author: Mine.Lee
 * @create: 2019/3/29 14:46
 * @version: v1.0
 * @remark: Expect no bugs
 */
public final class BASE64Util {

    /**
     * @description 采用BASE64算法对字符串进行编码
     * @author Mine.Lee
     * @param base 原字符串
     * @create 2019/3/29 14:48
     * @return java.lang.String 加密后的字符串
     */
    public static final String encode(String base) {
        return BASE64Util.encode(base.getBytes());
    }

    /**
     * @description 采用BASE64算法对字节数组进行编码
     * @author Mine.Lee
     * @param baseBuff 原字节数组
     * @create 2019/3/29 14:49
     * @remark ..
     * @return java.lang.String 加密后的字符串
     */
    public static final String encode(byte[] baseBuff) {
        return new BASE64Encoder().encode(baseBuff);
    }

    /**
     * @description 字符串解码，采用BASE64的算法
     * @author Mine.Lee
     * @param: encoder 需要解密的字符串
     * @create 2019/3/29 14:49
     * @remark ..
     * @return java.lang.String 解密后的字符串
     */
    public static final String decode(String encoder) {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] buf = decoder.decodeBuffer(encoder);
            return new String(buf);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
