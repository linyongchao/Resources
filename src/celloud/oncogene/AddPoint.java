package celloud.oncogene;

public class AddPoint {
	static String name[] = { "MT-12SrRNA" };
	static int pos[] = { 283, 303, 137, 150, 313 };
	static String ext[] = { ".3.png", ".10.png" };

	public static void main(String[] args) {
		for (String n : name) {
			for (int p : pos) {
				for (String e : ext) {
					System.out.print("\"" + n + "." + p + e + "\",");
				}
			}
		}
	}
}
