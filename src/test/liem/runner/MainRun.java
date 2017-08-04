package test.liem.runner;

import test.liem.list.LinkedList;
import test.liem.list.ListIterator;
import test.liem.list.SimpleLinkedList;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Liem Tran on 8/1/2017.
 */
public class MainRun {

    static void printList(LinkedList list) {
        ListIterator iterator = list.iterate();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "->");
        }
        System.out.println();
    }

    public final static void main(String[] args) {
        Integer[] inputs = new Integer[10];
        for(int i = 0; i < 10; i++) {
            inputs[i] = ThreadLocalRandom.current().nextInt(1, 100);
            System.out.print(inputs[i] + "->");
        }
        System.out.println();

        LinkedList linkedList = new SimpleLinkedList();

        System.out.println("========== APPENDING ================");
        for(int i : inputs) {
            linkedList.append(i);
            printList(linkedList);
        }

        System.out.println("========== REMOVE TAIL ================");
        linkedList.removeTail();
        printList(linkedList);

        System.out.println("========== REMOVE GREATER THAN ================");
        linkedList.removeAllGreaterThan(50);
        printList(linkedList);
    }
}
