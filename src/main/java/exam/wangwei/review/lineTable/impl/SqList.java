package exam.wangwei.review.lineTable.impl;


import exam.wangwei.review.lineTable.MyList;

import java.util.ArrayList;
import java.util.List;

/**
 *顺序表
 * 以数组方式存储
 * @author yohoyes
 */
public class SqList<T> implements MyList<T> {
    private Object[] listElem;
    private int curLen;

    public SqList(int maxSize) {
        curLen = 0;
        listElem = new Object[maxSize];
    }

    @Override
    public void clear() {
        curLen = 0;
        List<T> agg = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return curLen == 0;
    }

    @Override
    public int length() {
        return curLen;
    }

    @Override
    public T get(int i) {
        return (T)listElem[i];
    }

    @Override
    public void insert(int i, T x) {
        listElem[i] = x;
    }

    @Override
    public void remove(int i) {

    }

    @Override
    public int indexOf(T x) {
        return 0;
    }

    @Override
    public void display() {

    }
}
