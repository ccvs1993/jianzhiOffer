package wangyi;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exec111 {
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Map<Character,Character> map=new HashMap<>();
        map.put('A','2');
        map.put('B','2');
        map.put('C','2');
        map.put('D','3');
        map.put('E','3');
        map.put('F','3');
        map.put('G','4');
        map.put('H','4');
        map.put('I','4');
        map.put('J','5');
        map.put('K','5');
        map.put('L','5');
        map.put('M','6');
        map.put('N','6');
        map.put('O','6');
        map.put('P','7');
        map.put('Q','7');
        map.put('R','7');
        map.put('S','7');
        map.put('T','8');
        map.put('U','8');
        map.put('V','8');
        map.put('W','9');
        map.put('X','9');
        map.put('Y','9');
        map.put('Z','9');
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int m=sc.nextInt();
            String[] temp=new String[m];
            for (int i=0;i<m;i++){
                temp[i]=sc.next().replace('-',' ').trim();
            }
            Set<String> set=new TreeSet<>();
            for (int i=0;i<m;i++){
                char[] ch = temp[i].toCharArray();
                for(int j=0;j<ch.length;j++){
                    if(ch[j]>='A' && ch[j]<='Z'){
                        ch[j]=map.get(ch[j]);
                    }
                }
                temp[i]=new String(ch).replace(' ','-');//new String(ch,0,3)+'-'+new String(ch,4,ch.length-3);
                set.add(temp[i]);
            }
            for (String s : set) {
                System.out.println(s);
            }
        }
    }
}
