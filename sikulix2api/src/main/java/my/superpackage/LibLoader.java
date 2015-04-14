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
		
		File target = null;
		String resource = null;
		
		if(SystemUtils.IS_OS_WINDOWS){
			if(SystemUtils.OS_ARCH.equals("amd64")){
				// load windows 64 JIntellitype
			}else if(SystemUtils.OS_ARCH.equals("x86")){
				// load windows 32 JIntellitype
			}
		} else if(SystemUtils.IS_OS_LINUX){
			if(SystemUtils.OS_ARCH.equals("amd64")){
				// load linux 64 JIntellitype
				target = new File(tempFolder, "libJXGrabKey-64.so");
				resource = "lib/linux/libJXGrabKey-64.so";
			}else if(SystemUtils.OS_ARCH.equals("x86")){
				// load linux 32 JIntellitype
			}
		}
		
		System.out.println("will extract to: " + target);
		
		
		URL res = LibLoader.class.getClassLoader().getResource(resource);
		
		System.out.println("URL is " + res);
		
		boolean extracted = FileManager.extractResource(resource, target);
		System.out.println("Resource extracted? " + extracted);
		
	}
}
