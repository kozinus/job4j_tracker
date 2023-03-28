package ru.job4j.leetcode.problem24;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode next = head.next;
        ListNode temp = head.next.next;
        ListNode current = head;
        current.next = next.next;
        next.next = current;
        head = next != null ? next : current;
        return temp;
    }
}
