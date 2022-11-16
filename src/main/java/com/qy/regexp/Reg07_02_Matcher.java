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
public class Reg07_02_Matcher {

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

    /**
     *
     方法及说明
     public int start()
        返回以前四配的初始索引。
     public int start(int group)
        返回在以前的匹配操作期间，由给定组所捕获的子序列的初始索引
     public int end()
        返回最后匹配字符之后的偏移量。
     public int end(int group)
        返回在以前的匹配操作期间，由给定组所捕获子序列的最后字符之后的偏移量。
     public boolean lookingAt()
        尝试将从区域开头开始的输入序列与该模式匹配。
     public boolean find()
        尝试查找与该模式匹配的输入序列的下一个子序列。
     public boolean find(int start)
        重置此匹配器，然后尝试查找匹配该模式、从指定索引开始的输入序列的下一个子序列。
     public boolean matches()
        尝试将整个区域与模式匹配
     public Matcher appendReplacement(StringBuffer sb,String replacement)
        实现非终端添加和替换步骤.
     public StringBuffer appendTail(StringBuffer sb)
        实现终端添加和替换步骤.
     public String replaceAll(String replacement)
        替换模式与给定替换字符串相匹配的输入序列的每个子序列.
     public String replaceFirst(String replacement)
        替换模式与给定替换字符串匹配的输入序列的第一个子序列.
     public static String quoteReplacement(String s)
        返回指定字符串的字面替换字符串.这个方法返回一个字符 串,就像传递给Matcher类的appendReplacement方法一个字面字符串一样工作.
     public Matcher appendReplacement(StringBuffer sb,String replacement)
        实现非终端添加和替换步骤.
     public StringBuffer appendTail(StringBuffer sb)
        实现终端添加和替换步骤.
     */

    @Test
    public void matcher1(){

    }


}
