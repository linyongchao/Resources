package celloud.mongo;

import java.util.Comparator;

public class ComparePgs implements Comparator<Pgs> {

	@Override
	public int compare(Pgs p1, Pgs p2) {
		int date = p1.getUploadDate().compareTo(p2.getUploadDate());
		if (date == 0) {
			int key = p1.getDataKey().compareTo(p2.getDataKey());
			return key;
		} else {
			return 0 - date;
		}
	}
}
