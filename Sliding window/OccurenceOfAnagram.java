//problem link
//https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
import java.util.Arrays;

public class OccurenceOfAnagram {
    public boolean allZero(int[] count) {
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public int search(String pat, String txt) {
        int k = pat.length();
        int[] count = new int[26];
        for (char ch : pat.toCharArray()) {
            count[ch - 'a']++;
        }
        int i = 0, j = 0;
        int n = txt.length();
        int result = 0;
        while (j < n) {
            int idx = txt.charAt(j) - 'a';
            count[idx]--;
            if (j - i + 1 == k) {
                if (allZero(count)) {
                    result++;
                }
                count[txt.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        OccurenceOfAnagram OccurenceOfAnagram = new OccurenceOfAnagram();
        String txt = "forxxorfxdofr";
        String pat = "for";
        int result = OccurenceOfAnagram.search(pat, txt);
        System.out.println("Number of '" + pat + "' anagrams in '" + txt + "' is: " + result);
    }
}