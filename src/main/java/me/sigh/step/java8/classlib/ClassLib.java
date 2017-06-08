package me.sigh.step.java8.classlib;


import java.util.Optional;

/**
 * Created by wangtingbang on 2017/2/16.
 */
public class ClassLib {

  public void aboutOptional() {

    Optional<String> fullName = Optional.ofNullable(null);
    System.out.println("Full Name is set? " + fullName.isPresent());
    System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
    System.out.println(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));


    Optional<String> firstName = Optional.of("Tom");
    System.out.println("First Name is set? " + firstName.isPresent());
    System.out.println("First Name: " + firstName.orElseGet(() -> "[none]"));
    System.out.println(firstName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
    System.out.println();

  }

  public static void main(String argv[]) {
    ClassLib lib = new ClassLib();
    lib.aboutOptional();
  }


}
