package leetcode.editor.cn;

//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量0和1的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// nums[i] 不是 0 就是 1 
// 
// Related Topics 哈希表 
// 👍 350 👎 0

import java.util.HashMap;

public class ContiguousArray{
    public static void main(String[] args) {
        Solution solution = new ContiguousArray().new Solution();
        
    }
    //1.hash表+前缀和
    //2.前缀和转换思想0 --> -1
    //3.和图一起理解
    //4.为什么需要先添加map（0，-1）


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {
        //官网写法
        int count = 0;
        int maxLength = 0;
        HashMap<Integer,Integer> map = new HashMap();//第一个Integer装的是count的值也就是从0到n的和，第二个Integer装的是位置（从0开始）
        //注意为什么要添加这个
        map.put(count,-1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1){
                count++;
            }else {
                count--;
            }
            if(map.containsKey(count)){
                maxLength = Math.max(i - map.get(count) , maxLength);
//                map.put(count,i)//注意这里不需要添加，因为添加之后会重设置值，新的i比原来的要大，结果会变小。注意和图一起理解
            }else {
                map.put(count,i);
            }
        }
        return maxLength;


        //自己写的，时间过不了，但是逻辑正确
        /**
        int count = 0;
        int[] ints = new int[nums.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                ints[i] = -1;
            }else {
                ints[i] = nums[i];
            }
            count += ints[i];
            map.put(i,count);
        }

        int finValue = 0;//最长的字符串长度
        int mark = 0;//从第几位开始计算
        while (nums.length - mark > finValue){
            if (mark == 0){
                for (int i = nums.length-1; i > 0; i--) {//每个循环需要判断左边界，右边界，中间值，特殊值
                    if(map.get(i) == 0){
                        finValue = i + 1;
                        break;
                    }
                }
                mark++;
            }else{
                for (int i = nums.length-1; i > mark; i--) {
                    if(i - mark + 1 <= finValue){
                        break;
                    }
                    if(map.get(i) - map.get(mark-1) == 0){
                        finValue = i - mark + 1;
                    }
                }
                mark++;
            }
        }
        return finValue;
         */
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
