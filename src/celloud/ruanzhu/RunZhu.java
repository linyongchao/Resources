package celloud.ruanzhu;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import utils.FileTools;

public class RunZhu {
	public static String path = "/Users/lin/Documents/git/celloud/celloud/src/main/java/com/celloud";
	public static String[] folderFilter = { "model", "constants", "alipay", "jdpay" };
	public static String[] fileFilter = { "xml" };
	public static String result = "/Users/lin/RunZhu.txt";

	public static List<String> folderFilterList = null;

	public static void main(String[] args) {
		File f = new File(result);
		if (f.exists()) {
			f.delete();
		}
		folderFilterList = Arrays.asList(folderFilter);
		long start = new Date().getTime();
		getFile(new File(path));
		long end = new Date().getTime();
		//		System.out.println(end - start);
		//		System.out.println(FileTools.countLines(result));
		String p = FileTools.getLimitLines(result, 1, 3000);
		System.out.println(p);
	}

	public static void getFile(File path) {
		File[] list = path.listFiles();
		for (File file : list) {
			if (file.isDirectory()) {
				getFile(file);
			} else {
				readFilter(file);
			}
		}
	}

	public static void readFilter(File file) {
		String path = file.getParentFile().getName();
		if (!folderFilterList.contains(path)) {
			boolean isPrint = true;
			for (String fileFilter : fileFilter) {
				if (file.getName().contains(fileFilter)) {
					isPrint = false;
					break;
				}
			}
			if (isPrint) {
				try {
					read(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void read(File file) throws IOException {
		FileReader in = new FileReader(file);
		LineNumberReader reader = new LineNumberReader(in);
		String line = null;
		StringBuffer sb = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			if (!line.trim().equals("")) {
				sb.append(line).append("\n");
			}
		}
		reader.close();
		FileTools.createFile(result);
		FileTools.appendWrite(result, sb.toString());
	}
}
