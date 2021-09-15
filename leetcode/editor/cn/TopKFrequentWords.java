package editor.cn;

//给一非空的单词列表，返回前 k 个出现次数最多的单词。 
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。 
//
// 示例 1： 
//
// 
//输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 
//
// 示例 2： 
//
//
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k
// = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。 
// 输入的单词均由小写字母组成。 
// 
//
// 
//
// 扩展练习： 
//
// 
// 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
// 
// Related Topics 堆 字典树 哈希表 
// 👍 289 👎 0

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 已解决
 */

public class TopKFrequentWords {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentWords().new Solution();
        String[] s = {"i", "love", "leetcode", "i", "love", "coding", "saa", "saa", "sq", "se","i","i","love","leetcode","leetcode"};
        System.out.println(solution.topKFrequent(s, 4).toString());
//        Integer i1 = new Integer(3);
//        Integer i2 = new Integer(4);
//        System.out.println(i1.compareTo(i2));
//        HashMap<String,Integer> treeMap = new HashMap<>();
//
//        treeMap.put("k",5);
//        treeMap.put("a",2);
//        treeMap.put("z",1);
//        treeMap.put("bz",6);
////        treeMap.put("zc",9);
//
//        System.out.println(treeMap.getOrDefault("zc", 1));

    }

//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<String> topKFrequent(String[] words, int k) {

            HashMap<String, Integer> hashMap = new HashMap<>();
            for (String str : words) {
                hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
            }

            //下面有两种做法，一种直接对hashmap中的值进行排序；一种运用优先队列进行筛选。
            //方法一：直接排序
//        List<String> tem = new ArrayList<>();
//        for(Map.Entry<String,Integer> entry : hashMap.entrySet()){
//            tem.add(entry.getKey());
//        }
//
//        tem.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return (hashMap.get(o1) == hashMap.get(o2)) ? o1.compareTo(o2) : - hashMap.get(o1).compareTo(hashMap.get(o2));
//            }
//        });
//
//        return tem.subList(0,k);

//            //方法二：用优先队列
            PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(k + 1, new Comparator<Map.Entry<String, Integer>>() {
            //Map.Entry<String, Integer>,String:字符串，Integer:出现的次数;返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return (o1.getValue() == o2.getValue()) ? -o1.getKey().compareTo(o2.getKey()) : o1.getValue().compareTo(o2.getValue());
//                     compare方法，o1和o2比较，如果返回正整数说明o1大于o2；如果返回0，表示相等；返回负整数，表示o1小于o2
                }
            });

            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                //正确写法，先添加再删除，这种的大小最多为k+1,如果不想进行扩容，那么大小应该设置为k+1
                queue.offer(entry);
                if (queue.size() > k) {//如果大小超过k,移除最顶上的最小的元素。
                    queue.poll();
                }
                //注意这种写法为什么不行？
                // 当添加的元素为最小的元素时，先删除了第二小的元素，添加了最小的元素。而应该删除的是最小的元素
//            if (k == queue.size()){
//                queue.poll();
//            }
//            queue.offer(entry);
            }
            //！！！注意优先队列不能使用迭代器取出数据，可能会不符合预期结果，必须使用poll()方法取出全部元素
            List<String> list = new ArrayList<>();
            /*for (Map.Entry<String, Integer> entry : queue) {
                list.add(entry.getKey());
            }*/
            while(queue.peek() != null){//判断头部是否还存在元素
                list.add(queue.poll().getKey());
            }
            //Collections工具类
//            这里进行的反转说明优先队列是按照最大的在上面的形式，如果排序时加负号能省略反转吗？
//            //注意这里是不行的，因为优先队列poll时是将权值最小的的元素进行出栈！注意理解这句话
//            Collections.reverse(list);
            return list;


            //自己写的方法,可以有改进，但最好的是上面的方法
//            TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
//
////        HashMap<String,Integer> map = new HashMap<String,Integer>(words.length);
//            for (String str : words) {
//                Integer integer = treeMap.get(str);
//                if (integer != null) {
//                    treeMap.put(str, integer + 1);
//                } else {
//                    treeMap.put(str, 1);
//                }
//            }
//
//            Set<Map.Entry<String, Integer>> entries = treeMap.entrySet();
//            Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
//            TreeMap<Integer, String> treeMap1 = new TreeMap<>(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return -o1.compareTo(o2);
//                }
//            });
//            while (iterator.hasNext()) {
//                Map.Entry<String, Integer> next = iterator.next();
//                String s = treeMap1.get(next.getValue());
//                if (s != null) {
//                    treeMap1.put(next.getValue(), s + "," + next.getKey());
//                } else {
//                    treeMap1.put(next.getValue(), next.getKey());
//                }
//            }
//
//            List<String> list = new ArrayList<>(k);
//
//            Set<Map.Entry<Integer, String>> entries1 = treeMap1.entrySet();
//            Iterator<Map.Entry<Integer, String>> iterator1 = entries1.iterator();
//            while (k > 0) {
//                Map.Entry<Integer, String> next = iterator1.next();
//                String[] split = next.getValue().split(",");
//                for (String str : split) {
//                    if (k <= 0) break;
//                    list.add(str);
//                    k--;
//                }
//            }
//
//            return null;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}