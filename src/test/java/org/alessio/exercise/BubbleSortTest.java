package org.alessio.exercise;

import org.alessio.TestTimingExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TestTimingExtension.class)
class BubbleSortTest {

    private Integer[] arrayToSort;

    void init(String s){
        arrayToSort = Arrays.stream(s.split("-"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }

    @ParameterizedTest
    @CsvSource({
            "5-3-45-12-1-65-6",
            "5",
            "5-1",
    })
    void testSorting(String s){

        init(s);
        // Let's create a clone, only asList would keep reference to elements
        List<Integer> list = new ArrayList(Arrays.asList(arrayToSort));

        Collections.sort(list);
        assertFalse(arrayToSort.length > 1 && Arrays.equals(list.toArray(), arrayToSort), "Sorted and unsorted must be different");

        BubbleSort.bubbleSort(arrayToSort);
        assertArrayEquals(list.toArray(), arrayToSort, "Sorted and bubble-sorted must be equals after sorting");
    }

    @Test
    void testNull(){
        assertDoesNotThrow(() -> {
            BubbleSort.bubbleSort(arrayToSort);
        });
    }

    @AfterEach
    void reset(){
        arrayToSort = null;
    }


}