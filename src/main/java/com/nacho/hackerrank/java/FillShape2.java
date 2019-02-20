package com.nacho.hackerrank.java;

import java.util.ArrayList;
import java.util.List;

public class FillShape2 {

    // Complete the fillShape function below.
    public List<List<Integer>> fillShape(List<List<Integer>> matrix) {
        List<List<Integer>> listFill = new ArrayList<>(matrix);

        // Find the center of the Matrix
        Center center = this.getCenter(listFill);

        // Implement flodFill algorithm
        this.floodFill(listFill, center.getRow(), center.getColumn(), 0, 1);

        return listFill;
    }

    private void floodFill(List<List<Integer>> matrix, int row, int column, int oldValue, int newValue) {

        if (row < 0 || row >= matrix.size() || column < 0 || column >= matrix.get(0).size())
            return;

        if (matrix.get(row).get(column) != oldValue)
            return;

        // Replace with new value
        matrix.get(row).set(column, newValue);

        // Recur for south, north, east, and west
        floodFill(matrix, row + 1, column, oldValue, newValue);
        floodFill(matrix, row - 1, column, oldValue, newValue);
        floodFill(matrix, row, column + 1, oldValue, newValue);
        floodFill(matrix, row, column - 1, oldValue, newValue);
    }

    private Center getCenter(List<List<Integer>> matrix) {

        int row = this.getMiddle(matrix.size());
        int column = this.getMiddle(matrix.get(0).size());

        return new Center(row, column);
    }

    private int getMiddle(int num) {
        int middle;

        if (num % 2 == 0) {
            // Even
            middle = (num / 2 + num / 2 - 1) / 2;
        } else {
            // Odd
            middle = num / 2;
        }

        return middle;
    }

    class Center {
        private final int row;
        private final int column;

        public Center(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }


}
