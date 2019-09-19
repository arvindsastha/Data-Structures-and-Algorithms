package src.Arrays;

import src.DataStructureUtils;

/**
 * Merge Sort implementation
 */
public class MergeSort {

    private void sort(int[] input, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int arrayLength = (leftEnd - leftStart) + (rightEnd - rightStart) + 2;
        int[] mergedArray = new int[arrayLength];
        int index = 0;
        int leftStartCopy = leftStart, rightStartCopy = rightStart;

        for(;index < arrayLength && leftStart <= leftEnd && rightStart <= rightEnd; index++) {
            if(input[leftStart] <= input[rightStart]) {
                mergedArray[index] = input[leftStart];
                leftStart++;
            } else {
                mergedArray[index] = input[rightStart];
                rightStart++;
            }
        }

        for(;index < arrayLength && leftStart <= leftEnd; index++) {
            mergedArray[index] = input[leftStart];
            leftStart++;
        }

        for(;index < arrayLength && rightStart <= rightEnd; index++) {
            mergedArray[index] = input[rightStart];
            rightStart++;
        }

        index = 0;
        for(int i = leftStartCopy; i<=leftEnd; i++) {
            input[i] = mergedArray[index++];
        }

        for(int i = rightStartCopy; i<=rightEnd; i++) {
            input[i] = mergedArray[index++];
        }
    }

    private void mergeSort(int[] input, int start, int end) {
        if(start >= end) {
            return;
        }

        int leftEnd = start + ((end - start) / 2);
        mergeSort(input, start, leftEnd);

        int rightStart = leftEnd + 1;
        mergeSort(input, rightStart, end);

        sort(input, start, leftEnd, rightStart, end);
    }

    public static void main(String[] args) {
        int[] input = {4, 6, 1, 5, -51, 35, 76};

        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input, 0, input.length - 1);
        DataStructureUtils.printArray(input);
    }
}
