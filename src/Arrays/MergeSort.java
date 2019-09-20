package src.Arrays;

import src.DataStructureUtils;

/**
 * Merge Sort implementation
 *
 * Divide & Conquer algorithm
 *
 * Algorithm
 * 1. Split the array into two halves until size of 1 by recursing on left then on right
 * 2. Merge the two blocks of size N to form a new block of size 2N
 * 3. Copy the values of from new block to old block in the respective indices
 * 4. Also copy any left over values in the blocks, if the blocks are not of equal size
 * 5. Repeat steps 1-4 until you block size is equal to array size
 */
public class MergeSort {

    // For eg input => [3,2,12,1,4,3,11,13]

    /**
     * Sorts and merges two blocks
     * Eg: BlockA => [3,2,12] & BlockB => [1,4,3,11,33]
     * Resultant Block => [1,2,3,3,4,11,12,33]
     * @param input - Entire input array to be sorted
     * @param leftStart - First block start index
     * @param leftEnd - First block end index
     * @param rightStart - Second block start index
     * @param rightEnd - Second block end index
     */
    private void mergeAndSort(int[] input, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        // Calculating length of the new block
        // From the above example in comments BlockA size => 2-0 = 2
        // BlockB size => 4-0 = 4
        // Resultant Block size => 4 + 2 + 2 = 8
        int arrayLength = (leftEnd - leftStart) + (rightEnd - rightStart) + 2;
        int[] mergedArray = new int[arrayLength];

        // Starting index for resultant block
        int index = 0;

        // Copying the indices as it would be needed when replacing the values in input array
        int leftStartCopy = leftStart, rightStartCopy = rightStart;

        // Compare starting elements from both blocks, choose smaller value for ascending order
        for(;index < arrayLength && leftStart <= leftEnd && rightStart <= rightEnd; index++) {
            if(input[leftStart] <= input[rightStart]) {
                mergedArray[index] = input[leftStart];
                leftStart++;
            } else {
                mergedArray[index] = input[rightStart];
                rightStart++;
            }
        }

        // Left over values in BlockA
        for(;index < arrayLength && leftStart <= leftEnd; index++) {
            mergedArray[index] = input[leftStart];
            leftStart++;
        }

        // Left over values in BlockB
        for(;index < arrayLength && rightStart <= rightEnd; index++) {
            mergedArray[index] = input[rightStart];
            rightStart++;
        }

        // Resetting resultant block index to access it from the beginning to copy the values
        index = 0;

        // Copying values from BlockA into input array
        for(int i = leftStartCopy; i<=leftEnd; i++) {
            input[i] = mergedArray[index++];
        }

        // Copying values from BlockB into input array
        for(int i = rightStartCopy; i<=rightEnd; i++) {
            input[i] = mergedArray[index++];
        }
    }

    private void mergeSort(int[] input, int start, int end) {

        // Do not split for sizes of 1 or below
        if(start >= end) {
            return;
        }

        // BlockA
        int leftEnd = start + ((end - start) / 2);
        mergeSort(input, start, leftEnd);

        // BlockB
        int rightStart = leftEnd + 1;
        mergeSort(input, rightStart, end);

        // Sort BlockA and BlockB
        mergeAndSort(input, start, leftEnd, rightStart, end);
    }

    public static void main(String[] args) {
        int[] input = {4, 6, 1, 5, -51, 35, 76};

        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input, 0, input.length - 1);
        DataStructureUtils.printArray(input);
    }
}
