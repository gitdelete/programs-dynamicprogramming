package com.aman.dynamic;

// Approach 1: Have a flag: visited in LinkedList which will be marked true for visited nodes in first list.
// On traversing 2nd list we can find the intersection

// Approach 2: get count difference and traverse bigger by that countDiff and then traverse both lists int parallel.
// This is implemented below
public class IntersectionOfTwoLinkedList {

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

        Node head2 = new Node(1);
        head2.next = new Node(11);
        head2.next.next = new Node(9);
        head2.next.next.next = new Node(41);
        head2.next.next.next.next = new Node(15);

        findIntersection(head1, head2);
    }

    private static void findIntersection(Node head1, Node head2) {

        int count1 = getCount(head1);
        int count2 = getCount(head2);


        if(count1>count2){
            intersectionPoint(head1, head2, count1-count2);
        }else {
            intersectionPoint(head2, head1, count2-count1);
        }

    }

    private static void intersectionPoint(Node biggerList, Node smallerList, int c) {

            Node bigList = biggerList;
            Node smallList = smallerList;
            while(c>0){
                bigList= bigList.next;
                c--;
            }

            while (bigList != null || smallList!=null){
                if(bigList.data == smallList.data){
                    System.out.println("Intersection Found at "+bigList.data);
                    break;
                }
                bigList=bigList.next;
                smallList=smallList.next;
            }

            if(bigList == null || smallList==null){
                System.out.println("Intersection Not Found !! ");
            }

    }

    private static int getCount(Node head) {
        Node n = head;
        int count=0;
        while (n !=null){
            count++;
            n=n.next;
        }
        return count;
    }
}

