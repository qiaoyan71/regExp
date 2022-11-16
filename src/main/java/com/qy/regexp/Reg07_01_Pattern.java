package com.qy.regexp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

/**
 * java中3个类 pattern matcher PatternSyntaxException
 * @author qiaoyan
 * @date 2022年11月10日 15:34:02
 */
@Slf4j
public class Reg07_01_Pattern {

    /**
     正则表达式三个常用类 java.util.regex包主要包括以下三个类Pattern类、Matcher类和PatternSyntaxException
     ●Pattern类
         pattern对象是一个正则表达式对象.Pattern类没有公共构造方法.要创建一个Pattern对象,
         调用其公共静态方法,它返回一个Pattern对象.
         该方法接受一个正则表达式作为它的第一个参数,比如:Pattern r = Pattern.compile(pattern);
     ● Matcher类
         Matcher对像是对输入字符串进行解释和匹配的引擎.
         与Pattern类一样,Matcher也没有公共构造方法.你需要调用Pattern对像的matcher方法来获得一个Matcher对象
     ● PatternSyntaxException
        java.util.regex.PatternSyntaxException是一个非强制异常类,它表示一个正则表达式模式中的语法错误.
     */

    @Test
    public void pattern1(){
        // 整体匹配
        // 底层还是用matcher对象
        boolean flag1 = Pattern.matches("hello", "hello world");
        boolean flag2 = Pattern.matches("hello.*", "hello world");
        log.info("flag1:{},flag2:{}",flag1,flag2);
    }

}
