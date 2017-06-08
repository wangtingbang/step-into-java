package me.sigh.step.java8.classlib;

import java.util.stream.Stream;

/**
 * Created by wangtingbang on 2017/2/20.
 */
public class StreamInterface {

  public static void processOrder(){

    /**
     * An important characteristic of intermediate operations is laziness. Look at this sample where a terminal operation is missing:
     */
    Stream.of("d2", "a2", "b1", "b3", "c")
    .filter(s -> {
        System.out.println("filter: " + s);
        return true;
    });

    /**
     * When executing this code snippet, nothing is printed to the console. That is because intermediate operations will only be executed when a terminal operation is present.
     */
    Stream.of("d2", "a2", "b1", "b3", "c")
    .filter(s -> {
        System.out.println("filter: " + s);
        return true;
    })
    .forEach(s -> System.out.println("forEach: " + s));
  }

  public static void main(String[] argv){
    processOrder();

    System.out.println(1<<30);
  }
}
