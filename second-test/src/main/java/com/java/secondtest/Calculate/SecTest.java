package com.java.secondtest.Calculate;

import com.java.secondtest.entity.Sectest;

import java.time.LocalDateTime;

public class SecTest {

    public static Sectest calculate(Sectest sectest) {
        Double eoc = sectest.getEoc();
        Double u = sectest.getU();
        Double d = sectest.getD();
        Double a = sectest.getA();
        Double mel = sectest.getMel();
        Double tvr = 20 * (Math.log10(eoc / u)) + 20 * Math.log10(d) - a - mel;
        sectest.setTvr(tvr);
        LocalDateTime time = LocalDateTime.now();
        sectest.setDate(time);
        return sectest;
    }
}
