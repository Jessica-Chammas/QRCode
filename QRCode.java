
/*
 * Program #1
 * Creates QR Code
 * CS-160-1
 * 2/9/22
 * Jessica Chammas
 */
import java.util.Random;
import java.util.Scanner;
//imports packages for use in later code


public class QRCode {
    private int[][] grid;

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        final int DEFAULT_SEED = 160;         // default size of 'seed'
        final int DEFAULT_DIMENSION = 30;    // default size of 'dim'

        int seed;
        int dim;

        if (args.length == 2) {
            dim = Integer.parseInt(args[0]);
            seed = Integer.parseInt(args[1]);
        }
        else {

            dim = DEFAULT_DIMENSION;
            seed = DEFAULT_SEED;
        }
        /*
         * if user inputs two values through scanner then the dim and seed will be the two values inputed through user
         * if user does not input two values through args then the dim is the default value and the seed is the default
         * value
         */

        QRCode test = new QRCode();   // this creates an object which allows you to connect to public classes and methods
        int pattern[] = test.createPattern(dim, seed); //uses object 'test' to call on method 'createPattern'
        test.setGrid(dim, pattern);         // uses object 'test' to call on method 'setGrid'
        test.setFinder(0, 0);   // uses object 'test' to call on method 'setFinder' at (0,0)aka top right
        test.setFinder(dim-15, 0); // uses object 'test' to call on method 'setFinder' at (-15,0)top left
        test.setFinder(0, dim-15); // uses object 'test' to call on method 'setFinder at (0,15) bottom
        test.print();   //prints

    }


    public int[] createPattern(int dim, int seed) {
        int[] pattern;
        pattern = new int[dim * dim];
        Random randNum = new Random(seed);
        for (int i = 0; i < pattern.length; i++) {
            pattern[i] = randNum.nextInt(2);
        }
        return pattern;
    }

    /*
     * returns a new one dimensional array the size of dim squared,
     * which is filled with random 0's and 1's generated with the java.util.Random object
     */


    public void setGrid(int dim, int[] pattern) {
        grid = new int[dim][dim];
        int temp = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = pattern[temp];
                temp++;
            }
        }
    }

    public int[][] getGrid() {
        return grid;
    }
    // returns a representation of grid

    public void setFinder(int xPos, int yPos) {
        for (int i = yPos; i < yPos + 15; i++) {
            for (int j = xPos; j < xPos + 15; j++) {
                grid[i][j] = 1;
            }
        }

        for (int i = yPos + 2; i < yPos + 13; i++) {
            for (int j = xPos + 2; j < xPos + 13; j++) {
                grid[i][j] = 0;
            }
        }
        for (int i = yPos + 4; i < yPos + 11; i++) {
            for (int j = xPos + 4; j < xPos + 11; j++) {
                grid[i][j] = 2;
            }
        }
        for (int i = yPos + 6; i < yPos + 9; i++) {
            for (int j = xPos + 6; j < xPos + 9; j++) {
                grid[i][j] = 3;
            }
        }
    }
       /*
        *  This method overwrites the exisitng grid with a finder in the upper left, upper right, and lower
        * left grid. The for loops start at [xPos] [yPos] and make a 15x15 box of 1's, then a 11x11 box
        * of 0s within that square, then a 7x7 box of 2s within that, and then a 3x3 box of 3s.
        */
    public void print() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
     /*
      * This method outputs grid as a two-dimensional grid with no spaces between values in a row
      */
    public void print(int[] pattern) {
        for (int i = 0; i < Math.sqrt(pattern.length); i++) {
            for (int j = 0; j < Math.sqrt(pattern.length); j++) {
                System.out.print(pattern[i *3 + j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    /*
     * This method outputs the one-dimensional pattern passed as a parameter as a two-dimensional grid with
     * no spaces between values.
     */


    public void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    /*
     This method outputs the two-dimensional matrix passed as a parameter row by row with
     no spaces between values in a row
     */
    }

