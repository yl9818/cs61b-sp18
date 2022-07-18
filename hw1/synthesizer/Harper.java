package synthesizer;

public class Harper extends GuitarString {

    public Harper(double frequency) {
        super(frequency);
    }

    @Override
    public void tic() {
        Double head = buffer.dequeue();
        Double newHead = buffer.peek();
        Double newDouble = -1 * 0.5 * (head + newHead) * DECAY;
        buffer.enqueue(newDouble);
    }
}
