package com.seth.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @author xunbo.xu
 * @desc
 * @date 18/7/10
 */
public class UuidGenerator {

    /**
     * 生成32位uuid
     * @return
     */
    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    /**
     * 生成随机充值码，数字和字母组成,
     * @param length
     * @return
     */
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();
        // 参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

}
