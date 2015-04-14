package my.superpackage;

import java.awt.Event;

import org.sikuli.basics.HotkeyEvent;
import org.sikuli.basics.HotkeyListener;
import org.sikuli.basics.HotkeyManager;
import org.sikuli.basics.WindowsHotkeyManager;
import org.sikuli.script.Key;

import com.melloware.jintellitype.JIntellitype;

public class SikuliWindows {

	public static void main(String[] args) throws LoadLibException {
		//JIntellitype.setLibraryLocation("c:\\Programming\\Examples-java\\workspace\\keyboard-windows\\lib\\JIntellitype.dll");
		LibLoader.extractLib();
		Key.dump();

		HotkeyManager hkm = WindowsHotkeyManager.getInstance();

		hkm.addHotkey('v', Event.ALT_MASK, new HotkeyListener() {
			
			@Override
			public void hotkeyPressed(HotkeyEvent e) {
				System.out.println("Pressed " + e.keyCode + " " + e.modifiers);
			}
		});
	}

}
