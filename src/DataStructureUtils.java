package src;

public class DataStructureUtils {
    /**
     * Prints array values between the start and end index
     * @param input - Array to be printed
     * @param begin - Start index
     * @param end - End index
     */
     public static void printArray(int[] input, int begin, int end) {
        for(int i=begin; i<=end; i++) {
            System.out.print(input[i] + " ");
        }
    }
}
