package ws.abhis.leetcode.java;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/triangle/
 */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
//        int prevSum = Integer.MAX_VALUE;
//        for (int i=0; i<triangle.size(); i++) {
//            List<Integer> row = triangle.get(i);
//            int temp = Integer.MAX_VALUE;
//            for (int j=0; j<row.size(); j++) {
//                int newSum = 0;
//                if (prevSum == Integer.MAX_VALUE) {
//                    newSum = row.get(j);
//                } else {
//                    newSum = prevSum + row.get(j);
//                }
//                temp = Math.min(temp, newSum);
//            }
//            prevSum = temp;
//        }
//        return prevSum;
        return DFS(triangle, 0, 0, 0, Integer.MAX_VALUE);
    }

    private int DFS(ArrayList<ArrayList<Integer>> triangle, int row, int column, int sum, int minSum) {
        // add itself
        sum += triangle.get(row).get(column);

        if (row == triangle.size() - 1) { // last row
            if (sum < minSum) return sum;
        } else {
            minSum = DFS(triangle, row+1, column, sum, minSum);
            minSum = DFS(triangle, row+1, column+1, sum, minSum);
        }

        return minSum;
    }

    public static void main(String... args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(-1);
        list.add(list1);
        list1 = new ArrayList<>();
        list1.add(2); list1.add(3);
        list.add(list1);
        list1 = new ArrayList<>();
        list1.add(1); list1.add(-1); list1.add(-3);
        list.add(list1);

        Triangle triangle = new Triangle();
        System.out.println(triangle.minimumTotal(list));
    }
}
