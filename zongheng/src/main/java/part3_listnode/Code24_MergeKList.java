package part3_listnode;

import java.util.Arrays;
import java.util.List;

/**
 * 征服面试算法：https://mp.weixin.qq.com/s/nCAwQxaRnOidoG1FElfS2g
 */
public class Code24_MergeKList {

    public static void main(String[] args) {
        Node node3 = new Node(8, null);
        Node node2 = new Node(3, node3);
        Node node1 = new Node(1, node2);

        Node nodeA = new Node(10, null);
        Node nodeB = new Node(4, nodeA);
        Node nodeC = new Node(2, nodeB);


        Node nodeA_1 = new Node(9, null);
        Node nodeB_1 = new Node(7, nodeA_1);
        Node nodeC_1 = new Node(5, nodeB_1);

        printList(node1);
        printList(nodeC);
        printList(nodeC_1);
        List list = Arrays.asList(node1, nodeC, nodeC_1);
        Node node = mergeKList(list);

        printList(node);



    }

    public static Node mergeKList(List<Node> list){

        Node result = null;
        for(Node node : list){
            result = mergeTwoList(result, node);
        }
        return result;
    }

    public static Node mergeTwoList(Node list1, Node list2){

        // 哨兵节点
        Node sentinelNode = new Node(0, null);
        // 新链表的尾部节点，用于
        Node tailNode = sentinelNode;
        Node head1 = list1;
        Node head2 = list2;

        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                tailNode.next = head1;
                head1 = head1.next;
            }else{
                tailNode.next = head2;
                head2 = head2.next;
            }
            tailNode = tailNode.next;
        }
        if(head1 != null){
            tailNode.next = head1;
        }

        if(head2 != null){
            tailNode.next = head2;
        }

        return sentinelNode.next;
    }

    public static void printList(Node head){

        StringBuilder builder = new StringBuilder();
        while (head != null){
            builder.append(head.data + "\t");
            head = head.next;
        }
        System.out.println(builder.toString());
    }

    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
