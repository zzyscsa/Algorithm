package 二分查找;

/**
 * 升序数组某个点进行旋转
 * @Author: SCSA
 * @Date: 2020/8/8 12:20
 */
public class 搜索旋转排序数组 {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = left+(right-left)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > nums[left]) { //左边有序
                if (nums[left]<=target && nums[mid]>target) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else if (nums[mid] < nums[right]) { //右边有序
                if (nums[right] >= target && nums[mid]<target) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            } else { //如果有重复数字的情况
                left++;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {4,4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
