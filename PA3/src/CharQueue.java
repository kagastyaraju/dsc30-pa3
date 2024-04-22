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

    private static final int DEFAULT_CAPACITY = 5;



    /**
     * constructor for charqueue with default capacity
     *
     *
     */
    public CharQueue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * constructor for charqueue with default capacity
     * @param capacity integer capacity for queue
     * @throws IllegalArgumentException if capacity is less than 1
     *
     */
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

    /**
     * checks if charqueue is empty
     * @return boolean value based on size
     *
     */

    public boolean isEmpty() {
        // returns boolean value based on size
        return size == 0;
    }

    /**
     *
     * finds size of charqueue
     * @return size of charqueue
     *
     */
    public int size() {
        // returns size
        return size;
    }

    /**
     * clears charqueue values
     *
     */
    public void clear() {
        // clears the Queue by making front rear and size 0
        front = 0;
        rear = 0;
        size = 0;
    }

    /**
     * enqueues a new character, doubles the capacity of circular array if size reaches length
     * @param elem character element that is meant to be enqueued
     */
    public void enqueue(char elem) {
        // enqueues a new character, doubles the capacity of circular array if size reaches length
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


    /**
     * enqueues a new character, doubles the capacity of circular array if size reaches length
     *
     * @throws NoSuchElementException if charqueue is empty
     * @return first character in array
     *
     */
    public char peek() {
        // returns front of array
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return circularArray[front];

    }


    /**
     * dequeues a character
     * returns element that is dequeued
     * @throws NoSuchElementException if charqueue is empty
     * @return dequeued element
     */
    public char dequeue() {
        // removes element from the front and returns it
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        char elem = circularArray[front];
        front = (front + 1) % length;
        size--;
        return elem;

    }
}
