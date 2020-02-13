package com.gaurav.testclasses;
/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class TwoListMergeTest {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static String toStringOf(ListNode listNode){
        String listOfNodes="";
        ListNode head = listNode;
        while(head !=null){
            if(head!=null)
                listOfNodes+=head.val + "-";
            head = head.next;
        }
        listOfNodes = listOfNodes.substring(0,listOfNodes.length()-1);
        return listOfNodes;
    }

    public static ListNode getLinkedListFromArray(Integer... ints){
        if(ints.length<1){
            return null;
        }
        ListNode head = new TwoListMergeTest().new ListNode(ints[0]);
        ListNode nodeIterator = head;
        for(int index = 1; index<ints.length; index++){
            ListNode newNode = new TwoListMergeTest().new ListNode(ints[index]);
            nodeIterator.next = newNode;
            nodeIterator = nodeIterator.next;
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2 == null){
            return null;
        }
        ListNode x = nullCheck(l1, l2);
        if (x != null) return x;

        ListNode head = null;

        if(l1.val <= l2.val) {
            head = new ListNode(l1.val);
            l1 = l1.next;
        }
        else {
            head = new ListNode(l2.val);
            l2 = l2.next;
        }

        ListNode current = head;

        while(l1!= null && l2 != null){
            if(l1.val <= l2.val) {
                current.next = new ListNode(l1.val);
                current = current.next;
                l1 = l1.next;
            } else {
                current.next = new ListNode(l2.val);
                current = current.next;
                l2 = l2.next;
            }
        }

        while(l1!=null) {
            current.next = new ListNode(l1.val);
            current = current.next;
            l1 = l1.next;
        }

        while(l2!=null) {
            current.next = new ListNode(l2.val);
            current = current.next;
            l2 = l2.next;
        }

        return head;
    }


    private ListNode nullCheck(ListNode l1, ListNode l2) {
        if(l1!=null && l2==null){
            return l1;
        }
        if(l2!=null && l1==null){
            return l2;
        }
        return null;
    }

    @Test
    public void testMergeTwoLists(){
        assertThat(mergeTwoLists(getLinkedListFromArray(),getLinkedListFromArray()), is(getLinkedListFromArray()));
        assertThat(getStringAfterMergingLists(getLinkedListFromArray(1), getLinkedListFromArray()), is(toStringOf(getLinkedListFromArray(1))));
        assertThat(getStringAfterMergingLists(getLinkedListFromArray(1), getLinkedListFromArray(1)), is(toStringOf(getLinkedListFromArray(1,1))));
        assertThat(getStringAfterMergingLists(getLinkedListFromArray(1), getLinkedListFromArray(2)), is(toStringOf(getLinkedListFromArray(1,2))));
        assertThat(getStringAfterMergingLists(getLinkedListFromArray(2), getLinkedListFromArray(1)), is(toStringOf(getLinkedListFromArray(1,2))));
        assertThat(getStringAfterMergingLists(getLinkedListFromArray(1,3), getLinkedListFromArray(2)), is(toStringOf(getLinkedListFromArray(1,2,3))));
        assertThat(getStringAfterMergingLists(getLinkedListFromArray(1,2), getLinkedListFromArray(3)), is(toStringOf(getLinkedListFromArray(1,2,3))));
        assertThat(getStringAfterMergingLists(getLinkedListFromArray(1,2), getLinkedListFromArray(3,4)), is(toStringOf(getLinkedListFromArray(1,2,3,4))));
        assertThat(getStringAfterMergingLists(getLinkedListFromArray(1,3), getLinkedListFromArray(2,4)), is(toStringOf(getLinkedListFromArray(1,2,3,4))));
        assertThat(getStringAfterMergingLists(getLinkedListFromArray(1,2,4), getLinkedListFromArray(1,3,4)), is(toStringOf(getLinkedListFromArray(1,1,2,3,4,4))));
    }

    private String getStringAfterMergingLists(ListNode l1, ListNode l2) {
        return toStringOf(mergeTwoLists(l1,l2));
    }
}
