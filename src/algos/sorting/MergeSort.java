package algos.sorting;
import java.util.*;

/**
 * Created by rucha on 1/21/17.
 */
public class MergeSort {

    private int n;
    private int[] arr;

    public MergeSort(int[] a){
        this.arr = a;
        this.n = a.length;
    }

    public void sort(){
        mergeSort(0,n-1);
    }

    private void mergeSort(int start, int end){
        if(start == end)
            return;
        int half = (start + end) / 2;
        mergeSort(start,half);
        mergeSort(half+1,end);
        merge(start, half, end);
    }

    private void merge(int start, int mid, int end){
        int i = start;
        int j = mid+1;
        int[] temp = new int[n];
        int k = start;
        while(i<=mid && j<=end){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i];
                i++;
            }
            else{
                temp[k++] = arr[j];
                j++;
            }
        }
        while(i<=mid){
            temp[k++] = arr[i];
            i++;
        }
        while(j<=end){
            temp[k++] = arr[j];
            j++;
        }
        for(i=start; i<=end; i++)
        {
            arr[i] = temp[i];
        }
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
        MergeSort s = new MergeSort(a);
        s.sort();
        s.print();
    }
}
