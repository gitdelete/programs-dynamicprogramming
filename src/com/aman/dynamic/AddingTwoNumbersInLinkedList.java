package com.aman.dynamic;

public class AddingTwoNumbersInLinkedList {

    // Numbers
    public static void main(String[] args) {

        ListNode head1 = new ListNode(3);
        head1.next= new ListNode(8);
        head1.next.next=new ListNode(5);

        ListNode head2 = new ListNode(3);
        head2.next= new ListNode(8);
        head2.next.next= new ListNode(5);

        addNumbersInList(head1, head2);

        ListNode head3 = new ListNode(3);
        head1.next= new ListNode(8);
        head1.next.next=new ListNode(5);
        head1.next.next.next=new ListNode(5);
        head1.next.next.next.next=new ListNode(9);

        ListNode head4 = new ListNode(3);
        head2.next= new ListNode(8);
        head2.next.next= new ListNode(5);

    //    addNumbersInList(head3, head4);

    }

    private static void addNumbersInList(ListNode node, ListNode node3) {



    }

    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
      }
}
