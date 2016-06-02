package compare;

import java.util.Comparator;

public class ComparatorUser implements Comparator<User> {

	public int compare(User user0, User user1) {
		// 首先比较年龄，如果年龄相同，则比较名字
		int flag = user0.getAge().compareTo(user1.getAge());
		if (flag == 0) {
			return user0.getName().compareTo(user1.getName());
		} else {
			return flag;
		}
	}

}
