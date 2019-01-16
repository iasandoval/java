package com.nacho.collections;

public class CollectionsMain {

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5};
        int d = 4;
        rotateLeft(a,d);

        rotLeft(a,d);

    }

    static int[] rotateLeft(int[] a, int n) {

        int[] r = a.clone();

        int aSize = r.length;

        for(int i = 0; i<aSize; i++){
            int pos = (i+n) % aSize;
            r[i] = a[pos];
        }

        return r;
    }


    static int[] rotLeft(int[] a, int n) {

        int[] r = a.clone();

        int size = r.length-1;

        for(int x = 0; x<n; x++){

            int head = r[0];

            for(int i=0;i<size;i++) {
                r[i] = r[i+1];
            }

            r[size] = head;

        }

        return r;
    }

}
