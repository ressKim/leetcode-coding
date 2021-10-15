package programmers.levelOne;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42862
 */
public class 체육복 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int solution1 = solution.solution(5, new int[]{2,4}, new int[]{1,3,5});
        System.out.println("solution1 = " + solution1);
        int solution2 = solution.solution(5, new int[]{2,4}, new int[]{3});
        System.out.println("solution2 = " + solution2);
        int solution3 = solution.solution(3, new int[]{3}, new int[]{1});
        System.out.println("solution3 = " + solution3);

        int solution4 = solution.solution(20, new int[]{3,4,5}, new int[]{1,2,3});
        System.out.println("solution4 = " + solution4);
        int solution5 = solution.solution(20, new int[]{1,2,3,4,5}, new int[]{2});
        System.out.println("solution5 = " + solution5);

        int solution6 = solution.solution(5, new int[]{4,2}, new int[]{3,5});
        System.out.println("solution6 =  5 ?? " + solution6);
    }


    /**
     * n 학생수
     * lost 체육복 잃어버린 사람들
     * reserve 체육복 더들고 있는 사람들
     * <p>
     * 내가 들고왔는데 뺏겼든 옆에 사람이 뺏겼든간에 그냥 -1 된거다
     */
    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {

            int result = n - lost.length;
            int answer = 0;
            int reserveCount = 0;
            int temp = 1000000;
            Arrays.sort(lost);
            Arrays.sort(reserve);
            for (int l = 0, lostLength = lost.length; l < lostLength; l++) {
                for (int r = 0, reserveLength = reserve.length; r < reserveLength; r++) {
                    if (lost[l] - reserve[r] == 0) {
                        lost[l] = -100;
                        reserve[r] = -100;
                        reserveCount++;
                        break;
                    }
                }
            }
            for (int i : lost) {
                for (int r = 0, reserveLength = reserve.length; r < reserveLength; r++) {
                    temp = i - reserve[r];
                    if (temp == 1 || temp == -1) {
                        reserveCount++;
                        reserve[r] = -100;
                        break;
                    }
                }
            }
            answer = result + reserveCount;

            return answer;
        }
    }

}
