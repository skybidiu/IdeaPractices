package com.xingkx.package1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 银行家舍入法
 * 舍去位的数值小于5时，直接舍去
 * 舍去位的数值大于5时，进位后舍去
 * 等于5时，若5后面还有非0数值，则进位后舍去，若5后面是0时，则根据5前一位数的奇偶性来判断，奇数进位，偶数舍去
 */

/**
 * java支持7种舍入法
 * 1。ROUND_UP:远离零方向舍入。向绝对值最大的方向舍入，只要舍弃位非0即进位
 * 2。ROUND_DOWN:趋向零方向舍入。向绝对值最小的方法舍入，所有位都要舍弃，不存在进位情况
 * 3。ROUND_CEILING:向正无穷方向舍入。等于Math.round()
 * 4。ROUND_FLOOR:向负无穷方向舍入
 * 5。HALF_UP:最近数字舍入（5进）。经典的四舍五入
 * 6。HALF_DOWN:最近数字舍入（5舍）。在这里5是要舍弃的
 * 7。HALF_EVEN:银行家算法
 */
public class PrecisionVerify {
    public static void main(String[] args) {
        BigDecimal deposit = new BigDecimal(100000);
        BigDecimal rate = new BigDecimal(0.001875 * 3);
        BigDecimal interest = deposit.multiply(rate).setScale(2, RoundingMode.HALF_EVEN);

        System.out.println("季利息是：" + interest);


        /**
         * 四舍五入，保留位2
         */
        //1
        double f = 1111231.5545;
        BigDecimal bd = new BigDecimal(f);
        double f1 = bd.setScale(2, RoundingMode.HALF_UP).doubleValue();
        System.out.println(f1);

        //2 "#.00"表示两位小数 "#.0000"四位小数，以此类推
        DecimalFormat df = new DecimalFormat("#.00");
        double f2 = Double.parseDouble(df.format(f));
        System.out.println(f2);

        //3
        double f3 = Double.parseDouble(String.format("%.2f", f));
        System.out.println(f3);

    }
}

