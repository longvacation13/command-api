package com.example.utilClass.dfs;

// DFS : Depth First Search

/**
 * 전위-중위-순위는 부모 노드가 기준이다.
 * 전위순회 : 부모 -> 왼 -> 오
 * 중위순회 : 왼쪽 -> 부모 -> 오른쪽
 * 후위순회 : 왼쪽 -> 오른쪽 -> 부모
 */
public class BinaryTreeTest {
    Node root;

    public class Node {
        int data;
        Node lt;
        Node rt;
        Node(int data) {
            this.data = data;
            lt=rt=null;
        }
    }

    /**
     * 전위순회
     * @param root
     * @Desc root Node를 전달받으면 부모 -> 왼 -> 오른쪽
     */
    public void preDFS(Node root) {


    }


    
    public void BinaryTreeTest() {
        BinaryTreeTest tree = new BinaryTreeTest();
        tree.root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
    }
}
