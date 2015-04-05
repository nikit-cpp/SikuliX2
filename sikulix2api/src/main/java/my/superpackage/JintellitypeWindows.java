package my.superpackage;
import java.io.File;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;


public class JintellitypeWindows {

	public static void main(String[] args) {
		//System.load(new File("lib\\JIntellitype.dll").getAbsolutePath());
		//System.load("c:\\Programming\\Examples-java\\workspace\\keyboard-windows\\lib\\JIntellitype.dll");
		JIntellitype.setLibraryLocation("lib\\JIntellitype.dll"); 

		// Assign global hotkeys to Windows+A and ALT+SHIFT+B
		JIntellitype.getInstance().registerHotKey(1, JIntellitype.MOD_WIN, (int)'A');
		JIntellitype.getInstance().registerHotKey(2, JIntellitype.MOD_ALT + JIntellitype.MOD_SHIFT, (int)'B');
		
		//assign this class to be a HotKeyListener
		JIntellitype.getInstance().addHotKeyListener(new SuperListener());

	}
	

}

class SuperListener implements HotkeyListener{

	public void onHotKey(int aIdentifier) {
	    if (aIdentifier == 1)
	        System.out.println("WINDOWS+A hotkey pressed");
	
		if (aIdentifier == 2)
	        System.out.println("ALT+SHIFT+B hotkey pressed");
	    }
	}
	