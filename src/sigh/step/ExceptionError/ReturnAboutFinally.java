package sigh.step.ExceptionError;

/**
 * Created by wangtingbang on 15/11/6.
 */
public class ReturnAboutFinally {

  /**
   * @return 1
   */
  public int noVar(){
    try{
      return 0;
    }catch (Exception e){

    }finally {
      return 1;
    }
  }

  /**
   * @return 15
   */
  public int withVar(){
    int result = 0;
    try{
      result += 10;
      return result;
    }catch (Exception e){

    }finally {
      result += 5;
      return result;
    }
  }

  /**
   * @return 10
   */
  public int finallyNoReturn(){
    int result = 0;
    try{
      result += 10;
      return result;
    }catch(Exception e){

    }finally {
      result += 5;
    }
    return -1;
  }

  public static void main(String[] argv){
    ReturnAboutFinally test = new ReturnAboutFinally();
    System.out.println(test.noVar());
    System.out.println(test.withVar());
    System.out.println(test.finallyNoReturn());
  }
}
