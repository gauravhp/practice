package com.leetcode.common;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { this.val = x; }
    public ListNode(int x, ListNode next) { this.val = x; this.next = next; }

    public static ListNode getListNodes(int[] intNodes){
        if(intNodes.length==0) return null;
        ListNode head = new ListNode(intNodes[0]);
        ListNode ptr = head;
        for (int i = 1; i<intNodes.length; i++) {
            ptr.next = new ListNode(intNodes[i]);
            ptr = ptr.next;
        }
        return head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
