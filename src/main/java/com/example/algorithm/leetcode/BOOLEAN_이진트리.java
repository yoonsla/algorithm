package com.example.algorithm.leetcode;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class BOOLEAN_이진트리 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Input: root = [2,1,3,null,null,0,1]
        // Output: true

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        Solution solution = new Solution();
        boolean result = solution.evaluateTree(root);
        System.out.println(result);

    }

    static class Solution {

        public boolean evaluateTree(TreeNode root) {
            if (root.val == 1) {
                return true;
            }
            if (root.val == 0) {
                return false;
            }
            boolean left = evaluateTree(root.left);
            boolean right = evaluateTree(root.right);
            if (root.val == 2) {
                // true || false
                return left || right;
            }
            if (root.val == 3) {
                // true & false
                return left && right;
            }
            return true;
        }
    }


    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
