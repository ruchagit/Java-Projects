package algos.sorting;

/**
 * Created by rucha on 1/22/17.
 */
public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1;
        int k = m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--; k--;
            }
            else if(nums2[j] > nums1[i]){
                nums1[k] = nums2[j];
                j--; k--;
            }
            else{
                nums1[k] = nums1[i];
                i--; k--;
                nums1[k] = nums2[j];
                j--; k--;
            }
        }
        while(i>=0){
            nums1[k] = nums1[i];
            i--; k--;
        }
        while(j>=0){
            nums1[k] = nums2[j];
            j--; k--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,11,0,0,0};
        int[] nums2 = {5,6,10};
        MergeSortedArrays m = new MergeSortedArrays();
        m.merge(nums1,3,nums2,3);
        for(int i=0; i<nums1.length; i++){
            System.out.println(nums1[i] + " ");
        }
    }
}
