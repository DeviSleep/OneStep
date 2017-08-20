package com.demo1;

/**
 * Created by des on 2017/7/19.
 */
public class JieCheng {

    /**
     * n! 的算法
     */
    public static long doFactorial(long n) {
        if (n < 1) {
            System.out.println("error");
            return 0;
        } else if (n == 1 || n == 2) {
            return n;
        } else {
            return n * doFactorial(n - 1);
        }

    }

    public static void main(String[] args) {
        long n = 5;
        System.out.println(doFactorial(n));
    }

}
