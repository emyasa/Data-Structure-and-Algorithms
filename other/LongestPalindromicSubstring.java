package other;

public class LongestPalindromicSubstring {

    /* Description: Given a string s, return the longest palindromic substring in s.
    * */

    /* Guide:
    * 1st call to extend: Odd palindromic string
    * 2nd call to extend: Even palindromic string
    *
    * Note: don't use "if else" for the condition since "result" might change and needs to be evaluated again.
    * */

    /* Time Complexity:  O(n ^ 2)
    *  Space Complexity: O(1)
    * */

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("bb"));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = extend(s, i, i);
            String s2 = extend(s, i, i + 1);

            if (s1.length() > result.length()) result = s1;
            if (s2.length() > result.length()) result = s2;
        }

        return result;
    }

    private String extend(String s, int leftIndex, int rightIndex) {
        while (leftIndex >= 0 && rightIndex < s.length()) {
            if (s.charAt(leftIndex) != s.charAt(rightIndex)) break;
            leftIndex--;
            rightIndex++;
        }

        return s.substring(leftIndex + 1, rightIndex);
    }


}
