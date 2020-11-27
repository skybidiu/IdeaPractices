package com.xingkx.Test;

import java.text.DecimalFormat;

public class DateTest {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.0000000");
        Double d = 5.20;
        System.out.println(df.format(d));

    }
}
