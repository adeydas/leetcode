package ws.abhis.leetcode.java;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/word-search/
 * https://abhi.im/leetcode-word-search/
 */
public class WordSearch {
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null)
            return false;

        this.board = board;
        this.word = word;



        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    for (boolean[] row : visited)
                        Arrays.fill(row, false);
                    if (DFS(i, j, 0, visited))
                        return true;
            }
        }


        return false;
    }

    private boolean DFS(int row, int col, int wordIndex, boolean[][] visited) {

        if (board[row][col] != word.charAt(wordIndex) || visited[row][col]) {
            return false;
        }
        visited[row][col] = true;
        if (wordIndex == word.length()-1) {
            return true;
        }


            if (row < board.length - 1 && DFS(row + 1, col, wordIndex + 1, visited)) {
                 return true;
            }
            if (row > 0 && DFS(row - 1, col, wordIndex + 1, visited)) {
                return true;
            }
            if (col < board[0].length - 1 && DFS(row, col + 1, wordIndex + 1, visited)) {
                return true;
            }
            if (col > 0 && DFS(row, col - 1, wordIndex + 1, visited)) {
                return true;
            }

        visited[row][col] = false;

          return false;
    }

    public static void main(String... args) {
        char[][] board = new char[3][4];
//        board[0] = new char[]{'A', 'B', 'C', 'E'};
//        board[1] = new char[]{'S', 'F', 'C', 'S'};
//        board[2] = new char[]{'A', 'D', 'E', 'E'};
//        board[0] = new char[]{'C', 'A', 'A'};
//        board[1] = new char[]{'A', 'A', 'A'};
//        board[2] = new char[]{'B', 'C', 'D'};
        board[0] = new char[]{'A', 'B', 'C', 'E'};
        board[1] = new char[]{'S', 'F', 'E', 'S'};
        board[2] = new char[]{'A', 'D', 'E', 'E'};

        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, "ABCESEEEFS"));
    }
}
