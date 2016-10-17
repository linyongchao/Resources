package celloud.mongo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PgsTest {
	public static void main(String[] args) {
		List<Pgs> pgsList = new ArrayList<Pgs>();
		Pgs p0 = new Pgs();
		p0.setUploadDate(DateUtils.getDate("2016-06-01 12:12:13"));
		p0.setDataKey("201606020001005");
		Pgs p1 = new Pgs();
		p1.setUploadDate(DateUtils.getDate("2016-06-01 12:12:13"));
		p1.setDataKey("201606020001001");
		Pgs p2 = new Pgs();
		p2.setUploadDate(DateUtils.getDate("2016-06-01 12:12:13"));
		p2.setDataKey("201606020001002");
		Pgs p3 = new Pgs();
		p3.setUploadDate(DateUtils.getDate("2016-06-02 12:12:16"));
		p3.setDataKey("201606020001001");
		Pgs p4 = new Pgs();
		p4.setUploadDate(DateUtils.getDate("2016-06-02 12:12:13"));
		p4.setDataKey("201606020001001");
		Pgs p5 = new Pgs();
		p5.setUploadDate(DateUtils.getDate("2016-06-01 12:12:15"));
		p5.setDataKey("201606020001011");
		pgsList.add(p0);
		pgsList.add(p1);
		pgsList.add(p2);
		pgsList.add(p3);
		pgsList.add(p4);
		pgsList.add(p5);
		ComparePgs asc = new ComparePgs();
		// Comparator<Pgs> desc = Collections.reverseOrder(asc);
		Collections.sort(pgsList, asc);

		for (Pgs pgs : pgsList) {
			System.out.println(DateUtils.getString(pgs.getUploadDate()) + " --- " + pgs.getDataKey());

		}
	}
}
