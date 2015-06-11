package ws.abhis.leetcode.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/submissions/detail/27635705/
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0)
            return true;

        boolean[][] adjmatrix = new boolean[numCourses][numCourses];

        for (int i=0; i<numCourses; i++)
            Arrays.fill(adjmatrix[i], false);

        for (int i=0; i<prerequisites.length; i++) {
            int start = prerequisites[i][1];
            int end = prerequisites[i][0];
            adjmatrix[start][end] = true;
        }

        boolean r = true;
        for (int i=0; i<numCourses; i++) {
            Set<Integer> recursion = new HashSet<>();
            r &= DFS(i, adjmatrix, recursion);
        }

        return r;
    }

    private boolean DFS(int node, boolean[][] adjmatrix, Set<Integer> recursionstack) {
        if (!recursionstack.contains(node)) {
            recursionstack.add(node);
            boolean r = true;
            for (int i=0; i<adjmatrix[node].length; i++) {

                if (adjmatrix[node][i]) {
                    if (!recursionstack.contains(i)) {
                        r &= DFS(i, adjmatrix, recursionstack);
                    } else {
                        return false;
                    }
                }
            }
            return r;
        } else {
            return false;
        }
    }

    public static void main(String... args) {
        int[][] prerequisites = new int[4][2];
        prerequisites[0][0] = 0; prerequisites[0][1] = 1;
        prerequisites[1][0] = 3; prerequisites[1][1] = 1;
        prerequisites[2][0] = 1; prerequisites[2][1] = 3;
        prerequisites[3][0] = 3; prerequisites[3][1] = 2;

        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println(courseSchedule.canFinish(4, prerequisites));
    }
}
