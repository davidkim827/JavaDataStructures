package Labs.Week10_PracticeOnRecAndStack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by dk on 11/9/2017.
 */
public class MazeSolver {

    private static char[][] maze;
    private static int startRow;
    private static int startCol;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new File("Week10MazeData.txt")); //reads in the file for the maze

        //file includes the dimensions of the maze
        int y = reader.nextInt();
        int x = reader.nextInt();

        maze = new char[y][x];

        //creates and prints out maze before traversal
        for (int i = 0; i < y; i++) {
            String nextline = reader.next();
            for (int j = 0; j < x; j++) {
                maze[i][j] = nextline.charAt(j);
                if (nextline.charAt(j) == 'S') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        printMaze();

        //path to be marked for solution with star character
        char star = '*';

        System.out.println();
        System.out.println();

        //if maze is solvable, it will print out the path, else it will print out unsolvable
        if(mazeSolver(maze, startRow, startCol, star))
            printMaze();
        else
            System.out.print("Unsolvable");
    }

    //recursive algorithm to mark path of solution, and will mark path with spaces for already traversed areas.
    public static boolean mazeSolver(char[][] maze, int r, int c, char star) {
        if (r < 0 || c < 0 || r >= maze.length || c >= maze[0].length)
            return false;
        if(maze[r][c] == 'E')  //base case
            return true;
        if(maze[r][c] != '.' && maze[r][c] != 'S')
            return false;
        maze[r][c] = ' ';  //leaves trail of already traversed paths

        if (mazeSolver(maze, r-1, c, star)) {
            maze[r][c] = star;
            return true;
        }
        if (mazeSolver(maze, r+1, c, star)) {
            maze[r][c] = star;
            return true;
        }
        if (mazeSolver(maze, r, c+1, star)) {
            maze[r][c] = star;
            return true;
        }
        if (mazeSolver(maze, r, c-1, star)) {
            maze[r][c] = star;
            return true;
        }
        return false;
    }

    //prints out the maze
    public static void printMaze(){
        maze[startRow][startCol] = 'S';
        for (int i = 0; i < maze.length; i++)
            System.out.println(maze[i]);
    }
}
