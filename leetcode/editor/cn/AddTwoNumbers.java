package leetcode.editor.cn;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 6124 👎 0


/**
 * 已解决
 */
public class AddTwoNumbers{


    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(7);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode listNode = solution.addTwoNumbers(l1, l4);
        while(listNode != null){
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)

  //Definition for singly-linked list.
  public static class ListNode {
      int val;
      ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    ListNode head = new ListNode();
    ListNode tail = head;
    int carry = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln = new ListNode(0);

        if(l1 != null && l2 != null){
            int j = l1.val + l2.val + carry;
            if(j >= 10){
                ln.val = j%10;
                carry = 1;
            }else{
                ln.val = j;
                carry = 0;
            }
            tail.next = ln;
            tail = ln;
            addTwoNumbers(l1.next,l2.next);

        }else if(l1 != null && l2 == null){
            int j = l1.val + carry;
            if(j == 10){
                ln.val = 0;
                carry = 1;
            }else{
                ln.val = j;
                carry = 0;
            }
            tail.next = ln;
            tail = ln;
            addTwoNumbers(l1.next,null);
        }else if(l1 == null && l2 != null){
            int j = l2.val + carry;
            if(j == 10){
                ln.val = 0;
                carry = 1;
            }else{
                ln.val = j;
                carry = 0;
            }
            tail.next = ln;
            tail = ln;
            addTwoNumbers(null,l2.next);
        }

        if(carry ==1){
            tail.next = new ListNode(1);
            return head.next;
        }else{
            return head.next;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
