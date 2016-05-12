package celloud.hospitl;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class ThreeJia {
	public static String baidu = "/Users/lin/3.txt";
	public static String wiki = "/Users/lin/三甲.txt";

	public static void main(String[] args) throws IOException {
		List<String> baidulist = getList(baidu);
		List<String> wikilist = getList(wiki);
		System.out.println(baidulist.size());
		System.out.println(wikilist.size());
		int i = 0;
		for (String wk : wikilist) {
			if (!baidulist.contains(wk)) {
				i++;
				System.out.println(wk);
			}
		}
		System.out.println(i);
		System.out.println("-----");
		int p = 0;
		for (String string : baidulist) {
			if (!wikilist.contains(string)) {
				p++;
				System.out.println(string);
			}
		}
		System.out.println(p);
	}

	public static List<String> getList(String path) throws IOException {
		List<String> list = new ArrayList<String>();
		FileReader in = new FileReader(path);
		LineNumberReader reader = new LineNumberReader(in);
		String line = null;
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			if (line.contains("医院")) {
				list.add(line);
			}
		}
		reader.close();
		in.close();
		return list;
	}

}
