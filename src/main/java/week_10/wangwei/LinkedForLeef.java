package week_10.wangwei;

/**
 * 把树中的所有叶子节点通过链表从左到右相连接
 * @author yohoyes
 */
public class LinkedForLeef {

    /**
     * 首先构造出一棵树
     *    1
     *  2   3
     *   5 6 7
     *  # 表示空
     *  把树的字符串转化成char型数组
     *  头节点是chas[1] 不是chars[0] (为了方便建树,节点的左子节点下标是2*i,右子节点下标是2*i+1)
     * @param args
     */
    public static void main(String[] args) {
        String str = "#123#567";
        char[] chars = str.toCharArray();
        //建立根节点
        Node<Character> root = new Node<Character>(chars[1]);

        //建树
        buildTree(root,chars,1);
        //连接叶子节点并返回左边第一个子节点
        Node firstLeef = getLeef(root);
    }

    /**
     * 连接叶子节点
     * 首先得判断是不是叶子节点
     * @param root
     * @return
     */
    public static Node getLeef(Node root){
        //判断节点是否为空
        if(root==null){
            return null;
        }
        //判断节点是不是叶子节点
        if(root.getLeft()==null&&root.getRight()==null){
            return root;
        }
        //拿到左边叶子节点
        Node leef = getLeef(root.getLeft());
        if(leef==null){
            //拿到右边的叶子节点
            leef = getLeef(root.getRight());
        }
        if(leef!=null){
            //前面的节点连上这个节点
            leef.setNext(getLeef(root.getRight()));
        }
        return leef;
    }

    /**
     * 建立树
     * arr[0]空着
     * 根目录在arr[1]
     * @param arr
     */
    public static void buildTree(Node root,char[] arr, int i){
        //只需要遍历到树的一半的位置就可以了
        if(i>arr.length/2){return;}
        //判断有无左子节点
        if(2*i<arr.length){
            //判断左子节点是不是空
            if(arr[i*2]!='#') {
                Node<Character> left = new Node<Character>(arr[i * 2]);
                root.setLeft(left);
                //建立左子树
                buildTree(left, arr, i * 2);
            }
        }
        //判断有无右子节点
        if(2*i+1<arr.length){
            //判断右子节点是不是空
            if(arr[i*2+1]!='#') {
                Node<Character> right = new Node<Character>(arr[i * 2 + 1]);
                root.setRight(right);
                //建立右子树
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
