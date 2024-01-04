package com.example.codingtest;

import java.util.*;

public class CpCodingTest {

    public void test() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        String[] scores = {"DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F", "DB0001 B-", "AI5543 D+",
                           "DS7651 A+", "OS1808 B-"
        };

        //System.out.println(Arrays.deepToString(scores));
        for(int i = 0; i < scores.length; i++) {
            String[] arr = scores[i].split(" ");
            String course = arr[0];
            String currentGrade = arr[1];
            if(map.containsKey(course)) {                               // 현재 key가 존재하고
                if(compareGrades(map.get(course), currentGrade) >= 1) {        // 비교했을때 현재 key에 대한 값이 클때만
                    map.put(course, currentGrade);
                }
            } else {    // key 가 존재하지 않으면 당연히 저장해야함
                map.put(course, currentGrade);
            }
        }

        // hashamp 값 출력

        List<Map.Entry<String, String>> sortedGrades = new ArrayList<>(map.entrySet());
        sortedGrades.sort((e1, e2)-> {
            int gradeComparison = compareGrades(e2.getValue(), e1.getValue());
            return gradeComparison;
        });

        for(Map.Entry<String, String> mp : sortedGrades) {
            System.out.println("Key : "+mp.getKey());
            System.out.println("Value : "+mp.getValue());
        }
    }

    private int compareGrades(String grade1, String grade2) {
        List<String> gradeOrder = Arrays.asList("A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D+", "D0", "D-", "F");
        return Integer.compare(gradeOrder.indexOf(grade1), gradeOrder.indexOf(grade2));
    }

}
