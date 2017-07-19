package com.demo1;

/**
 * Created by des on 2017/7/19.
 */
public class SelectSort {
    //选择排序算法
    public static void selectionSort(int[] number){
        for(int i=0;i<number.length-1;i++){
            int num=i;
            for (int j=i+1;j<number.length;j++){
                if (number[j]<number[num]){
                    num = j;
                }
            }
            if (i!=num){
                swap(number,i,num);
            }
        }
    }

    //用于交换数组中的所用为i，j的元素
    private static void swap(int[] number,int i,int j){
        int t;
        t=number[i];
        number[i]=number[j];
        number[j]=t;
    }

    public static void main(String[] args){
        int[] num=new int[10];
        for(int i=0;i<num.length;i++){
            num[i]=(int)(Math.random()*100)+1;
        }

        selectionSort(num);
        for (int i=0;i<num.length;i++){
            System.out.println(num[i]);
        }
    }

}
