package filelocktest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.channels.FileLock;

import utils.FileTools;

/**
 * @Description 使用文件锁，依然会有多线程同时操作同一个文件的问题，故此测试<br>
 *              测试结果：一旦一个线程获取文件锁，则其他线程无法再操作此文件<br>
 *              测试结论：文件锁没有问题，是其他地方的问题
 * 
 * @author lin
 * @date 2017年2月23日 下午2:37:04
 */
public class FileLockTest {
	public static String testFile = "/Users/lin/testfile.txt";

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		lockFile(testFile);
	}

	public static void lockFile(String path) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		FileLock filelock = null;
		if (!new File(path).exists()) {
			FileTools.createFile(path);
		}
		filelock = FileTools.getFileLock(new File(path));
		System.out.println("main get Lock");
		SleepThread sleep = new SleepThread();
		sleep.getClass().getMethod("sleep", new Class[] { String.class }).invoke(sleep, path);
		filelock.release();
		System.out.println("main release Lock");
	}
}
