package fsocg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import utils.FileTools;

public class FSocgInit {
	public static void main(String[] args) {
		String path = "/Users/lin/1.txt";
		List<String> list = FileTools.filetoList(new File(path));
		List<FSocgDB> data = new ArrayList<FSocgDB>();
		for (int i = 1; i < list.size(); i++) {
			String line[] = list.get(i).split("\t");
			if (line.length == 6) {
				FSocgDB fs = new FSocgDB();
				fs.setGene(line[0]);
				fs.setCosm(line[1]);
				fs.setAaMutSyntax(line[2]);
				fs.setCdsMutSyntax(line[3]);
				fs.setAmpliconId(line[4]);
				fs.setInsert(line[5]);
				FSocgInsert.save(fs);
				data.add(fs);
			}
		}
		System.out.println(data.size());
	}
}
