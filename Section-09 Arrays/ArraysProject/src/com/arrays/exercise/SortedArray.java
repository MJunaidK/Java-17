package com.arrays.exercise;

import java.util.Scanner;
import java.util.Arrays;

public class SortedArray {

    public static int[] getIntegers(int capacity) {

        Scanner scanner = new Scanner(System.in);
        int[] array = new int[capacity];
        System.out.println("Enter " + capacity + " integer values:\r");
        for (int i=0; i<array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printArray(int[] array) {

        for (int i=0; i<array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array) {

        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;
            for (int i=0; i<sortedArray.length-1; i++) {
                if (sortedArray[i] < sortedArray[i+1]) {
                    temp = sortedArray[i];                     // 1
                    sortedArray[i] = sortedArray[i+1];         // 2
                    sortedArray[i+1] = temp;                   // 3
                    flag = true;                               // 4
                }
            }
        }
        return sortedArray;
    }
}


/*The tricky part about this coding exercise is swapping the elements around in the array.

The outer loop (while) is checking to see if we've reached the end of the array without swapping any of the values.  If that's the case, we're done.

Otherwise, the inner loop (for) will traverse the array, and then check (if) whether the current value is less than the next value.

If this is true, we want to swap them around because we're sorting from biggest to smallest.

In the process of swapping the two values:

        1.  we want to store the current value in a temporary variable (so we don't lose it when we do the next step).

        2.  assign the next value to the current index of the array.

        3.  assign the value stored in the temporary variable to the next index in the array.

        4.  then we set our flag variable to true because we're not done lopping through the array.
*/
