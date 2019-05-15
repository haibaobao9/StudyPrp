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

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        Log.d("xxy",minDepth(root) + "");
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
        int left = 0 , right = nums.length - 1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int temp = 0;
        for (int i : nums){
            temp += i;
            sum = temp > sum ? temp : sum;
            temp = temp > 0 ? temp : 0;
        }
        return sum;
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i > -1; i--){
            if (digits[i] != 9){
                digits[i] += 1;
                return digits;
            }else {
                digits[i] = 0;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int m = a.length() - 1, n = b.length() - 1, step = 0;
        while (m > -1 || n > -1){
            int v1 = m > -1 ? a.charAt(m--) - '0' : 0;
            int v2 = n > -1 ? b.charAt(n--) - '0' : 0;
            builder.insert(0,(v1 + v2 + step) % 2);
            step = (v1 + v2 + step) / 2;
        }
        if (step == 1){
            builder.insert(0, 1);
        }
        return builder.toString();
    }

    public int mySqrt(int x) {
        if (x < 2){
            return x;
        }
        int left = 0, right = x,ans = 0;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if (x / mid >= mid){
                ans = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public int climbStairs(int n) {
        if (n < 3){
            return n;
        }
        int pre = 2, prePre = 1,result = 0;
        for (int i = 3; i <= n; i++){
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        if (head.val == head.next.val){
            head.next = head.next.next;
            return deleteDuplicates(head);
        }else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

    public ListNode deleteDuplicatesByStack(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            if (!stack.contains(head.val)){
                stack.push(head.val);
            }
            head = head.next;
        }
        ListNode p = null, q = null;
        while (!stack.isEmpty()){
            p = new ListNode(stack.pop());
            p.next = q;
            q = p;
        }
        return p;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m + n - 1; i > -1; i--){
             int v1 = m > 0 ? nums1[m - 1] : Integer.MIN_VALUE;
             int v2 = n > 0 ? nums2[n - 1] : Integer.MIN_VALUE;
             if (v1 > v2){
                 nums1[i] = v1;
                 m --;
             }else {
                 nums1[i] = v2;
                 n --;
             }
        }
    }

    public static class TreeNode {
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return helper(root.left,root.right);
    }

    private boolean helper(TreeNode p, TreeNode q){
        if (p == null && q ==null){
            return true;
        }
        if (p == null || q == null || p.val != q.val){
            return false;
        }
        return helper(p.left,q.right) && helper(p.right,q.left);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(0,list);
        }
        return result;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length - 1);
    }

    private TreeNode helper(int nums[],int left,int right){
        if (left > right) return null;
        int mid = (right - left) / 2 + left;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums,left,mid - 1);
        node.right = helper(nums,mid + 1,right);
        return node;
    }

    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode node){
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        int lh = helper(node.left);
        int rh = helper(node.right);
        if (lh == - 1 || rh == - 1 || Math.abs(lh - rh) > 1){
            return -1;
        }
        return Math.max(lh,rh) + 1;
    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int lh = minDepth(root.left);
        int rh = minDepth(root.right);
        return (rh == 0 || lh == 0) ? rh + lh + 1 : Math.min(rh,lh) + 1;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.val == sum && root.left == null && root.right == null)
            return true;
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows < 1) return result;
        List<Integer> fst = new ArrayList<>();
        fst.add(1);
        result.add(fst);
        for (int i = 1; i < numRows; i ++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> former = result.get(i - 1);
            for (int j = 1; j < former.size(); j++){
                list.add(former.get(j) + former.get(j - 1));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex < 0) return result;
        for (int i = 0; i <= rowIndex; i++){
            result.add(1);
            for (int j = i - 1; j > 0;j --){
                result.set(j,result.get(j) + result.get(j - 1));
            }
        }
        return result;
    }

    public int maxProfit(int[] prices) {
        int max = 0,temp = 0;
        for (int i = 1; i < prices.length; i++){
            temp += prices[i] - prices[i - 1];
            max = Math.max(temp,max);
            temp = Math.max(temp,0);
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i ++){
            max += (prices[i] - prices[i - 1]) < 0 ? 0 : prices[i] - prices[i - 1];
        }
        return max;
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int n : nums){
            result ^= n;
        }
        return result;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head,fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
