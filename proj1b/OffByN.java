public class OffByN implements CharacterComparator {
    int offN;
    OffByN(int N) {
        offN = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        return (Math.abs(x - y) == offN);
    }
}
