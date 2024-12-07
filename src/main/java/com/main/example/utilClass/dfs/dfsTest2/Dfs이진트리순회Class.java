package com.main.example.utilClass.dfs.dfsTest2;


/**
 * 이진트리순회(Depth-First Search) 예제
 */
public class Dfs이진트리순회Class {
    Node root;

    public class Node {
        int data;
        Node lt, rt;
        public Node(int val) {
            data = val;
            lt=rt=null;
        }
    }


    // 이진트리순회
    public void DFS(Node root) {
        if(root == null) {
            return;
        }
        else {
            // System.out.println(root.data); // 전위순회
            DFS(root.lt);
            System.out.println(root.data);
            DFS(root.rt);
        }
    }
     public void DFSTest() {
        Dfs이진트리순회Class tree = new Dfs이진트리순회Class();
        tree.root           = new Node(1);
        tree.root.lt        = new Node(2);
        tree.root.rt        = new Node(3);
        tree.root.lt.lt     = new Node(4);
        tree.root.lt.rt     = new Node(5);
        tree.root.rt.lt     = new Node(6);
        tree.root.rt.rt     = new Node(7);
        DFS(tree.root);
    }

}
