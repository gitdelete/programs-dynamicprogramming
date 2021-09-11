package com.aman.dynamic;

public class CheckIfLinkedListISCircular {

    static class Node {

        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {

        Node head1 = new Node(10);
        head1.next = new Node(2);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(41);
        head1.next.next.next.next = new Node(15);
        head1.next.next.next.next = head1.next.next.next;


        isCircular(head1);
    }

    private static void isCircular(Node head) {

        Node node1=head;
        Node node2=head;

        while(node2!=null && node2.next!=null){
            node1=node1.next;
            node2=node2.next.next;
            if(node2 == node1){
                System.out.println("Its circular !!! " + node1.data);
                break;
            }
        }

       if(node2 == null || node2.next == null) {
            System.out.println("Its not circular !!!");
       }


    }

}
