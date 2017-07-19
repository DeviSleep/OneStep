package com.demo1;

/**
 * Created by des on 2017/7/19.
 * 递归： 是指函数/过程/子程序/在运行过程中直接或间接调用自身而产生的重入现象。
 */
public class Digui {

    /**
     * 计算二进制中1的个数，
     * N为奇数，二进制中1的个数等于N/2的个数
     */
    public static int getBinary(int num){
        if (num==1){
            return 1;
        }
        if (0==num%2){
            return getBinary(num/2);
        }else {
            return getBinary(num/2)+1;
        }
    }

    public static void main(String[] args){
            System.out.println(getBinary(10));
    }

}
