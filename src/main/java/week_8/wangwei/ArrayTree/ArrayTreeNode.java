package week_8.wangwei.ArrayTree;

public class ArrayTreeNode<T> {
    private T value;

    public ArrayTreeNode(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
