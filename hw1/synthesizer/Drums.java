package synthesizer;

public class Drums extends GuitarString {

    protected static final double DECAY = 1.0;

    public Drums(double frequency) {
        super(frequency);
    }

    @Override
    public void tic() {
        Double head = buffer.dequeue();
        Double newHead = buffer.peek();
        Double newDouble = 0.5 * (head + newHead) * DECAY;
        if (Math.random() > 0.5) {
            newDouble *= -1;
        }
        buffer.enqueue(newDouble);
    }
}
