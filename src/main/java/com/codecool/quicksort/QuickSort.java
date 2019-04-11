package com.codecool.quicksort;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class QuickSort {

    /**
     * Sorts the given List in place
     *
     * @param toSort the List to sort. Throws an error if its null
     */
    Random random = new Random();


    public void sort(List<Integer> toSort) {
        if (toSort == null) {
            throw new IllegalArgumentException();
        }
        if (toSort.size() > 1) {
            Integer initialPivotIndex = random.nextInt(toSort.size());
            Integer pivot = toSort.get(initialPivotIndex);
            Integer temp;
            Integer leftPointer = 0;
            Integer lastIndex = toSort.size() - 1;
            Integer rightPointer = lastIndex;
            while (leftPointer != rightPointer) {
                if (toSort.get(leftPointer) > pivot) {
                    if (toSort.get(rightPointer) < pivot) {
                        temp = toSort.get(rightPointer);
                        toSort.set(rightPointer, toSort.get(leftPointer));
                        toSort.set(leftPointer, temp);
                    } else {
                        rightPointer--;
                    }
                } else {
                    leftPointer++;
                }
            }
            Integer pointersValue = toSort.get(leftPointer);
            Integer finalPivotIndex;
            if (pivot < pointersValue) {
                if (initialPivotIndex > leftPointer) {
                    finalPivotIndex = leftPointer;
                    temp = toSort.get(finalPivotIndex);
                    toSort.set(finalPivotIndex, pivot);
                    toSort.set(initialPivotIndex, temp);
                } else {
                    finalPivotIndex = leftPointer - 1;
                    temp = toSort.get(max(finalPivotIndex, 0));
                    toSort.set(max(finalPivotIndex, 0), pivot);
                    toSort.set(initialPivotIndex, temp);
                }
            } else {
                if (initialPivotIndex < leftPointer) {
                    finalPivotIndex = leftPointer;
                    temp = toSort.get(finalPivotIndex);
                    toSort.set(finalPivotIndex, pivot);
                    toSort.set(initialPivotIndex, temp);
                } else {
                    finalPivotIndex = leftPointer + 1;
                    temp = toSort.get(min(finalPivotIndex, lastIndex));
                    toSort.set(min(finalPivotIndex, lastIndex), pivot);
                    toSort.set(initialPivotIndex, temp);
                }
            }
            sort(toSort.subList(0, finalPivotIndex));
            sort(toSort.subList(min(finalPivotIndex + 1, lastIndex), toSort.size()));
        }
    }
}
