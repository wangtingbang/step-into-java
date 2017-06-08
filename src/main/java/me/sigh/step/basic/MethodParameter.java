package me.sigh.step.basic;

/**
 * Created by wangtingbang on 2017/2/16.
 */
public class MethodParameter {

  public static void main(String[] argv){

    Integer a = 10;
    Integer b = 20;
    method(a,b);

    System.out.println("a="+a);
    System.out.println("b="+b);

  }

  public static void method(Integer a, Integer b){
    a = new Integer(a*10);
    b = b*10;
  }
}
