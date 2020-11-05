package KMP;

import java.util.Arrays;

/**
 * KMP字符串匹配
 * @Author: SCSA
 * @Date: 2020/8/16 15:17
 */
public class KMP {


    /**
     * @param s1
     * @param s2
     * @param next
     * @return 匹配到返回匹配的位置下标，未匹配到返回-1
     */
    public static int kmpSearch(String s1, String s2, int[] next) {
        int aaaaa = 1;
        int j = 0; //s2匹配的位置
        for (int i = 0; i < s1.length(); i++) {
            while (j > 0 && s1.charAt(i)!=s2.charAt(j)) {
                j = next[j-1];
            }
            if (s1.charAt(i)==s2.charAt(j)) {
                j++;
            }
            if (j == s2.length()) {
                return i-j+1;
            }
        }
        return -1;
    }

    /**
     * 获得部分匹配值的next数组,next[i]表示(0,i)前缀和后缀共有元素的长度
     * @param s
     * @return
     */
    public static int[] kmpNext(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;
        int j = 0;
        for(int i = 1; i < next.length; i++) {
            //当 s.charAt(i) != s.charAt(j) ，我们需要从 next[j-1]获取新的 j
            //s.charAt(i)就是后缀的最后一个字母
            while(j > 0 && s.charAt(i)!=s.charAt(j)) {
                j = next[j-1];
            }
            if(s.charAt(i)==s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        String s1 = "BBC ABCDAB ABCDABCDABDE";
        String s2 = "ABCDABD";
        int[] next = kmpNext(s2);
        System.out.println(Arrays.toString(next));
        System.out.println(kmpSearch(s1, s2, next));
    }
}
