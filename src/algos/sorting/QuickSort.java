package algos.sorting;

/**
 * Created by rucha on 1/21/17.
 */
public class QuickSort {

    private int n;
    private int[] arr;

    public QuickSort(int[] a){
        this.arr = a;
        this.n = a.length;
    }

    public void sort(){
        quickSort(0,n-1);
    }

    private void quickSort(int start, int end){
        if(start >= end)
            return;
        int pivotPos = partition(start,end);
        quickSort(start,pivotPos-1);
        quickSort(pivotPos+1,end);
    }

    private int partition(int start, int end){
        int pivotVal = arr[end];
        int p = start;
        int i = start;
        while(i < end){
            if(arr[i] < pivotVal){
                swap(i,p);
                p++;
            }
            i++;
        }
        swap(p, end);
        return p;
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
        int[] a = {5, 22, -1, 0, 2, -3, -2};
        QuickSort s = new QuickSort(a);
        s.sort();
        s.print();
    }
}
