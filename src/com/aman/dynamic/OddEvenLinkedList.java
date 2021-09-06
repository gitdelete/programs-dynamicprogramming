package com.aman.dynamic;

public class OddEvenLinkedList {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(2);
        head.next.next = new Node(9);
        head.next.next.next = new Node(42);
        head.next.next.next.next = new Node(15);

        oddEvenSeperate(head);
        printList(head);

    }

    private static void oddEvenSeperate(Node head) {
        Node end= head;
        Node node = head;
        Node prev = null;

        while(end.next!=null){
            end=end.next;
        }

        Node new_end=end;
        while (node != end) {
            if (node.data % 2 == 0) {
                if (node == head) {
                    new_end.next=node;
                    new_end.next.next=null;
                    new_end=new_end.next;
                    node=node.next;
                    head=node;
                }else {
                    new_end.next=node;
                    new_end.next.next=null;
                    new_end=new_end.next;
                    prev.next=node.next;
                    node=node.next;
                }
            }else {
                prev=node;
                node=node.next;
            }
        }
    }

    static void printList(Node head)
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

}
