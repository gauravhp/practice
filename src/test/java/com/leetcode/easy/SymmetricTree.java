package com.leetcode.easy;
// https://leetcode.com/problems/symmetric-tree/

import com.leetcode.common.TreeNode;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
       return isMirror(root,root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1==null && t2 == null){
            return true;
        }
        if(t1==null || t2==null){
            return false;
        }
        return (t1.val==t2.val) && (isMirror(t1.left,t2.right) && isMirror(t2.left,t1.right));
    }

    @Test
    public void testIsSymmetric() {
        assertThat(isSymmetric(new TreeNode()), is(true));
        assertThat(isSymmetric(new TreeNode(1)), is(true));
        assertThat(isSymmetric(new TreeNode(1,new TreeNode(2),null)), is(false));
        assertThat(isSymmetric(new TreeNode(1,new TreeNode(2),new TreeNode(2))), is(true));
    }
}
