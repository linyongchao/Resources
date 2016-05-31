package celloud.hospitl;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class ThreeJia {
	public static String baidu = "/Users/lin/hospital.txt";

	public static void main(String[] args) throws IOException {
		List<String> baidulist = getList(baidu);
		System.out.println(baidulist.size());
		System.out.println("-------------");
		StringBuffer privince = new StringBuffer();
		int p = 0, h = 0;
		StringBuffer hospital = new StringBuffer("insert into tb_company (company_name,province,create_date) values (");
		String title = null;
		for (String string : baidulist) {
			if (!string.contains("院") && !string.contains("中心") && !string.contains("集团")) {
				string = string.substring(0, string.indexOf("（"));
				title = string.replace("省", "").replace("市", "");
				privince.append(string).append("\n");
				p++;
			} else {
				h++;
				hospital.append("'"+string+"'").append(",").append("'"+title+"',").append("now()").append("),(");
			}
		}
		System.out.println(privince.toString());
		System.out.println(p);
		System.out.println("-------------");
		System.out.println(hospital.toString());
		System.out.println(h);
		System.out.println("-------------");
	}

	public static List<String> getList(String path) throws IOException {
		List<String> list = new ArrayList<String>();
		FileReader in = new FileReader(path);
		LineNumberReader reader = new LineNumberReader(in);
		String line = null;
		while ((line = reader.readLine()) != null) {
			list.add(line.trim());
		}
		reader.close();
		in.close();
		return list;
	}

}
