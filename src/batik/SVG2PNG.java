package batik;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;

public class SVG2PNG {
	public static boolean svg2png(String svg, String png) {
		File svgFile = new File(svg);
		if (!svgFile.exists()) {
			System.out.println("SVG图片不存在");
			return false;
		}
		File pngFile = new File(png);
		if (!pngFile.exists()) {
			System.out.println("PNG图片不存在");
			return false;
		}
		return svg2png(svgFile, pngFile);
	}

	public static boolean svg2png(File svg, File png) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(svg);
			out = new FileOutputStream(png);
		} catch (FileNotFoundException e) {
			System.out.println("SVG或者PNG图片不存在");
			return false;
		}
		out = new BufferedOutputStream(out);
		return svg2png(in, out);
	}

	public static boolean svg2png(InputStream in, OutputStream out) {
		Transcoder transcoder = new PNGTranscoder();
		TranscoderInput input = new TranscoderInput(in);
		TranscoderOutput output = new TranscoderOutput(out);
		try {
			transcoder.transcode(input, output);
		} catch (TranscoderException e) {
			System.out.println("非正常的SVG输入流！");
			return false;
		}
		try {
			if (in != null)
				in.close();
		} catch (IOException e) {
			System.out.println("输入流关闭异常！");
			return false;
		}
		try {
			if (out != null)
				out.close();
		} catch (IOException e) {
			System.out.println("输出流关闭异常！");
			return false;
		}
		return true;
	}
}
