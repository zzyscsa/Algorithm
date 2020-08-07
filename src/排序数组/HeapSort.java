package 排序数组;

import java.util.Arrays;

/**
 * 堆排序
 * @Author: SCSA
 * @Date: 2020/8/7 16:47
 */
public class HeapSort {

    private static int[] heapSort(int[] nums) {
        int n = nums.length;
        for (int i = n/2-1; i >= 0; i--) {
            initiate(nums, i, n);
        }
        for (int i = nums.length-1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            initiate(nums, 0, i);
        }

        return nums;
    }

    /**
     * 维护最大堆
     * @param nums
     * @param index 当前调整的结点下标
     * @param len 维护的长度
     */
    private static void initiate(int[] nums, int index, int len) {
        int temp = nums[index];
        for (int i = index*2+1; i < len; i = i*2+1) {
            if((i+1)<len && nums[i]<nums[i+1]) {
                i++;
            }
            if(nums[i] > temp) {
                nums[index] = nums[i];
                index = i;
            }
        }
        nums[index] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,9,41,6,5,2,6,5,196,8,16,51,77};
        System.out.println(Arrays.toString(heapSort(nums)));
    }

}
