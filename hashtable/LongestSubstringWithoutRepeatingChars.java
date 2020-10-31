import java.util.Arrays;

public class LongestSubstringWithoutRepeatingChars {

    /* Description:
    * Given a string s, find the length of the longest substring without repeating characters. */

    /* Data Structure: HashTable - can also be considered as Two Pointer
    *  Hint: Index of Previous Occurence as temp
    *   - ASCII is a 7-bit character set containing 128 characters.
    *   - ans is always updated, relative to temp
    */

    /* Visual Representation of ans and temp
    * s = "ababc"
    * ['a', 'b', 'a', 'b', 'c']
    * temp (index) moves every time there's an occurence
    * ans (length) always check the difference from the current index (i) and temp
    * */

    /* Time Complexity: O(n) - Linear
    * Where n is the length of string */

    public int lengthOfLongestSubstring(String s) {
        int ans = 0, temp = 0;
        int[] characterArray = new int[128];

        for (int i = 0; i < s.length(); i++) {
            if (characterArray[s.charAt(i)] > 0) {
                temp = Math.max(temp, characterArray[s.charAt(i)]);
            }

            characterArray[s.charAt(i)] = i + 1;
            ans = Math.max(ans, i - temp + 1);
        }

        return ans;
    }

    /* Demo */
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChars solution = new LongestSubstringWithoutRepeatingChars();
        int length = solution.lengthOfLongestSubstring("ababcabcd");
        System.out.println("Longest substring w/o repeating chars: " + length);
    }
}
