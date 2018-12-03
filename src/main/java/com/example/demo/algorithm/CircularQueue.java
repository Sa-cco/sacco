package com.example.demo.algorithm;
//循环队列
public class CircularQueue {
    //数组: items, 数组大小：n;
    private String[] items;
    private int n;
    private int head;
    private int tail;

    //申请一个大小为 capacity 的数组
    public CircularQueue(int capacity){
        items=new String [capacity];
        n=0;
    }

    //入队
    public boolean enqueue(String item){
        if ((tail+1)%n==head)return false;
        items[tail]=item;
        tail=(tail+1)%n;
        return true;
    }

    //出队
    public String dequeue(){
        if (head==tail)return null;
        String ret=items[head];
        head=(head+1)%n;
        return ret;
    }
//冒泡排序，a表示数组，n表示数组大小
    public void sort1(int[] a,int n){
        if(n<=1)return;
        for(int i=0;i<n;i++){
            //提前退出冒泡循环的标志位
            boolean flag=false;
            for (int j=0;j<n-1;j++){
                if(a[j]>a[j+1]){
                    int tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                    flag=true;//表示有数据交换
                }
            }
            if(!flag)break;//没有数据交换，提前退出
        }
    }
    //插入排序，a表示数组，n表示数组大小
    public void insertionSort(int[] a,int n){
        if (n<=1)return;
        for (int i=0;i<n;i++){
            int value=a[i];
            int j=i-1;
            //查找插入的位置
            for (;j>=0;--j){
                if (a[j]>value){
                    a[j+1]=a[j];//数据的移动
                }else {
                    break;
                }
            }
            a[j+1]=value;//插入数据
        }
    }

}





















