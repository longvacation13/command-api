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


    /**
     * LinkedList
     */
     public void LinkedListNodeTest() {
         Scanner sc = new Scanner(System.in);
         ListNode l1 = new ListNode();
         ListNode dummyNode = l1;

         int index = 0;
         while(index < 5) {
             dummyNode.next = new ListNode(sc.nextInt());
             dummyNode = dummyNode.next;
             index++;
         }

         printLinkedList(l1.next);
     }
     // 10 20 30 40 50


    public void printLinkedList(ListNode l) {
         while(l != null) {
             System.out.println(l.val);
             l = l.next;
         }
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