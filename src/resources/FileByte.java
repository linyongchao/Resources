package resources;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * @Description:文件和二进制字节流的转换
 * @author lin
 * @date 2014-10-22 下午1:06:07
 */
public class FileByte {

	/**
	 * 将二进制字节流写成文件
	 * 
	 * @param b
	 *            ：二进制字节流
	 * @param file
	 *            ：目标文件
	 */
	public static void byteToFile(byte[] b, File file) {
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			os.write(b);
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 将文件写成二进制字节流
	 * 
	 * @param file
	 *            ：目标文件
	 * @return：二级制字节流
	 */
	public static byte[] fileToByte1(File file) {
		if (!file.exists()) {
			return new byte[0];
		}
		byte[] bytes = null;
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			long length = file.length();
			if (length > Integer.MAX_VALUE) {// 当文件的长度超过了int的最大值
				System.out.println("this file is too big");
				return new byte[0];
			}
			int size = (int) length;
			bytes = new byte[size];
			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length
					&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}
			// 如果得到的字节长度和file实际的长度不一致就可能出错了
			if (offset != bytes.length) {
				System.out.println("file length is error");
				return new byte[0];
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return bytes;
	}

	/**
	 * 将文件写成二进制字节流（ByteArrayOutputStream）
	 * 
	 * @param file
	 *            ：目标文件
	 * @return：二级制字节流
	 */
	public static byte[] fileToByte2(File file) {
		if (!file.exists()) {
			return new byte[0];
		}
		FileInputStream in = null;
		ByteArrayOutputStream out = null;
		try {
			in = new FileInputStream(file);
			out = new ByteArrayOutputStream(1024);
			byte[] temp = new byte[1024];
			int size = 0;
			while ((size = in.read(temp)) != -1) {
				out.write(temp, 0, size);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (out == null) {
			return new byte[0];
		} else {
			return out.toByteArray();
		}
	}

	/**
	 * 将文件写成二进制字节流（MappedByteBuffer）
	 * 
	 * @param file
	 *            ：目标文件
	 * @return：二级制字节流
	 */
	public static byte[] fileToByte3(File file) {
		if (!file.exists()) {
			return new byte[0];
		}
		FileChannel fc = null;
		byte[] result = null;
		try {
			fc = new RandomAccessFile(file, "r").getChannel();
			MappedByteBuffer byteBuffer = fc.map(MapMode.READ_ONLY, 0,
					fc.size()).load();
			long length = fc.size();
			if (length > Integer.MAX_VALUE) {// 当文件的长度超过了int的最大值
				System.out.println("this file is too big");
				return new byte[0];
			}
			result = new byte[(int) length];
			if (byteBuffer.remaining() > 0) {
				byteBuffer.get(result, 0, byteBuffer.remaining());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fc != null) {
				try {
					fc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	/**
	 * 将文件写成二进制字节流（ByteBuffer）
	 * 
	 * @param file
	 *            ：目标文件
	 * @return：二级制字节流
	 */
	public static byte[] fileToByte4(File file) {
		if (!file.exists()) {
			return new byte[0];
		}
		FileChannel channel = null;
		FileInputStream fs = null;
		byte[] result = null;
		try {
			fs = new FileInputStream(file);
			channel = fs.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
			while ((channel.read(byteBuffer)) > 0) {
			}
			result = byteBuffer.array();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (channel != null) {
				try {
					channel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fs != null) {
				try {
					fs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}