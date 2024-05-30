package com.example.algorithm.leetcode;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class BST의_범위_합계 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
        // Output: 32
        // Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        int low = 7;
        int high = 15;

        Solution solution = new Solution();
        int i = solution.rangeSumBST(root, low, high);
        System.out.println("result: " + i);
    }

    static class Solution {

        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) {
                return 0;
            }
            int sum = 0;
            if (root.val >= low && root.val <= high) {
                sum += root.val;
            }
            if (root.val > low) {
                sum += rangeSumBST(root.left, low, high);
            }
            if (root.val < high) {
                sum += rangeSumBST(root.right, low, high);
            }
            return sum;
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

        public static int makeBST(TreeNode root, int low, int high) {
            return 0;
        }
    }
}
