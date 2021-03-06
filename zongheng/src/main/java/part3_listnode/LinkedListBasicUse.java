package part3_listnode;

public class LinkedListBasicUse {
    
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }



    public static void main(String[] args) {
        // 头部添加节点1
        LinkedListBasicUse.Node head = new Node(1);
        System.out.println("头部添加节点1：" + LinkedListBasicUse.toString(head));
        // 尾部添加节点2
        head = LinkedListBasicUse.insertList(head, new Node(2), 2);
        System.out.println("尾部添加节点2：" + LinkedListBasicUse.toString(head));
        // 中间添加节点3
        head = LinkedListBasicUse.insertList(head, new Node(3), 2);
        System.out.println("中间添加节点3：" + LinkedListBasicUse.toString(head));
        // 删除中间节点2
        head = LinkedListBasicUse.deleteNode(head, 2);
        System.out.println("删除中间节点2：" + LinkedListBasicUse.toString(head));
        // 删除头部节点1
        head = LinkedListBasicUse.deleteNode(head, 1);
        System.out.println("删除头部节点1：" + LinkedListBasicUse.toString(head));
    }

   public static int getListLength(Node head) {
        int length = 0;
        Node node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     * 删除节点
     *
     * @param head     链表头节点
     * @param position 删除节点位置，取值从1开始
     * @return 删除后的链表头节点
     */
    public static Node deleteNode(Node head, int position) {
        if (head == null) {
            return null;
        }
        int size = getListLength(head);
        if (position > size || position <= 0) {
            System.out.println("输入的参数有误");
            return head;
        }
        if (position == 1) {
            //curNode就是链表的新head
            return head.next;
        } else {
            Node preNode = head;
            int count = 1;
            while (count < position) {
                preNode = preNode.next;
                count++;
            }
            Node curNode = preNode.next;
            preNode.next = curNode.next;
        }
        return head;
    }

    /**
     * 链表插入
     *
     * @param head       链表头节点
     * @param nodeInsert 待插入节点
     * @param position   待插入位置，取值从2开始
     * @return 插入后得到的链表头节点
     */
    public static Node insertList(Node head, Node nodeInsert, int position) {
        // 需要判空，否则后面可能会有空指针异常
        if (head == null) {
            return nodeInsert;
        }
        int size = getListLength(head);
        if (position > size + 1 || position < 1) {
            System.out.println("位置参数越界");
            return head;
        }
        //在链表开头插入
        if (position == 1) {
            nodeInsert.next = head;
            return nodeInsert;
        } else {
            Node pNode = head;
            int count = 1;
            while (count < position - 1) {
                pNode = pNode.next;
                count++;
            }
            nodeInsert.next = pNode.next;
            pNode.next = nodeInsert;
        }
        return head;
    }


    /**
     * 链表打印
     *
     * @param head 头结点
     */
    public static String toString(Node head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.data).append("\t");
            head = head.next;
        }
        return sb.toString();
    }

}