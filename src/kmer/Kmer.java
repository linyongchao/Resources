package kmer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Kmer {
	public static String path = "/Users/lin/K-mer.txt";

	public static void main(String[] args) throws IOException {
		File file = new File(path);
		BufferedReader br = null;
		long start = new Date().getTime();
		Map<String, String> map = new HashMap<String, String>(2100000);
		br = new BufferedReader(new FileReader(file));
		String line = null;
		while ((line = br.readLine()) != null) {
			String arr[] = line.split("\t");
			map.put(arr[0], arr[1]);
		}
		if (br != null) {
			br.close();
		}
		long end = new Date().getTime();
		System.out.println("init:" + (end - start));
		br = new BufferedReader(new FileReader(file));
		String line1 = null;
		int i = 0;
		while ((line1 = br.readLine()) != null) {
			i++;
			map.get(line1.split("\t")[0]);
			if (i == 10000) {
				break;
			}
		}
		if (br != null) {
			br.close();
		}
		i = 0;
		long end1 = new Date().getTime();
		System.out.println("10000:" + (end1 - end));

		br = new BufferedReader(new FileReader(file));
		line1 = null;
		while ((line1 = br.readLine()) != null) {
			i++;
			map.get(line1.split("\t")[0]);
			if (i == 30000) {
				break;
			}
		}
		if (br != null) {
			br.close();
		}
		i = 0;
		long end2 = new Date().getTime();
		System.out.println("30000:" + (end2 - end1));

		br = new BufferedReader(new FileReader(file));
		line1 = null;
		while ((line1 = br.readLine()) != null) {
			i++;
			map.get(line1.split("\t")[0]);
			if (i == 100000) {
				break;
			}
		}
		if (br != null) {
			br.close();
		}
		i = 0;
		long end3 = new Date().getTime();
		System.out.println("100000:" + (end3 - end2));

		br = new BufferedReader(new FileReader(file));
		line1 = null;
		while ((line1 = br.readLine()) != null) {
			i++;
			map.get(line1.split("\t")[0]);
			if (i == 300000) {
				break;
			}
		}
		if (br != null) {
			br.close();
		}
		i = 0;
		long end4 = new Date().getTime();
		System.out.println("300000:" + (end4 - end3));

		br = new BufferedReader(new FileReader(file));
		line1 = null;
		while ((line1 = br.readLine()) != null) {
			i++;
			map.get(line1.split("\t")[0]);
			if (i == 1000000) {
				break;
			}
		}
		if (br != null) {
			br.close();
		}
		i = 0;
		long end5 = new Date().getTime();
		System.out.println("1000000:" + (end5 - end4));
	}
}
