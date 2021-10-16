package programmers.levelOne;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    // https://programmers.co.kr/learn/courses/30/lessons/42840?language=java

    public static void main(String[] args) {
        Solution solution1 = new Solution();
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {1, 3, 2, 4, 2};

        int[] solution = solution1.solution(first);
        solution1.solution(second);
    }

    static class Solution {

        public static int[] solution(int[] answers) {
            int[][] patterns = {
                    {1, 2, 3, 4, 5},
                    {2, 1, 2, 3, 2, 4, 2, 5},
                    {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
            };

            int[] hit = new int[3];
            for(int i = 0; i < hit.length; i++) {
                for(int j = 0; j < answers.length; j++) {
                    if(patterns[i][j % patterns[i].length] == answers[j]) hit[i]++;
                }
            }

            int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < hit.length; i++)
                if(max == hit[i]) list.add(i + 1);

            int[] answer = new int[list.size()];
            int cnt = 0;
            for(int num : list)
                answer[cnt++] = num;
            return answer;
        }

    }
}
