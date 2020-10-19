package util.wangwei;

/**
 * 实现队列
 * @param <T>
 * @author yohoyes
 */
public class MyQueue<T> {
   MyLink<T> link = new MyLink<T>();

    /**
     * 插入
     * @param data
     */
   public void offer(T data) {
       Node<T> cur = link.head;
       while (cur.next!=null){
           cur = cur.next;
       }
       cur.next = new Node<T>(data);
   }

   /**
    * 移除
    * @return
    */
   public T poll(){
       T data = null;
       if(isEmpty()){
           return null;
       }else {
           data = link.head.next.data;
           link.head.next = link.head.next.next;
       }
       return data;
   }

    /**
     * 判空
     * @return
     */
   public boolean isEmpty(){
        return link.head.next == null;
   }

   /**
   * 返回队列第一位元素
   * @return
   */
   public T peek(){
       if(isEmpty()){
           return null ;
       }else {
           return link.head.next.data;
       }
   }
}
