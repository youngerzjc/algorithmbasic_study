package part3_listnode;

/**
 * 合并两个有序链表
 */
public class Code24_MergeTwoList {

    public static void main(String[] args) {
        Node node3 = new Node(8, null);
        Node node2 = new Node(3, node3);
        Node node1 = new Node(1, node2);

        Node nodeA = new Node(5, null);
        Node nodeB = new Node(4, nodeA);
        Node nodeC = new Node(2, nodeB);

        printList(node1);
        printList(nodeC);
        Node node = mergetTwoList(node1, nodeC);

        printList(node);



    }

    public static Node mergetTwoList(Node list1, Node list2){

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
