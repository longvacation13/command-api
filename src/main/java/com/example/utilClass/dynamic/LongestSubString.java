package com.example.utilClass.dynamic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LongestSubString {
    static int[] dy;

    public void test() {
        String s = "pwwkew";
        //String s = "dvdf";
        Queue<Integer> q1 = new LinkedList<>();

        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        

        for(int i = 0; i < s.length(); i++) {
            int lt = i;
            while(lt < s.length()) {
                if(map.getOrDefault(s.charAt(lt),0) >= 1) {
                    map.clear();
                    break;
                } else {
                    map.put(s.charAt(lt), map.getOrDefault(s.charAt(lt),0)+1);
                    if(map.keySet().size() > maxLength) {
                        maxLength = map.keySet().size();
                    }
                }
                lt++;
            }
        }
        System.out.println(maxLength);
    }
}
