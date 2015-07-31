package com.test.random;

import java.util.Random;

public class Test {
	public static void main(String[] args) {
		int max=20;
        int min=11;
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
			int s = random.nextInt(19)%(19-6+1)+6;
			System.out.println(s);
		}

	}
}
