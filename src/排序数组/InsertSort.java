package 排序数组;

import java.util.Arrays;

/**
 * 插入排序
 * @Author: SCSA
 * @Date: 2020/8/8 14:39
 */
public class InsertSort {

    private static void insertSort(int[] nums) {
        if (nums.length == 0) return;
        for (int i = 0; i < nums.length; i++) {
            int preIndex = i-1;
            int cur = nums[i];
            while (preIndex >= 0 && cur < nums[preIndex]) {
                nums[preIndex+1] = nums[preIndex]; //移动到当前位置
                preIndex--;
            }
            nums[preIndex+1] = cur;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,5,9,41,6,5,2,6,5,196,8,16,51,77};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }


}
