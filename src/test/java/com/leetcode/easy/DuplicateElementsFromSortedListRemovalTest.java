package com.leetcode.easy;

import com.leetcode.common.ListNode;
import org.junit.Test;

import static com.leetcode.common.DataGenerator.getListNodes;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;


public class DuplicateElementsFromSortedListRemovalTest {


    @Test
    public void testDeleteDuplicates() {
        assertNull(deleteDuplicates(getListNodes()));
        assertEquals(deleteDuplicates(getListNodes(1)),getListNodes(1));
        assertEquals(deleteDuplicates(getListNodes(1,2)),getListNodes(1,2));
        assertEquals(deleteDuplicates(getListNodes(1,1)),getListNodes(1));
        assertEquals(deleteDuplicates(getListNodes(1,1,2,3)),getListNodes(1,2,3));
        assertEquals(deleteDuplicates(getListNodes(1,2,2,3)),getListNodes(1,2,3));
        assertEquals(deleteDuplicates(getListNodes(1,2,3,3)),getListNodes(1,2,3));
        assertEquals(deleteDuplicates(getListNodes(1,2,2,3,3)),getListNodes(1,2,3));
        assertEquals(deleteDuplicates(getListNodes(1,2,2,2,3,3)),getListNodes(1,2,3));
        assertEquals(deleteDuplicates(getListNodes(1,2,2,2,2,3,3)),getListNodes(1,2,3));
        assertEquals(deleteDuplicates(getListNodes(1,1,2,3,3)),getListNodes(1,2,3));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode current = head;
        while(current.next!=null){
            while (current.val == current.next.val) {
                current.next = current.next.next;
                if(current.next == null){
                    break;
                }
            }
            current = current.next;
            if(current==null){
                break;
            }
        }
        return head;
    }

}
