package algos.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by rucha on 1/21/17.
 */
public class SelectionSort {
    private int n;
    private int[] arr;

    public SelectionSort(int[] a){
        this.arr = a;
        this.n = a.length;
    }

    public void sort(){
        for(int i=0; i<n; i++) {
            int k = i;
            int min = arr[i];
            for(int j=i+1; j<n; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                    k = j;
                }
            }
            swap(i, k);
        }
    }

    private void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void print(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[] a = {5, 22, -1, 0, 2, 7, 6};
        SelectionSort s = new SelectionSort(a);
        s.sort();
        s.print();
    }
}
