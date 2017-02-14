package algos.sorting;
import java.util.*;

/**
 * Created by rucha on 1/21/17.
 */
public class HeapSort {

    private int n;
    private int[] arr;
    private int capacity;

    public HeapSort(int[] a){

        this.capacity = 100;
        this.arr = new int[this.capacity];
        this.n = a.length;
        System.arraycopy(a,0,this.arr,0,a.length);
    }

    private void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb.toString());
    }

    public int getMax(){
        return arr[1];
    }

    public void deleteMax(){
        swap(1, n-1);
        n--;
        pushDown(1,2,3);
    }

    private void pushDown(int parent,int lc,int rc){
        int selectedChild = parent;
        if(lc<n && arr[lc] > arr[parent]){
            selectedChild = lc;
        }
        if(rc<n && arr[rc] > arr[selectedChild]){
            selectedChild = rc;
        }
        if(selectedChild != parent){
            swap(parent,selectedChild);
            parent = selectedChild;
            lc = 2 * parent;
            rc = lc + 1;
            pushDown(parent,lc,rc);
        }
    }

    public void insert(int num){
        arr[n++] = num;
        pushUp();
    }

    private void pushUp(){
        int currPos = n-1;
        int currParent = currPos/2;
        while(currParent >= 1){
            if(arr[currParent] < arr[currPos]){
                swap(currParent,currPos);
                currPos = currParent;
                currParent = currPos/2;
            }
            else
                break;
        }
    }

    public void buildHeap(){
        for(int i=(n-1)/2; i>=1; i--){
            pushDown(i,2*i, 2*i+1);
        }
    }

    public int[] heapSort(){
        buildHeap();
        int[] res = new int[n];
        int j = n;
        for(int i=1; i<j; i++){
            res[j-i] = getMax();
            deleteMax();
        }
        return res;
    }

    public void print(int[] a){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<a.length; i++) {
            sb.append(a[i]).append(' ');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        /*int[] a = {-9999,50,30,15,19,20,10,5,2};
        HeapSort s = new HeapSort(a);
        s.print();
        s.deleteMax();
        s.print();
        s.insert(100);
        s.print();*/
        int[] b = {-9999,1,2,3,4,5,6,7,8,9,10};
        HeapSort s = new HeapSort(b);
        //s.print();
        //int[] res = s.heapSort();
        //s.print(res);
        s.buildHeap();
        s.print();
    }
}
