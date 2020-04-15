package com.gaurav.testclasses;

import java.util.Arrays;
import java.util.List;

public class Common {
    public static int[] intArray(Integer... ints) {
        int[] newArray = new int[ints.length];
        int index = 0;
        for(int i : ints){
            newArray[index++] = i;
        }
        return newArray;
    }

    public static List<Integer> intList(Integer... ints) {
        return Arrays.asList(ints);
    }

    public static ListNode getListNodes(Integer... ints) {
        if(ints.length==0){
            return null;
        }
        ListNode head = new ListNode(ints[0]);
        if(ints.length>1) {
            ListNode current = head;
            ListNode tail = new ListNode(ints[1]);
            for(int i = 2; i < ints.length; i++){
                current.next = tail;
                current = current.next;
                tail = new ListNode(ints[i]);
            }
            current.next = tail;
        }
        return head;
    }
}
