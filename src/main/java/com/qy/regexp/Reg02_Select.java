package com.qy.regexp;

import com.qy.regexp.util.RegUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 选择匹配 |
 * @author qiaoyan
 * @date 2022年11月10日 15:34:02
 */
@Slf4j
public class Reg02_Select {


    @Test
    public void select(){
        RegUtils.printResult("123|223|323","123,,,223,,323");
    }

}
