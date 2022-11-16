package com.qy.regexp;

import com.qy.regexp.util.RegUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Parameter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 分组,捕获,反向引用
 * @author qiaoyan
 * @date 2022年11月10日 15:34:02
 */
@Slf4j
public class Reg08_ReverseReference {


    /**
     问题: 给你一段文本，请你找出所有四个数字连在一起的子串，并且这四个数字要满足
        ①第1位与 第4位相同
        ②第2位与第3位相同，比如1221，5775

     从而引出反向引用
     1。分组
        我们可以用圆括号组成一个比较复杂的匹配模式，那么一个圆括号的部分我们可以看作是一个子表达式(或称为一个分组)。
     2。捕获
        把正则表达式中子表达式/分组匹配的内容，保存到内存中以数字编号或显式命名的组里，方便后面引用，从左向右，以分组的左括号为标志，
        第一个出现的分组 的组号为1，第二个为2，以此类推。组0代表的是整个正则式
     3。反向引用
        圆括号的内容被捕获后，可以在这个括号后被使用，从而写出一个比较实用的匹配模式，这个我们称为反向引用，
        这种引用既可以是在正则表达式内部，也可以是在正则表达式外，内部反向引用 \\分组号，外部反向引用 $分组号
     */

    @Test
    public void matcher1(){
//        1.要匹配两个连续的相同数字：(\\d)\\1
//        2.要匹配五个连续的相同数字：（\\d)\\1{4）
//        3.要匹配个位与千位相同，十位与百位相同的数5225，1551 : (\\d)(\\d)\\2\\1
        /**
         *
         请在字符串中检索商品编号，形式如：12321-333999111这 样的号码，
         要求满足前面是一个五位数，然后一个-号，然后是一个九位数，连续的每三位要相同
         */
        RegUtils.printAllMatch(
                "(\\d)(\\d)\\d\\2\\1-(\\d)\\3{2}(\\d)\\4{2}(\\d)\\5{2}",
                "12321-333999111",
                "22321-333999111",
                "12321-3339991112",
                "12321-333999"
        );
    }

    @Test
    public void matcher2(){
        // 去除结巴语句
        String content = "我我...我是...是是...个..个..个..小..小...小学生";
        /**
         * 思路:
         * 1. 找到连续重复子串,将该串修改为单个  (.)\\1+  结合 外反向引用$1 进行数据替换
         * 2. 需要先去除.符号
         */
        content = content.replace(".","");
        Pattern pattern = Pattern.compile("(.)\\1+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            log.info("匹配到: {}",matcher.group(0));
        }
        String newContent = matcher.replaceAll("$1");
        log.info("newContent: {}",newContent);

        // 支持链式调用
        String newContent2 = Pattern.compile("(.)\\1+")
                .matcher(content)
                .replaceAll("$1");
        log.info("newContent2: {}",newContent2);
    }


}
