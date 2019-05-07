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

        searchInsert(new int[]{1, 3, 5, 6}, 5);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public int reserve(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? 0 : (int) res;
    }

    public boolean isPalindrome(int x) {
        if (0 <= x && x < 10) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int res = 0;
        while (res < x) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return x == res || x == res / 10;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) return "";
        String prefix = strs[0];
        for (String s : strs) {
            while (s.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            switch (c) {
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
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int temp = 0;
        for (int i : nums) {
            temp += i;
            if (temp > maxSum) {
                maxSum = temp;
            }
            if (temp < 0) {
                temp = 0;
            }
        }
        return maxSum;
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        int[] array = new int[digits.length + 1];
        array[0] = 1;
        return array;
    }

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int step = 0;
        while (i > -1 || j > -1) {
            int val1 = i > -1 ? a.charAt(i--) - '0' : 0;
            int va12 = j > -1 ? b.charAt(j--) - '0' : 0;
            result.insert(0, (val1 + va12 + step) % 2);
            step = (va12 + val1 + step) / 2;
        }
        if (step == 1) {
            result.insert(0, 1);
        }
        return result.toString();
    }

    public int mySqrt(int x) {
        if (x < 2) return x;
        int ans = 0, left = 0, right = x;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (x / mid >= mid) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public int climbStairs(int n) {
        if (n < 3) return n;
        int pre = 2, prePre = 1, result = 0;
        for (int i = 3; i <= n; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            head.next = head.next.next;
            return deleteDuplicates(head);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

    public ListNode deleteDuplicatesByStack(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            if (!stack.contains(head.val)) {
                stack.push(head.val);
            }
            head = head.next;
        }
        ListNode cur = null, pre = null;
        while (!stack.isEmpty()) {
            cur = new ListNode(stack.pop());
            cur.next = pre;
            pre = cur;
        }
        return cur;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        for (int i = length - 1; i > -1; i--) {
            int v1 = m > 0 ? nums1[m - 1] : Integer.MIN_VALUE;
            int v2 = n > 0 ? nums2[n - 1] : Integer.MIN_VALUE;
            if (v1 > v2) {
                nums1[i] = v1;
                --m;
            } else {
                nums1[i] = v2;
                --n;
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null || p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

}
