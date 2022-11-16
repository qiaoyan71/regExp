package com.qy.regexp.util;

import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class RegUtils {

    /**
     * 全部匹配,返回 TRUE|FALSE
     * @param regex
     * @param contents
     * @author qiaoyan
     * @date 2022年11月11日 15:18:12
     */
    public static void printAllMatch(String regex,String ... contents){
        for (String content : contents) {
            log.info("=========> {}", content);
            log.info("匹配结果: {}",Pattern.matches(regex,content));
        }
    }

    /**
     * 单条目匹配内容
     * @param regex
     * @param content
     * @author qiaoyan
     * @date 2022年11月11日 14:05:36
     */
    public static void printResult(String regex,String content){
        Pattern pattern = Pattern.compile(regex);
        core(pattern,content);
    }

    /**
     * 多条目匹配内容
     * @param regex
     * @param contents
     * @author qiaoyan
     * @date 2022年11月11日 14:05:36
     */
    public static void printResult(String regex,String ... contents){
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < contents.length; i++) {
            core(pattern, contents[i]);
        }
    }

    private static void core(Pattern pattern, String content) {
        log.info("=========> {}", content);
        Matcher matcher = pattern.matcher(content);
        int count = 0;
        while(matcher.find()){
            count++;
            log.info("匹配到:{}",matcher.group(0));
        }
        if(count == 0){
            log.info("未匹配到数据");
        }
    }

    /**
     * 匹配并提取转换数据
     * <pre>
     *     eg:
     *         String msg = "name=xiaohei1,'name'='xiaoxiao2';value:123,text=bbc";
     *         String patternStr = "([\"']?)(?<key>name|value|text)\\1\\s*[=:]\\s*([\"']?)(?<value>[^;,]*)\\3";
     *         String convetMsg = convetMsg(msg, patternStr, (k, v) -> {
     *             switch (k) {
     *                 case "name":
     *                     return "【name】";
     *                 case "value":
     *                     return "【value】";
     *                 default:
     *                     return "【unknown】";
     *             }
     *         });
     * </pre>
     * @param msg           字符串
     * @param patternStr    匹配规则
     * @param function      转换规则
     * @param pairs         自定义 key，value 名称
     * @author qiaoyan
     * @date 2022年11月15日 11:50:50
     * @return java.lang.String
     */
    public static String convetMsg(String msg, String patternStr, BiFunction<String,String,String> function, Pair<String,String> ... pairs){
        Pattern pattern = Pattern.compile(patternStr);
        StringBuffer sb = new StringBuffer();
        Matcher matcher = pattern.matcher(msg);
        while(matcher.find()){
            String group = matcher.group(0);
            log.debug("group:{}",group);
            String keyName = pairs.length != 0 ? pairs[0].getKey() : "key";
            String valueName = pairs.length != 0 ? pairs[0].getValue() : "value";
            String key = matcher.group(keyName);
            String value = matcher.group(valueName);
            String newGroup = new StringBuffer()
                    .append(msg, matcher.start(), matcher.start(valueName))
                    .append(function.apply(key,value))
                    .append(msg, matcher.end(valueName), matcher.end())
                    .toString();
            matcher.appendReplacement(sb,newGroup);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

}
