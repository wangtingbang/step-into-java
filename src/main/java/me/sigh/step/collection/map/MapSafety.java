package me.sigh.step.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangtingbang on 2017/2/28.
 */
public class MapSafety {

  static Map<Object, Object> map = new HashMap<>();

  public class ThreadClass implements Runnable{

    @Override
    public void run(){
      for(int idx=0; idx< 100; idx++) {
        map.put("123", "String123-"+idx);
        map.put(123, 123*100+idx);
        System.out.println(map);
      }
    }
  }

  public static void main(String[] argv){
    MapSafety tmp = new MapSafety();
    String a = null;
    a.hashCode();
    for(int idx = 0; idx< 10; idx++) {
      ThreadClass thread = tmp.new ThreadClass();
      thread.run();
    }
  }
}
