package com.codecool.quicksort;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class QuickSort {

    /**
     * Sorts the given List in place
     * @param toSort the List to sort. Throws an error if its null
     */
    Random random = new Random();


    public void sort(List<Integer> toSort) {
        if (toSort == null) { throw new IllegalArgumentException(); }
        if (toSort.size() > 1) {
            Integer initialPivotIndex = random.nextInt(toSort.size());
            Integer pivot = toSort.get(initialPivotIndex);
            System.out.println(pivot);
            Integer temp;
            Integer leftPointer = 0;
            Integer lastIndex = toSort.size() - 1;
            Integer rightPointer = lastIndex;
            while(leftPointer != rightPointer) {
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
            System.out.println(Arrays.toString(toSort.toArray()));
        }
    }

//    public void sort(List<Integer> toSort) {
//        if (toSort.size() > 1) {
//            Integer pivotIndex = random.nextInt(toSort.size());
//            Integer pivot = toSort.get(pivotIndex);
//            Integer temp;
//            Integer leftPointer = 0;
//            Integer rightPointer = toSort.size()-1;
//            boolean pivotInPlace = false;
//            while (!pivotInPlace) {
//                if (leftPointer == pivotIndex) {leftPointer++;}
//                if (toSort.get(leftPointer) > pivot) {
//                    if (toSort.get(rightPointer) < pivot) {
//                        if (rightPointer == pivotIndex) {rightPointer++;}
//                        temp = toSort.get(rightPointer);
//                        toSort.set(rightPointer, toSort.get(leftPointer));
//                        toSort.set(leftPointer, temp);
//                        leftPointer++;
//                        rightPointer--;
//                    } else {
//                        rightPointer--;
//                        if (rightPointer == leftPointer) {
//                            leftPointer++;
//                        }
//                    }
//                } else {
//                    leftPointer++;
//                    if (leftPointer >= rightPointer) {
//                        if (leftPointer == toSort.size() - 1) {
//                            temp = toSort.size() - 1;
//                            toSort.set(toSort.size() - 1, pivot);
//                            toSort.set(pivotIndex, temp);
//                        } else {
//                            temp = toSort.get(leftPointer - 1);
//                            toSort.set(leftPointer - 1, pivot);
//                            toSort.set(pivotIndex, temp);
//                            sort(toSort.subList(0,pivotIndex));
//                            sort(toSort.subList(pivotIndex + 1,toSort.size() - 1));
//                        }
//                        pivotInPlace = true;
//                    }
//                }
//            }
//
//        }
//    }

//    boolean sidesAreSet = false;
//            while (!sidesAreSet) {
//                if (leftPointer >= rightPointer) {
//                    sidesAreSet = true;
//                }
//                if (toSort.get(leftPointer) > pivot) {
//                    if (toSort.get(rightPointer) < pivot) {
//                        temp = toSort.get(rightPointer);
//                        toSort.set(rightPointer, toSort.get(leftPointer));
//                        toSort.set(leftPointer, temp);
//                        leftPointer++;
//                        rightPointer--;
//                    } else {
//                        rightPointer--;
//                        if (rightPointer == leftPointer) {
//                            sidesAreSet = true;
//                        }
//                    }
//                } else {
//                    leftPointer++;
//                }
//
//            }
//            if (leftPointer == lastIndex) {
//                temp = toSort.get(lastIndex);
//                toSort.set(lastIndex, pivot);
//                toSort.set(pivotIndex, temp);
//                sort(toSort.subList(0, lastIndex));
//
//            } else if (leftPointer == 0) {
//                temp = toSort.get(0);
//                toSort.set(0, pivot);
//                toSort.set(pivotIndex, temp);
//                sort(toSort.subList(1, lastIndex + 1));
//            } else {
//                temp = toSort.get(leftPointer - 1);
//                toSort.set(leftPointer - 1, pivot);
//                toSort.set(pivotIndex, temp);
//                sort(toSort.subList(0, pivotIndex));
//                sort(toSort.subList(pivotIndex + 1, lastIndex));
//            }
}
