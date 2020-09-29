package com.xingkx.package2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class PropTest {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("Test/test01/哈哈/t.properties");
            Properties prop = new Properties();
            prop.load(in);
            System.out.println(prop.getProperty("username"));

            Scanner scanner = new Scanner(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
