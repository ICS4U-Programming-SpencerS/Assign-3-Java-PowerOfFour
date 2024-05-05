//package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * power of four assignment 3
 *
 * @author Spencer Scarlett
 * @version 1.0
 * @since 2024-04-25
 */

// powerOfFour class
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

        // input and output file paths
        final File file = new File("input.txt");
        final File fileOut = new File("output.txt");

        try {
            //objects for filewriter, scanner, and printwriter
            final FileWriter fW = new FileWriter(fileOut);
            final Scanner sc = new Scanner(file);
            final PrintWriter write = new PrintWriter(fW);

            // read each line from input file
            while (sc.hasNextLine()) {
                // sets line as string first
                final String line = sc.nextLine();

                try {
                    // before parsing it as an int
                    final int intLine = Integer.parseInt(line);

                    // function call for input
                    int result = isPowerOfFour(intLine);
                    // if the value is a power of four, one is returned and displayed
                    if (result == 1) {
                        write.println(intLine + " is a power of four.");
                        // if 0 is resulted, the value is not a power of four
                    } else if (result == 0) {
                        write.println(intLine + " is not a power of four.");
                        // for invalid inputs (0)
                    } else {
                        write.println(intLine + " is not a power of four and is an invalid input.");
                    }

                    // for input lines that are not parsable as ints
                } catch (NumberFormatException error) {
                    System.out.println("Error " + line + " is an invalid input(whole numbers only).");
                }
            }
            
            // closing resources and output message (to console)
            write.close();
            sc.close();
            System.out.println("Done program");

        } catch (IOException error) {
             // For when no input file is found.
            System.out.println("An error occurred: "
                    + error.getMessage());
        }
    }


    /**
     * Determines whether a given number is a power of four.
     *
     * @param n The number to be checked.
     * @return 1 if the number is a power of four, 0 if it is not, -1 if the input is invalid.
     */
    public static int isPowerOfFour(int n) {
        // if input is 0 or less
        if (n == 0)
            return -1;
        // base case, 1 is a power of four
        if (n == 1)
            return 1;
        // not a power of four value
        if (n % 4 != 0)
            return 0;

        // recursively checks the number each time to determine if it's a power of four
        return isPowerOfFour(n / 4);
    }
}