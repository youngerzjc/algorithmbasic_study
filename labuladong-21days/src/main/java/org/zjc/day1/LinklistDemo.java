package org.zjc.day1;

import java.util.PriorityQueue;

/**
 * @author: zhangjunchai
 * @Date: 2022/4/6 14:17
 * @Description:
 */
public class LinklistDemo {

    public static void main(String[] args) {

    }

}

// https://leetcode-cn.com/problems/intersection-of-two-linked-lists/submissions/
class Solution_getIntersectionNode {
    // 仅考虑的无环情况下的解答。
    // 「寻找两条链表的交点」的核心在于让 p1 和 p2 两个指针能够同时到达相交节点 c1，那么可以通过预先计算两条链表的长度来做到这一点，先将两个链表的差值长度先提前进行移动，然后再进行比较两个链表的节点
    //
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        // 计算长度
        int l1 = 0;
        int l2 = 0;
        while (p1 != null) {
            l1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            l2++;
            p2 = p2.next;
        }
        p1 = headA;
        p2 = headB;
        // 长度差值
        int n = Math.abs(l1 - l2);
        // 消除长度差值
        if (l1 > l2) {
            for (int i = 0; i < n; i++) {
                p1 = p1.next;
            }
        } else if (l1 < l2) {
            for (int i = 0; i < n; i++) {
                p2 = p2.next;
            }
        }
        // 同时移动两个链表，进行比较
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}

// https://leetcode-cn.com/problems/linked-list-cycle-ii/
class Solution_detectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

// https://leetcode-cn.com/problems/linked-list-cycle/
class Solution_hasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}


// https://leetcode-cn.com/problems/middle-of-the-linked-list/
class Solution_middleNode {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}


// https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/submissions/
class Solution_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        // find n + 1
        ListNode nthFromEnd = findNthFromEnd(dummy, n + 1);
        // delete
        nthFromEnd.next = nthFromEnd.next.next;
        return dummy.next;
    }

    public ListNode findNthFromEnd(ListNode head, int n) {
        ListNode p2 = head;
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }
}

// https://leetcode-cn.com/problems/merge-k-sorted-lists/submissions/
class Solution_mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode p = dummy;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>((v1, v2) -> {
            return v1.val - v2.val;
        });
        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.add(node);
            }
        }
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.remove();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
        }

        return dummy.next;
    }
}

// https://leetcode-cn.com/problems/merge-two-sorted-lists/submissions/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                dummy.next = p2;
                p2 = p2.next;
            } else {
                dummy.next = p1;
                p1 = p1.next;
            }
            dummy = dummy.next;
        }
        if (p1 != null) {
            dummy.next = p1;
        }
        if (p2 != null) {
            dummy.next = p2;
        }
        return p.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}