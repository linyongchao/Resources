package batik;

import java.io.File;
import java.io.IOException;

import org.apache.batik.transcoder.TranscoderException;

public class Test {
	public static void main(String[] args) throws IOException, TranscoderException {
		String path = "/Users/lin/23/89/20151030793649/SVG";
		File f = new File(path);
		File[] list = f.listFiles();
		for (File file : list) {
			if (file.getName().endsWith(".svg")) {
				System.out.println(file.getName());
				SVG2PNG.svg2png(file, new File(path + "/" + file.getName().replace(".svg", ".png")));
			}
		}
	}
}
