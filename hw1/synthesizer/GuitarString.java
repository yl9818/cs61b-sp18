package synthesizer;

public class GuitarString {
    protected BoundedQueue<Double> buffer;
    protected static final int SR = 44100;
    protected static final double DECAY = .996;


    public GuitarString(double frequency) {
        int N = (int) Math.round(SR / frequency);
        buffer = new ArrayRingBuffer<>(N);
        for (int i = 0; i < N; i++) {
            buffer.enqueue(0.0);
        }
    }

    public void pluck() {
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.dequeue();
        }
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.enqueue(Math.random() - 0.5);
        }
    }

    public void tic() {
        Double head = buffer.dequeue();
        Double newHead = buffer.peek();
        Double newDouble = 0.5 * (head + newHead) * DECAY;
        buffer.enqueue(newDouble);
    }

    public double sample() {
        return buffer.peek();
    }

//    @Override
//    public String toString() {
//
//    }


}
