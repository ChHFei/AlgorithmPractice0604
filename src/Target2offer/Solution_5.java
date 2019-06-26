package Target2offer;

//题目5
//        题目描述
//        请实现一个函数，将一个字符串中的每个空格替换成“%20”。
//        例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

//  思路1 O（n^2） 从头到尾遍历替换，不足以拿offer
//  思路2 O（n）    先遍历1次，提前计算好替换后的长度，p1在原始字符串尾，p2指向替换后的字符串的末尾。从后向前复制，遇到空格p2加上%20



public class Solution_5 {
    public String replaceSpace(StringBuffer str) {
        int p1 = str.length()-1;
        for (int i=0;i<=p1;i++){
            if (str.charAt(i) == ' ')
                str.append("  ");
        }
        int p2 = str.length()-1;
        while (p1>=0 && p2>p1){
            char c = str.charAt(p1--);
            if (c == ' '){
                str.setCharAt(p2--,'0');
                str.setCharAt(p2--,'2');
                str.setCharAt(p2--,'%');
            }else {
                str.setCharAt(p2--,c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer test = new StringBuffer("We Are Happy");
        StringBuffer test2 = new StringBuffer(" helloworld");
        Solution_5 solution_5 = new Solution_5();
        solution_5.replaceSpace(test2);
        System.out.println(test2);
    }

}
