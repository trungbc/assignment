package com.assignment;

import java.util.Scanner;

public class StairCase {

  static void staircase(int n) {

    for (int i = 1; i <= n; i++) {
      for (int j = n - i; j > 0; j--) {
        System.out.print(" ");
      }
      for (int k = i; k > 0; k--) {
        System.out.print("#");
      }
      System.out.print("\n");
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    staircase(n);
    in.close();
  }

}
