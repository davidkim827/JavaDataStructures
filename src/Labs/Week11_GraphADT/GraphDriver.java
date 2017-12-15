package Labs.Week11_GraphADT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by dk on 11/30/2017.
 */
public class GraphDriver {
    public static void main(String[] args) throws FileNotFoundException{
        //reads in the text file
        Scanner reader = new Scanner(new File("Lab11Data.txt"));

        //reads in the first line that contains the letters of the graph
        String vertices = reader.nextLine();
        LetterGraph graph = new LetterGraph(vertices.length());

        //reads and adds the vertices
        for(int i = 0; i < vertices.length(); i++){
            char vertex = vertices.charAt(i);
            graph.addVertex(vertex);
        }
        //displays the edge array and vertices to verify if everything was read in and implemented correctly on the graph
        graph.getVerticesEdgesArray();

        System.out.print(graph.isEmpty());
        System.out.println();

        //reads and adds the edges for the vertices
        while(reader.hasNextLine()){
            String edge = reader.nextLine();
            graph.addEdge(edge.charAt(0), edge.charAt(1));
        }
        //displays the edge array and vertices to verify if everything was read in and implemented correctly on the graph
        graph.getVerticesEdgesArray();


        graph.getToVertices('B');
        System.out.println();
        graph.unreachableVertices();
        System.out.println();
        System.out.print(graph.isPath('B', 'A'));
    }
}
