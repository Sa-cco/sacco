package com.example.demo.algorithm;


/**
 * 队列的实现
 * 顺序队列、链式队列
 */
public class queueArray {
    //数组 items，数组大小 n;
    private String[] items;
    private int n=0;
    //head 表示队头下标，tail表示队尾下标
    private int head=0;
    private int tail=0;
public queueArray(int number){
    items=new String [number];
    n=number;
}
//入列
public boolean enqueue(String str){
    if(tail==n){
        if (head==0){
            return false;
        }
        for (int i=head;i<tail;i++){
            items[i-head]=items[i];
        }
        tail -=head;
        head=0;
    }

    items[tail]=str;
    ++tail;
    return true;
}
//出队
public String dequeue(){
    if(head==tail)return null;
    String strings=items[head];
    ++head;
    return strings;
}
}
