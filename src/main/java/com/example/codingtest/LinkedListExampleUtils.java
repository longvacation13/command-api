package com.example.codingtest;

import java.util.*;

public class LinkedListExampleUtils {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // headNode ( root )
        ListNode resultNode = new ListNode();
        ListNode curNode = resultNode;
        int carry = 0;

        while(l1 != null || l2 != null) {

            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int sum = x + y + carry;
            curNode.next = new ListNode(sum % 10);
            carry = sum / 10;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            curNode = curNode.next;
        }

        if(carry > 0) {
            curNode.next = new ListNode(carry);
        }

        return resultNode.next;
    }


}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//        ListNode dummyHead = new ListNode();
//        ListNode current = dummyHead;
//
//        int carry = 0;
//        while(l1 != null || l2 != null) {
//
//            int x = (l1 != null) ? l1.val : 0;
//            int y = (l2 != null) ? l2.val : 0;
//
//            int sum = x + y + carry;
//            carry = sum / 10;  // 다음 자릿수로 올릴값
//
//            current.next = new ListNode(sum%10);
//            current = current.next;
//
//            if(l1 != null)  l1 = l1.next;
//            if(l2 != null)  l2 = l2.next;
//
//            if (carry > 0) {
//                current.next = new ListNode(carry); // 마지막 자릿수가 없을 경우
//            }
//        }
//
//        return dummyHead.next;
//
//    }
//}