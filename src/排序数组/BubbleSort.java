package 排序数组;

import java.util.Arrays;

/**
 * 冒泡排序
 * @Author: SCSA
 * @Date: 2020/8/8 14:25
 */
public class BubbleSort {

    private static void bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-1-i; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                }
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {1,5,9,41,6,5,2,6,5,196,8,16,51,77};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }


}
