package com.shusheng.demo;

import java.util.*;

/**
 * @author 刘闯
 * @date 2022/6/23
 */
public class leccCode {
    public static void main(String[] args) {
        ListNode valid = mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(3))),
                new ListNode(1, new ListNode(3, new ListNode(4))));

        System.out.println("s = " + valid);
    }
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode();
        ListNode next = listNode;
        while (list1 != null && list2 != null){
            if (list1.val > list2.val){
                listNode.next = list2;
                list2 = list2.next;
            } else {
                listNode.next = list1;
                list1 = list1.next;
            }
            listNode = listNode.next;
        }

        listNode.next = list1 == null ? list2 : list1;

        return next.next;
    }

    public static boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');


        for (int i = 0; i < s.length(); i++) {
            if (deque.isEmpty()){
                deque.push(s.charAt(i));
                continue;
            }
            if (map.getOrDefault(deque.peek(), 'q') == s.charAt(i)){
                deque.poll();
                continue;
            }
            deque.push(s.charAt(i));
        }

        return deque.isEmpty();
    }

    public List<String> letterCombinations(String digits) {

        List<String> str = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> temp = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            temp.add(map.get(Integer.parseInt(String.valueOf(digits.charAt(0)))));
        }

        for (int i = 0; i < temp.size(); i++) {

        }

        return str;
    }


    public static String longestCommonPrefix(String[] strs) {
        String str = "";
        int i = 0;
        while (true){
            if (strs[0].length() == 0 || strs[0].length() <= i){
                return str;
            }
            char ch = strs[0].charAt(i);
            for (String ct : strs) {
                if (ct.length() <= i || !(ct.charAt(i) == ch)) {
                    return str;
                }
            }
            str = strs[0].substring(0, i+1);
            i ++;
        }
    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        int length = s.length();

        int num = 0;

        for (int i = 0; i < length; i++) {
            if (i == length-1){
                num += map.get(s.charAt(i)+"");
                break;
            }
            String sub = s.substring(i, i + 2);
            if (map.containsKey(sub)) {
                num += map.get(sub);
                i ++;
                continue;
            }
            num += map.get(s.charAt(i)+"");
        }


        return num;

    }


    public static String intToRoman(int num) {
        StringBuilder str = new StringBuilder();

        int len = 1000;

        while (num != 0){
            int temp = num / len;
            str.append(queryRules(temp*len));
            num = num % len;
            len = len / 10;
        }

        return str.toString();
    }

    public static String queryRules(int number){
        StringBuilder str = new StringBuilder();
        if (number >= 1000){
            while (number > 0){
                // 组合数
                number = number - 1000;
                if (number >= 0){
                    str.append("M");
                }
            }
            return str.toString();
        }

        if (number >= 100){
            // 特殊情况
            if (number == 900){
                str.append("DM");
            } else if (number == 400){
                str.append("CM");
            } else {
                // 一般情况
                while (number > 0){
                    // 组合
                    if (number >= 500){
                        number = number - 500;
                        str.append("D");
                    }
                    number = number - 100;
                    if (number >= 0){
                        str.append("C");
                    }
                }
            }
            return str.toString();
        }

        if (number >= 10){
            // 特殊情况
            if (number == 90){
                str.append("LC");
            } else if (number == 40) {
                str.append("XC");
            }else {
                // 一般情况
                while (number > 0){
                    // 组合
                    if (number >= 50){
                        number = number - 50;
                        str.append("L");
                    }
                    number = number - 10;
                    if (number >= 0){
                        str.append("X");
                    }
                }
            }
            return str.toString();
        }

        if (number >= 1) {
            // 特殊情况
            if (number == 9) {
                str.append("IX");
            } else if (number == 4) {
                str.append("IV");
            } else {
                // 一般情况
                while (number > 0) {
                    // 组合
                    if (number >= 5) {
                        number = number - 5;
                        str.append("V");
                    }
                    number = number - 1;
                    if (number >= 0) {
                        str.append("I");
                    }
                }
            }
            return str.toString();
        }

        return str.toString();
    }

    public static int maxArea(int[] height) {
        int length = height.length;
        int temp = 0;

        for (int i = 0; i < length; i++) {
            for (int j = length-1; j > i; j --) {
                int xy = (j - i) *  Math.min(height[i], height[j]);
                temp = Math.max(xy, temp);

                if (height[j] > height[i]){
                    break;
                }
            }
        }

        return temp;
    }



    public static String longestPalindrome1(String s) {
        int length = s.length();
        String str = "";

        for (int i = 0; i < length; i++) {
            for (int j = i+1; j <= length; j ++){
                String sub = s.substring(i, j);
                if (isLongest(sub)) {
                    str = sub.length() > str.length() ? sub : str;
                }
            }
        }

        return str;
    }

    public static boolean isLongest(String str){
        String str1 = new StringBuffer(str).reverse().toString();

        return str1.equals(str);
    }

    public static String longestPalindrome(String s) {
        int length = s.length();
        String str = "";
        for (int j = 0; j < length / 2; j++) {
            int end = length-j;
            for (int i = j; i < end; i++) {
                String a = s.substring(i, end);
                String z = new StringBuffer(a).reverse().toString();
                if (a.equals(z) && a.length() > str.length()){
                    str = a;
                }

                String a1 = s.substring(j, length-i);
                String z1 = new StringBuffer(a1).reverse().toString();

                if (a1.equals(z1) && a1.length() > str.length()){
                    str = a1;
                }
            }
        }


        return str;
    }

    public static List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int m = words.length, n = words[0].length(), ls = s.length();
        for (int i = 0; i < n; i++) {
            if (i + m * n > ls) {
                break;
            }
            Map<String, Integer> differ = new HashMap<String, Integer>();
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            for (int start = i; start < ls - m * n + 1; start += n) {
                if (start != i) {
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        int length = words[0].length();

        HashMap<String, Integer> ha = new HashMap<>();
        for (String word : words) {
            putItem(ha, word);
        }

        List<Integer> rel = new ArrayList<>();

        String[] splitStr = new String[s.length()/length+1];
        for (int k = 0; k < s.length() - words.length; k++) {
            int j = 0;
            for (int i = k; i < s.length(); i = i+length) {
                splitStr[j ++] = s.substring(i, length*(j));
            }

            if (splitStr.length < words.length){
                continue;
            }

            HashMap<String, Integer> splMap = new HashMap<>();
            for (int i = k; i < words.length; i++) {
                putItem(splMap, splitStr[i]);
            }
            for (int i = words.length; i < splitStr.length; i ++){
                if (splMap.equals(ha)){
                    rel.add((i-words.length)*length);
                }
                // 进行滑动

                // 移除
                delItem(splMap, splitStr[i-words.length]);
                // 新增
                putItem(splMap, splitStr[i]);
            }
        }




        return rel;
    }

    public static void putItem(HashMap<String, Integer> map, String word){
        Integer integer = map.get(word);
        if (integer == null){
            map.put(word, 1);
            return;
        }
        map.put(word,integer+1);
    }

    public static void delItem(HashMap<String, Integer> map, String word){
        Integer integer = map.get(word);
        if (integer.equals(1)){
            map.remove(word);
            return;
        }
        map.put(word,integer-1);
    }
}
