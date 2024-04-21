/*
    Name: TODO
    PID:  TODO
 */

import java.util.NoSuchElementException;

/**
 * implementation of character Queue
 *
 * @author Kaushik Agastyaraju
 * @since April 18th 2024
 */

public class CharQueue {
    /* instance variables, feel free to add more if you need */
    private char[] circularArray;
    private int length;
    private int front;
    private int rear;

    private int size;

    public CharQueue() {
        this(5);
    }

    public CharQueue(int capacity) {

        if (capacity < 1) {
            throw new IllegalArgumentException();

        }
        circularArray = new char[capacity];
        front = 0;
        rear = 0;
        size = 0;

    }

    public boolean isEmpty() {
        // TODO
        return size == 0;
    }

    public int size() {
        // TODO
        return size;
    }

    public void clear() {
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(char elem) {
        if (size == circularArray.length) {
            double_capacity();
        }
        circularArray[rear] = elem;
        rear = (rear + 1) % circularArray.length;
        size++;
    }


    public char peek() {
        // TODO
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return circularArray[front];

    }

    public char dequeue() {
        // TODO
        return 0;
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        char elem = circularArray[front];
        front = (front + 1) % circularArray.length;
        size--;
        return elem;

    }
    private void double_capacity() {
        char[] newArray = new char[circularArray.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = circularArray[(front + i) % circularArray.length];
        }
        circularArray = newArray;
        front = 0;
        rear = size;
    }

}
