package week_10.wangwei;

/**
 * 把树中的所有叶子节点通过链表从左到右相连接
 * @author yohoyes
 */
public class LinkedForLeef {

    public static void main(String[] args) {
       String str = "#123#567##";
        char[] chars = str.toCharArray();
        Node<Character> root = new Node<Character>(chars[1]);
        buildTree(root,chars,1);
        Node firstLeef = getLeef(root);
    }

    /**
     * 连接叶子节点
     * @param root
     * @return
     */
    public static Node getLeef(Node root){
        if(root==null){
            return null;
        }
        if(root.getLeft()==null&&root.getRight()==null){
            return root;
        }
        Node leef = getLeef(root.getLeft());
        if(leef==null){
            leef = getLeef(root.getRight());
        }
        leef.setNext(getLeef(root.getRight()));
        return leef;
    }

    /**
     * 建立树
     * arr[0]空着
     * 根目录在arr[1]
     * @param arr
     */
    public static void buildTree(Node root,char[] arr, int i){
        if(i>arr.length/2){return;}
        if(2*i<arr.length){
            if(arr[i*2]!='#') {
                Node<Character> left = new Node<Character>(arr[i * 2]);
                root.setLeft(left);
                buildTree(left, arr, i * 2);
            }
        }
        if(2*i+1<arr.length){
            if(arr[i*2+1]!='#') {
                Node<Character> right = new Node<Character>(arr[i * 2 + 1]);
                root.setRight(right);
                buildTree(right, arr, i * 2 + 1);
            }
        }
    }
}


/**
 * 节点类
 * @param <T>
 */
class Node<T>{
    Node next;
    Node left;
    Node right;
    T value;

    public Node(T value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
