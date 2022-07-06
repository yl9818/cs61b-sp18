public class ArrayDeque<T> {
    public class Node{

    }
    private int size;
    private int first;
    private int last;
    private int dequeLength;
    private T[] deque;
    private double usageRatio;
    private static final int DEFAULT_CAPACITY = 8;

    private void updateUsage(){
        usageRatio = (double) size/dequeLength;
    }

    public ArrayDeque(){
        deque = (T[]) new Object[DEFAULT_CAPACITY];
        dequeLength = DEFAULT_CAPACITY;
        size = 0;
        first = -1;
        last = -1;
        updateUsage();
    }

    public ArrayDeque(ArrayDeque<T> other){
        deque = (T[]) new Object[other.dequeLength];
        size = other.size;
        first = last = -1;
        for (int i=0;i<size;i++){
            addLast(other.get(i));
        }
        if (size > 0){
            first = 0;
            last = size - 1;
        }
        updateUsage();
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public T get(int index){
        index += first;
        index %= dequeLength;
        return deque[index];
    }

    public int minusone(int index){
        if (index == 0){
            return dequeLength - 1;
        }
        return index - 1;
    }

    public int plusone(int index){
        index %= dequeLength;
        if (index == dequeLength - 1){
            return 0;
        }
        return index + 1;
    }

    public void addFirst(T item){
        if (usageRatio > 0.8){
            resize(dequeLength*2);
        }
        if (first == -1){
            first++;
            last++;
        }else{
            first = minusone(first);
        }
        deque[first] = item;
        size++;
        updateUsage();
    }

    public void addLast(T item){
        if (usageRatio > 0.8){
            resize(size*2);
        }
        if (last == -1){
            first++;
            last++;
        }else{
            last = plusone(last);
        }
        deque[last] = item;
        size++;
        updateUsage();
    }

    public T removeFirst(){
        if (size == 0) return null;
        if (usageRatio < 0.25 &&
                deque.length > DEFAULT_CAPACITY){
            resize(size/2);
        }
        T val = deque[first];
        first = plusone(first);
        size--;
        updateUsage();
        return val;

    }

    public T removeLast(){
        if (size == 0) return null;
        if (usageRatio < 0.25 &&
                deque.length > DEFAULT_CAPACITY){
            resize(size/2);
        }
        T val = deque[last];
        last = minusone(last);
        size--;
        updateUsage();
        return val;
    }

    public void printDeque(){
        int a = first;
        while (a != plusone(last)){
            System.out.print(deque[a] + " ");
            a = plusone(a);
        }

        System.out.println();
    }

    public void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(deque,0,a,0,size);
        deque = a;
        updateUsage();
    }
}
