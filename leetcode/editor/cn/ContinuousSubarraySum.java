package editor.cn;

//给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组： 
//
// 
// 子数组大小 至少为 2 ，且 
// 子数组元素总和为 k 的倍数。 
// 
//
// 如果存在，返回 true ；否则，返回 false 。 
//
// 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [23,2,4,6,7], k = 6
//输出：true
//解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。 
//
// 示例 2： 
//
// 
//输入：nums = [23,2,6,4,7], k = 6
//输出：true
//解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。 
//42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
// 
//
// 示例 3： 
//
// 
//输入：nums = [23,2,6,4,7], k = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 0 <= nums[i] <= 109 
// 0 <= sum(nums[i]) <= 231 - 1 
// 1 <= k <= 231 - 1 
// 
// Related Topics 数学 动态规划 
// 👍 270 👎 0

import java.io.*;

public class ContinuousSubarraySum{
    public static void main(String[] args) {
        Solution solution = new ContinuousSubarraySum().new Solution();
        String str = "sakudhwqdadqw.txt";
        str = str.substring(0,str.lastIndexOf("."));
        System.out.println(str);
//        solution.test1("private String type;");
//        try {
//            solution.manageFile("D:\\copytest\\test1","D:\\copytest\\test2");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            solution.manageFile1("D:\\copytest\\test1\\AllotOrder.txt","D:\\copytest\\test2");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        File file = new File("D:\\copytest\\test3\\ShareRelationshipLog.txt");
//        solution.rename("D:\\copytest\\test3\\ShareRelationshipLog.txt");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        return false;
    }

    public void rename(String path){
        File file1 = new File(path);
        File file2 = new File(file1.getParent() + "\\" + "hello.txt");
        file1.renameTo(file2);
    }

    public void test1(String s){
//        System.out.println(s.substring(s.lastIndexOf("(")));
//        System.out.println(s.substring(s.lastIndexOf("(")).replace("(\"", "").replace("\")", ""));

        if(s.contains("@ApiModelProperty")){
            String substring = s.substring(s.lastIndexOf("value"));
            System.out.println(substring);
            substring = substring.replace("value = \"","").replace("\")","");
            System.out.println(substring);
        }

        if(s.contains("private")){
            System.out.println(s.substring(s.lastIndexOf(" ")).replace(";", ""));
        }
    }

    public void manageFile(String oldPath, String newPath) throws IOException {

        File file = new File(newPath);
        String filePath = new String(newPath + file.getName());

        String filename = "";

        String memo = "";
        String column = "";

        File oldFile = new File(oldPath);

        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(oldFile));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                if(s.contains("@TableName")){
                    String substring = s.substring(s.lastIndexOf("("));
                    substring = substring.replace("(\"","").replace("\")", "");
                    filename = substring;
                }
                if(s.contains("@ApiModelProperty")){
                    String substring = s.substring(s.lastIndexOf("value"));
                    substring = substring.replace("value = \"","").replace("\")","");
                    memo = substring;
                }
                if(s.contains("private")){
                    column = s.substring(s.lastIndexOf(" ")).replace(";", "");

                    //将键值对写入文件内
                    String finalValue = new String(column + "=" + memo);
                    saveAsFileWriter(finalValue,filePath);
                }

                System.out.println(br.readLine());
//                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        filename = filename + "txt";


        file.renameTo(new File(file.getParent() + "\\" + filename));


//        return result.toString();






//        File file = new File(newPath);
//        FileInputStream in = new FileInputStream(oldFile);
//        FileOutputStream out = new FileOutputStream(file);
//        ;
//
//        byte[] buffer = new byte[2097152];
//        int readByte = 0;
//        while ((readByte = in.read(buffer)) != -1) {
//            out.write(buffer, 0, readByte);
//        }
//
//        in.close();
//        out.close();
//
//        System.out.println(file.getName());
//        String name = file.getName();
//
////        if (name.endsWith("." + oldExt)) {
//
//        name = name.substring(0, name.lastIndexOf(".") + 1);
//
//        name += "txt";
//
//        file.renameTo(new File(file.getParent() + "\\" + name));

//        }

    }

    /**
     * 将字符串写入到文件
     * @param content
     */
    private void saveAsFileWriter(String content,String filePath) {
        FileWriter fwriter = null;
        try {
            // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
            fwriter = new FileWriter(filePath, true);
            fwriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void manageFile1(String oldPath, String newPath) throws IOException {

        File oldFile = new File(oldPath);
        File newFile = new File(newPath);

        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(oldFile));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                System.out.println(br.readLine());
//                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }





}
//leetcode submit region end(Prohibit modification and deletion)

}
