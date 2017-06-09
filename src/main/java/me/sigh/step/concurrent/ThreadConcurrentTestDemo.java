package me.sigh.step.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadConcurrentTestDemo {

  private static int c = 0;

  public static void main(String[] args) {
    int count = 3;
    CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
    ExecutorService executorService = Executors.newFixedThreadPool(count);
    for (int i = 0; i < count; i++) {
      executorService.execute(new ThreadConcurrentTestDemo().new Task(cyclicBarrier, i));
    }

    executorService.shutdown();
    while (!executorService.isTerminated()) {
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.printf("c:%d\n", c);
  }

  public class Task implements Runnable {
    private int flag = 0;
    private int idx;
    private CyclicBarrier cyclicBarrier;

    public Task(CyclicBarrier cyclicBarrier, int idx) {
      this.cyclicBarrier = cyclicBarrier;
      this.idx = idx;
    }

    // @Override
    public void run() {
      try {
        // 等待所有任务准备就绪
        cyclicBarrier.await();

        // 测试内容
        for (int i = 0; i < 1000; i++) {
          if (idx == 1) {
            c--;
            flag--;
          } else {
            c++;
            flag++;
          }
        }
        System.out.printf("idx:\t%d, flag:\t%d, c:\t%d\n", idx, flag, c);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
