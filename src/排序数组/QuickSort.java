package 排序数组;

import java.util.Arrays;

/**
 * 快速排序
 * @Author: SCSA
 * @Date: 2020/8/8 13:26
 */
public class QuickSort {

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int temp = nums[start];
        int tempStart = start, tempEnd = end;
        while(start < end) {
            while(start < end && nums[end] >= temp) {
                end--;
            }
            nums[start] = nums[end];
            while(start < end && nums[start] <= temp) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = temp;
        quickSort(nums, tempStart, start-1);
        quickSort(nums, start+1, tempEnd);
    }


    public static void main(String[] args) {
        int[] nums = {1,5,9,41,6,5,2,6,5,196,8,16,51,77};
        quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }


}
