package com.playground;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListCycleDetectorTest {

    @ParameterizedTest
    @MethodSource
    public void testNonCircularLinkedLists(LinkedList<String> nonCircularLinkedList) {
        assertFalse(LinkedListCycleDetector.isCircular(nonCircularLinkedList));
    }

    @ParameterizedTest
    @MethodSource
    public void testCircularLinkedLists(LinkedList<String> circularLinkedList) {
        assertTrue(LinkedListCycleDetector.isCircular(circularLinkedList));
    }

    static Stream<LinkedList<String>> testNonCircularLinkedLists() {
        return Stream.of(
                new LinkedList("a"),
                new LinkedList("a").add("b"),
                new LinkedList("a").add("b").add("c"),
                new LinkedList("a").add("b").add("c").add("d")
        );
    }

    static Stream<LinkedList<String>> testCircularLinkedLists() {
        return Stream.of(
                new LinkedList("a").close(),
                new LinkedList("a").addAndClose("b"),
                new LinkedList("a").add("b").addAndClose("c"),
                new LinkedList("a").add("b").add("c").addAndClose("d")
        );
    }
}