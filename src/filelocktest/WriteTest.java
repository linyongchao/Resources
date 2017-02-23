package filelocktest;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileLock;

import utils.FileTools;

public class WriteTest {

	public static void main(String[] args) throws IOException {
		String path = FileLockTest.testFile;
		FileLock filelock = FileTools.getFileLock(new File(path));
		System.out.println("write get Lock");
		FileTools.appendWrite(path, "1\t2\t3\t4\t5\n");
		System.out.println("write append over");
		filelock.release();
	}
}
