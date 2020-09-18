package com.nacho.hackerrank.fillshape;

import java.util.ArrayList;
import java.util.List;

public class FillShape {

    // Complete the fillShape function below.
    public List<List<Integer>> fillShape(List<List<Integer>> matrix) {
        List<List<Integer>> listFill = new ArrayList<>(matrix);

        for (List<Integer> r : listFill) {
            Border b = this.checkBorder(r);

            if (b.hasFill()) {
                for (Integer f : b.getIndexToFill()) {
                    r.set(f, 1);
                }
            }
        }

        return listFill;
    }

    private Border checkBorder(List<Integer> row) {
        Border border = new Border();

        // check left border
        for (int l = 0; l < row.size(); l++) {
            if (row.get(l) == 1) {
                border.setIndexL(l);
                break;
            }
        }

        // check right border
        for (int r = row.size() - 1; r >= 0; r--) {
            if (row.get(r) == 1) {
                border.setIndexR(r);
                break;
            }
        }

        // check filling spaces
        for (int f = border.getIndexL() + 1; f < border.getIndexR(); f++) {
            if (row.get(f) == 0) {
                border.addToIndexToFill(f);
            }
        }

        return border;
    }


    class Border {
        private int indexL;
        private int indexR;
        private List<Integer> indexToFill;

        public Border() {
            this.indexToFill = new ArrayList<>();
        }

        public boolean hasFill() {
            return !this.indexToFill.isEmpty();
        }

        public void addToIndexToFill(Integer i) {
            this.indexToFill.add(i);
        }

        public List<Integer> getIndexToFill() {
            return this.indexToFill;
        }

        public int getIndexL() {
            return indexL;
        }

        public void setIndexL(int indexL) {
            this.indexL = indexL;
        }

        public int getIndexR() {
            return indexR;
        }

        public void setIndexR(int indexR) {
            this.indexR = indexR;
        }
    }

}
