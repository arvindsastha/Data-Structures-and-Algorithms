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
    }

    /**
     * Prints the entire array
     * @param input - Array to be printed
     */
    public static void printArray(int[] input) {
        printArrayBetweenStartAndEnd(input, 0, input.length - 1);
    }
}
