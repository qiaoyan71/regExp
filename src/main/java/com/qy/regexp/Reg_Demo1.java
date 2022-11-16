package com.qy.regexp;

import com.qy.regexp.util.RegUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 测试
 * @author qiaoyan
 * @date 2022年11月10日 15:34:02
 */
@Slf4j
public class Reg_Demo1 {

    @Test
    public void test01(){
        // 判断是否是整数或小数,支持正负
        // 先简单,再补充其他情况
        // 支持整数
        String reg01 = "^\\d+$";
        // + 支持正负
        String reg02 = "^[-+]?\\d+$";
        // + 支持小数
        String reg03 = "^[-+]?\\d+(\\.\\d+)?$";
        // + 处理特殊情况,eg 0011
        String reg04 = "^[-+]?([1-9]\\d*)(\\.\\d+)?$";
        // + 处理特殊情况,eg 0.91
        String reg05 = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";
        RegUtils.printAllMatch(reg05,
                "1122",
                "11.01",
                "11.00",
                "+1122.01",
                "-22.02",
                "-0.00"
                );
    }

}
