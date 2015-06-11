package ws.abhis.leetcode.java;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s==null || s.isEmpty())
            return false;
        if (wordDict == null || wordDict.size()==0)
            return false;
        for (int i=0; i<s.length(); ++i) {
            if (wordDict.contains(s.substring(0, i+1)) && wordBreak(s.substring(i+1), wordDict))
                return true;
        }
        return false;
    }

    public boolean wordBreak2(String s, Set<String> wordDict) {
       int n = s.length();
   if (n < 1) return false;

   // T[i][j] == true iff s[i..j] is segmentable
   boolean[][] seg = new boolean[n][n];
   for (int l=0; l<n; ++l) { // segment length, seg[i,i] has length of 0.
     for (int i=0; i<n-l; ++i) { // start letter
       int j = i + l;
       if (wordDict.contains(s.substring(i, j+1))) {
         seg[i][j] = true;
         continue;
       }
       for (int k=i; k<j; ++k) { // intermediate letter
         if (seg[i][k] && seg[k+1][j]) {
           seg[i][j] = true;
           break;
         }
       }
     }
   }

   return seg[0][n-1];
    }

    public static void main(String... args) {
        WordBreak wordBreak = new WordBreak();
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");
        System.out.println(wordBreak.wordBreak("leetcode", dict));
        System.out.println(wordBreak.wordBreak2("leetcode", dict));
    }
}
