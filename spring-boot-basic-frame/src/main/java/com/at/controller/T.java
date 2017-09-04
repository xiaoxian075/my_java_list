package com.at.controller;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static com.at.frame.utils.VerifyUtil.*;

/**
 * Created by Administrator on 2017/5/19.
 */
public class T {


    @Test
    public void test(){
        Assert.assertTrue(isAnyEmpty(""));
        Assert.assertTrue(isAnyEmpty("",null));
        Assert.assertTrue(isAnyEmpty("","","abc"));

        Assert.assertTrue(isAnyNull(null));
        Assert.assertTrue(isAnyNull("abc",null));
        Assert.assertFalse(isAnyNull("abc"));


        Assert.assertTrue(isAnyLengthLess(10,"abc"));
        Assert.assertTrue(isAnyLengthLess(10,"abc",null,""));

        Assert.assertTrue(isAnyLengthGreat(1,"abcde"));
        Assert.assertTrue(isAnyLengthGreat(1,"abcde",null,"12","aaa"));

        Assert.assertFalse(isAnyLengthGreat(10,"abcde"));
        Assert.assertFalse(isAnyLengthGreat(10,"abcde",null,null,"aaa"));

        Assert.assertTrue(isAnyLengthNotIn(1,2,"abc",null,""));

        Assert.assertTrue(isAnyLess(Integer.valueOf(111),112));
        Assert.assertTrue(isAnyLess(Float.valueOf(111),112));
        Assert.assertTrue(isAnyLess(Double.valueOf(111),112));
        Assert.assertTrue(isAnyLess(BigDecimal.valueOf(111),112));
    }

}
