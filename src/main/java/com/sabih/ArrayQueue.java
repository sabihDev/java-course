package com.sabih;

import java.util.Arrays;

public class ArrayQueue {

  private int[] items = new int[5];
  private int rear;
  private int count;
  private int front;

  public ArrayQueue(int capacity) {
    items = new int[capacity];
  }

  public void enque(int newItem) {
    if (count == items.length) {
      throw new IllegalStateException();
    }
    items[rear] = newItem;
    rear = (rear + 1) % items.length;
    count++;
  }

  public int deque() {
    var item = items[front];
    items[front] = 0;
    front = (front + 1) % items.length;
    count--;
    return item;
  }

  @Override
  public String toString() {
    return Arrays.toString(items);
  }
}
