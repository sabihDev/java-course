package com.sabih;

import java.util.Stack;

public class QueueWithTwoStacks {

  private Stack<Integer> s1 = new Stack<>();
  private Stack<Integer> s2 = new Stack<>();

  public void enque(int item) {
    s1.push(item);
  }

  public int deque() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }

    moveS1toS2();

    return s2.pop();
  }

  public int peek() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }

    moveS1toS2();

    return s2.peek();
  }

  private void moveS1toS2() {

    if (s2.isEmpty()) {
      while (!s1.isEmpty()) {
        s2.push(s1.pop());
      }
    }
  }

  public boolean isEmpty() {
    return s1.isEmpty() && s2.isEmpty();
  }
}
