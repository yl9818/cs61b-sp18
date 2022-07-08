public class ArrayDeque<T> implements Deque<T> {
    private int size;
    private int first;
    private int last;
    private int dequeLength;
    private T[] deque;
    private double usageRatio;
    private static final int DEFAULT_CAPACITY = 8;
    private double EPSILON = 1e-8;

    private void updateUsage() {
        usageRatio = (double) size / (double) dequeLength;
    }

    public ArrayDeque() {
        deque = (T[]) new Object[DEFAULT_CAPACITY];
        dequeLength = DEFAULT_CAPACITY;
        size = 0;
        first = -1;
        last = -1;
        updateUsage();
    }

//    public ArrayDeque(ArrayDeque other) {
//        deque = (T[]) new Object[other.dequeLength];
//        size = other.size;
//        first = -1;
//        last = -1;
//        for (int i = 0; i < size; i++) {
//            addLast((T) other.get(i));
//        }
//        if (size > 0) {
//            first = 0;
//            last = size - 1;
//        }
//        updateUsage();
//    }

    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        index += first;
        index %= dequeLength;
        return deque[index];
    }

    private int minusone(int index) {
        if (index == 0) {
            return dequeLength - 1;
        }
        return index - 1;
    }

    private int plusone(int index) {
        index %= dequeLength;
        if (index == dequeLength - 1) {
            return 0;
        }
        return index + 1;
    }

    @Override
    public void addFirst(T item) {
        if (usageRatio > 0.85) {
            resize(dequeLength * 2);
        }
        if (first == -1) {
            first++;
            last++;
        } else {
            first = minusone(first);
        }
        deque[first] = item;
        size++;
        updateUsage();
    }

    @Override
    public void addLast(T item) {
        if (usageRatio > 0.85) {
            resize(dequeLength * 2);
        }
        if (last == -1) {
            first++;
            last++;
        } else {
            last = plusone(last);
        }
        deque[last] = item;
        size++;
        updateUsage();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T val = deque[first];
        first = plusone(first);
        size--;
        updateUsage();
        if (usageRatio < 0.5 && dequeLength >= DEFAULT_CAPACITY * 2) {
            resize(dequeLength / 2);
        }
        return val;

    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T val = deque[last];
        last = minusone(last);
        size--;
        updateUsage();
        if (usageRatio < 0.5 && dequeLength >= DEFAULT_CAPACITY * 2) {
            resize(dequeLength / 2);
        }
        return val;
    }

    @Override
    public void printDeque() {
        int a = first;
        while (a != plusone(last)) {
            System.out.print(deque[a] + " ");
            a = plusone(a);
        }

        System.out.println();
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            a[i] = deque[first];
            first = plusone(first);
        }
        dequeLength = capacity;
        deque = a;
        first = 0;
        last = size - 1;
        updateUsage();
    }
}
