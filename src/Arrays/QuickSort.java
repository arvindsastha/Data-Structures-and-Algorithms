package src.Arrays;

import src.DataStructureUtils;

/**
 * Quick Sort Implementation
 * Divide & Conquer strategy
 * Merge Sort without additional space
 * Worst case complexity O(n2)
 *
 * Algorithm
 * 1.Choose a pivot (Random value). Mostly, first value or last value.
 * Here, pivot is the last element of the array
 * 2.Point the left pointer to the beginning of the array
 * 3.Point the right pointer to the end of the array but before the pivot [i.e, at end - 1 position]
 * 4.Move the left pointer towards the end until a value larger or equal to the pivot is found and stop. Also make a note of the position
 * 5.Now move the right pointer towards the beginning until a value smaller or equal than pivot is found
 * 6.Swap left pointer and right pointer
 * 7.Make a note of left pointer's position
 * 8.Continue until left moves beyond right or right goes before left
 * 9.Finally swap pivot with value at left pointer's position
 * 10.Split the array into 2: arr[start to pivot position -1] and arr[pivot position + 1 to end] until size of the array is 2
 * and repeat steps 1-10
 */
class QuickSort {

    /**
     * Method to split the array at the pivot and sort recursively
     * @param input - array to be split and sorted
     * @param begin - Start index
     * @param end - End index
     */
    private static void splitAndSort(int[] input, int begin, int end) {

        // Split the array for a minimum of size 2
        // If begin is equal to end the size of the array is 1
        if(begin < end) {
            int pivotPosition = quickSort(input, begin, end);
            // For eg input => [4,2,2,8]
            // When 8 is the pivot, pivot position will be last position
            // Right split is not possible anymore

            // Split arr[begin] .. arr[pivotPosition -1]
            splitAndSort(input, begin, pivotPosition - 1);

            // Split arr[pivotPosition + 1] .. arr[end]
            splitAndSort(input, pivotPosition + 1, end);
        }
    }

    /**
     * Method that performs the quick sort for the partitions
     * @param input - input array to be re-arranged with pivot
     * @return - the sorted array
     */
    private static int quickSort(int[] input, int begin, int end) {

        // Print the split array
        //System.out.println("***************");
        //DataStructureUtils.printArray(input, begin, end);

        // Eg input => [4, 31, 2, 11], begin = 0, end = 3
        // Above example is used to depict the first pass as follows

        // Choosing the last element in the array as pivot
        // Note: Random pivot improves average time complexity but not the worst case complexity
        // Eg: pivot = 11
        int pivot = input[end];

        // Placing the leftmost pointer at the beginning
        // Placing the right pointer at the end (but before pivot)
        // Eg: low = 0, high = 2
        int low = begin, high = end - 1;

        // Final position where pivot has to be swapped after the pass
        // Eg: pivotFinalPosition = 3
        int pivotFinalPosition = end;

        // Printing the pivot element
        //System.out.println("Pivot: " + pivot);

        // To keep track of movement
        // True will make left pointer traverse towards right
        // False will make right pointer traverse towards left
        boolean moveLeft = true;

        // Traverse until low pointer is either to the left or equal to right pointer
        while(low <= high) {
            if(moveLeft && input[low] > pivot) {
                // When a large value is found
                // left traversing is stopped
                // position is noted for future swap with smaller value
                // Traverse direction is changed

                // Eg: [31] > 11, pivotFinalPosition = 1
                pivotFinalPosition = low;
                moveLeft = false;
            } else if(moveLeft && input[low] <= pivot) {
                // When values are lesser than the pivot
                // move the left pointer to the right as the pivot value is going to be after that

                // Eg: [4] < 11, low = 1
                low++;
            } else if(input[high] <= pivot) {
                // When a small value is found
                // swap is done with lower value in the left
                // Swap the larger value found at the beginning
                // Traverse direction is changed

                // Eg: [2] < 11, values 31 and 2 will be swapped
                // input after swap => [4, 2, 31, 11]
                // low = 2
                // pivotPosition = 2
                int temp = input[low];
                input[low] = input[high];
                input[high] = temp;
                moveLeft = true;
                low++;
                pivotFinalPosition = low;
            } else {
                // When a large value is found
                // move the right pointer to the left as the pivot value is going to be before that
                high--;
            }
        }

        // Swap the pivot finally in the appropriate position
        // Eg: input after pivot swap => [4, 2, 11, 31]
        if(pivotFinalPosition != end) {
            int temp = input[end];
            input[end] = input[pivotFinalPosition];
            input[pivotFinalPosition] = temp;
        }

        //System.out.println("Pivot Final Position: " + pivotFinalPosition);
        // Eg: position = 2
        return pivotFinalPosition;
    }

    public static void main(String[] args) {
        int[] input = {4, 6, 1, 5, 51, 35, 76};

        splitAndSort(input, 0, input.length - 1);
        DataStructureUtils.printArray(input, 0, input.length - 1);
    }
}