package compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {

	public static void main(String[] args) {
		List<User> userlist = new ArrayList<User>();
		userlist.add(new User("dd", "4"));
		userlist.add(new User("aa", "1"));
		userlist.add(new User("ee", "5"));
		userlist.add(new User("bb", "2"));
		userlist.add(new User("ff", "5"));
		userlist.add(new User("cc", "3"));
		userlist.add(new User("gg", "6"));

		ComparatorUser comparator = new ComparatorUser();
		Collections.sort(userlist, comparator);

		for (int i = 0; i < userlist.size(); i++) {
			User user_temp = (User) userlist.get(i);
			System.out.println(user_temp.getAge() + "," + user_temp.getName());
		}

	}
}