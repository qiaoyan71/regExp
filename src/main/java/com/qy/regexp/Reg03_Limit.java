package com.qy.regexp;

import com.qy.regexp.util.RegUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 限定符
 * @author qiaoyan
 * @date 2022年11月10日 15:34:02
 */
@Slf4j
public class Reg03_Limit {


    @Test
    public void limit(){
        /**
            用于指定其前面的字符和组合项连续出现的次数
            正则匹配是[贪婪匹配],会尽可能多的匹配出结果
            *   指定字符重复0或n次
            +   指定字符重复1或n次
            ?   指定字符重复0或1次,最多一次
            {n}     只能n个
            {n,m}   只能n->m 个
            {n,}    最少匹配n,正无穷
         */

        String source = "123,,,223,,23";

        RegUtils.printResult("\\d{3,}",source);

        // 贪婪匹配
        RegUtils.printResult("\\d{2,}",source);
    }

    @Test
    public void xml(){
        // 匹配xml数据
        String strs = "xml|data|property";
        String content = "<xml>abc_01</xml><data>data_01</data><xml>abc_03</xml>";
        RegUtils.printResult("<("+ strs +")>(.*?)</\\1>",content);
    }

}
