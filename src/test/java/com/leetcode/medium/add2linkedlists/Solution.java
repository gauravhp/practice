package com.leetcode.medium.add2linkedlists;

import com.leetcode.common.ListNode;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * User: Gaurav Parmar
 * Date: 18-05-2021
 * Time: 15:33
 */
class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode tail = null;
        int carry = 0;
        while(ptr1!=null || ptr2!=null || carry>0){
            int val1 = ptr1!=null?ptr1.val:0;
            int val2 = ptr2!=null?ptr2.val:0;
            int nextDigit = (val1 + val2 + carry)%10;
            carry = (val1 + val2 + carry)/10;
            ListNode newNode = new ListNode(nextDigit);
            if(result==null){
                result = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
            if(ptr1!=null)
                ptr1 = ptr1.next;
            if(ptr2!=null)
                ptr2 = ptr2.next;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] list1 = new int[] {2,4,3};
        int[] list2 = new int[] {5,6,4};
        ListNode firstList = ListNode.getListNodes(list1);
        ListNode secondList = ListNode.getListNodes(list2);
        ListNode result = addTwoNumbers(firstList,secondList);
        System.out.println(result.toString());
    }

}