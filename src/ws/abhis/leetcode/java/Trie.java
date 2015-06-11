package ws.abhis.leetcode.java;

import junit.framework.TestCase;

/**
 * Implement a trie with insert, search, and startsWith methods.

 Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 */
public class Trie extends TestCase {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        initialize();
    }

    /**
     * Initialize trie with all alphabets
     */
    private void initialize() {
        int j = 0;
        for (int i=97; i<=122; i++, j++) {
            TrieNode n = new TrieNode(String.valueOf( (char) i ));
            root.nodes.add(n);
        }
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0)
            return;

        int len = 0;
        TrieNode node = root;
        while (len < word.length()) {
            boolean found = false;

            for (int i = 0; i < node.nodes.size(); i++) {
                if (node.nodes.get(i).val.equals(String.valueOf( word.charAt(len)))) {
                    node = node.nodes.get(i);
                    found = true;
                    break;
                }
            }

            if (!found) {
                TrieNode t = new TrieNode(String.valueOf(word.charAt(len)));
                node.nodes.add(t);
                node = t;
            }

            len = len + 1;

        }
    }



    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0)
            return false;

        int len = 0;
        TrieNode node = root;
        while (len < word.length()) {

            boolean found = false;
            for (int i = 0; i < node.nodes.size(); i++) {
                if (node.nodes.get(i).val.equals(String.valueOf( word.charAt(len)))) {
                    node = node.nodes.get(i);
                    found = true;
                    break;
                }
            }
            if (!found) return false;

            len = len + 1;
        }

        if (node.nodes.size() == 0)
            return true;
        else
            return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String word) {
        if (word == null || word.length() == 0)
            return false;

        int len = 0;
        TrieNode node = root;
        while (len < word.length()) {
            boolean found = false;
            for (int i = 0; i < node.nodes.size(); i++) {
                if (node.nodes.get(i).val.equals(String.valueOf( word.charAt(len)))) {
                    node = node.nodes.get(i);
                    found = true;
                    break;
                }
            }
            if (!found) return false;

            len = len + 1;
        }

        return true;
    }

    /**
     * Test cases
     */
    public void testOne() {
        insert("ael");
        insert("aep");
    }
    public void testTwo() {
        insert("hello");
        insert("help");
        insert("heaven");

        assertTrue(search("help") && !search("heck") && !search("hec"));
    }

}

