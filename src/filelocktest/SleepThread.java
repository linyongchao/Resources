package filelocktest;

import utils.FileTools;

public class SleepThread {
	public void sleep(String path) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		FileTools.appendWrite(path, "a\tb\tc\td\te\n");
		System.out.println("thread append over");
	}
}
