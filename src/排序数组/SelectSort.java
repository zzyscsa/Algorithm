package 排序数组;

import java.util.Arrays;

/**
 * 选择排序
 * @Author: SCSA
 * @Date: 2020/8/10 13:33
 */
public class SelectSort {

    private static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,5,9,41,6,5,2,6,5,196,8,16,51,77};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }


}
