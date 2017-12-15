package Labs.Week11_GraphADT;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dk on 11/30/2017.
 */
public class LetterGraph {

    private char[] vertices;
    private int[][] edges;
    private Queue getToVerticesQueue;
    private int capacity;
    private int index;
    private boolean[] visited;
    private int visitedCount;

    public LetterGraph(int maxVertices) {
        this.capacity = maxVertices;
        this.index = 0;
        this.vertices = new char[maxVertices];
        this.edges = new int[maxVertices][maxVertices];
        this.getToVerticesQueue = new ArrayDeque<>();
        visited = new boolean[maxVertices];
    }

    public boolean isEmpty() {
        return vertices.length == 0;
    }

    public boolean isFull() {
        return vertices.length == capacity;
    }

    public void addVertex(char vertex) {
        this.vertices[index++] = vertex;
    }

    //method to verify if graph's methods(add vertex, add edge) were implemented correctly
    public void getVerticesEdgesArray() {
        for (int i = 0; i < vertices.length; i++)
            System.out.print(vertices[i] + " ");

        System.out.println();
        System.out.println();

        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length; j++)
                System.out.print(edges[i][j]);
            System.out.println();
        }
        System.out.println();
    }

    //method to add edges to graph
    public void addEdge(char vertex1, char vertex2) {
        edges[indexOf(vertex1)][indexOf(vertex2)] = 1;
    }

    //method to return the index of a given character argument
    public int indexOf(char vertex) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] == vertex)
                return i;
        }
        return 1000;
    }
    //method to return the character of a given integer index argument
    public char charOfIndex(int index) {
        return vertices[index];
    }

    //method to print out all the vertices that have edges directed towards them from a given character argument
    public void getToVertices(char vertex) {
        getToVerticesHelper(vertex);
        for (Object o : getToVerticesQueue) {
            char letter = (char) o;
            System.out.print(letter + " ");
        }
        getToVerticesQueue.clear();
    }

    //helper method for getToVertices
    public void getToVerticesHelper(char vertex) {
        for (int i = 0; i < edges[indexOf(vertex)].length; i++) {
            if (edges[indexOf(vertex)][i] == 1)
                getToVerticesQueue.add(charOfIndex(i));
        }
    }

    //method to print out what vertices do not point to other vertices
    public void unreachableVertices() {
        System.out.println("The unreachable vertices are: ");
        int sum = 0;
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length; j++)
                sum = sum + edges[i][j];
            if (sum == 0)
                System.out.print(charOfIndex(i) + " ");
            sum = 0;
        }
    }

    //method to return a boolean answer to whether there is a path from one character argument vertex to another
    public boolean isPath(char startVertex, char endVertex) {
        if (startVertex == endVertex)
            return false;
        else {
            Queue<Character> q = new LinkedList<>();
            q.add(startVertex);

            while (!q.isEmpty()) {
                char c = q.peek();
                char child = getUnvisitedChildNode(c);

                if (child != 'a') {
                    visited[indexOf(child)] = true;
                    q.add(child);
                } else if (child == endVertex)
                    return true;
                q.remove();
            }
        }
        clearVisited();
        return false;
    }

    //marks and returns children nodes that have not been visited
    public char getUnvisitedChildNode(char c) {
        for (int i = 0; i < edges.length; i++) {
            if (edges[indexOf(c)][i] > 0)
                if (!visited[i])
                    return charOfIndex(i);
        }
        return 'a';
    }

    //helper method to clear visited boolean vertices array size of 26 to represent the letters visited
    public void clearVisited() {
        for (int i = 0; i < visited.length; i++)
            visited[i] = false;
    }
}
