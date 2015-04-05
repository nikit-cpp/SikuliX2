package org.sikuli.basics;

public class LibLoader {

	public static void main(String[] args) {
		System.out.println(System.getProperty("java.library.path"));
		Runtime.getRuntime().loadLibrary("JXGrabKey");
	}

}
