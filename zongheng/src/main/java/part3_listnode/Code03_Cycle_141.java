package part3_listnode;

/**
 * 循环连表
 * 征服算法面试：https://mp.weixin.qq.com/s/iMSkLpq7n4dTi2XCpd2egA
 * 解题方案：
 *  1、使用hash的方式.(遍历迭代链表，判断节点是否存在于map中；不存在则put，存在则代表找到了入口位置；空间复杂度O(N))
 *  2、使用快慢双指针的方式（空间复杂度O(N)）
 *  首先看如何确定是否有环，方法就是双指针，一个快指针（一次走两步），一个慢指针（一次走一步）。如果快的能到达表尾就不会有环，否则如果存在圈，则慢指针一定会在某个位置与快指针相遇。
 *  这就像在操场长跑，一个人快一个人慢，只要时间够，快的一定能在某个时候再次追上慢的人(也就是所谓的套圈)。
 */
public class Code03_Cycle_141 {

    public static void main(String[] args) {

        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;

//        print(node1);
        boolean result = hasCycle(node1);
        System.out.println(result);

     /*   Node cycleNode = detectCycleNode(node1);
        System.out.println(cycleNode.data);*/
    }

    public static boolean hasCycle(Node node){

        Node fast = node;
        Node slow = node;
        while(fast != null && slow != null
                && fast.next != null && slow.next != null ){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }


   /* public static Node detectCycleNode(Node node){
        Node fast = node;
        Node slow = node;
//        Node targetNode = null;
        while(fast != null && slow != null && fast.next != null){

            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                fast = node;
//                slow = slow.next;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }

        return null;
//        return targetNode;
    }*/

    /**
     * 打印链表
     * @param head
     */
    public static void print(Node head){
        StringBuilder builder = new StringBuilder();
        while (head != null){
            builder.append(head.data + "\t");
            head = head.next;
        }
        System.out.println(builder);
    }


}

class Node{
    int data;
    Node next;
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

