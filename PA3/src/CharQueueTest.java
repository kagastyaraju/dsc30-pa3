import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CharQueueTest {

    @org.junit.jupiter.api.Test
    void defaultConstructor() {
        CharQueue queue = new CharQueue();
        assertNotNull(queue);
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void constructorwithparam() {
        CharQueue queue = new CharQueue(10);
        assertNotNull(queue);
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }


    @org.junit.jupiter.api.Test
    void isEmpty() {
        CharQueue queue = new CharQueue();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        assertThrows(NoSuchElementException.class, queue::peek);
    }


    @org.junit.jupiter.api.Test
    void size() {
        CharQueue queue = new CharQueue();
        queue.enqueue('X');
        queue.enqueue('Y');
        queue.enqueue('Z');
        assertEquals(3, queue.size());
        assertEquals('X', queue.dequeue());
        assertEquals(2, queue.size());
        assertEquals('Y', queue.dequeue());
        assertEquals('Z', queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        CharQueue queue = new CharQueue();
        queue.enqueue('P');
        queue.enqueue('Q');
        queue.clear();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        assertThrows(NoSuchElementException.class, queue::dequeue);
    }

    @org.junit.jupiter.api.Test
    void enqueue() {
        CharQueue queue = new CharQueue(2);
        queue.enqueue('L');
        queue.enqueue('M');
        queue.enqueue('N'); // Trigger resize
        assertFalse(queue.isEmpty());
        assertEquals(3, queue.size());
        assertEquals('L', queue.peek());
    }

    @org.junit.jupiter.api.Test
    void peek() {
        CharQueue queue = new CharQueue();
        queue.enqueue('R');
        assertEquals('R', queue.peek());
        queue.enqueue('S');
        assertEquals('R', queue.peek());
        queue.dequeue();
        assertEquals('S', queue.peek());
    }

    @org.junit.jupiter.api.Test
    void dequeue() {
        CharQueue queue = new CharQueue();
        queue.enqueue('A');
        queue.enqueue('B');
        assertEquals('A', queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals('B', queue.peek());
        queue.enqueue('C');
        assertEquals('B', queue.dequeue());
        assertEquals('C', queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}