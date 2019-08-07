package Easy;

public class DeleteDuplicates {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode cur = head;
            while (cur != null && cur.next != null) {// 遍历链表的条件
                if (cur.val == cur.next.val) {
                    ListNode node = cur.next;
                    cur.next = node.next;
                    node.next = null;//清除野指针
                } else {
                    cur = cur.next;
                }

            }
            return head;
        }
    }

    public class ListNode {// java中定义链表，一个int val，一个next指针
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
