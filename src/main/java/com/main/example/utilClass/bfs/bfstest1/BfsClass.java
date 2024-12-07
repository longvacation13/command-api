package com.main.example.utilClass.bfs.bfstest1;

import java.util.LinkedList;
import java.util.Queue;

public class BfsClass {
    Node root;

    public class Node {
        Node lt, rt;
        int data;
        Node(int val) {
            this.data = val;
        }
    }

    /**
     * root node를 넘겨받아서 레벨우선 탐색
     * @param root
     */
    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);

        int L=0; // level
        while(!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(L +" : "); // 레벨 출력
            for(int i = 0; i < len; i++) { // 레벨 별로 순회함
                Node curNode = Q.poll();
                System.out.print(curNode.data+" ");

                // 노드가 있을 경우에만 넣음
                if(curNode.lt != null) Q.offer(curNode.lt);
                if(curNode.rt != null) Q.offer(curNode.rt);
            }
            L++;
            System.out.println();
        }
    }

    public void Bfstest() {

        BfsClass b1 = new BfsClass();
        b1.root = new Node(1);  // root node를 구성함
        b1.root.lt = new Node(2);
        b1.root.rt = new Node(3);
        b1.root.lt.lt = new Node(4);
        b1.root.lt.rt = new Node(5);
        b1.root.rt.lt = new Node(6);
        b1.root.rt.rt = new Node(7);

        BFS(b1.root);

    }

}
