package week_8.wangwei.ArrayTree;

/**
 * 数组存储树
 * @author yohoyes
 */
public class ArrayTree {

    private ArrayTreeNode[] list = null;
    private int length;

    public ArrayTree(int length){
        this.length = length;
        list = new ArrayTreeNode[length+1];
    }

    /**
     * 获取index元素的左子节点
     * @return
     */
    public ArrayTreeNode getChildLeft(ArrayTreeNode node){
        for(int i=1; i<length; i++){
            if (list[i].getValue() == node.getValue()){
                if(i*2<=length){
                    return list[i*2];
                }
            }
        }
        return null;
    }

    /**
     * 获取index元素的右子节点
     * @return
     */
    public ArrayTreeNode getChildRight(ArrayTreeNode node){
        for(int i=1; i<length; i++){
            if (list[i].getValue() == node.getValue()){
                if(i*2+1<=length){
                    return list[i*2+1];
                }
            }
        }
        return null;
    }

    /**
     * 获取父节点
     * @param node
     * @return
     */
    public ArrayTreeNode getParent(ArrayTreeNode node){
        for(int i=1; i<length; i++){
            if (list[i].getValue() == node.getValue()){
                int index;
                if(i%2==0){
                   index = i/2;
                }else {
                    index = (i-1)/2;
                }
                return list[index];
            }
        }
        return null;
    }

    /**
     * 添加左子节点
     * @param parent
     * @param child
     */
    public void addChildLeft(ArrayTreeNode parent, ArrayTreeNode child){
        int index = getIndex(parent);
        if(index!=-1){
            list[index*2] = child;
        }
    }

    /**
     * 添加右子节点
     * @param parent
     * @param child
     */
    public void addChildRight(ArrayTreeNode parent, ArrayTreeNode child){
        int index = getIndex(parent);
        if(index!=-1){
            list[index*2+1] = child;
        }
    }

    /**
     * 获取某节点的下标
     * @param node
     * @return
     */
    public int getIndex(ArrayTreeNode node){
        for(int i=1;i<length+1;i++){
            if(node.getValue() == list[i].getValue()) {
                return i;
            }
        }
        return -1;
    }
}
