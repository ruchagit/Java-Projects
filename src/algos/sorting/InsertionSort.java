package algos.sorting;

/**
 * Created by rucha on 1/21/17.
 */
public class InsertionSort {
    private int n;
    private int[] arr;

    public InsertionSort(int[] a){
        this.arr = a;
        this.n = a.length;
    }

    public void sort(){
        for(int i=1; i<n; i++){
            for(int j=i; j>0; j--){
                if(arr[j] < arr[j-1]){
                    swap(j, j-1);
                }
            }
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
        InsertionSort s = new InsertionSort(a);
        s.sort();
        s.print();
    }
}
