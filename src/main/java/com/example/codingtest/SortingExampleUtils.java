package com.example.codingtest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SortingExampleUtils {

    /**
     * 시간복잡도 n^2
     *
     */
    public void 선택정렬() {
        int[] arr = {13, 5, 11, 7, 23, 15};

        int minIndex = 0;
        for(int i = 0; i <  arr.length ; i++) {
            minIndex = i;       // 비교하기위한 값 -> 이 값을 최소값으로 잡고 이값보다 작은값을 minIndex로 교체한다.
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }

    public void 버블정렬() {
        int[] arr = {13, 5, 11, 7, 23, 15};

        // 1. for : 순환 횟수
        // 1번째 순환 : 현재 상태에서 가장 큰 값이 오른쪽으로 밀림
        // 2번째 순환 : 현재 상태에서 가장 큰 값이 오른쪽 - 1 번째로 밀림
        // ...
        // 5번째 순환 : 1번째로 밀림
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public void 버블정렬연습() {
        int arr[] = {11, 7, 5, 6, 10, 9};

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length-i-1; j++) {
                int tmp = arr[j];
                if(arr[j] > arr[j+1]) {
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
                arrSystemOut(arr);
            }
        }
    }


    /**
     * 삽입정렬 키워드 : 
     */
    public void 삽입정렬() {
        int arr[] = {11, 7, 5, 6, 10, 9};
        // 7 11
        // 7 11 5 -> 7 5 11 -> 5 7 11
        for(int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            for(int j = i-1; j >= 0; j--) {
                if(arr[j+1] < arr[j]) {
                    tmp = arr[j+1];  // 작은값 갱신
                    arr[j+1]= arr[j];
                    arr[j] = tmp;
                }
            }
            for(int k=0; k < arr.length; k++) {
                System.out.print(arr[k]+" ");
            }
            System.out.println();
        }
    }

    public void 삽입정렬연습() {
        int arr[] = {11, 7, 5, 6, 10, 9};

        for(int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            for(int j = i-1; j >= 0; j--) {
                if(arr[j] > arr[j+1]) {
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        arrSystemOut(arr);

    }




    /**
     * LRU 알고리즘
     * 핵심 : c[i] = c[i-1];
     */
    public void LRU알고리즘() {
        Queue<Integer> q = new LinkedList<>();
        
        int arr[] = {1, 2, 3, 2, 6, 2, 3, 5, 7};

        int[] c = new int[5];

        for(int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            int cacheIndex = -1;
            for(int j = 0; j < c.length; j++) {
                if(tmp == c[j]) { // cache hit 했을경우
                    cacheIndex = j;
                    break;
                }
            }

            if(cacheIndex >= 0) {  // cache hit
                // hit 지점부터 밀어냄
                for(int j=cacheIndex; j > 0; j--) {
                    c[j] = c[j-1];
                }
            } else {  // cache miss
                // 가장 마지막부터 밀어냄
                for(int j=c.length-1; j > 0; j--) {
                    c[j] = c[j-1];
                }
            }
            c[0] = tmp;
            arrSystemOut(c);
        }



    }
//
//    // 히트발생지점부터 정리
//                    for(int k=j; k > 0; k--) {
//        c[k] = c[k-1];
//    }
//    c[0] = tmp;
//    arrSystemOut(c);
//                    break;


    /**
     * array를 받으면 순서대로 sys out 해준다.
     * @param arr
     */
    public void arrSystemOut(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    /**
     *  시간복잡도 N 인 중복확인
     */
    public void 중복확인HashMap() {
        String answer = "U";
        HashSet<Integer> set = new HashSet<>();
        int[] arr = {20, 25, 52, 30, 39, 33, 43, 33};
        for(int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])) {
                answer = "D";
                break;
            } else {
                set.add(arr[i]);
            }
        }
        System.out.println(answer);

    }

    /**
     * 시간 복잡도 N LOGN
     */
    public void 중복확인Sorting() {

    }

    public void 이분검색() {
        //int[] arr = {23, 87, 65, 12, 57, 32, 99, 81};
        //int searchNum = 32;
        int[] arr = {73,32,31,49,94,37,40,62,78,66,27,100,99,29,9};
        int searchNum = 99;

        int tmp = 0;
        // 삽입정렬
        for(int i = 1; i < arr.length; i++) {
            tmp = arr[i];
            for(int j=i-1; j >= 0; j--) {
                if(arr[j] > arr[j+1]) {
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        arrSystemOut(arr);

        int midNum = arr.length / 2;
        if(searchNum == arr[midNum]) {
            System.out.println(midNum+1);
        } else if(searchNum > arr[midNum]) {
            for(int i = midNum+1; i < arr.length; i++) {
                if(searchNum == arr[i]) {
                    System.out.println(i+1);
                    break;
                }
            }
        } else if(searchNum < arr[midNum]) {
            for(int i = midNum; i >=0 ; i--) {
                if(searchNum == arr[i]) {
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }

    /**
     * 결정 알고리즘은 이분 검색의 대표적인 예임
     * lt <= rt 라면 계속 돌림 ( while )
     * 값의 범위를 분명하게 픽스할 수 있을때 사용함
     */
    // 1 2 3 4 5 6 7 8 9
    public void 결정알고리즘() {
      // int N = 9; // 노래 갯수
      // int M = 3; // 레코드의 갯수
      // int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int N = 10; // 노래 갯수
        int M = 3; // 레코드의 갯수
        int[] arr = {6,5,8,5,6,8,7,6,6,7};


        int lt = Arrays.stream(arr).max().getAsInt(); // stream 메소드의 max, min은 getAsInt로 써야함, min max는 optional int형 반환이라 그렇다.
        int rt = Arrays.stream(arr).sum();            // sum 의 경우 기본형 int를 리턴함

        int answer = 0;

        while(lt <= rt) {
            int mid = (lt + rt) / 2; // dvd 한장의 용량이다 -> 이게 가능한가?

            if(count(arr, mid) <= M) {      // 레코드 갯수 만큼을 만족하는지
                answer = mid;
                rt = mid - 1;
            } else {                        // 불가능 하다면 lt는 의미가 없다.
                lt = mid + 1;               // lt    16    rt
                                            // mid 가 16일때 4장이 필요하다면 16 이하 숫자는 의미가 없음. 왜냐면 한장에 16으로 했을때 4장 필요하니까
                                            // 따라서 lt는 16+1이 된다.
            }
        }
        System.out.println(answer);
    }

    /**
     *
     * @param arr               배열
     * @param capacity          용량 -> mid가 넘어옴
     * @return                  이 배열의 용량(capacity) 기준으로 dvd 몇장이 필요한지 return
     */
    public int count(int[] arr, int capacity) {
        int cnt=1, sum=0;
        for(int x : arr) {
            if(sum+x > capacity) {
                cnt++;          // 새로운 dvd로 넘어감
                sum = x;        // 현재 곡을 새로운 dvd로 세팅
            }
            else sum+= x;
        }
        return cnt;

        // 내가 작성한 코드
//        int sum = 0;
//        int resultCount = 1;        // 초기 수량은 1이니까
//        for(int i = 0; i < arr.length; i++) {
//            sum += arr[i];
//            if(sum > capacity) {
//                sum = arr[i];
//                resultCount++;
//            } else if(sum == capacity) {
//                sum = 0;                    // 같은 경우 새 dvd로 교체하는게 아니기 떄문에 resultcount를 올리면 안된다.
//                resultCount++;              // 반례가 마지막 인덱스까지 계산했을때 딱 맞을 경우 resultCount를 + 해주면 안됨
//                                            // 따라서 잘못됨
//            }
//        }
//        return resultCount;
    }


    // 마구간 정하기 (결정알고리즘)
    public void 마구간정하기() {
        int[] arr = {1, 2, 8, 4, 9};
        Arrays.sort(arr);
        int C = 3; // 말의 갯수

    }



}
