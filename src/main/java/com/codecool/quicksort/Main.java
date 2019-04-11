package com.codecool.quicksort;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        List<Integer> list = Arrays.asList(5, 3, 1, 12, 9,8,2,0);
        System.out.println(Arrays.toString(list.toArray()));
        quickSort.sort(list);
        System.out.println(Arrays.toString(list.toArray()));
        List<Integer> list2 = Arrays.asList(120,4,32,98,1,0,4,13,25);
        System.out.println(Arrays.toString(list2.toArray()));
        quickSort.sort(list2);
        System.out.println(Arrays.toString(list2.toArray()));

    }

}
