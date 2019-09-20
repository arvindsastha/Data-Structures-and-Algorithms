package src.Arrays;

import src.DataStructureUtils;

/**
 * Binary Search implementation
 *
 * Algorithm
 * 1. Sort the given array if it is not already
 * 2. Partition the array in the middle
 * 3. Check if the value to be searched is equal to the middle value
 * 4. If not, search in the left partition if the value is lesser than the middle value
 * 5. Else, search in the right partition if the value is greater than the middle value
 */
class BinarySearch {

    /**
     * Method to search value in the array using binary search algorithm
     * @param input - Input array
     * @param valueToBeSearched - Value that needs to be found
     * @return - Position of the found value
     */
    private int doBinarySearch(int[] input, int valueToBeSearched) {

        // Start and end will be at the either end of the list initially
        int start = 0, end = input.length - 1;
        while(start <= end) {
            // Middle element calculation
            int middle = start + (end - start) / 2;
            if (input[middle] == valueToBeSearched) {
                return middle + 1;
            } else if (input[middle] < valueToBeSearched) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }

    /**
     * Method to assist searching target value in a list
     * @param input - Input array
     * @param valueToBeSearched - Target value
     */
    private void search(int[] input, int valueToBeSearched) {
        int position = doBinarySearch(input, valueToBeSearched);
        if(position == -1) {
            System.out.println("The given value " + valueToBeSearched + " is not found in the list.");
        } else {
            System.out.println("The given value " + valueToBeSearched + " is found at position " + position + " in the sorted list.");
        }
    }

    public static void main(String[] args) {
        int[] input = {4, 6, 1, 5, 51, 35, 76};

        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(input);

        System.out.print("Sorted Array: ");
        DataStructureUtils.printArray(input);
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.search(input, 4);
        binarySearch.search(input, 6);
        binarySearch.search(input, 1);
        binarySearch.search(input, 5);
        binarySearch.search(input, 51);
        binarySearch.search(input, 35);
        binarySearch.search(input, 76);
        binarySearch.search(input, -3);
        binarySearch.search(input, 511);
    }
}
