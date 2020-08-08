package 二分查找;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * @Author: SCSA
 * @Date: 2020/8/8 12:53
 */
public class 寻找重复数字 {
    public static int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = left+(right-left)/2;
            int cnt = 0;
            for (int n : nums) {
                if (n <= mid)
                    cnt++;
            }
            if (cnt <= mid) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        System.out.println(findDuplicate(nums));
    }
}
