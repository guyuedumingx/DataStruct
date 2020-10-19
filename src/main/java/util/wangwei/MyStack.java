package util.wangwei;

import java.util.Stack;

/**
 * 栈
 * @param <T>
 * @author yohoyes
 */
public class MyStack<T> {
    private MyLink<T> link = new MyLink<T>();

    public T peek() {
        if(link.head.next==null){
            return null;
        }
        return link.head.next.data;
    }

    public T pop() {
        if(link.head.next==null){
            return null;
        }
        T data = peek();
        link.head.next = link.head.next.next;
        return data;
    }

    public void push(T data){
        link.add(data);
    }

    public boolean isEmpty(){
        return link.head.next == null;
    }
}
