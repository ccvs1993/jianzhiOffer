package whiteBook.algorithm.chap2.string;

/**
 * Created by wangfei on 2017/6/25.
 * 给定输入是"I have 36 books, 40 pens2."；要求输出"I evah 36 skoob, 40 2snep." （假设标点符号只能是点号或逗号）。
 */
public class No6 {
    public static String reverseString(String str){
        String[] strArray=str.split(" ");
        StringBuilder sb=new StringBuilder(200);
        for (String s : strArray) {
            String re=reverseWord(s);
            sb.append(re).append(" ");
        }
        return sb.toString();
    }
    public static String reverseWord(String str){
        if(isWord(str)){
            if(isSymbol(str.charAt(str.length()-1))){
                str=str.substring(0,str.length()-1);
            }
            StringBuilder sb=new StringBuilder(str);
            str=sb.reverse().toString();
            return str;
        }
        return str;
    }
    public static boolean isWord(String str){
        if(isSymbol(str.charAt(str.length()-1))){
            str=str.substring(0,str.length()-1);
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
           if( !Character.isAlphabetic(c)){
               return false;
           }
           if(!Character.isDigit(i)){
               return true;
           }
        }
        return true;
    }

    public static boolean isSymbol(Character c){
        if(c.equals(' ') || c.equals(',') || c.equals('.')){
            return true;
        }else
            return false;
    }

    public static void main(String[] args) {
        String str="I have 36 books, 40 pens2.";
        System.out.println(reverseString(str));
        //System.out.println(isSymbol());
    }

}
