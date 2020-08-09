package 排序数组;

import java.util.Arrays;

/**
 * 归并排序（递归）
 * @Author: SCSA
 * @Date: 2020/8/9 11:57
 */
public class MergeSort {

    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left+(right-left)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);

        if (nums[mid] <= nums[mid+1]) return;

        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[nums.length];
        System.arraycopy(nums, left, temp, left, right-left+1);
        int i = left, j = mid+1;
        for (int k = left; k <= right; k++) {
            if (i==mid+1) {
                nums[k] = temp[j++];
            } else if (j==right+1) {
                nums[k] = temp[i++];
            } else if (temp[i]<=temp[j]) { //注意使用temp数组比较大小,nums数组已被改动过
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {15,89,9,5,49,5,16,5,1,3,85,16,516,9,5,1,6,54,8,6,23};
        mergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

}
