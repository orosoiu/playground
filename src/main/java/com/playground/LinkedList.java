package com.playground;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Custom linked list implementation which exposes access to underlying nodes and allows
 * "closing" the list by creating a circular reference tail -> head
 * This is useful for testing solutions to the "is a linked list circular" problem
 */
public class LinkedList<T> {

    @Getter
    private final Node<T> head;
    private Node<T> tail;
    private boolean closed = false;

    public LinkedList(T value) {
        head = new Node<>(value, null);
        tail = head;
    }

    public LinkedList<T> add(T value) {
        if (closed) {
            throw new UnsupportedOperationException("Cannot add more elements after closing the list");
        }

        var newTail = new Node<T>(value, null);
        tail.next = newTail;
        tail = newTail;
        return this;
    }

    public LinkedList<T> addAndClose(T value) {
        if (closed) {
            throw new UnsupportedOperationException("Cannot add more elements after closing the list");
        }

        var newTail = new Node<T>(value, head);
        tail.next = newTail;
        tail = newTail;
        closed = true;
        return this;
    }

    public LinkedList<T> close() {
        if (closed) {
            throw new UnsupportedOperationException("Cannot add more elements after closing the list");
        }

        tail.next = head;
        closed = true;
        return this;
    }

    @AllArgsConstructor
    public static class Node<T> {

        @Getter
        private T value;
        @Getter
        private Node<T> next;

        public boolean hasNext() {
            return next != null;
        }
    }
}
