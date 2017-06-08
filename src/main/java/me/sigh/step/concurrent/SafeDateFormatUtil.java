package me.sigh.step.concurrent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangtingbang on 2017/2/24.
 */
public class SafeDateFormatUtil implements Runnable{

//  class SafeWithThreadLocal implements Runnable {

    String str;
    Date dt;

//    public SafeWithThreadLocal(String str){
//      this.str = str;
//    }
  public SafeDateFormatUtil(String str){
    this.str = str;
  }

    ThreadLocal<DateFormat> dateFormatThreadLocal = new ThreadLocal<>();

    public void run(){

      DateFormat df = dateFormatThreadLocal.get();
      if(df==null){
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormatThreadLocal.set(df);
      }

      try {
        Date dt = df.parse(str);
//        System.out.println(Thread.currentThread().getId()+"++++"+dt.toString());
      }catch (Exception e){
        e.printStackTrace();
      }
    }
//  }


  public static void main(String[] argv){

    for(int idx=0;idx<1000000; idx++){
      StringBuffer sb = new StringBuffer("2017-01-");
      sb.append(idx%31+1);
      sb.append(" 00:00:00");
//      Thread t = new SafeWithThreadLocal(sb.toString());
      new SafeDateFormatUtil(sb.toString()).run();
    }

  }
}
