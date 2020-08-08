package 二分查找;

/**
 * 存在重复元素
 * @Author: SCSA
 * @Date: 2020/8/8 12:29
 */
public class 寻找旋转排序数组中的最小值 {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(left <= right) {
            int mid = left+(right-left)/2;
            min = Math.min(min, nums[mid]);
            if (nums[mid] > nums[left]) {
                min = Math.min(min, nums[left]);
                left = mid+1;
            } else if (nums[mid] < nums[right]) {
                min = Math.min(min, nums[mid]);
                right = mid-1;
            } else {
                left++; //如果重复数字
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {4,4,4,4,4,4,4,4};
        System.out.println(findMin(nums));
    }
}
