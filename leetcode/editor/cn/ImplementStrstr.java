package leetcode.editor.cn;

//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 104 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 913 👎 0

public class ImplementStrstr{
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        String str1 = "aabaaabaaac";
        String str2 = "aabaaac";

        System.out.println(solution.strStr(str1, str2));


    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if("".equals(needle)){
            return 0;
        }

        char[] c1 = haystack.toCharArray();
        char[] c2 = needle.toCharArray();
        int in = 1;

        //计算nextVal的值，是计算前缀和后缀相同的最多字母的个数
        int[] w = new int[c2.length];
        w[0] = 0;
        for(int i = 1,j = 0; i < w.length; i++){
            while(j > 0 && c2[j] != c2[i]){
                j = w[j - 1];
            }
            if(c2[j] == c2[i]){
                j++;
            }
            w[i] = j;
        }

        int[] finaw = new int[w.length];
        finaw[0] = 0;
        for (int i = 1; i < w.length; i++) {
            finaw[i] = w[i-1];//注意这里不加1是在程序中要好计算一点。手算的话加1好计算.(向后移一位，第一位赋值-1，之后所有数加1)
        }

        int index = 0;
        //kmp算法
        for (int i = 0; i < c1.length; i++) {//这里长度不能写成c1.length - c2.length + 1，因为指针需要全部走完c1.
            if(c1[i] != c2[index]){
                if(index == 0){
                    i++;
                }
                index = finaw[index];
                i = i - 1;
            }else if(c1[i] == c2[index] && index == c2.length-1){
                return i-index;
            }else if(c1[i] == c2[index]){
                index++;
            }
        }
        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
