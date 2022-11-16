package com.qy.regexp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符匹配
 * @author qiaoyan
 * @date 2022年11月10日 15:34:02
 */
@Slf4j
public class Reg01_Char {


    @Test
    public void group(){
        String source = "123,,,223,,323";
        Pattern pattern = Pattern.compile("(\\d{3,}),,,(?<g1>\\d{3,})");
        Matcher matcher = pattern.matcher(source);
        while(matcher.find()){
            // group(0) -- 表示匹配到的子串
            log.info("匹配到:{}",matcher.group(0));
            // 后续的每组从1,2,3 ...
            log.info("第一组:{}",matcher.group(1));
            log.info("第二组:{}",matcher.group(2));

            // 使用名称获取
            log.info("第g1组:{}",matcher.group("g1"));
        }
    }


    /**
     * 元字符匹配 - 字符匹配符
     * @author qiaoyan
     * @date 2022年11月10日 15:05:27
     * @throws
     */
    @Test
    public void test02(){
         /*
         \\w    匹配 字母,数组,下划线
         \\W    对\\w取反 [^A-Za-z0-9]
         \\d    匹配数字
         \\D    对\\d取反 [^0-9]
         \\s    匹配空白字符, 空格 或 制表符
         \\S    对\\s取反
         .      匹配处\n之外的所有字符, 仅匹配.需要使用转义 \\.
         */

        /*
         * 1. [a-z]
         * 正则默认区分大小写,如何不区分;
         * (?i)abc      表示abc不区分大小写
         * a(?i)bc      表示bc不区分大小写
         * a((?i)b)c    表示只有b不区分大小写
         * 或者使用     Pattern pattern = Pattern.compile("reg",Pattern.CASE_INSENSITIVE);
         */
        Pattern pattern = Pattern.compile("reg",Pattern.CASE_INSENSITIVE);
    }
}
