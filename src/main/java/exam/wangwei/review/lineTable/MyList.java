package exam.wangwei.review.lineTable;

/**
 * 线性表公有父类
 * @author yohoyes
 */
public interface MyList<T> {

    void clear();

    boolean isEmpty();

    int length();

    T get(int i);

    void insert(int i, T x);

    void remove(int i);

    int indexOf(T x);

    void display();
}
