/***********************************************************
 * @Description : 
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2020/1/19 0:49
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package Chapter05LinkedList.LeetCode61RotateList;

import Chapter05LinkedList.LinkedListTool;
import Chapter05LinkedList.ListNode;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 链表的元素个数
        int cnt = 0;
        ListNode cur = dummyHead;
        // 找到链表的最后节点
        while (cur.next != null) {
            cur = cur.next;
            cnt++;
        }
        // 只要把链表最后k个元素移动到最前面就达到目标啦
        int n = k % cnt;
        // p和q初始化为dummyHead可以防止很多null的异常
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        for (int i = 0; i < n + 1; i++) {
            // q移动到和p间距为n的地方
            q = q.next;
        }
        // p和q一直往后移动直到q移动到链表结尾
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        dummyHead.next = p.next;
        p.next = null;
        cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = LinkedListTool.create(nums);
        ListNode newHead = new Solution().rotateRight(head, 2);
        LinkedListTool.show(newHead);
    }
}
