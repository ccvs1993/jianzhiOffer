package com.chap5;

import java.util.*;

/**
 * 找出字符串中第一个只出现一次的字符
 * 如输入abaccdeff,输出b
 */
public class No35 {

    public int FirstNotRepeatingChar(String str) {
        char[] ch = str.toCharArray();
        Map<Character,Node> map=new LinkedHashMap<>();
        List<Node> ls=new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            int val=0;
            if(map.containsKey(ch[i])){
                val=map.get(ch[i]).val;
            }
            map.put(ch[i],new Node(val==0?1:val+1,i));
        }
        Set<Map.Entry<Character, Node>> entries = map.entrySet();
        for (Map.Entry<Character, Node> entry : entries) {
            if(entry.getValue().val==1){
                ls.add(entry.getValue());
            }
        }
        Collections.sort(ls, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.index.compareTo(o2.index);
            }
        });
        return ls.get(0).index;
    }

    public int FirstNotRepeatingChar2(String str) {
        char[] ch = str.toCharArray();
        Map<Character,Integer> map=new LinkedHashMap<>();
        for (int i = 0; i < ch.length; i++) {
            int val=0;
            if(map.containsKey(ch[i])){
                val=map.get(ch[i]);
            }
            map.put(ch[i],val==0?1:val+1);
        }
        for(int i=0;i<ch.length;i++){
            if(map.get(ch[i])==1){
                return i;
            }
        }
        return 0;
    }
    class Node{
        Integer val=0;
        Integer index=0;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        String s="abbaccdeffz";
        System.out.println(new No35().FirstNotRepeatingChar2(s));
    }
}
