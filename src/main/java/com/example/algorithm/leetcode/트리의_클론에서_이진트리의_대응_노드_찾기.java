package com.example.algorithm.leetcode;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class 트리의_클론에서_이진트리의_대응_노드_찾기 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*
            Input: tree = [7,4,3,null,null,6,19], target = 3
            Output: 3
            Explanation: In all examples the original and cloned trees are shown. The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.
         */
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(19);

        TreeNode clonedRoot = cloneTree(root);

        TreeNode target = new TreeNode(3);

        Solution solution = new Solution();
        TreeNode result = solution.getTargetCopy(root, clonedRoot, target);
        System.out.println(result.val);
    }

    public TreeNode cloneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = cloneTree(root.left);
        newRoot.right = cloneTree(root.right);
        return newRoot;
    }

    static class Solution {

        private TreeNode resultNode;

        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            if (original == null) {
                return null;
            }
            if (original.val == target.val) {
                resultNode = cloned;
            }
            getTargetCopy(original.left, cloned.left, target);
            getTargetCopy(original.right, cloned.right, target);
            return resultNode;
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
}
