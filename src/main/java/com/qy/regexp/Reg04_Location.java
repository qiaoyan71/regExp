package com.qy.regexp;

import com.qy.regexp.util.RegUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 定位符
 * @author qiaoyan
 * @date 2022年11月10日 15:34:02
 */
@Slf4j
public class Reg04_Location {


    @Test
    public void location(){
        /**
            定位符,规定要匹配的字符串出现的位置,比如在字符串的开始还是结束位置
            正则匹配是[贪婪匹配],会尽可能多的匹配出结果
            ^       指定起始字符
            $       指定结束字符          eg: ^\\d-[a-z]+$  以一个数字开头,连接-,并至少1个小写字母结尾
            \\b     匹配目标字符串的边界
            \\B     匹配目标字符串的非边界,与\\b相反
         */
        RegUtils.printResult("^\\d-[a-z]+$","1-abc");

        RegUtils.printResult("abc\\b","1-abc","abc-123","ac-bc");
    }

}
