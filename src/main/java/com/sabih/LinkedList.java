package com.sabih;

import java.util.NoSuchElementException;

public class LinkedList {

  private class Node {
    int value;
    Node next;

    public Node(int value) {
      this.value = value;
      this.next = null;
    }
  }

  private Node head;
  private Node tail;
  private int size;

  public void addLast(int item) {
    var node = new Node(item);

    if (isEmpty()) {
      head = tail = node;
      size++;
      return;
    }

    tail.next = node;
    tail = node;
    size++;
  }

  public void addFirst(int item) {
    var node = new Node(item);
    if (isEmpty()) {
      head = tail = node;
      size++;
      return;
    }

    node.next = head;
    head = node;
    size++;
  }

  public int indexOf(int item) {
    var index = 0;
    var current = head;
    while (current != null) {
      if (current.value == item) {
        return index;
      }

      index++;
      current = current.next;
    }

    return -1;
  }

  public boolean contains(int item) {
    return indexOf(item) != -1;
  }

  public void removeFirst() {
    var second = head.next;

    if (isEmpty()) throw new NoSuchElementException();

    if (head == tail) {
      head = tail = null;
      size--;
      return;
    }

    head.next = second.next;
    head = second;
    size--;
  }

  public void removeLast() {
    if (isEmpty()) throw new NoSuchElementException();

    if (head == tail) {
      head = tail = null;
      size--;
      return;
    }

    var previous = getPreviousNode(tail);
    tail = previous;
    tail.next = null;
    size--;
  }

  public int getSize() {
    return size;
  }

  public void reverse() {
    if (isEmpty()) return;
    var previous = head;
    var current = head.next;
    while (current != null) {
      var next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    tail = head;
    tail.next = null;
    head = previous;
  }

  public int getKthFromTheEnd(int k) {
    var a = head;
    var b = head;

    for (int i = 0; i < k - 1; i++) {
      b = b.next;
    }

    while (b != tail) {
      a = a.next;
      b = b.next;
    }

    return a.value;
  }

  public int[] toArray() {
    var current = head;
    int[] array = new int[size];

    int i = 0;

    while (current != null) {
      array[i++] = current.value;
      current = current.next;
    }

    return array;
  }

  public void print() {
    Node current = head;

    if (isEmpty()) {
      System.out.println("List is empty");
      return;
    }

    while (current != null) {
      System.out.println(current.value);
      current = current.next;
    }
  }

  private boolean isEmpty() {
    return head == null;
  }

  private Node getPreviousNode(Node node) {

    var current = head;
    while (current.next != null) {
      if (current.next == node) return current;

      current = current.next;
    }

    return null;
  }
}
