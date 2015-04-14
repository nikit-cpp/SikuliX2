package my.superpackage;

import java.awt.Event;

import org.sikuli.basics.HotkeyEvent;
import org.sikuli.basics.HotkeyListener;
import org.sikuli.basics.HotkeyManager;
import org.sikuli.basics.LinuxHotkeyManager;
import org.sikuli.script.Key;

public class SikuliLinux {

	public static void main(String[] args) throws LoadLibException {

		LibLoader.extractLib();
		Key.dump();
		HotkeyManager hkm = LinuxHotkeyManager.getInstance();

		hkm.addHotkey('v', Event.ALT_MASK, new HotkeyListener() {
			
			@Override
			public void hotkeyPressed(HotkeyEvent e) {
				System.out.println("Pressed " + e.keyCode + " " + e.modifiers);
			}
		});
	}

}
