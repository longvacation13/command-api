package com.example.codingtest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeetCodeTest {

    public void IntegerToRoman() {

        //int num = 3;   // III
        //int num = 53;  // LIII
//        int num = 1994;  // MCMXCIV
        int num = 5133;
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        StringBuilder result = new StringBuilder();
        for(Map.Entry<String, Integer> dto : map.entrySet()) {
            if(num / dto.getValue() >= 1) {
                for(int j=0; j < num / dto.getValue(); j++) {
                    result.append(dto.getKey());
                }
                num %= dto.getValue();
            }
        }
        System.out.println(result.toString());

    }

    /**
     *
     * @param num
     * @return
     * @Desc
     *          number를 받으면 이게 5 * 10 ^ N 인지 혹은 1 * 10 ^ N 인지 확인한다.
     */
    private boolean isPowYn(int num) {
        boolean result = true;

        // 1~9 사이값이 나올때까지 계속 나눗셈 해줌
        while(num / 10 > 1) {
            num /= 10;
        }

        if(num != 1) {
            result = false;
        }

        return result;
    }


    public void ContainerWithMostWater() {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        int maxValue  = 0;
//        for(int lt = 0; lt < heights.length; lt++) {
//            for(int rt = heights.length-1; rt >= lt; rt--) {
//                int vertical = Math.abs(rt - lt);
//                int height   = getMinValue(heights[lt], heights[rt]);
//                int width    = vertical * height;
//                if(width > maxValue) {
//                    maxValue = width;
//                }
//            }
//        }

        int lt = 0;
        int rt = heights.length-1;
        while(rt > lt) {
            int vertical = Math.abs(rt - lt);
            int height   = Math.min(heights[lt], heights[rt]);
            int width    = vertical * height;


            if(heights[lt] < heights[rt]) {
                lt++;
            } else if(heights[lt] > heights[rt]) {
                rt--;
            } else {
                lt++;
                rt--;
            }
        }


        System.out.println("maxValue : "+maxValue);
    }

    public int getMinValue(int a, int b) {
        if(a < b) {
            return a;
        } else {
            return b;
        }
    }


    public void threeSum() {
        //int[] num = {2, 1, 0, -1, -1, -4};
        HashSet<List<Integer>> set = new HashSet<>();

        int[] nums = {-4, 1, -1, 0, -1, 2}; // -4, -1, -1, 0, 1, 2
        //int[] nums = {1, 2, -2, -1};
        Arrays.sort(nums);

        int lt = 0;
        int rt = nums.length-1;

        while(lt < rt-1) {
            int sum = nums[lt] + nums[rt];

            if(sum + nums[lt+1] == 0) {
                //System.out.println(nums[lt]+","+nums[rt]+","+nums[lt+1]);
                set.add(Arrays.asList(nums[lt], nums[rt], nums[lt+1]));
                rt--;
                continue;
            }

            if(sum + nums[rt-1] == 0) {
                //System.out.println(nums[lt]+","+nums[rt]+","+nums[rt-1]);
                set.add(Arrays.asList(nums[lt], nums[rt], nums[rt-1]));
                lt++;
                continue;
            }

            if(sum+nums[lt+1] < 0) lt++;
            if(sum+nums[rt-1] > 0) rt--;

        }

        HashSet<Integer> test = new HashSet<>();





        System.out.println(set.stream().collect(Collectors.toList()));
        int a = 1;
        int b = 2;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 최적화 요소
        // 1) 현재 값과 이전값이 같을 경우 -> 조합은 이미 결정되었으니 넘어감

        HashSet<List<Integer>> hash = new HashSet<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++) {

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int lt = i+1;
            int rt = nums.length - 1;
            while(lt < rt) {
//                if(i == lt) { lt++; continue; }
//                if(i == rt) { rt--; continue; }
                int sum = nums[i] + nums[lt] + nums[rt];

                if(sum == 0) {
                    List<Integer> dto = Arrays.asList(nums[i], nums[lt], nums[rt]);
                    Collections.sort(dto);
                    hash.add(dto);
                    lt++;
                    rt--;
                } else if(sum > 0) {
                    rt--;
                } else if(sum < 0) {
                    lt++;
                }
            }
        }

        List<List<Integer>> list = hash.stream().collect(Collectors.toList());
        return list;
    }
}
