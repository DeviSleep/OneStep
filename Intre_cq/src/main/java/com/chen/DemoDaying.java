package com.chen;

/**
 * Created by des on 2017/11/26.
 */
public class DemoDaying {


    public static void main(String []args){

        for(int i=1;i<=5;i++){
            for(int j=5; i<=j; j--)
                System.out.print(" ");
            for(int j=1; j<=i; j++)
                System.out.print("*");
            for(int j=1; j<i; j++)
                System.out.print("*");
            System.out.println();
        }
    }


}
