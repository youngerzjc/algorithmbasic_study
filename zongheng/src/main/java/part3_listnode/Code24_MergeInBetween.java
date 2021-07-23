package part3_listnode;

/**
 * LeetCode1669题：给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
 */
public class Code24_MergeInBetween {

    public static void main(String[] args) {

        Node node4 = new Node(9, null);
        Node node3 = new Node(8, node4);
        Node node2 = new Node(3, node3);
        Node node1 = new Node(1, node2);

        Node nodeA = new Node(5, null);
        Node nodeB = new Node(4, nodeA);
        Node nodeC = new Node(2, nodeB);

        printList(node1);
        printList(nodeC);

        Node resultNode = mergeInBetween(node1, 1, 4, nodeC);
        printList(resultNode);


    }

    /**
     *  需要考虑下边界问题：a若是1；b若是最后一个（这个倒是不必在意）
     * @param list1
     * @param a 要移除的开始位置数，从1开始计数
     * @param b 要移除的终止位置数，从1开始计数
     * @param list2
     * @return
     */
    public static Node mergeInBetween(Node list1, int a , int b, Node list2){

        Node moveNode = list1;
        Node pre1 = list1;
//        Node pre1 = (a == 1)? list2 : list1;
        Node post1 = list1;

        Node pre2 = list2;

        int i = 0;
        while(true){
            i++;
            // 记录 a - 1 位置的指针
            if(i ==  a - 1 ){
                pre1 = moveNode;
            }
            // 记录 b + 1 位置的指着
            if(i == b){
                post1 = moveNode.next;
                break;
            }
            moveNode = moveNode.next;
            if(moveNode == null){
                throw new RuntimeException("要删除的下标越界");
            }
        }

        Node post2 = pre2;
        while (post2.next != null){
            post2 = post2.next;
        }
        // a = 1 时，需要特殊处理
        if(a == 1){
            pre1 = pre2;
        }else{
            pre1.next = pre2;
        }
        post2.next = post1;

        return pre1;
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
