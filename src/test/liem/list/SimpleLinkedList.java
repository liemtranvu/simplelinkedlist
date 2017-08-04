package test.liem.list;

/**
 * Created by Liem Tran on 7/26/2017.
 */
public class SimpleLinkedList implements LinkedList{

    private int size = 0;
    private Node first;
    private Node last;

    public SimpleLinkedList() {
    }

    @Override
    public void append(int value) {
        link(value);
    }

    @Override
    public boolean removeTail() {
        return (unlink(last) != null);
    }

    @Override
    public void removeAllGreaterThan(int value) {
        Node current = first;

        do {
            if(current.item > value) {
                Node next =  current.next;
                unlink(current);
                current = next;
            } else {
                current = current.next;
            }
        } while (current != null);
    }

    @Override
    public ListIterator iterate() {
        return new DefaultListIterator();
    }


    private void link(int value) {
        final Node l = last;
        final Node newNode = new Node(l, value, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    private Integer unlink(Node l) {
        final Integer element = l.item;
        final Node prev = l.prev;
        final Node next = l.next;
        l.item = null;
        l.prev = null;
        l.next = null;

        if (prev == null)
            first = next;
        else
            prev.next = next;

        if(next == null)
            last = prev;
        else
            next.prev = prev;

        size--;

        return element;
    }


    private static class Node {
        Integer item;
        Node next;
        Node prev;

        Node(Node prev, int element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private class DefaultListIterator implements ListIterator {
        private Node lastReturned;
        private Node next;
        private int nextIndex;
        private int listSize;

        public DefaultListIterator() {
            this.listSize = size;
            lastReturned = first;
            next = first.next;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public Integer next() {
            return nextNode().item;
        }

        private boolean checkModification() {
            if(listSize != size) {
                listSize = size;
                return true;
            }
            return false;
        }

        Node nextNode() {
            if(checkModification()) {
                throw new ConcurrentModificationException();
            }
            if(nextIndex > 0) {
                lastReturned = next;
                next = lastReturned.next;
            }
            nextIndex++;
            return lastReturned;
        }
    }

}
