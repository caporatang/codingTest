package com.example.codingtest.dataStructure.linkedList;

/**
 * packageName : com.example.codingtest.dataStructure.linkedList
 * fileName : TestLinkedList
 * author : taeil
 * date : 8/8/24
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 8/8/24        taeil                   최초생성
 */
public class BasicLinkedList<T> {
    // 가장 앞에 위치하는 node
    public Node<T> head = null;

    public class Node<T> {
        // 노드
        T data;

        // 다음 노드를 가리킬 next
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }


    public void addNode(T data) {
        if(head == null) {
            // head 가 null 이면 가장 앞에 있는 Node가 없는거니까 head에 data를 할당.
            head = new Node<>(data);
        } else {
            // head가 null이 아니다 -> 기존 node가 있다.
            Node<T> node = this.head;
            while(node.next != null) {
                /*
                 * node가 null이 아니면 node에 node.next 값을 할당한다.
                 * node가 생성되면 node의 pointer는 null로 생성된다.
                 * node의 next가 null이 아니라면 다음 node가 있다는것을 의미하므로, node에 node.next값을 할당한다.
                 * node가 null 이라서 할당을 안하는 시점이라면, tail node 즉, 이 LinkedList의 끝이다.
                 */
                node = node.next;
            }
            /*
             * linkedList의 끝 노드여서 while문을 빠져나왔다.
             * 그럼 현재 노드의 next에 새로운 데이터를 가지고 addNode의 인자로 들어온 data를 가진 노드를 연결 시켜주면 linkedList에 추가가 된다.
             */
            node.next = new Node<T>(data);
        }
    }

    public void printAll() {
        if(head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);

            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public static void main(String[] args) {
        BasicLinkedList<Integer> testLinkedList = new BasicLinkedList<>();
        testLinkedList.addNode(1);
        testLinkedList.addNode(2);
        testLinkedList.addNode(3);
        testLinkedList.addNode(4);

        System.out.println(testLinkedList.head.next.data);
        System.out.println(testLinkedList.head.next.next.data);

    }
}