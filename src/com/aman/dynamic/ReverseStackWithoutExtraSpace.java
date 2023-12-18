package com.aman.dynamic;

import java.util.*;

public class ReverseStackWithoutExtraSpace {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);st.push(3);st.push(4);st.push(5);
        System.out.println(st);
        reverseStack(st);
        System.out.println(st);

        /*Reversing a queue is simple*/
        Queue<Integer> queue = new LinkedList();
        queue.add(1);queue.add(2);queue.add(3);queue.add(4);queue.add(5);
        System.out.println(queue);
        reverseQueue(queue);
        System.out.println(queue);


        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);
        System.out.println(list);
        reverseList(list);
        System.out.println(list);
    }

    private static void reverseList(List<Integer> list) {
           if(!list.isEmpty()) {
               int x = list.remove(0);
               reverseList(list);
               list.add(x);
           }
    }

    private static void reverseStack(Stack<Integer> st) {

        if(!st.empty()){
            int x= st.pop();
            reverseStack(st);
            insertAgain(x,st);
        }

    }

    private static void insertAgain(int x, Stack<Integer> st) {

        if(st.empty()){
            st.push(x);
        }else {
            int y=st.pop();
            insertAgain(x, st);
            st.push(y);
        }
    }

    private static void reverseQueue(Queue<Integer> q) {
        if(!q.isEmpty()){
            int x= q.poll();
            reverseQueue(q);
            q.add(x);
        }

    }
}
