package org.alessio.exercise;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args){
        Integer[] arrayToSort = {5,3,45,12,1,65,6};
        System.out.println("Original Array is:" + Arrays.toString(arrayToSort));

        bubbleSort(arrayToSort);
        System.out.println("Sorted Array is:" + Arrays.toString(arrayToSort));
    }

    public static void bubbleSort(Integer[] arrayToSort){

        if(arrayToSort == null || arrayToSort.length < 2){
            return;
        }


        for(int i = 0; i < arrayToSort.length -1; i++){
            boolean updated = false;
            for (int j = 1; j < arrayToSort.length - i; j++){
                if(arrayToSort[j-1] > arrayToSort[j]){
                    // If current comparation gives that left is > right, then exchange them
                    int temp = arrayToSort[j-1];
                    arrayToSort[j-1] = arrayToSort[j];
                    arrayToSort[j] = temp;
                    updated = true;
                }
            }

            if(!updated) {
                // Optimization to avoid useless cycles
                System.out.println("Exiting, nothing was updated this cycle");
                break;
            }
        }
    }
}
