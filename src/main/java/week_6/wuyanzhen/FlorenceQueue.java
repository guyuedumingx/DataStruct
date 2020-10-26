//package week_6.wuyanzhen;
//
//import java.util.Iterator;
//
///**
// * @author Florence
// */
//public class FlorenceQueue<E> implements Iterable<E>{
//    private E peek=null;
//    private Node<E> head=new Node<>();
//    private Node<E> tail=head;
//    int size=0;
//
//    /**
//     * 链尾入队
//     * @param data
//     */
//    public void enQueue(E data){
//        Node<E> newNode = new Node<E>(data);
//        tail.setNext(newNode);
//        tail=newNode;
//        size++;
//    }
//
//    /**
//     * 链头出队
//     * @return
//     */
//    public E deQueue() throws Exception {
//        if (size!=0){
//            Node<E> dequeueNode = head.getNext();
//            E data=dequeueNode.getData();
//            head.setNext(dequeueNode.getNext());
//            size--;
//            return data;
//        }
//        throw new Exception("出队错误");
//    }
//
//    public E front(){
//        return head.getNext().getData();
//    }
//
//    public boolean isEmpty(){
//        return size==0;
//    }
//    public int size(){
//        return size;
//    }
//
//    @Override
//    public Iterator<E> iterator() {
//        return  new Iterator<E>() {
//            Node<E> cur=head;
//            @Override
//            public boolean hasNext() {
//                return cur.getNext()!=null;
//            }
//
//            @Override
//            public E next() {
//                E data=cur.getNext().getData();
//                cur=cur.getNext();
//                return data;
//            }
//        };
//    }
//}
