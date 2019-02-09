package Tutoral;

import java.io.IOException;

class TryThread extends Thread {
  public TryThread(String firstName, String secondName, long delay) {
    this.firstName = firstName;
    this.secondName = secondName;
    aWhile = delay;
    setDaemon(true);
  }
  public void run() {
    try {
      while (true) {
        System.out.print(firstName);
        sleep(aWhile);
        System.out.print(secondName + "\n");
      }
    } catch (InterruptedException e) {
      System.out.println(firstName + secondName + e);
    }
  }
  private String firstName;
  private String secondName;
  private long aWhile;
}
public class CreateThread {
  public static void main(String[] args) {
    Thread first = new TryThread("A ", "a  ", 200L);
    Thread second = new TryThread("B ", "b ", 300L);
    Thread third = new TryThread("C ", "c ", 500L);
    Thread four = new TryThread("D ", "d ", 700L);
    System.out.println("Press Enter when you have had enough...\n");
    first.start();
    second.start();
    third.start();
    four.start();
    try {
      System.in.read();
      System.out.println("Enter pressed...\n");
    } catch (IOException e) {
      System.out.println(e);
    }
    return;
  }
}
