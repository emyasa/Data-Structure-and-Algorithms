package array;

public class FirstUniqueChar {

    /* Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
     * */

    /* Guide
    * ASCII is a 7-bit code, meaning that 128 characters (27) are defined.
    * Populate the charFrequency first, then loop through again to check each frequency
    * */

    /* Time Complexity: O(n)
    * Space Complexity: O(n)
    * */

    public static void main(String[] args) {
        int index = new FirstUniqueChar().firstUniqueCharIndex("leetcode");
        System.out.println("First unique char index: " + index);
    }

    public int firstUniqueCharIndex(String s) {
        char[] charFrequency = new char[128];
        for (char c: s.toCharArray()) {
            charFrequency[c]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if(charFrequency[s.charAt(i)] == 1) return i;
        }

        return -1;
    }
}
