package 排序数组;

import java.util.Arrays;

/**
 * 归并排序（迭代）
 * @Author: SCSA
 * @Date: 2020/8/9 12:18
 */
public class MergeSort2 {

    private static void mergeSort(int[] nums) {
        int n = nums.length;
        int k = 1;
        while (k < n) {
            mergePass(nums, k, n);
            k *= 2;
        }
    }

    /** MergePass方法负责将数组中的相邻的有k个元素的字序列进行归并 */
    private static void mergePass(int[] nums, int k, int n) {
        int i = 0, j;
        //从前往后,将2个长度为k的子序列合并为1个
        while (i < n-2*k+1) {
            merge(nums, i, i+k-1, i+2*k-1);
            i += 2*k;
        }
        //这段代码保证了，将那些“落单的”长度不足两两merge的部分和前面merge起来。
        if(i < n - k ) {
            merge(nums, i, i+k-1, n-1);
        }
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
            } else if (temp[i]<=temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {15,89,9,5,49,5,16,5,1,3,85,16,516,9,5,1,6,54,8,6,23};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }


}
