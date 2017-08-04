package test.liem.list;

/**
 * Created by FRAM on 8/4/2017.
 */
public class ConcurrentModificationException extends RuntimeException {
    public ConcurrentModificationException() {
        super("there is a modification while iterating the list");
    }
}
