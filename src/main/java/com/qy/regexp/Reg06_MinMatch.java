package com.qy.regexp;

import com.qy.regexp.util.RegUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 非贪婪匹配,最小匹配
 * @author qiaoyan
 * @date 2022年11月10日 15:34:02
 */
@Slf4j
public class Reg06_MinMatch {


    @Test
    public void test(){
        /**
         当此字符紧随任何其他限定符(*、+、？、{n}、{n，}、{n，m})之后时，匹配模式是“非贪心的“。
         “非贪心的“模式匹配搜索到的、尽可能短的字符串，而默认的“贪心的“模式匹配搜索到的、尽可能长的字符串。
         例如，在字符串“oooo“中，“o+？“只匹配单个“o“，而“o+“匹配 所有“o“。
         */
        RegUtils.printResult("o+","aaaaaaoooooooo");
        RegUtils.printResult("o+?","aaaaaaoooooooo");
    }

}
