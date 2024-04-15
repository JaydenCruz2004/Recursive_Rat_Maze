/**
 * MazeSolver attempts to recursively traverse a Maze. The goal is to get from the
 * given starting position to the bottom right, following a path of '.' . Arbitrary
 * constants are used to represent locations in the maze that have been breadcrumbs
 * and that are part of the solution PATH.
 */

public class MazeSolver {
    private Maze maze;

    /**
     * Constructor for the MazeSolver class.
     */
    public MazeSolver(Maze maze) {
        this.maze = maze;
    }

    /**
     * Attempts to recursively traverse the maze. Inserts special
     * characters indicating locations that have been TRIED and that
     * eventually become part of the solution PATH.
     *
     * @param row row index of current location
     * @param column column index of current location
     * @return true if the maze has been solved
     */

    int count = 0;

    public boolean maze_solved(int row, int column) {
        boolean done = false;
        System.out.println("The rat is at " + row + ", " + column + ".");

        if (maze.validPosition(row, column)) {
            maze.tryPosition(row, column);
            count++;

            System.out.println("The rat is at " + row + ", " + column + ".");

            if (row == maze.endR && column == maze.endC)
                done = true;
            else {
                done = maze_solved(row - 1, column); // NORTH
                if (!done)
                    done = maze_solved(row, column + 1); // EAST
                if (!done)
                    done = maze_solved(row + 1, column); // SOUTH
                if (!done)
                    done = maze_solved(row, column - 1); // WEST
            }

            if (done)
                maze.markPath(row, column);
        }

        return done;
    }
}

