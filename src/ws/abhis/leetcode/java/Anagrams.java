package ws.abhis.leetcode.java;

import java.util.*;

/**
 * https://leetcode.com/problems/anagrams/
 */
public class Anagrams {

    public List<String> anagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        List<String> ret = new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>();

        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedS = String.valueOf(c);

            if (mp.containsKey(sortedS)) {
                List<String> l = mp.get(sortedS);
                l.add(s);
                mp.put(sortedS, l);
            } else {
                List<String> l = new ArrayList<>();
                l.add(s);
                mp.put(sortedS, l);
            }
        }

        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, List<String>> e = (Map.Entry<String, List<String>>) it.next();
            List<String> l = e.getValue();
            if (l.size() > 1) {
                for (String s : l) {
                    ret.add(s);
                }
            }
        }

       return ret;
    }
}
