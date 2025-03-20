package org.alessio.exercise;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args){
        Integer[] arrayToSort = {5,3,45,12,1,65,6};
        System.out.println("Original Array is:" + Arrays.toString(arrayToSort));

        insertionSort(arrayToSort);
        System.out.println("Sorted Array is:" + Arrays.toString(arrayToSort));
    }

    public static void insertionSort(Integer[] arrayToSort){

        if(arrayToSort == null || arrayToSort.length < 2){
            return;
        }

        for(int i = 1; i < arrayToSort.length; i++){

            int key = arrayToSort[i];
            int j = i-1;
            while(j >= 0 && arrayToSort[j] > key) {
                arrayToSort[j + 1] = arrayToSort[j];
                j--;
            }

            arrayToSort[j + 1] = key;
        }
    }
}
