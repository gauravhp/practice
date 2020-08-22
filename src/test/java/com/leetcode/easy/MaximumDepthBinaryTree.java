package com.leetcode.easy;
// https://leetcode.com/problems/maximum-depth-of-binary-tree/
/*
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 */
import com.leetcode.common.TreeNode;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MaximumDepthBinaryTree {
    public int getMaxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1 + Math.max(getMaxDepth(root.left),getMaxDepth(root.right));
    }

    @Test
    public void testGetMaxDepth() {
        assertThat(getMaxDepth(new TreeNode()), is(1));
        assertThat(getMaxDepth(new TreeNode(1)), is(1));
        assertThat(getMaxDepth(new TreeNode(1)), is(1));
        assertThat(getMaxDepth(new TreeNode(3,new TreeNode(9),  new TreeNode(20, new TreeNode(15), new TreeNode(7)))), is(3));
    }
}
