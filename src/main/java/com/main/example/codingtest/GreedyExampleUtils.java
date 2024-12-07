package com.main.example.codingtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GreedyExampleUtils {

    public class Body implements Comparable<Body>{
        int x, y;
        public Body(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Body o) {
            if(this.x == o.x) {
                return o.y - this.y;
            } else {
                return o.x - this.x;
            }
        }
    }



    public void 씨름선수() {
        int resultCount = 0;

        int n = 5;
        int[][] arr = {{172, 67},{183, 65},{180, 70},{170, 72},{181, 60}};
        List<Body> lists = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            lists.add(new Body(arr[i][0], arr[i][1]));
        }
        Collections.sort(lists);

        int maxWeight = 0;
        for(int i = 0; i < lists.size(); i++) {
            if(i == 0) {
                resultCount++;
                maxWeight = lists.get(i).y;
                continue;
            }
            else {
                    if(lists.get(i).y > maxWeight) {
                        maxWeight = lists.get(i).y;
                        resultCount++;
                    }

            }
        }

        System.out.println(resultCount);

    }

}
