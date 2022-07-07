
public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        return (Math.abs(x - y) == 1);
    }
    // calculate difference between two chars
    // int diff = 'd' - 'a'; // returns -3

}
