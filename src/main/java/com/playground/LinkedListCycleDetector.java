package com.playground;

/**
 * Tests if the specified linked list is circular
 * A linked list is considered circular when the tail of the list is pointing to the head of the list
 */
public class LinkedListCycleDetector {

    /**
     * This method uses two pointers to traverse the list: first pointer skips ahead 1 node, while the second
     * skips ahead 2 nodes. The iteration is completed when the end of the list is reached (for non-circular lists)
     * or when the two iterators end up pointing to the same node (for circular lists).
     */
    public static boolean isCircular(LinkedList linkedList) {
        var firstIterator = linkedList.getHead();
        var secondIterator = linkedList.getHead();

        while(firstIterator.hasNext() && secondIterator.hasNext() && secondIterator.getNext().hasNext()) {
            firstIterator = firstIterator.getNext();
            secondIterator = secondIterator.getNext().getNext();
            if (firstIterator == secondIterator) {
                return true;
            }
        }

        return false;
    }
}
