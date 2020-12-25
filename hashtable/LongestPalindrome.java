package hashtable;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {

    /* Description:
    * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
    * Letters are case sensitive, for example, "Aa" is not considered a palindrome here. */

    /* Data Structure: HashTable */

    /* Visual Representation
    * "abbcc"
    * a added to the set
    * b added to the set
    * b is removed from the set, count is incremented
    * c is added to the set
    * c is removed from the set, count is incremented
    * count (2) times 2 + 1 - since the character set is not empty. */

    /* Time Complexity: O(n) where n is the number of characters in the string
    *  Space Complexity: O(n) use of Set */

    public int longestPalindrome(String s) {
        Set<Character> characterSet = new HashSet<>();
        int count = 0;

        for (char c: s.toCharArray()) {
            if (characterSet.contains(c)) {
                characterSet.remove(c);
                count++;
            } else {
                characterSet.add(c);
            }
        }

        if (!characterSet.isEmpty()) return count * 2 + 1;

        return count * 2;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        LongestPalindrome solution = new LongestPalindrome();
        int count = solution.longestPalindrome(s);
        System.out.println("Longest Palindrome: " + count);
    }

}
