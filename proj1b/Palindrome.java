public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        if (word.length() < 2) {
            return true;
        }
        Deque<Character> deque = wordToDeque(word);
        return isPalindrome(deque);
    }

    public boolean isPalindrome(Deque<Character> deque) {
        if (deque.size() < 2) {
            return true;
        }
        Character first = deque.removeFirst();
        Character last = deque.removeLast();
        if (!first.equals(last)) {
            return false;
        }
        return isPalindrome(deque);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() < 2) {
            return true;
        }
        for (int i = 0; i < word.length() / 2; i++) {
            Character first = word.charAt(i);
            Character last = word.charAt(word.length() - 1 - i);
            if (!cc.equalChars(first, last)) {
                return false;
            }
        }
        return true;
    }


}
