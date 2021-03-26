public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }
    public boolean isPalindrome(String word) {
        // Any word of length 1 or 0 is a palindrome.
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        int startPos = 0;
        int endPos = word.length() - 1;
        while (startPos <= endPos) {
            if (word.charAt(startPos) != word.charAt(endPos)) {
                return false;
            }
            startPos++;
            endPos--;
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        // Any word of length 1 or 0 is a palindrome.
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        int startPos = 0;
        int endPos = word.length() - 1;
        while (startPos <= endPos) {
            if (startPos == endPos) {
                break;
            }
            if (!(cc.equalChars(word.charAt(startPos), word.charAt(endPos)))) {
                return false;
            }
            startPos++;
            endPos--;
        }
        return true;
    }
}