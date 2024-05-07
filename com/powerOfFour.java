import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Power of Four Assignment 3
 * Determines whether a given number is a power of four and finds the maximum value from an input file.
 * 
 * @author Spencer Scarlett
 * @version 1.0
 * @since 2024-04-25
 */
public final class powerOfFour {

    /** Private constructor to prevent instantiation. */
    private powerOfFour() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused
     */
    public static void main(String[] args) {

        // Input and output file paths
        final File file = new File("input.txt");
        final File fileOut = new File("output.txt");

        try {
            // Objects for file writer, scanner, and print writer
            final FileWriter fW = new FileWriter(fileOut);
            final Scanner sc = new Scanner(file);
            final PrintWriter write = new PrintWriter(fW);

            // declaring array and size
            int[] intArray = new int[100];

            // this is new and is designed to test where to hold the arrays
            // normally for storing info
            int index = 0;

            // Read each line from input file
            while (sc.hasNextLine()) {
                // Sets line as string first
                final String line = sc.nextLine();

                try {
                    // Before parsing it as an int
                    final int intLine = Integer.parseInt(line);
                    // Store the integer in the array
                    intArray[index++] = intLine;
                    int result = isPowerOfFour(intLine);

                    // If the value is a power of four, one is returned and displayed
                    if (result == 1) {
                        write.println(intLine + " is a power of four.");
                    } else if (result == 0) {
                        // If 0 is resulted, the value is not a power of four
                        write.println(intLine + " is not a power of four.");
                    } else {
                        // For invalid inputs (0)
                        write.println(intLine + " is not a power of four and is an invalid input.");
                    }
                    // Find and print the maximum value
                    int max = findMax(intArray, index, 0);
                    write.println("Maximum value from input file: " + max);

                } catch (NumberFormatException error) {
                    System.out.println("Error " + line + " is an invalid input(whole numbers only).");
                }
            }

            // Closing resources and output message (to console)
            write.close();
            sc.close();
            System.out.println("Done program");

        } catch (IOException error) { // For when no input file is found.
            System.out.println("An error occurred: " + error.getMessage());
        }
    }

    /**
     * Determines whether a given number is a power of four.
     *
     * @param n The number to be checked.
     * @return 1 if the number is a power of four, 0 if it is not, -1 if the input is invalid.
     */
    public static int isPowerOfFour(int n) {
        // If input is 0 or less
        if (n == 0)
            return -1;
        // Base case, 1 is a power of four
        if (n == 1)
            return 1;
        // not a power of four value
        if (n % 4 != 0)
            return 0;

        // recursively checks the number each time to determine if it's a power of four
        return isPowerOfFour(n / 4);
    }

    /**
     * function to find the maximum value in the array using recursion
     *
     * @param arr the array of integers
     * @param size the size of the array
     * @param index the current index in the array
     * @return the maximum value in the array
     */
    public static int findMax(int[] arr, int size, int index) {
        // base case, if the index value is the last element, return the value as it's the maximum
        if (index == size - 1) {
            return arr[index];
        }
        // recursive case, finds the maximum value in the rest of the array
        int maxRest = findMax(arr, size, index + 1);
        return Math.max(arr[index], maxRest);
    }
}
