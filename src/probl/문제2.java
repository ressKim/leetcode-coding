package probl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class 문제2 {

  public String solution(String[] log) {
    String answer = "";

    ArrayList<Date> dateList = new ArrayList<>();
    //시간 차이 저장 list (5분이하, 최대 105 분 으로 저장)
    ArrayList<Long> diffTimeList = new ArrayList<>();

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

    //dateList 에 저장
    for (String dateString : log) {
      try {
        dateList.add(simpleDateFormat.parse(dateString));
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }

    for (int i = 0; dateList.size() / 2 > i; i++) {
      long endTime = dateList.get(2 * i + 1).getTime();
      long startTime = dateList.get(2 * i).getTime();

      long diffMin = (endTime - startTime) / (60 * 1000);

      if (!(diffMin < 5)) {
        if (diffMin >= 105) {
          diffTimeList.add(105L);
        } else {
          diffTimeList.add(diffMin);
        }
      }
    }
    long answerLong = 0L;
    for (Long aLong : diffTimeList) {
      answerLong += aLong;
    }

    //답변 형식으로 변경
    long minute = 0L;
    long hours = 0L;
    if (answerLong / 60 >= 1) {
      hours = answerLong / 60;
      minute = answerLong % 60;
    } else {
      minute = answerLong;
    }
    //시간 추가
    if (hours / 10 >= 1) {
      answer += hours;
    } else if (hours == 0) {
      answer += "00";
    } else {
      answer += "0" + hours;
    }
    //분 추가
    answer += ":";
    if (minute / 10 >= 1) {
      answer += minute;
    } else if (minute == 0) {
      answer += "00";
    } else {
      answer += "0" + minute;
    }

    return answer;

  }


  public static void main(String[] args) {
    문제2 T = new 문제2();
    String[] arr = {"08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"};
    System.out.println("정답 = " + T.solution(arr));

  }
}
