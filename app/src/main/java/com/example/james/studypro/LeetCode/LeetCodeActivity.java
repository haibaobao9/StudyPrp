package com.example.james.studypro.LeetCode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.james.studypro.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LeetCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leet_code);

        int[] a = new int[]{1, 3, 5, 6};
        Log.d("xxy", searchInsert(a, 5) + "");
        Log.d("xxy", searchInsert(a, 2) + "");
        Log.d("xxy", searchInsert(a, 7) + "");
        Log.d("xxy", searchInsert(a, 0) + "");
        Log.d("xxy", searchInsert(new int[]{1, 3}, 0) + "");
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[]{-1, -1};
        }
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

    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int) result;
    }

    public boolean isPalindrome(int x) {
        if (x >= 0 && x < 10) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int rev = 0;
        while (rev < x) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev == x || rev / 10 == x;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) return "";
        String perfix = strs[0];
        for (String str : strs) {
            while (str.indexOf(perfix) != 0) {
                perfix = perfix.substring(0, perfix.length() - 1);
            }
        }
        return perfix;
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
                    if (stack.isEmpty() || stack.pop() != 'c') {
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
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int curIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[curIndex]) {
                curIndex++;
                nums[curIndex] = nums[i];
            }
        }
        return curIndex + 1;
    }

    public int removeElement(int[] nums, int val) {
        int curIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[++curIndex] = nums[i];
            }
        }
        return curIndex + 1;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return nums[left] < target ? left + 1 : left;
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum >= result) {
                result = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public String addBinary(String a, String b) {
        int step = 0;
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        while (i > -1 || j > -1) {
            int aValue = i > -1 ? a.charAt(i--) - '0' : 0;
            int bValue = j > -1 ? b.charAt(j--) - '0' : 0;
            result.insert(0, (aValue + bValue + step) % 2);
            step = (aValue + bValue + step) / 2;
        }
        if (step == 1) {
            result.insert(0, 1);
        }
        return result.toString();
    }

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 0, right = x, ans = 0;
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
        if (n < 3) {
            return n;
        }
        int pre = 2, prepre = 1, result = 0;
        for (int i = 3; i <= n; i++) {
            result = pre + prepre;
            prepre = pre;
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

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        for (int i = m + n - 1; i >= 0; i--) {
            int nums1_val = m > 0 ? nums1[m - 1] : Integer.MIN_VALUE;
            int nums2_val = n > 0 ? nums2[n - 1] : Integer.MIN_VALUE;
            if (nums1_val > nums2_val) {
                nums1[i] = nums1_val;
                m--;
            } else {
                nums1[i] = nums2_val;
                n--;
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
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    private boolean isMirror(TreeNode t1,TreeNode t2){
        if (t1 == null && t2 == null){
            return true;
        }
        if (t1 == null || t2 == null || t1.val != t2.val){
            return false;
        }
        return isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(0,list);
        }
        return result;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return helper(nums,0,nums.length - 1);
    }

    private TreeNode helper(int[] nums,int left,int right){
        if (left > right) return null;
        int mid = (right - left) /2 + left;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums,left,mid - 1);
        node.right = helper(nums,mid + 1,right);
        return node;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return helper(root) != -1;
    }

    private int helper(TreeNode node){
        if (node == null) return 0;
        int leftDepth = helper(node.left);
        int rightDepth = helper(node.right);
        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1)
            return -1;
        return Math.max(leftDepth,rightDepth) + 1;
    }

}
