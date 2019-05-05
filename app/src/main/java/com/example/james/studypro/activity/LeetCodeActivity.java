package com.example.james.studypro.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.james.studypro.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class LeetCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leet_code);
    }

    public int[] twoSum(int[] nums, int target){
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    public int reserve(int x){
        long res = 0;
        while (x != 0){
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? 0 : (int) res;
    }

    public boolean isPalindrome(int x) {
        if (0 <= x && x < 10){
            return true;
        }
        if (x < 0 || x % 10 == 0){
            return false;
        }
        int res = 0;
        while (res < x){
            res = res * 10 + x % 10;
            x /= 10;
        }
        return x == res || x == res / 10;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) return "";
        String prefix = strs[0];
        for (String s : strs){
            while (s.indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length() - 1);
            }
        }
        return prefix;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars){
            switch (c){
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '(':
                    stack.push(')');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] != nums[index]){
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[index ++] = nums[i];
            }
        }
        return index;
    }
}
