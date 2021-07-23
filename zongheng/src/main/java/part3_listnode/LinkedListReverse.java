package part3_listnode;

import java.util.Random;

/**
 * 链表翻转
 */
public class LinkedListReverse {
    public static void main(String[] args) {
        LinkedListReverse bean = new LinkedListReverse();
        Node head = bean.buildTestData();
        System.out.println("-----反转前-----");
        bean.print(head);
        System.out.println("-----反转后------");
        Node reverseHead = bean.reverse(head);
        bean.print(reverseHead);
    }


    /**
     * 链表翻转
     * @param head
     * @return
     */
    public Node reverse(Node head){

        Node pre = null;
        Node cur = head;
        Node temp = null;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
        /*while(true){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            if(temp == null){
                return cur;
            }
            cur = temp;
        }*/

    }

    /**
     * 构建测试数据
     * @return
     */
    public Node buildTestData(){
        Node head = new Node(1, null);

        Node cur = head;
        for(int i = 0; i < 5; i++){
            int value = new Random().nextInt(10);
            Node newNode = new Node(value, null);
//            System.out.println(value);
            cur.next = newNode;
            cur = newNode;
        }
        return head;
    }

    /**
     * 打印链表
     * @param head
     */
    public void print(Node head){
        StringBuilder builder = new StringBuilder();
        while (head != null){
            builder.append(head.data + "\t");
            head = head.next;
        }
        System.out.println(builder);
    }

    class Node{
        int data;
        Node next;
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
