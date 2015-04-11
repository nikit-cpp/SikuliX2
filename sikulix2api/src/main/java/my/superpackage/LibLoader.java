package my.superpackage;

import java.io.File;
import java.net.URL;

import org.apache.commons.lang3.SystemUtils;
import org.sikuli.basics.FileManager;
import org.sikuli.basics.Settings;

public class LibLoader {
	public static void main(String... args) {
		String tempFolder = System.getProperty("java.io.tmpdir");
		System.out.println(tempFolder);
		File target = new File(tempFolder, "libJXGrabKey-64.so");
		System.out.println("will extract to: " + target);
		
		String resource = "lib/linux/libJXGrabKey-64.so";
		
		URL res = LibLoader.class.getClassLoader().getResource(resource);
		
		System.out.println("URL is " + res);
		
		boolean extracted = FileManager.extractResource(resource, target);
		System.out.println("Resource extracted? " + extracted);
		
		System.out.println("is lisux " + Settings.isLinux());
		System.out.println("is windows " + Settings.isWindows());
		
		System.out.println(SystemUtils.OS_ARCH);
	}
}
