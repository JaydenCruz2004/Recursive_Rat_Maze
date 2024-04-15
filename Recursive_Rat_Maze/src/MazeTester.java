import java.util.*;
import java.io.*;

/**
 * Tester uses recursion to determine if a maze can be traversed.
 */
public class MazeTester {
    /**
     * Creates a new maze, prints its original form, attempts to
     * solve it, and prints out its final form.
     */

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the name of the file containing the maze: ");
        String filename = scan.nextLine();

        Maze labyrinth = new Maze(filename);

        MazeSolver solver = new MazeSolver(labyrinth);

        System.out.println("Initial Maze:");
        System.out.println("Goodluck Mr.Rat");
        System.out.println(labyrinth);

        System.out.println("Test: " + labyrinth.startR);
        System.out.println("Test: " + labyrinth.startC);

        if (solver.maze_solved(labyrinth.startR, labyrinth.startC))
            System.out.println("The maze was successfully traversed!");
        else
            System.out.println("There is no possible path for the rat :(");

        System.out.println("Final Maze:");
        System.out.println(labyrinth);
    }
}
