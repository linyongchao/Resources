package random;

import java.util.UUID;

public class UUIDTest {
	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		System.out.println(uuid.toString().replace("-", ""));
		System.out.println(uuid.toString().replace("-", "").length());
	}
}
