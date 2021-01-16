package com.sdu.learn;

import java.util.Stack;

/**
 * @author huaikong
 * @create 2021-01-16 13:45
 */
public class day02 {
    public static class Node{
        public int value;
        public Node next;

        public Node(int data){
            value = data;
        }
    }

    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data){
            value = data;
        }
    }

    public static Node reverseLinkedList(Node head){
        Node pre = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node removeValue(Node head,int num){
        while(head != null){
            if(head.value != num){
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while(cur != null){
            if(cur.value == num){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static class MyStack{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack(){
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int newNum){
            if(stackMin.isEmpty()){
                stackMin.push(newNum);
            }else if(newNum < getMin()){
                stackMin.push(newNum);
            }else {
                stackMin.push(stackMin.peek());
            }
            stackData.push(newNum);
        }

        public int pop(){
            if(stackData.isEmpty()){
                throw new RuntimeException("栈空");
            }
            stackMin.pop();
            return stackData.pop();
        }

        private int getMin() {
            if(stackMin.isEmpty()){
                throw new RuntimeException("栈空");
            }
            return stackMin.peek();
        }
    }

    public static class TwoStacksQueue{
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue(){
            stackPop = new Stack<>();
            stackPush = new Stack<>();
        }

        private void pushToPop(){
            if(stackPop.empty()){
                while(!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void add(int pushInt){
            stackPush.push(pushInt);
            pushToPop();
        }

        public int poll(){
            if(stackPop.empty() && stackPush.empty()){
                throw new RuntimeException("队空")；
            }
            pushToPop();
            return  stackPop.pop();
        }

        public int peek(){
            if(stackPop.empty() && stackPush.empty()){
                throw new RuntimeException("队空")；
            }
            pushToPop();
            return stackPop.peek();
        }
    }

    public static class MyQueue{
        private int[] arr;
        private int pushi;
        private int polli;
        private int size;
        private final int limit;

        public MyQueue(int l){
            arr = new int[l];
            pushi = 0;
            polli = 0;
            size = 0;
            limit = l;
        }

        public void push(int value){
            if(size == limit){
                throw new RuntimeException("队满");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop(){
            if(size == 0){
                throw new RuntimeException("队空");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        private int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }
    }
}
