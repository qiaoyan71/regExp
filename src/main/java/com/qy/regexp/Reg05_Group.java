package com.qy.regexp;

import com.qy.regexp.util.RegUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import sun.plugin2.os.windows.Windows;

/**
 * 分组
 * @author qiaoyan
 * @date 2022年11月10日 15:34:02
 */
@Slf4j
public class Reg05_Group {


    @Test
    public void group(){
        /**
         (pattern)
            非命名捕获。捕获匹配的子字符串。
            编号为零的第一个捕获是由[整个正则表达式模式匹配的文本].
            其它捕获结果则根据左括号的顺序从1开始自动编号。

         (?<name>pattern)
            命名捕获。将匹配的子字符串捕获到一个组名称或编号名称中。用于name的字符串不能包含任何标点符号，并且不能以数字开头。
            可以使用单引号替代尖括号，例如 (?'name1') (?<name2>)
            也可以使用编号获取
         */
        RegUtils.printResult("^\\d-[a-z]+$","1-abc");
        RegUtils.printResult("abc\\b","1-abc","abc-123","ac-bc");
    }


    @Test
    public void groupNoCatch1(){
        /**
         (?:pattern)
            非捕获匹配. 不可用 macher.group() 来获取
            不存储供以后使用的匹配。这对于用“or“字符(|)组合模式部件的情况很有用。
            例如， industr(?:y|ies)是比'industry|industries'更经济的表达式。
         */
        RegUtils.printResult("industr(?:y|ies)","this is a industry as a industries");
//        19:45:25.153 [main] INFO com.qy.regexp.RegUtils - =========> this is a industry as a industries
//        19:45:25.156 [main] INFO com.qy.regexp.RegUtils - 匹配到:industry
//        19:45:25.156 [main] INFO com.qy.regexp.RegUtils - 匹配到:industries
    }

    @Test
    public void groupNoCatch2(){
        /**
         (?=pattern)
            非捕获匹配. 不可用 macher.group() 来获取
            例如,Windows(?=95|98|NT|2000)'匹配 "Windows2000"中的"Windows",但不匹配"Windows3.1"中的 "Windows"
         */
        RegUtils.printResult("Windows(?=95|98|NT|2000)","机器1:Windows2000","机器2:Windows3.1");
//        19:44:28.523 [main] INFO com.qy.regexp.RegUtils - =========> 机器1:Windows2000
//        19:44:28.528 [main] INFO com.qy.regexp.RegUtils - 匹配到:Windows
//        19:44:28.528 [main] INFO com.qy.regexp.RegUtils - =========> 机器2:Windows3.1
//        19:44:28.528 [main] INFO com.qy.regexp.RegUtils - 未匹配到数据
    }

    @Test
    public void groupNoCatch3(){
        /**
         (?:pattern)
            非捕获匹配. 不可用 macher.group() 来获取
            该表达式匹配不处于匹配pattern的字符串的起始点的搜索字符串。
            例如，Windows(?!95|98|NT|2000)匹配 “Windows3.1“中的“Windows“，
            但不匹配“Windows2000“中的 ‘Windows“
         */
        RegUtils.printResult("Windows(?!95|98|NT|2000)","机器1:Windows2000","机器2:Windows3.1");
//        19:44:47.682 [main] INFO com.qy.regexp.RegUtils - =========> 机器1:Windows2000
//        19:44:47.688 [main] INFO com.qy.regexp.RegUtils - 未匹配到数据
//        19:44:47.688 [main] INFO com.qy.regexp.RegUtils - =========> 机器2:Windows3.1
//        19:44:47.688 [main] INFO com.qy.regexp.RegUtils - 匹配到:Windows
    }

}
