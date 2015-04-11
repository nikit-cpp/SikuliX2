package my.superpackage;

import java.awt.Event;
import java.io.File;
import java.io.IOException;

import jxgrabkey.JXGrabKey;

import org.sikuli.basics.HotkeyEvent;
import org.sikuli.basics.HotkeyListener;
import org.sikuli.basics.HotkeyManager;
import org.sikuli.basics.LinuxHotkeyManager;
import org.sikuli.basics.WindowsHotkeyManager;
import org.sikuli.script.Key;
import org.sikuli.script.RunTime;

import com.melloware.jintellitype.JIntellitype;

public class SikuliLinux {

	public static void main(String[] args) throws IOException {
		RunTime.get();
		System.load("/home/nik/workspace/SikuliX2_my/lib/linux/libJXGrabKey-64.so");
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
