package com.java.thirdtest.Calculate;


import com.java.thirdtest.entity.Thirtest;

import java.time.LocalDateTime;

public class ThirTest {
    public static Thirtest calculate(Thirtest thirtest) {
        Double eoc = thirtest.getEoc();
        Double d = thirtest.getD();
        Double a = thirtest.getA();
        Double mel = thirtest.getMel();
        Double sl = 20 * (Math.log10(eoc)) + 20 * Math.log10(d) - a - mel;
        thirtest.setSl(sl);
        LocalDateTime time = LocalDateTime.now();
        thirtest.setDate(time);
        return thirtest;
    }
}
