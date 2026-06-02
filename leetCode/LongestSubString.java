package leetCode;
/*
Given a string s, find the length of the longest substring without duplicate characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */
import java.util.HashSet;

public class LongestSubString {
    public static void main(String[] args) {
        LongestSubString longestSubString = new LongestSubString();
        System.out.println(longestSubString.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }
                set.add(s.charAt(i));
                maxLength = Math.max(maxLength, i - left + 1);

        }
        return maxLength;

    }

}
