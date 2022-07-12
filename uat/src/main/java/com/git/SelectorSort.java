package com.git;

import org.junit.Test;

import java.util.Arrays;

public class SelectorSort {

    @Test
    public void SelectorSortTest(){
        int [] arr = {1,2,4,6,8,0,9,7,5,3};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }





}
