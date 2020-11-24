package week_11.wangwei;

/**
 * 线索二叉树
 * @author yohoyes
 */
public class ThreadedBinaryTree {
    public static void main(String[] args) {
        String str = "#123#567";
        char[] chars = str.toCharArray();
        //建立根节点
        Node<Character> root = new Node<Character>(chars[1]);

        //建树
        buildTree(root,chars,1);
        search(null,root);
    }

    private static Node search(Node root, Node node){
        if(node==null){
            return root;
        }
        node.setPre(root);
        root = search(node, node.getLeft());
        return search(root, node.getRight());
    }

    /**
     * 建立树
     * arr[0]空着
     * 根目录在arr[1]
     * @param arr
     */
    public static void buildTree(Node root, char[] arr, int i){
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
    Node<T> pre;
    Node<T> left;
    Node<T> right;
    T value;

    public Node(T value) {
        this.value = value;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
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
