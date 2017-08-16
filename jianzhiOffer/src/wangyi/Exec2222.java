package wangyi;

import java.util.*;

public class Exec2222 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count=sc.nextInt();
        int[] x=new int[count];
        int[] y=new int[count];
        List<Integer> xlist=new ArrayList<>();
        List<Integer> ylist=new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int temp=sc.nextInt();
            xlist.add(temp);
            x[i]=temp;
        }
        for (int i = 0; i < count; i++) {
            int temp=sc.nextInt();
            ylist.add(temp);
            y[i]=temp;
        }
        Collections.sort(xlist);
        Collections.sort(ylist);

        int maxX=xlist.get(count-1);
        int maxY=ylist.get(count-1);
        int minX=xlist.get(0);
        int minY=xlist.get(0);
        int minStep=Integer.MAX_VALUE;
        int temp=0;
        int rex=1;
        for (int i = 0; i < count; i++) {
            for(int j=0;j<count;j++){
                if(j==i){
                    rex=-1;
                }else {
                    rex=1;
                }
                temp+=(x[j]*rex+y[j]*rex);
            }
            System.out.println(temp);
            if(Math.abs(temp)<minStep){
                minStep=temp;
            }
        }

        System.out.println(minStep);
    }
}
