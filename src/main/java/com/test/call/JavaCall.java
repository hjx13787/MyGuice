package com.test.call;

public class JavaCall {
	static {
		System.loadLibrary("calldll");
	}

	public native int Open();

	public native void Close();

	public native Object[] test(int invalue);

	public static void main(String[] args) {
		JavaCall jc = new JavaCall();
		int iResult = jc.Open();
		if (iResult < 0) {
			return;
		}

		for (int iTestCount = 0; iTestCount < 100; iTestCount++) {
			System.out.println("[JAVA OUT] ==============Test " + iTestCount + " Begin ==============");

			Object[] obj1 = jc.test(1);

			for (int i = 0; i < 10; i++) {
				System.out.println("[JAVA OUT] obj1[" + i + "]=" + obj1[i]);
			}

			Object[] obj2 = jc.test(2);
			for (int i = 0; i < 10; i++) {
				System.out.println("[JAVA OUT] obj2[" + i + "]=" + obj2[i]);
			}

			System.out.println("[JAVA OUT] ==============Test " + iTestCount + " End ==============");
		}

		jc.Close();
	}

}
