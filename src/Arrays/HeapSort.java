package src.Arrays;

import src.DataStructureUtils;

/**
 * Heap Sort implementation
 *
 * Algorithm
 * 1. Build MaxHeap using heapify from n-1 to 1 in reverse order
 * 2. Swap first element with last element
 * 3. Heapify for position 0 with array size reduced to N-1
 * 4. Repeat steps 2-3 until array size is reduced to 0
 */
class HeapSort {

    /**
     * Builds max heap for the input array in reverse order
     * @param input - Input array
     */
    private void buildMaxHeap(int[] input) {
        for(int i=input.length/2 - 1; i>=0; i--) {
            heapify(input, i, input.length);
        }
    }

    /**
     * Heapifies the given binary heap for the element at the elementPosition
     * Assumption: Binary heap and max heap
     * @param input - Input array
     * @param elementPosition - Position of the element considered for hepaify process
     * @param heapSize - Heap size
     */
    private void heapify(int[] input, int elementPosition, int heapSize) {

        // Need to take the largest value from children and replace it with parent
        // Largest position will denote the largest child. Initially set to element's position
        int largestPosition = elementPosition;

        // If left child exists and it is larger than the parent, record the position
        if(2*elementPosition+1<heapSize && input[largestPosition] < input[2*elementPosition+1]) {
            largestPosition = 2*elementPosition+1;
        }

        // If right child exists and it is larger than the parent, record the position
        if(2*elementPosition+2<heapSize && input[largestPosition] < input[2*elementPosition+2]) {
            largestPosition = 2*elementPosition+2;
        }

        // If any of such child exists and is greater than the parent
        // replace the child with parent
        // And heapify at the replaced position
        if(largestPosition != elementPosition) {
            DataStructureUtils.swapValuesInArray(input, largestPosition, elementPosition);
            heapify(input, largestPosition, heapSize);
        }
    }

    /**
     * Method that performs heap sort
     * @param input - Input array
     */
    void heapSort(int[] input) {
        // Build Max Heap
        buildMaxHeap(input);
        int heapSize = input.length - 1;
        for(;heapSize>=0;heapSize--) {
            // Swap arr[0] and arr[end]
            // Intuition is max element would be found at the root of the heap i.e, index 0 of array
            DataStructureUtils.swapValuesInArray(input, 0, heapSize);

            // After swapping heapify with position 0 since max element was replaced from position 0
            heapify(input, 0, heapSize);
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 3, 36, 2, 19, 25, 100, 17, 7};

        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(input);
        DataStructureUtils.printArray(input);
    }
}