package me.sigh.step.basic;

import java.util.ArrayList;
import java.util.List;

public class MethodCallTestDemo {

  public static void main(String[] args) {
    String str = "a";
    int i =-1;
    int[] iArr = new int[]{-1,-2,-3};
    String[] sArr = new String[]{"a", "b", "c"};
    List<String> list = new ArrayList();
    list.add("astring");
    list.add("bstring");
    
    change(str, i, iArr, sArr, list);
    System.out.printf("%s, %d, %d, %s, %s\n", str, i , iArr[0], sArr[0], list.get(0));
  }
  
  //方法调用后入参的值不会被改变，但入参的引用会被修改
  public static void change(String str, int i, int[] iArr, String[] sArr, List<String> list){
    str = str==null?"null":str.concat("change");
    i +=1;
    for(int idx=0; idx<iArr.length;idx++){
      iArr[idx]+=10;
    }
    for(int idx=0; idx<sArr.length;idx++){
      sArr[idx] = sArr[idx]==null?"null":sArr[idx].concat("change");
    }
    for(int idx=0;idx<list.size();idx++){
      list.set(idx, list.get(idx)==null?"null":list.get(idx).concat("change"));
    }
  }
}
