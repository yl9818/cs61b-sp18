package synthesizer;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayRingBuffer<T> implements BoundedQueue<T> {

    private T[] items;
    private int head;
    private int tail;
    private int count;

    private static final int DEFAULT_CAPACITY = 4;

    public ArrayRingBuffer(int N) {
        items = (T[]) new Object[N];
        count = 0;
        head = 0;
        tail = 0;
    }

    public ArrayRingBuffer() {
        this(DEFAULT_CAPACITY);
    }

    public int capacity() {
        return items.length;
    }

    public int fillCount() {
        return count;
    }

    public void enqueue(T x) {
        if (fillCount() >= capacity()) {
            throw new RuntimeException("Full ArrayRingBuffer");
        }
        items[tail] = x;
        tail = plusOne(tail);
        count++;
    }

    public T dequeue() {
        if (count < 1) {
            throw new RuntimeException("Empty ArrayRingBuffer");
        }
        T toBeRemoved = items[head];
        head = plusOne(head);
        count--;
        return toBeRemoved;
    }

    public T peek() {
        if (count < 1) {
            throw new RuntimeException("Empty ArrayRingBuffer");
        }
        return items[head];
    }

    private int plusOne(int n) {
        if (n < items.length - 1) {
            return n + 1;
        }
        return (n + 1) % items.length;
    }

    public class ArrayRingBufferIterator implements Iterator<T> {
        private int pos;

        public boolean hasNext() {
            if (pos <= tail) {
                return true;
            }
            return false;
        }

        public T next() {
            if (pos > tail) {
                throw new NoSuchElementException();
            }
            pos++;
            return items[pos - 1];
        }
    }


    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass().getName().equals("synthesizer.ArrayRingBuffer")) {
            return false;
        }
        ArrayRingBuffer buffer = (ArrayRingBuffer) o;
        boolean res = this.items.equals(buffer.items);
        return res;
    }



}
