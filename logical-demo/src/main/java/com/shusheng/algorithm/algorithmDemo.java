package com.shusheng.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘闯
 * @date 2021/8/26.
 */
public class algorithmDemo {
    public static void main(String[] args) {
        String paypalishiring = convert("A", 1);
        System.out.println("paypalishiring = " + paypalishiring);
    }

    /**
     * 题一 计算两数之和
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int q = 0; q < nums.length; q ++){
            for (int w = q+1; w < nums.length; w ++){
                if (nums[q] + nums[w] == target){
                    return new int[]{q,w};
                }
            }
        }
        throw new RuntimeException("没有数！");
    }

    /**
     * 解法2
     */
    public static int[] twoSum1(int[] nums, int target) {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            li.add(nums[i]);
            int k = target - nums[i];
            int i1 = li.indexOf(k);
            if (i1 != -1 && i1 != i){
                return new int[]{i1, i};
            }
        }
        throw new RuntimeException("无数据！");
    }

    /**
     * 题二 两数之后
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        ListNode res = new ListNode();
        ListNode r = res;

        int blag = 0;

        while (l1 != null || l2 != null){
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);

            if (sum + blag >= 10){
                r.next = new ListNode(sum-10+blag);
                blag = 1;
            } else {
                r.next = new ListNode(sum+blag);
                blag = 0;
            }
            r = r.next;

            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (blag == 1){
            r.next = new ListNode(1);
        }
        return res.next;
    }

    /**
     * 题三 无重复最长字符串
     */
    public static int lengthOfLongestSubstring(String s) {
       int n = s.length(), ans = 0;
       Map<Character, Integer> map = new HashMap<>(); // current index of character
       // try to extend the range [i, j]
       for (int j = 0, i = 0; j < n; j++) {
               if (map.containsKey(s.charAt(j))) {
                       i = Math.max(map.get(s.charAt(j)), i);
                   }
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j + 1);
            }
        return ans;
    }

    /**
     * 第七题 整数翻转
     */
    public static int reverse(int x) {
        String str = String.valueOf(x);
        StringBuilder str1 = new StringBuilder();
        boolean blag = str.charAt(0) == '-';
        for (int i = str.length()-1, j = 0; i > 0; i --){
            if (j == 0 && str.charAt(i) == '0'){
                continue;
            }
            j = 1;
            str1.append(str.charAt(i));
        }

        if (blag){
            str1.insert(0, "-");
        } else {
            str1.append(str.charAt(0));
        }

        try{
            return Integer.parseInt(String.valueOf(str1));
        }catch (Exception e){
            return 0;
        }

        /**
         * ret 保存旧的翻转中间值, temp 保存新的翻转过程中间值 依次提取 x 的末位加入 temp, 如果发生溢出则通过temp/10
         * 无法得到上一轮的翻转结果 ret
         *
             int ret = 0;
             while (x != 0) {
             int temp = ret * 10 + x % 10;
             if (temp / 10 != ret)
             return 0;
             ret = temp;
             x /= 10;
             }
             return ret;
         **/
    }

    /**
     * 回文数  121       0  1
     */
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int i = 0, j = str.length()-1;
        while (i < j){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }

    /**
     * 中位数
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = (nums1 != null && nums1.length > 0) ? nums1.length : 0;
        int l2 = (nums2 != null && nums2.length > 0) ? nums2.length : 0;
        int[] l3 = new int[l1+l2];
        int i = 0,j = 0, temp = 0;
        while(i < l1 || j < l2){
            if (i == l1){
                while (j < l2){
                    l3[temp ++] = nums2[j ++];
                }
                break;
            }
            if (j == l2){
                while (i < l1){
                    l3[temp ++] = nums1[i ++];
                }
                break;
            }
            if (nums1[i] < nums2[j]){
                l3[temp ++] = nums1[i ++];
            } else {
                l3[temp ++] = nums2[j ++];
            }
        }
        if (l3.length == 1){
            return l3[0]*1.0;
        }
        if (l3.length % 2 == 0){
            return (l3[l3.length/2] + l3[l3.length/2-1])*1.0/2;
        } else {
            return l3[l3.length/2]*1.0;
        }
    }

    /**
     * Z 字形变换
     */
    public static String convert(String s, int numRows) {
        StringBuilder res = new StringBuilder();
        int temp = numRows <= 2 ? 0 : numRows - 2;
        for (int i = 0, n = s.length(); i < numRows; i++) {
            int k = i;
            if (i == 0 || i == numRows - 1) {
                while (k < n){
                    res.append(s.charAt(k));
                    k += numRows+temp;
                }
            } else {
                boolean blag = true;
                while (k < n){
                    res.append(s.charAt(k));
                    k += blag ? (numRows-i-1)*2 : i*2;
                    if ((numRows-i-1)*2 != 0 || i*2 != 0){
                        blag = !blag;
                    }
                }
            }
        }
        return String.valueOf(res);
    }
}
