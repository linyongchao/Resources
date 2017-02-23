package fsocg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import utils.FileTools;

public class FSocgInit {
	public static void main(String[] args) {
		String path = "/Users/lin/FS-ocg/Spacegen.DNA.hotspot.V2_5.bed";
		List<String> list = FileTools.filetoList(new File(path));
		List<FSocg> data = new ArrayList<FSocg>();
		for (int i = 1; i < list.size(); i++) {
			String line[] = list.get(i).split("\t");
			FSocg fs = new FSocg();
			fs.setChrom(line[0]);
			fs.setPositionStr(line[1]);
			fs.setPositionEnd(line[2]);
			fs.setAlleleName(line[3]);
			fs.setNum(line[4]);
			fs.setPlus(line[5]);
			fs.setVariant(line[6]);
			fs.setGene(line[7]);
			data.add(fs);
		}
	}
}
