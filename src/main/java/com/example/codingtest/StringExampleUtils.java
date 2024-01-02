package com.example.codingtest;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExampleUtils {


    /**
     * @param input1
     * @param input2
     * @return
     * @Desc
     * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
     * 대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
     * 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
     * 문자열은 영어 알파벳으로만 구성되어 있습니다.
     * 첫 줄에 해당 문자의 개수를 출력한다.
     */
    public int sameStringNumberCount(String input1, String input2) {


        // 소문자로 일괄 변환
        input1 = input1.toLowerCase();
        input2 = input2.toLowerCase();

        int response = 0;

        Matcher matcher = Pattern.compile(input1).matcher(input2);
        while(matcher.find()) {
            response++;
        }

        return response;
    }


    /**
     * 문자열을 입력받아 lower -> upper로 upper는 lower로 변환함
     * @param input
     * @return
     */
    public String changeUpperAndLower(String input) {

        StringBuilder response =  new StringBuilder();

        for(char c : input.toCharArray()) {
            if(Character.isLowerCase(c)) {
                response.append(Character.toUpperCase(c));
            } else {
                response.append(Character.toLowerCase(c));
            }
        }

        return response.toString();

    }

    /**
     *
     * @param input
     * @return
     * @Desc
     * 문장속 가장 긴단어를 출력함
     *  - 가장 길이가 긴 단어가 여러개일 경우 -> 가장 앞쪽에 위치한 단어를 답으로함
     */
    public String longestWord(String input) {
        String maxResponse = "";
        int maxResponseLength = 0;  // 가장 긴 단어의 길이

        // 1. input을 공백 기준으로 나눔
        String[] arr  = input.split(" ");

        for(String word : arr) {
            // 1. 길이 체크
            if(word.length() > maxResponseLength) {
                maxResponse = word;
                maxResponseLength = word.length();
            }
        }

        return maxResponse;
    }

    /**
     * 단어를 입력받아서 뒤집기
     * @param input
     * @return
     */
    public String wordReverse(String input) {
        int count = 0;

        StringBuffer sb = new StringBuffer(input);
        return sb.reverse().toString();
    }

    /**
     * staircase
     * @param n
     * @desc
     * 출력방식 (5 기준)
     *     #
     *    ##
     *   ###
     *  ####
     * #####
     */
    public void stairCase(int n) {

        for(int i = 0; i < n ; i++) {
            for(int j = n - (i+1); j > 0 ; j--) {
                System.out.print(" ");
            }
            for(int j = 0; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public int getTotalX(List<Integer> a, List<Integer> b) {

        // list array를 int[]로 변환
        int[] arr = a.stream().mapToInt(Integer::intValue).toArray();
        int lcm = findLCMOfArray(arr);
        System.out.println("lcm : "+ lcm);

        return 0;
    }

    // 두 숫자의 최대 공약수를 계산하는 함수
    private static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 두 숫자의 최소 공배수를 계산하는 함수
    private static int findLCM(int a, int b) {
        return ( a * b ) / findGCD(a, b);
    }

    // 배열에서 최소공배수 찾기
    private static int findLCMOfArray(int[] arr) {
        int lcm = arr[0];
        for(int i = 1; i < arr.length ; i++) {
            lcm = findLCM(lcm, arr[i]);
        }
        return lcm;
    }


    /**
     * 특정 문자 뒤집기
     * @param words
     * @Desc
     * 5. 특정 문자 뒤집기
     * 설명
     * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
     * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
     * 입력
     * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
     * 출력
     * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
     * 예시입력
     * a#b!GE*T@S
     * 예시출력
     * S#T!EG*b@a
     */
    public String specificChracterReverse(String words) {

        char[] wordsToCharArr = words.toCharArray();

        int leftIndex = 0;
        int rightIndex = wordsToCharArr.length-1;

        while(rightIndex > leftIndex) {

            // 알파벳 조합이 나올때까지 찾음 (왼쪽)
            while((rightIndex > leftIndex) && !Character.isAlphabetic(wordsToCharArr[leftIndex])) {
                leftIndex++;
            }

            // 알파벳 조합이 나올때까지 찾음 (오른쪽)
            while((rightIndex > leftIndex) && !Character.isAlphabetic(wordsToCharArr[rightIndex])) {
                rightIndex--;
            }

            // 왼쪽과 오른쪽의 알파벳 인덱스 끼리 뒤집음
            if(rightIndex > leftIndex) {
                char temp = wordsToCharArr[leftIndex];
                wordsToCharArr[leftIndex] = wordsToCharArr[rightIndex];
                wordsToCharArr[rightIndex] = temp;
                leftIndex++;
                rightIndex--;
            }

        }
        return new String(wordsToCharArr);

    }

    public void duplicateCharacterDelete(String words) {
        char[] wordsArr = words.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();

        int index = 0;
        for(char c : wordsArr) {
            if(map.get(c) == null) {
                map.put(c, index);
                list.add(c);
                index++;
            }
        }


        StringBuilder str = new StringBuilder();

        for(Character c : list) {
            str.append(c);
        }

        System.out.println(str.toString());
    }

    /** 팰린드롬
     *
     * @param words
     */
    public void leehyolee(String words) {

        // 1. 소문자로 변환
        words = words.toLowerCase();


        String regex1 = "[^a-zA-Z0-9가-힣]"; // 특수문자제외
        String regex2 = "[^a-zA-Z가-힣]";    // 특수문자제외

        // 2. 문자만 남기고 다 제거
        words = words.replaceAll(regex2, "");
        String[] nums = {"12312","!23123"};

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        HashMap<HashSet<Integer>, Integer> map2 = new HashMap<>();

        // 정방향 문자 
        System.out.println(words);
        HashSet<Integer> set = new HashSet<>();


        // 역방향 문자
        StringBuffer sb = new StringBuffer(words);
        sb = sb.reverse();


        if(sb.toString().equals(words)) {
            System.out.println("YES");

        } else {
            System.out.println("NO");
        }

    }

    public void outputOnlyNumbers(String words) {
        String regex = "[^0-9]";
        words = words.replaceAll(regex, "");

        System.out.println(words);
        System.out.println(words.charAt(0));

        StringBuffer sb = new StringBuffer(words);

        if(words.charAt(0) == '0') {
            words = sb.deleteCharAt(0).toString();
        }

        System.out.println(words); 

    }


    // teachermode, e
    // 최소 거리 계산
    // 문자열과 문자를 입력받아서 문자열로부터의 거리를 계산함
    // 해결방법
    // 1. t 에 해당하는 문자열의 인덱스를 받아서 arrayList에 저장함
    // 2. s 에 해당하는 문자열과 t 에 해당하는 인덱스간 최소 값(Math.abs)로 구함
    // 3. 최소값에 해당하면 해당 인덱스의 결과값으로 저장 StringBuilder.append()
    // 4. 최종출력 
    public void shortestWordsDistance(String s, String t) {

        List<Integer> tIndex = new ArrayList<>();

        int index = s.indexOf(t);
        while(index >= 0) {
            tIndex.add(index);
            index = s.indexOf(t, index+1);
        }

        StringBuilder result = new StringBuilder();
        for(int j = 0; j < s.length(); j++) {
            int minValue = -1;
            for(Integer i : tIndex) {
                if(minValue != -1) { // 값 세팅이 된 이후
                    if(minValue > Math.abs(i-j)) {
                        minValue = Math.abs(i-j);
                    }
                } else { // 초기값 세팅
                    minValue = Math.abs(i-j);
                }
            }
            // 여기까지 오면 index별 최소값은 정의가 끝남
            result.append(minValue+" ");
        }
        System.out.println(result.toString());
    }


    // 문자열을 입력받아 연속으로 반복되는 경우 문자열 바로 오른쪽에 반복 횟수를 표기함
    // 반복횟수가 1인경우 생략
    // 예 입력 : KKHSSSSSSSE 출력 : K2HS7E
    public void zipString(String words) {

        // n - n+1 계산을 위해 일단 빈값으로
        words = words+" ";

        int sameCount = 1;
        int index = 0;

        StringBuilder sb = new StringBuilder();

        char startWords = words.charAt(0);

        while(index < words.length()-1) {
            System.out.println(index);
            if(sameCount == 1) {
                // 초기화
                startWords = words.charAt(index);
            }

            if(words.charAt(index) == words.charAt(index+1)) {
                sameCount++;
                index++;
            } else {
                sb.append(startWords);
                if(sameCount > 1) sb.append(sameCount);
                sameCount = 1;
                index++;
            }
        }

        System.out.println(sb.toString());
    }

    /**
     * 암호해독
     * @param words
     */
    public void decryptWords(String words) {

        // 문자 치환
        words = words.replaceAll("#", "1");
        // * 케이스의 경우 \\ 두번 해줘야 인식함
        words = words.replaceAll("\\*", "0");
        System.out.println(words);

        int index = 0;
        // 1. words를 7씩으로 나눔
        while(index+7 <= words.length()) {

            System.out.println(words.substring(index, index+7));


            // 2진수 -> 10진수로 변환
            String word = words.substring(index, index+7);

            // 10진수 숫자 출력
            System.out.println(Integer.parseInt(word, 2));

            // 10진수 숫자 > 아스키 코드로 출력
            System.out.println((char)Integer.parseInt(word, 2));

            index = index + 7;
        }
    }


    /**
     * 팰린드롬 - > 시간 복잡도 O(N^2)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        String answer = "";
        int maxLength = 0;
        StringBuilder sb = new StringBuilder();


        for(int i = 0; i < s.length() - 1; i++) {
            sb.append(s.charAt(i));
            for(int j = 1+i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                StringBuilder rsb = new StringBuilder(sb).reverse(); // reverse
                if(sb.toString().equals(rsb.toString())) {
                    if(sb.toString().length() > maxLength) {
                        answer = sb.toString();
                        maxLength = sb.toString().length();
                    }
                }
            }
            sb.setLength(0);
        }
        return answer;
    }

    /**
     * 시간복잡도 O(N) 팰린드롬
     * @param s
     * @return
     * @example babad
     */
    public void longestPalindromeNew(String s) {
        String answer = "";
        for(int i = 0; i < s.length(); i++) {
            // 홀수길이
            String p1 = palindromeCenter(s, i, i);
            if (p1.length() > answer.length()) {
                answer = p1;
            }

            // 짝수 길이 팰린드롬 체크
            String p2 = palindromeCenter(s, i, i + 1);
            if (p2.length() > answer.length()) {
                answer = p2;
            }
        }
        System.out.println(answer);
    }

    public String palindromeCenter(String s, int lt, int rt) {
        while(lt >= 0 && rt < s.length() && s.charAt(lt) == s.charAt(rt)) {
            lt--;
            rt++;
        }
        return s.substring(lt + 1, rt);
    }

    // leetcode medium test : https://leetcode.com/problems/string-to-integer-atoi/
    public int StringToInteger() {
        String s = "-2147483648";
        // 1. white space -> 무시함
        // 2. ?
        // 3. digit 아닌거 나올때까지 읽음
        // 4. 123 -> 12로 0032는 32로, 숫자가 읽히기 않을 경우 0으로
        // 5. 32bit 범위에 포함되지 않을 경우 (MIN 또는 MAX_VALUE로)
        if (s == null || s.length() == 0) return 0;

        int index = 0, sign = 1, total = 0;

        // Step 1: Discard Whitespaces
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        // Step 2: Handle signs
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }



        // Step 3: Convert number and avoid overflow
        while (index < s.length()) {
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;

            // Check for overflow
            if (total > Integer.MAX_VALUE / 10 ||
                    (total == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10 * total + digit;
            index++;
        }

        return total * sign;

    }
}
