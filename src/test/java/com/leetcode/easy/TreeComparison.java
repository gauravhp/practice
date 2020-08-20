package com.leetcode.easy;

import com.leetcode.common.TreeNode;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * https://leetcode.com/problems/same-tree/
 *    Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 */
public class TreeComparison {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }

        if(oneTreeNodeIsNull(p,q)){
            return false;
        }

        if(!isSameTree(p.left,q.left)){
            return false;
        }

        if(!isSameTree(p.right,q.right)){
            return false;
        }

        if(p.val == q.val){
            return true;
        } else {
            return false;
        }
    }

    private boolean oneTreeNodeIsNull(TreeNode p, TreeNode q) {
        if(p==null && q!=null)
            return true;
        if(q==null && p!=null)
            return true;
        return false;
    }

    private boolean bothHasRightChild(TreeNode p, TreeNode q) {
        return((p.right!=null)&&(q.right!=null));
    }

    private boolean bothHasLeftChild(TreeNode p, TreeNode q) {
        return ((p.left!=null) && (q.left!=null));
    }

    @Test
    public void testIsSameTree() {
        assertThat(isSameTree(new TreeNode(),new TreeNode()), is(true));
        assertThat(isSameTree(new TreeNode(1),new TreeNode()), is(false));
        assertThat(isSameTree(new TreeNode(1,new TreeNode(2),new TreeNode(3)),new TreeNode(1,new TreeNode(2),new TreeNode(3))), is(true));
        assertThat(isSameTree(new TreeNode(1,new TreeNode(2),null),new TreeNode(1,null,new TreeNode(2))), is(false));
        assertThat(isSameTree(new TreeNode(1,new TreeNode(2),new TreeNode(1)),new TreeNode(1,new TreeNode(1),new TreeNode(2))), is(false));
    }
}
