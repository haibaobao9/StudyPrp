package com.example.james.studypro.Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeAlgorithm {
    public static void main(String[] args){
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.right = node7;

        List<Integer> list = bfs(node);
        for (int i : list){
            System.out.println(i);
        }
    }

    public static List<Integer> preOrder(TreeNode node){
        List<Integer> result = new ArrayList<>();
        if (node == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()){
            if (node != null){
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }else if (!stack.isEmpty()){
                node = stack.pop().right;
            }
        }
        return result;
    }

    public static List<Integer> inOrder(TreeNode node){
        List<Integer> result = new ArrayList<>();
        if (node == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()){
            if (node != null){
                stack.push(node);
                node = node.left;
            }else if (!stack.isEmpty()){
                TreeNode temp = stack.pop();
                result.add(temp.val);
                node = temp.right;
            }
        }
        return result;
    }

    public static List<Integer> postOrder(TreeNode node){
        List<Integer> list = new ArrayList<>();
        if (node == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null, cur = null;
        stack.push(node);
        while (!stack.isEmpty()){
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) || ((pre != null) && (pre == cur.left || pre == cur.right))){
                list.add(cur.val);
                stack.pop();
                pre = cur;
            }else {
                if (cur.right != null){
                    stack.push(cur.right);
                }
                if (cur.left != null){
                    stack.push(cur.left);
                }
            }
        }
        return list;
    }

    public static List<Integer> dfs(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
        return list;
    }

    public static List<Integer> bfs(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
        return list;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }
}
