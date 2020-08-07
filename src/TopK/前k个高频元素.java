package TopK;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 手写堆实现
 * @Author: SCSA
 * @Date: 2020/8/7 17:27
 */
public class 前k个高频元素 {
    static class Node {
        public int code;
        public int times;

        public Node(int code, int times) {
            this.code = code;
            this.times = times;
        }
    }


    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        Node[] arr = new Node[k];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (index < k) {
                Node node = new Node(entry.getKey(), entry.getValue());
                arr[index] = node;
                index++;
                if (index == k) {
                    for (int i = k /2 -1; i >= 0; i--) {
                        initiate(arr, i, k);
                    }
                }
            } else {
                if (entry.getValue() > arr[0].times) {
                    arr[0] = new Node(entry.getKey(), entry.getValue());
                    initiate(arr, 0, k);
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i].code;
        }
        return res;
    }

    /**
     * 维护小顶堆
     * @param arr
     * @param index
     * @param k
     */
    private static void initiate(Node[] arr, int index, int k) {
        Node temp = arr[index];
        for (int i = index*2+1; i < k; i = i*2+1) {
            //找左右结点最小值
            if ((i+1)<k && arr[i+1].times<arr[i].times) {
                i++;
            }
            if (temp.times > arr[i].times) {
                arr[index] = arr[i];
                index = i;
            }
        }
        arr[index] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,11,1,1,1,1,1,1,2,2,2,3,3,3,3,3,3,3,3,3};
        int k = 3;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
