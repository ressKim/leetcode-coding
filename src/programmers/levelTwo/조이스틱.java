package programmers.levelTwo;

//https://programmers.co.kr/learn/courses/30/lessons/42860

import java.util.*;

public class 조이스틱 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int jeroen = solution.solution("JEROEN");
        System.out.println("jeroen = " + jeroen);

        int jan = solution.solution("JAN");
        System.out.println("jan = " + jan);

    }

    /**
     * 각 자리에서 A~Z 까지의 이동횟수는 고정되니깐 따록 HashMap 에 저장
     * 첫째자리 ~ 20번째자리 에서 왔다갔다 할 경우의 수만 따지면 된다.
     * ++ 마지막 자리에서 첫째 자리로 갈 수 있는 것, 첫째 자리에서 마지막 자리로
     * 갈 수 있는것.... 경우의 수 따지기가 너무 어렵다..
     * 각 A~Z 횟수 지정이 끝난 뒤 좌, 우 각각A 가 아닌 값들의
     * 자릿수까지 이동하는 횟수들을 구한다.
     * 찾아서 더 작은 쪽으로 움직이면 된다.
     */
    static class Solution {
        public int solution(String name) {
            int answer = 0;
            String[] arr = new String[]{
                    "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                    "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
            ArrayList<String> alphabet = new ArrayList<>(Arrays.asList(arr));
            HashMap<String, Integer> alphabetValue = new HashMap<>();
            int size = alphabet.size();
            for (int s = 0; size > s; s++) {
                if (s < size / 2) {
                    alphabetValue.put(arr[s], s);
                } else {
                    alphabetValue.put(arr[s], size - s);
                }
            }
            String[] nameArray = name.split("");

            int ACount = 0;
            // A 아닌 것들을 만드는데 필요한 갯수 계산 위,아래
            for (String s : nameArray) {
                if (s.equals("A")) {
                    ACount++;
                } else {
                    answer += alphabetValue.get(s);
                }
            }

            // A가 아닌 값들 좌우로 왔다갔다 하는 수 계산
            /**
             * A 가 아닌값들을 A 로 바꾸면서 왔다갔다 계산
             */
            if (!nameArray[0].equals("A")) {
                nameArray[0] = "A";
                ACount++;
            }
            int loc = 0;
            int rightCount = 0;
            int rightNextCount = 0;
            int leftCount = 0;
            int leftNextCount = 0;
            int plusLocation = 0;
            int minusLocation = 0;
            while (ACount != nameArray.length) {
                while (true) {
                    plusLocation = getPlusLocation(loc, rightCount, nameArray.length);
                    if (nameArray[plusLocation].equals("A")) {
                        rightCount++;
                    } else {
                        break;
                    }
                }
                while (true) {
                    minusLocation = getMinusLocation(loc, leftCount, nameArray.length);
                    if (nameArray[minusLocation].equals("A")) {
                        leftCount++;
                    } else {
                        break;
                    }
                }
                if (leftCount < rightCount) {
                    loc = getMinusLocation(loc, leftCount, nameArray.length);
                    nameArray[loc] = "A";
                    answer += leftCount;
                } else if (leftCount == rightCount) {
                    while (true) {
                        plusLocation = getPlusLocation(loc, rightNextCount, nameArray.length);
                        if (nameArray[plusLocation].equals("A")) {
                            rightNextCount++;
                        } else {
                            break;
                        }
                    }
                    while (true) {
                        minusLocation = getMinusLocation(loc, leftNextCount, nameArray.length);
                        if (nameArray[minusLocation].equals("A")) {
                            leftNextCount++;
                        } else {
                            break;
                        }
                    }

                    if (leftCount + leftNextCount > rightCount + rightNextCount) {
                        loc = getPlusLocation(loc, rightCount, nameArray.length);
                        nameArray[loc] = "A";
                        answer += rightCount;
                    }else{
                        loc = getMinusLocation(loc, leftCount, nameArray.length);
                        nameArray[loc] = "A";
                        answer += leftCount;
                    }

                } else {
                    loc = getPlusLocation(loc, rightCount, nameArray.length);
                    nameArray[loc] = "A";
                    answer += rightCount;
                }
                ACount++;
            }
            return answer;
        }

        private int getPlusLocation(int loc, int rightCount, int length) {
            if ((loc + rightCount) >= length) {
                return loc + rightCount - length;
            } else {
                return loc + rightCount;
            }
        }

        private int getMinusLocation(int loc, int leftCount, int length) {
            if ((loc - leftCount) < 0) {
                return length + loc - leftCount;
            } else {
                return loc - leftCount;
            }
        }
    }
}
