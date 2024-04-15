import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Name: Jayden Cruz
 * Date: 11/16/23
 * Class: CSC-1120.01
 * Recursive Rat Maze
 * Pledge: I have neither given nor received unauthorized aid on this program.
 * Description: This  Java program is to use a recursive algorithm to have the rat find its way through the maze,
 * and print out a solution to the maze as well as the number of steps it took to find the solution.
 */
public class Maze {
    public int startR;
    public int startC;
    public int endR;
    public int endC; //starting/ending methods
    private static char breadcrumbs = '.'; //breadcrumbs
    private static char PATH = 'o'; //path
    private static char TRIED = '#'; //visited/tried
    private int numberRows, numberColumns;  //number of rows and columns in the maze
    private char[][] grid;  //grid

    /**
     * Constructor for the Maze class. Loads a maze from the given file.
     * Throws a FileNotFoundException if the given file is not found.
     *
     * @param filename the name of the file to load
     * @throws FileNotFoundException if the given file is not found
     */

    public Maze(String filename) throws FileNotFoundException //searching for maze file
    {
        Scanner scan = new Scanner(new File(filename));
        numberRows = scan.nextInt();
        numberColumns = scan.nextInt();

        grid = new char[numberRows][numberColumns];

        for (int i = 0; i < numberRows; i++) {
            for (int j = 0; j < numberColumns; j++) {//values of each position
                grid[i][j] = scan.next().charAt(0);

                if (grid[i][j] == 'R') {
                    startR = getStartR(i, j); //get Rats start position
                    startC = getStartC(i, j); //get Cheese start position
                }

                if (grid[i][j] == 'C') {
                    endR = getEndR(i, j); //get Rat ending position
                    endC = getEndC(i, j); //get cheese ending position
                }
            }
        }
    }

    /**
     * Returns the ending method
     *
     * @param r rat
     * @param c cheese
     * @return r
     */
    int getEndR(int r, int c) {
        if (grid[r][c] == 'C')
            System.out.println("Row" + r + "Column" + c);
        return r;
    }

    /**
     * Returns the ending method
     *
     * @param r rat
     * @param c cheese
     * @return c
     */
    int getEndC(int r, int c) { //update
        if (grid[r][c] == 'C')
            System.out.println("Row" + r + "Column" + c);
        return c;
    }

    /**
     * Returns the start method
     *
     * @param r rat
     * @param c cheese
     * @return r
     */
    int getStartR(int r, int c) { //update
        if (grid[r][c] == 'R')
            System.out.println("Row" + r + "Column" + c);
        return r;
    }

    /**
     * Returns the start method
     *
     * @param r rat
     * @param c cheese
     * @return c
     */
    int getStartC(int r, int c) { //update
        if (grid[r][c] == 'R')
            System.out.println("Row" + r + "Column" + c);
        return c;
    }

    /**
     * Marks the specified position in the maze as TRIED
     *
     * @param row the index of the row to try
     * @param col the index of the column to try
     */
    public void tryPosition(int row, int col) {
        grid[row][col] = TRIED;  //try the position to see if its allowable location; updates to be o
    }

    /**
     * Return the number of rows in this maze
     *
     * @return the number of rows in this maze
     */
    public int getRows() {
        return grid.length; //grid.length;
    }

    /**
     * Return the number of columns in this maze
     *
     * @return the number of columns in this maze
     */
    public int getColumns() {
        return grid[0].length;
    }

    /**
     * Marks a given position in the maze as part of the PATH
     *
     * @param row the index of the row to mark as part of the PATH
     * @param col the index of the column to mark as part of the PATH
     */
    public void markPath(int row, int col) {
        //grid[row][col] = PATH; //updates to be . if it is the solution path
        if (grid[row][col] != 'C') {
            grid[row][col] = PATH;
        }
        breadcrumbs++;  //counts the breadcrumbs that are places
    }

    /**
     * Determines if a specific location is valid. A valid location
     * is one that is on the grid, is not blocked, and has not been TRIED.
     *
     * @param row    the row to be checked
     * @param column the column to be checked
     * @return true if the location is valid
     */
    public boolean validPosition(int row, int column) //within the domain of the position
    {
        boolean result = false;
        if (row >= 0 && row < grid.length &&
                column >= 0 && column < grid[row].length)

            if (grid[row][column] == '.' || grid[row][column] == 'R' || grid[row][column] == 'C')
                result = true;

        return result;
    }

    /**
     * Returns the maze as a string.
     *
     * @return a string representation of the maze
     */
    public String toString() // will return a string that prints how the maze was solution set
    {
        String result = "\n";

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++)
                result += grid[row][column] + "";
            result += "\n";
        }
        return result;
    }
}