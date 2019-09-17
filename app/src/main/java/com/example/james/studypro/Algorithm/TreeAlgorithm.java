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

        postOrder(node);
    }

    public static void preOrder(TreeNode node){
        System.out.println(node.val);
        if (node.left != null){
            preOrder(node.left);
        }
        if (node.right != null){
            preOrder(node.right);
        }
    }

    public static void preOrder2(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()){
            if (node != null){
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            }else if (!stack.isEmpty()){
                node = stack.pop().right;
            }
        }
    }

    public static void inOrder(TreeNode node){
        if (node.left != null){
            inOrder(node.left);
        }
        System.out.println(node.val);
        if (node.right != null){
            inOrder(node.right);
        }
    }

    public static void inOrder2(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()){
            if (node != null){
                stack.push(node);
                node = node.left;
            }else if (!stack.isEmpty()){
                TreeNode temp = stack.pop();
                System.out.println(temp.val);
                node = temp.right;
            }
        }
    }

    public static void postOrder(TreeNode node){
        if (node.left != null){
            postOrder(node.left);
        }
        if (node.right != null){
            postOrder(node.right);
        }
        System.out.println(node.val);
    }

    public static void postOrder2(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = null, pre = null;
        stack.push(node);
        while (!stack.isEmpty()){
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))){
                System.out.println(cur.val);
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
    }

    public static List<Integer> dfs(TreeNode node){
        List<Integer> list = new ArrayList<>();
        if (node == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null){
                stack.push(temp.right);
            }
            if (temp.left != null){
                stack.push(temp.left);
            }
        }
        return list;
    }

    public static List<Integer> bfs(TreeNode node){
        List<Integer> list = new ArrayList<>();
        if (node == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null){
                queue.add(temp.right);
            }
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
