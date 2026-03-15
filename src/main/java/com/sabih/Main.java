package com.sabih;

public class Main {
  public static void main(String[] args) {
    PriorityQueue que = new PriorityQueue();
    que.add(5);
    que.add(3);
    que.add(6);
    que.add(1);
    que.add(4);
    System.out.println(que);

    while (!que.isEmpty()) {
      System.out.println(que.remove());
    }
  }
}
