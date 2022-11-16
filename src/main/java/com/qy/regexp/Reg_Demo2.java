package com.qy.regexp;

import com.qy.regexp.util.RegUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 测试
 * @author qiaoyan
 * @date 2022年11月10日 15:34:02
 */
@Slf4j
public class Reg_Demo2 {

    @Test
    public void test01(){
        // 匹配包含与不包含
        RegUtils.printAllMatch(
                "(a|b|c|d|e|f|g|[^xyz])*",
            "abcd",
                "abc",
                "abcxyz"
        );
    }

    @Test
    public void find(){
        // 提取并替换 key=value | 'key'='value' | key:value | "key":"value" 中的value值
        String msg = "name=xiaohei1,'name'='xiaoxiao2';value:123,text=bbc";
        String patternStr = "([\"']?)(?<key>name|value|text)\\1\\s*[=:]\\s*\\1(?<value>[^;,]*)\\1";
        String convetMsg = RegUtils.convetMsg(msg, patternStr, (k, v) -> {
            switch (k) {
                case "name":
                    return "【name】";
                case "value":
                    return "【value】";
                default:
                    return "【unknown】";
            }
        });
        log.info("msg=[{}]",msg);
        log.info("convetMsg=[{}]",convetMsg);
    }

}
