package com.main.example.utilClass.bfstest2;

import com.main.example.utilClass.dfs.dfsTest1.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BfsClassTest2 {

    Node root;


    public void BFS(Node root) {
        Queue<Node> q1 = new LinkedList<>();
        q1.offer(root);
        int LVL = 0;

        while(!q1.isEmpty()) {
            int len = q1.size();
            System.out.println("LVL : "+LVL+" ");
            for(int i = 0; i < len; i++) {
                Node n1 = q1.poll();
                System.out.print(n1.data+" ");
                if(n1.lt != null) q1.offer(n1.lt);
                if(n1.rt != null) q1.offer(n1.rt);
            }
            System.out.println();
            // for문이 종료되고 나면 아래 레벨로 내려가기 때문에
            LVL++;
        }

    }

    public void test() {
        BfsClassTest2 tree = new BfsClassTest2();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        BFS(tree.root);
    }

}
