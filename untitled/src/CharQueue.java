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
        this.circularArray = new char[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.length = capacity;

    }

    public boolean isEmpty() {
        // returns boolean value based on size
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(char elem) {
        if (size == length) {
            char[] newArray = new char[length * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = circularArray[(front + i) % length];
            }

            length = length * 2;
            circularArray = newArray;
            front = 0;
            rear = size;
        }


        circularArray[rear] = elem;
        rear = (rear + 1) % length;
        size++;
    }


    public char peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return circularArray[front];

    }

    public char dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        char elem = circularArray[front];
        front = (front + 1) % length;
        size--;
        return elem;

    }
}
