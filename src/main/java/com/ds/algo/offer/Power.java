package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/9.
 */
public class Power {

    public double Power(double base, int exponent) {
        if(exponent == 0){
            return 1;
        }

        int power = Math.abs(exponent);
        double result = 1;
        for (int i = 1; i <= power; i++) {
            result *= base;
        }
        return exponent < 0 ? 1/result : result;
    }

}
