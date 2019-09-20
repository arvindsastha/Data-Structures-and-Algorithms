package src;

public class DataStructureUtils {
    /**
     * Prints array values between the start and end index including start and end
     * @param input - Array to be printed
     * @param begin - Start index
     * @param end - End index
     */
     public static void printArrayBetweenStartAndEnd(int[] input, int begin, int end) {
        for(int i=begin; i<=end; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println("");
    }

    /**
     * Prints the entire array
     * @param input - Array to be printed
     */
    public static void printArray(int[] input) {
        printArrayBetweenStartAndEnd(input, 0, input.length - 1);
    }

    /**
     * Utility method to swap values
     * @param input - Input array in which values should be swapped
     * @param indexA - First index
     * @param indexB - Second index
     */
    public static void swapValuesInArray(int[] input, int indexA, int indexB) {
        int temp = input[indexA];
        input[indexA] = input[indexB];
        input[indexB] = temp;
    }
}
