package TopK;

/**
 * 使用快排的思想方法
 * @Author: SCSA
 * @Date: 2020/9/24 14:28
 */
public class 数组中第k大的元素 {
    public static int findKth(int[] a, int n, int k) {
        // write code here
        int begin = 0, end = n-1;
        int pos = 0;
        while(begin <= end) {
            pos = partion(a, begin, end);
            if(pos == n-k) {
                return a[pos];
            } else if(pos > n-k) {
                end = pos-1;
            } else {
                begin = pos+1;
            }
        }
        return -1;
    }
    private static int partion(int[] arr, int start, int end) {
        if(start>end) return 0;
        int temp = arr[start];
        while(start < end) {
            while(start < end && arr[end] >= temp) {
                end--;
            }
            arr[start] = arr[end];
            while(start < end && arr[start] <= temp) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = temp;
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,9,41,6,5,2,6,5,196,8,16,51,77};
        //[1, 2, 5, 5, 5, 6, 6, 8, 9, 16, 41, 51, 77, 196]
        System.out.println(findKth(arr, arr.length, 7));
    }
}
