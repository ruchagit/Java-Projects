package algos.sorting;

import java.util.*;

/**
 * Created by rucha on 1/21/17.
 */
public class CountingSort {

    private int n;
    private int[] arr;
    private int[] res;

    public CountingSort(int[] a){

        this.n = a.length;
        this.arr = a;
        this.res = new int[n];
    }

    public void radixSort(){
        // Find the maximum number to know number of digits
        int m = getMax();

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(exp);
    }

    private int getMax()
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    private void countSort(int exp)
    { // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            res[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++)
            arr[i] = res[i];
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(res[i]).append(' ');
        }
        System.out.println(sb.toString());
    }

    public void print(int[] b){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<b.length; i++) {
            sb.append(b[i]).append(' ');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[] b = {99,45,98,2,13,0};
        CountingSort s = new CountingSort(b);
        int[] b1 = {4,3,1,2,2,2,1,0,3,32};
        CountingSort s1 = new CountingSort(b1);
        s.radixSort();
        s.print();
        s1.countSort(1);
        s1.print();
    }
}
