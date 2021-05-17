package pattern.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 *
 * Example 1:
 *
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * Example 2:
 *
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 * Example 3:
 *
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 */
public class LongestSubstringKDistinct {

    public static int findLength(String str, int k) {
        // validation input
        if(Objects.isNull(str) || k > str.length() || str.length() ==0) {
            throw new IllegalArgumentException("Invalid input");
        }

        // initialization
        int start=0, end = 0, maxLen=0;
        Map<Character,Integer> charFreqMap = new HashMap<>();

        // loop for each char -> expand start and end
        while(end<str.length()) {
            Character cR = str.charAt(end);
            charFreqMap.put(cR, charFreqMap.getOrDefault(cR, 0)+1);

            // shrink until we left with k distinct
            while (charFreqMap.size()>k) {
                Character cL = str.charAt(start++);
                charFreqMap.put(cL, charFreqMap.get(cL)-1);

                // remove from map if frequency is 0
                if(charFreqMap.get(cL) == 0) {
                    charFreqMap.remove(cL);
                }
            }

            //record maxLen
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(findLength("araaci", 1));
    }

}
