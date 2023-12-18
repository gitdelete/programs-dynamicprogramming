package com.aman.dynamic;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostPathMatrix_RIGHT_DOWN_LEFT_UP_DIJKSTRA {

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int ROW = 5;
    static int COL = 5;

    // Custom class for representing
// row-index, column-index &
// distance of each cell
    static class Cell
    {
        int x;
        int y;
        int distance;

        Cell(int x, int y, int distance)
        {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    // Custom comparator for inserting cells
// into Priority Queue
    static class distanceComparator
            implements Comparator<Cell>
    {
        public int compare(Cell a, Cell b)
        {
            if (a.distance < b.distance)
            {
                return -1;
            }
            else if (a.distance > b.distance)
            {
                return 1;
            }
            else {return 0;}
        }
    }

    // Utility method to check whether current
// cell is inside grid or not
    static boolean isInsideGrid(int i, int j)
    {
        return (i >= 0 && i < ROW &&
                j >= 0 && j < COL);
    }

    // Method to return shortest path from
// top-corner to bottom-corner in 2D grid
    static int shortestPath(int[][] grid, int row,
                            int col)
    {
        int[][] dist = new int[row][col];

        // Initializing distance array by INT_MAX
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        // Initialized source distance as
        // initial grid position value
        dist[0][0] = grid[0][0];

        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(
                row * col, new distanceComparator());

        // Insert source cell to priority queue
        pq.add(new Cell(0, 0, dist[0][0]));
        while (!pq.isEmpty())
        {
            Cell curr = pq.poll();
            for(int i = 0; i < 4; i++)
            {
                int rows = curr.x + dx[i];
                int cols = curr.y + dy[i];

                if (isInsideGrid(rows, cols))
                {
                    if (dist[rows][cols] >
                            dist[curr.x][curr.y] +
                                    grid[rows][cols])
                    {

                        // If Cell is already been reached once,
                        // remove it from priority queue
                        if (dist[rows][cols] != Integer.MAX_VALUE)
                        {
                            Cell adj = new Cell(rows, cols,
                                    dist[rows][cols]);

                            pq.remove(adj);
                        }

                        // Insert cell with updated distance
                        dist[rows][cols] = dist[curr.x][curr.y] +
                                grid[rows][cols];

                        pq.add(new Cell(rows, cols,
                                dist[rows][cols]));
                    }
                }
            }
        }
        return dist[row - 1][col - 1];
    }

    // Driver code
    public static void main(String[] args)
            throws IOException
    {
        int[][] grid = { { 31, 100, 65, 12, 18 },
                { 10, 13, 47, 157, 6 },
                { 100, 113, 174, 11, 33 },
                { 88, 124, 41, 20, 140 },
                { 99, 32, 111, 41, 20 } };

        System.out.println(shortestPath(grid, ROW, COL));
    }
}
