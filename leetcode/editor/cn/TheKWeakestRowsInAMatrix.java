package leetcode.editor.cn;
/*给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。 */

//给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。 
//
// 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。 
//
// 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。 
//
// 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。 
//
// 
//
// 示例 1：
//
// 
//输入：mat = 
//[[1,1,0,0,0],
// [1,1,1,1,0],
// [1,0,0,0,0],
// [1,1,0,0,0],
// [1,1,1,1,1]], 
//k = 3
//输出：[2,0,3]
//解释：
//每行中的军人数目：
//行 0 -> 2 
//行 1 -> 4 
//行 2 -> 1 
//行 3 -> 2 
//行 4 -> 5 
//从最弱到最强对这些行排序后得到 [2,0,3,1,4]
// 
//
// 示例 2： 
//
// 
//输入：mat = 
//[[1,0,0,0],
// [1,1,1,1],
// [1,0,0,0],
// [1,0,0,0]], 
//k = 2
//输出：[0,2]
//解释： 
//每行中的军人数目：
//行 0 -> 1 
//行 1 -> 4 
//行 2 -> 1 
//行 3 -> 1 
//从最弱到最强对这些行排序后得到 [0,2,3,1]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 2 <= n, m <= 100 
// 1 <= k <= m 
// matrix[i][j] 不是 0 就是 1 
// 
// Related Topics 数组 二分查找 矩阵 排序 堆（优先队列） 
// 👍 78 👎 0

import javafx.scene.layout.Priority;

import java.util.*;
//1.优先队列的创建方法
//2.优先队列中使用的方法，peek(),poll(),offer()
//3.compare中返回值的含义。
//4.一般四个判断，左边界，右边界，中间值，特殊值。

/**
 * 已解决
 */
public class TheKWeakestRowsInAMatrix{
    public static void main(String[] args) {
        Solution solution = new TheKWeakestRowsInAMatrix().new Solution();
        int mat[][] = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        System.out.println(solution.kWeakestRows(mat, 3));
//        System.out.println(new String("a").compareTo(new String("b")));//-1
//        System.out.println(11/2);

//        String s1 = "abc";
//        String s2 = "abc";
//        String s3 = "abc" +"def";
//        String s4 = "abcdef";
//        String s5 = s2 + "def";
//        String s6 = new String("abc");
//        System.out.println(s1 == s2);//true
//        System.out.println(s3 == s4);//false ->true
//        System.out.println(s4 == s5);//false
//        System.out.println(s4.equals(s5));//true，比较的是值，不是地址
//        System.out.println(s1 == s6);//false,s6创建了两个对象

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //先计算出每行存在1的个数，并加入到优先队列中。
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<Map.Entry<Integer,Integer>>(k + 1, new Comparator<Map.Entry<Integer, Integer>>() {
            //注意k小于原数组的情况，在插入时需要进行判断且容易出错。
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                //Map.Entry<Integer1, Integer2>,Integer1:所在行数，Integer2:行中1的个数;按照行中有1的从小到大排序如果有相等的按照行数从小到大排序；也就是大的要先出。
                return -(o1.getValue() == o2.getValue() ? o1.getKey().compareTo(o2.getKey()) : o1.getValue().compareTo(o2.getValue()));
                // compare方法，o1和o2比较，如果返回正整数说明o1大于o2；如果返回0，表示相等；返回负整数，表示o1小于o2
                //在优先队列中，o1和o2比较，如果返回正整数说明o1的权值大于o2；如果返回0，表示权值相等；返回负整数，表示o1的权值小于o2
                //注意优先队列是按照你排序的方法，大的排在前面，小的排在后买面；一般情况下就按照你的方法进行排序后并取出，再进行反转就能得到预想的数据。
                //注意优先队列先出栈的是权值最小的数据,保存的都是权值大的数据
            }
        });

        for (int i = 0; i < mat.length; i++) {
            int i1 = search(mat[i]);
            map.put(i,i1);
        }

        for (Map.Entry<Integer,Integer> m : map.entrySet()){
            priorityQueue.offer(m);
            if(priorityQueue.size() > k){
                priorityQueue.poll();//
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        while (priorityQueue.peek() != null){
            list.add(priorityQueue.poll().getKey());
        }

        Collections.reverse(list);

        int[] finint = new int[k];

        for (int i = 0; i < k; i++) {
            finint[i] = list.get(i);
        }

        return finint;
    }

    //自己写的查找方法
    public int search(int test1[]){
        //一般四个判断，左边界，右边界，中间值，特殊值。
        int location = 0;
        for (int i = 0; i < test1.length; i++) {
            //左边界判断
            if(i == 0){
                if(test1[i] == 0){
                    break;
                }
            }
            //右边界判断
            if (test1[i] == 1 && i == test1.length - 1){
                location = test1.length;
            }
            //中间值判断
            if(test1[i] == 0){
                location = i;
                break;
            }
        }
        return location;
    }

    //官网写法
//    int m = mat.length, n = mat[0].length;
//    List<int[]> power = new ArrayList<int[]>();
//        for (int i = 0; i < m; ++i) {
//        int l = 0, r = n - 1, pos = -1;
//        while (l <= r) {
//            int mid = (l + r) / 2;
//            if (mat[i][mid] == 0) {
//                r = mid - 1;
//            } else {
//                pos = mid;
//                l = mid + 1;
//            }
//        }
//        power.add(new int[]{pos + 1, i});


//    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {//这里创建的时候没有指定大小，会自动扩容。因为指定大小后很容易出错，所以一般不指定大小。
//        public int compare(int[] pair1, int[] pair2) {
//            if (pair1[0] != pair2[0]) {
//                return pair1[0] - pair2[0];
//            } else {
//                return pair1[1] - pair2[1];
//            }
//        }
//    });
//        for (int[] pair : power) {
//        pq.offer(pair);
//    }
//    int[] ans = new int[k];
//        for (int i = 0; i < k; ++i) {
//        ans[i] = pq.poll()[1];//先出栈的是权值较小的值，且查看compare方法，我们就是需要权值较小的先出栈。如果指定大小，那么较小的在插入时可能会先出栈。留下的是权值较大的
//    }
//        return ans;

}


//leetcode submit region end(Prohibit modification and deletion)

}
