package com.qy.regexp;

import com.qy.regexp.util.RegUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String类自带的正则api
 * @author qiaoyan
 * @date 2022年11月10日 15:34:02
 */
@Slf4j
public class Reg09_StringReg {

    @Test
    public void string1(){
        // 完全匹配
        String content = "15811112222";
        log.info("匹配结果: {}",content.matches("1(3|5|6)\\d{9}"));

        // 执行替换 eg: 将连续4个一样的数字替换为0000
        log.info("处理后结果: {}",content.replaceAll("(\\d)\\1{3}", "0000"));

        // 执行分割
        String[] split = content.split("58|12");
        log.info("处理后结果: {}", Arrays.asList(split));
    }

}
