package com.springboot.demo.algorithm;

/**
 * 链表反转
 *
 * @AUTHOR Yrp
 * @CREATE 2018-09-18
 * 09:21
 **/
public class LinkReverse {

    static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }

        public Node(Node next, int data) {
            this.next = next;
            this.data = data;
        }
    }

    // 初始化node，使node1为头结点
    public static Node initLink() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        return node1;
    }

    public static void printNodeData(Node node) {
        if (node == null) return;
        while (node.next != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.print(node.data);
    }

    // 反转链表(非递归)
    //原始初始化链表为：1->2->3->4->5
    public static Node reverseNode(Node headNode) {
        Node preNode = null;
        // 反转核心
        while (headNode != null) {
            Node tempNode = headNode;   // 头结点
            headNode = headNode.next;   // 头结点向下移一位
            tempNode.next = preNode;    // 第一次将头结点置空，第一趟为1->null(尾节点)，第二趟preNode=1,那么为2->1
            preNode = tempNode;         // 每一次反转之后新的头结点
        }
        return preNode;
    }

    public static void main(String[] args) {
        printNodeData(initLink());
        System.out.println();
        printNodeData(reverseNode(initLink()));
    }

}
