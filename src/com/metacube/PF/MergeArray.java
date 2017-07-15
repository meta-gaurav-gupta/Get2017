package com.metacube.PF;

/**
 * PFAssignment6 - Merge Two Arrays And Produce Third Array
 * @author User
 */
public class MergeArray {
    /**
     * @param a integer array
     * @param asize integer size of array a
     * @param b integer array
     * @param bsize integer size of array b
     * @param c integer array - output array
     * @return integer array - merged result
     */
    public int[] join(int[] a, int asize, int[] b, int bsize, int[] c){
        int index_a = 0;
        int index_b = 0;
        int index_c = 0;
        int sortedOrderFirstArray = checkSortedOrder(a);
        int sortedOrderSecondArray = checkSortedOrder(b);
        if((sortedOrderFirstArray == 1) && (sortedOrderSecondArray == 1)) {
            while(index_a < asize && index_b < bsize){
                if(a[index_a] < b[index_b]){
                    c[index_c] = a[index_a];
                    index_c++;
                    index_a++;
                }else{
                    c[index_c] = b[index_b];
                    index_b++;
                    index_c++;
                }
            }
            while(index_a < asize){
                c[index_c] = a[index_a];
                index_c++;
                index_a++;
            }
            while(index_b < bsize){
                c[index_c] = b[index_b];
                index_c++;
                index_b++;
            }
        }else if((sortedOrderFirstArray == 2) && (sortedOrderSecondArray == 2)) {
            while(index_a < asize && index_b < bsize){
                if(a[index_a] > b[index_b]){
                    c[index_c] = a[index_a];
                    index_c++;
                    index_a++;
                }else{
                    c[index_c] = b[index_b];
                    index_b++;
                    index_c++;
                }
            }
            while(index_a < asize){
                c[index_c] = a[index_a];
                index_c++;
                index_a++;
            }
            while(index_b < bsize){
                c[index_c] = b[index_b];
                index_c++;
                index_b++;
            }
            reverseArray(c);
        }else if(((sortedOrderFirstArray == 1) && (sortedOrderSecondArray == 2))
                || ((sortedOrderFirstArray == 2) && (sortedOrderSecondArray == 1))) {
            if(sortedOrderFirstArray == 1) {
                reverseArray(b);
            }else {
                reverseArray(a);
            }

            while(index_a<asize && index_b<bsize){
                if(a[index_a] < b[index_b]){
                    c[index_c] = a[index_a];
                    index_c++;
                    index_a++;
                }else{
                    c[index_c] = b[index_b];
                    index_b++;
                    index_c++;
                }
            }
            while(index_a < asize){
                c[index_c] = a[index_a];
                index_c++;
                index_a++;
            }
            while(index_b < bsize){
                c[index_c] = b[index_b];
                index_c++;
                index_b++;
            }
        }else {
            System.out.println("Array are Not Sorted.");
        }

        return c;
    }

    /**
     * @param a integer array
     * @return integer array with reverse of a array
     */
    public int[] reverseArray(int[] a) {
        for(int i = 0 ; i < a.length / 2 ; i++) {
            a[i] = a[a.length - i - 1] + a[i];
            a[a.length - i - 1] = a[i] - a[a.length - i - 1];
            a[i] = a[i] - a[a.length - i - 1]; 
        }
        
        return a;
    }

    /**
     * @param a integer array
     * @return integer ( 0 -> not sorted 1 -> ascending sort 2 -> descending sort
     */
    public int checkSortedOrder(int[] a) {
        int flagAsc = 0;
        int flagDesc = 0;
        int result;
        for(int i = 1 ; i < a.length ; i++){
            if(a[i] > a[i - 1]){
            flagAsc++;
            }else if(a[i] < a[i - 1]){
            flagDesc++;
            }
        }
        if(flagAsc == a.length - 1){
            result = 1;
        }else if(flagDesc == a.length - 1){
            result = 2;
        }else{
            result = 0;
        }
        
        return result;
    }
}
