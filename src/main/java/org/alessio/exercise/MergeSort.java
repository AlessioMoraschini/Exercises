package org.alessio.exercise;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args){
        Integer[] arrayToSort = {5,3,45,12,1,65,6};
        System.out.println("Original Array is:" + Arrays.toString(arrayToSort));

        mergeSort(arrayToSort);
        System.out.println("Sorted Array is:" + Arrays.toString(arrayToSort));
    }

    public static void mergeSort(Integer[] arrayToSort) {

        if (arrayToSort == null || arrayToSort.length < 2) {
            return;
        }

        // Let's create left and right arrays using mid-point as delimiter
        int mid = arrayToSort.length / 2;
        Integer[] left = Arrays.copyOfRange(arrayToSort, 0, mid);
        Integer[] right = Arrays.copyOfRange(arrayToSort, mid, arrayToSort.length);

        mergeSort(left);
        mergeSort(right);

        merge(left, right, arrayToSort);
    }

    private static void merge(Integer[] left, Integer[] right, Integer[] arrayToSort) {

        int i = 0, j = 0, k = 0;

        // We have two sorted arrays left and right.
        // Let's merge them into arrayToSort, by comparing elements from left to right
        while(i < left.length && j< right.length){
            if(left[i] < right[j]){
                arrayToSort[k++] = left[i++];
            } else {
                arrayToSort[k++] = right[j++];
            }
        }

        // If we have elements left in left or right, let's add them to arrayToSort
        // First using left
        for(; i < left.length; i++) {
            arrayToSort[k++] = left[i];
        }

        // Then using right
        for(; j < right.length; j++) {
            arrayToSort[k++] = right[j];
        }
    }
}
