package my.superpackage;

@Deprecated
public class LinuxLibLoader {

	public static void main(String[] args) {
		System.out.println(System.getProperty("java.library.path"));
		Runtime.getRuntime().loadLibrary("JXGrabKey");
	}

}
