package com.sabih;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

  private final List<Character> leftBrackets = Arrays.asList('(', '{', '[', '<');
  private final List<Character> rightBrackets = Arrays.asList(')', '}', ']', '>');

  public boolean isBalanced(String input) {
    Stack<Character> stack = new Stack<>();

    for (char ch : input.toCharArray()) {
      if (isLeftExpression(ch)) stack.push(ch);

      if (isRightExpression(ch)) {
        if (stack.empty()) return false;

        var top = stack.pop();
        if (!bracketsMatch(top, ch)) return false;
      }
    }

    return stack.empty();
  }

  private boolean isLeftExpression(char ch) {
    return leftBrackets.contains(ch);
  }

  private boolean isRightExpression(char ch) {
    return rightBrackets.contains(ch);
  }

  private boolean bracketsMatch(char left, char right) {
    return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
  }
}
