package test.liem.list;

/**
 * Created by FRAM on 7/26/2017.
 */
public interface LinkedList {

    void append(int value);
    boolean removeTail();
    void removeAllGreaterThan(int value);

    ListIterator iterate();
}
