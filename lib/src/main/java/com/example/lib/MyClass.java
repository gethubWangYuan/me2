package com.example.lib;

public class MyClass {
    public static void main(String[] args){
        int[] array = {4, 3, 2, 1, 6};

        for (int i = 1; i < array.length; i++) {
            //指定最小数的索引
            int inex = 0;
            for (int j = i; j < array.length; j++) {
                //w
                if (array[j] < array[inex]){
                    inex = j;
                }
            }

            if (inex == i){
                int code = array[inex];
                array[inex] = array[array.length - i];
                array[array.length - i] = code;
            }
            inex++;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}