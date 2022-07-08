
public class OffByOne implements CharacterComparator {
    // calculate difference between two chars
    // int diff = 'd' - 'a'; // returns -3
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }
}
