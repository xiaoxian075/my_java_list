package com.at.controller.admin;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/6/21.
 */
public class T {

    public static void main(String[] args){

        BigDecimal sum = new BigDecimal(0D);
        long lc = 0L;
        long s = 0L;
        for(int i=1;i<1000_0000;i+=3){
            sum = sum.add(new BigDecimal(i/15D).setScale(2,BigDecimal.ROUND_HALF_UP));
            lc += (i*100/15);
            s += i;
        }
        System.out.println(sum);
        System.out.println(lc);
        System.out.println(s);
    }

}
