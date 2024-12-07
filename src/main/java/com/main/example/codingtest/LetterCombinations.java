package com.main.example.codingtest;

import java.util.*;

public class LetterCombinations {

    List<String> results = new ArrayList<>();
    class Node {
        char[] chars;
        Node next;
        public Node(char[] chars) {
            this.chars = chars;
        }
        public Node() {}
    }

    public void test() {
        String num = "234";

        Map<Integer, char[]> map = new HashMap<>();
        map.put(2, new char[] {'a','b','c'});
        map.put(3, new char[] {'d','e','f'});
        map.put(4, new char[] {'g','h','i'});
        map.put(5, new char[] {'j','k','l'});
        map.put(6, new char[] {'m','n','o'});
        map.put(7, new char[] {'p','q','r','s'});
        map.put(8, new char[] {'t','u','v'});
        map.put(9, new char[] {'w','x','y','z'});

        Node root = new Node();
        Node curNode = root;

        for(char X : num.toCharArray()) {
            curNode.next = new Node(map.get(Character.getNumericValue(X)));
            curNode = curNode.next;
        }


        this.recurrsive(root.next, "");
        System.out.println();


    }

    /**
     * root Node를 넣으면 끝까지 다 찾음
     * @param
     * @return
     */
    public void recurrsive(Node node, String current) {
        if(node == null) {
            results.add(current);
            return;
        }
        for(char ch : node.chars) {
            recurrsive(node.next, current + ch);
        }
    }

}
