package TopK;

import java.util.Arrays;

/**
 * 不使用优先队列，手写最大堆
 * @Author: SCSA
 * @Date: 2020/8/7 15:12
 */
public class 最小的k个数 {
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length < k || k <= 0) {
            return new int[0];
        }
        int[] nums = new int[k];
        // 初始化堆
        for(int i = 0; i < k; i++) {
            nums[i] = arr[i];
        }

        //维护大顶堆,从下至上维护，从第一个非叶子节点开始！
        for(int i = k / 2 - 1; i >= 0; i--) {
            initiate(nums, i, k);
        }

        //把arr.length-k个数字依次和堆顶比较
        for(int i = k; i < arr.length; i++) {
            if(arr[i] < nums[0]) {
                nums[0] = arr[i];
                //从下标0开始继续维护
                initiate(nums, 0, k);
            }
        }

        //将大顶堆中结点升序排序
        for(int i = nums.length-1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            initiate(nums, 0, i);
        }

        return nums;
    }

    /**
     * 维护大顶堆函数
     * @param nums 堆数组
     * @param index 需要维护的结点下标
     * @param k 维护的结点个数
     */
    private static void initiate(int[] nums, int index, int k) {
        int temp = nums[index];
        for(int i = index*2+1; i < k; i = i*2+1) { //每次都找左孩子
            if( (i+1)<k && nums[i] < nums[i+1]) {
                //获得左右孩子中最大的结点
                i++;
            }
            if (nums[i] > temp) {
                nums[index] = nums[i];
                index = i; //更新index的值，index最终代表当前维护的tamp在堆中的最终位置，需要不断向下寻找
            } else {
                break; //下面的结点都是维护好的，就不需要继续下去了
            }
        }
        nums[index] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,2,4,2,2,3,1,4};
        System.out.println(Arrays.toString(getLeastNumbers(arr, 8)));
    }
}
