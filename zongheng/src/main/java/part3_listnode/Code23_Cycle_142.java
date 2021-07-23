package part3_listnode;

/**
 * 征服面试算法：https://mp.weixin.qq.com/s/iMSkLpq7n4dTi2XCpd2egA
 *
 * 寻找循环链表的入口节点，证明过程
 * </br>
 * 设链表中环外部分的长度为 a。slow 指针进入环后，又走了 b 的距离与 fast 相遇。此时，fast 指针已经走完了环的 n 圈，因此它走过的总距离为
 *
 *      a+n(b+c)+b=a+(n+1)b+nc
 *
 * 根据题意，任意时刻，fast 指针走过的距离都为 slow 指针的 2 倍。因此，我们有
 *
 *      a+(n+1)b+nc=2(a+b)
 *
 * 也就是：a=c+(n−1)(b+c)
 *
 * 由于b+c就是环的长度，假如为LEN，则：
 *
 *      a=c+(n-1)LEN
 *
 * 有了这个等量关系，我们会发现：从相遇点到入环点的距离加上 n-1圈的环长，恰好等于从链表头部到入环点的距离。
 *
 *
 *
 * 因此，当发现 slow 与fast 相遇时，我们再将快指针指向链表头部；随后，它和slow 每次向后移动一个位置。最终，它们会在入环点相遇。
 */
public class Code23_Cycle_142 {


    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;

        Node cycleEntryNode = detectCycleNode(node1);

        System.out.println(cycleEntryNode.data);

    }

    /**
     * 使用快慢指针先探测出是循环链表
     * @param head
     * @return
     */
    public static Node detectCycleNode(Node head){

        Node slow = head;
        Node fast = head;
        while(slow != null && fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;


            if(slow == fast){
                fast = head;
                while(fast == slow){
                    return fast;
                }
            }
        }

        return null;
    }


    static class Node{
        int data;
        Node next;
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
