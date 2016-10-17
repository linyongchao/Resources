package celloud.log;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class LogAnalysis {
	/**
	 * 日志路径
	 */
	public static String path = "/Users/lin/Dropbox/log/";

	/**
	 * 日志保留规则
	 */
	public static String[] printResular = { "update", "fixed", "fix", "add", "delete" };
	public static String[] userResular = { "linyongchao" };

	public static void main(String[] args) throws IOException {
		Scanner console = new Scanner(System.in); //实例化参数
		System.out.println("默认路径为：/Users/lin/Dropbox/log/");
		System.out.println("若使用默认路径，请直接输入文件名");
		System.out.println("否则请输入带路径文件名");
		System.out.print("请输入：");
		String input = console.next(); //获取输入内容给 input
		console.close();
		if (!input.contains(String.valueOf(File.separatorChar))) {
			path = path + input;
		} else {
			path = input;
		}
		if (!new File(path).exists()) {
			System.out.println(path + "文件不存在");
			return;
		}
		FileReader in = new FileReader(path);
		LineNumberReader reader = new LineNumberReader(in);
		String line = null;
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			for (String s : userResular) {
				if (line.contains(s)) {
					String l[] = line.split("\t");
					for (String string : l) {
						if (isPrint(string)) {
							System.out.println(string);
						}
					}
				}
			}
		}
		System.out.println("over");
		reader.close();
		in.close();
	}

	private static boolean isPrint(String line) {
		for (String string : printResular) {
			if (line.startsWith(string)) {
				return true;
			}
		}
		return false;
	}
}
