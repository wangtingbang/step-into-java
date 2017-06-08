package me.sigh.step.extendz;

import java.util.List;

/**
 * Created by wangtingbang on 2017/3/28.
 */
public class InterfaceImpl<T> implements CommonIntf {
  @SuppressWarnings("unchecked") @Override public T getT() {

    T tmp = (T) new Object();

    String a = tmp.getClass().getName();
    System.out.printf("className:" + a);

    return null;
  }

  public static void main(String[] argv){
    InterfaceImpl<String> a = new InterfaceImpl<>();
    a.getT();
  }
}
