package leetcode.editor.cn;
    /*给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。*/


//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。 
//
// 
//
// 例如， 
//
// 
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// 
//
// 示例 1: 
//
// 
//输入: columnTitle = "A"
//输出: 1
// 
//
// 示例 2: 
//
// 
//输入: columnTitle = "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 
//输入: columnTitle = "ZY"
//输出: 701 
//
// 示例 4: 
//
// 
//输入: columnTitle = "FXSHRXW"
//输出: 2147483647
// 
//
// 
//
// 提示： 
//
// 
// 1 <= columnTitle.length <= 7 
// columnTitle 仅由大写英文组成 
// columnTitle 在范围 ["A", "FXSHRXW"] 内 
// 
// Related Topics 数学 字符串 
// 👍 265 👎 0

/**
 * 已解决
 */
public class ExcelSheetColumnNumber{
    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnNumber().new Solution();
//        System.out.println(solution.titleToNumber("ZYHHH"));
//        System.out.println(Math.pow(11.635,2.760));
        System.out.println(7&8);
    }
    //总结的点
    // 1.记录进制的转换
    // 2.^符号的作用，不是指数，是亦或，指数运算的方法Math.pow()
    // 3.Acsii码，A的起始值65，a起始值97

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int titleToNumber(String columnTitle) {//-64
        char[] chars = columnTitle.toCharArray();
        int charsLength = chars.length;
        int finalValue = 0;
        for (int i = 0; i < charsLength; i++) {//zxc
            int test = chars[i];
            test = test - 64;
            test = (int) (test * Math.pow(26,(charsLength - 1 - i)));
            finalValue = finalValue + test;
        }
        return finalValue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
