package org.sikuli.basics;

import java.awt.Event;

import org.sikuli.script.Key;

import com.melloware.jintellitype.JIntellitype;

public class Launcher {

	public static void main(String[] args) {
		JIntellitype.setLibraryLocation("c:\\Programming\\Examples-java\\workspace\\keyboard-windows\\lib\\JIntellitype.dll");
		Key.dump();
		//HotkeyManager hkm = LinuxHotkeyManager.getInstance();
		HotkeyManager hkm = WindowsHotkeyManager.getInstance();
		// JIntellitype.MOD_WIN, (int)'A'
		hkm.addHotkey('v', Event.ALT_MASK, new HotkeyListener() {
			
			@Override
			public void hotkeyPressed(HotkeyEvent e) {
				System.out.println("Pressed " + e.keyCode + " " + e.modifiers);
			}
		});
	}

}
