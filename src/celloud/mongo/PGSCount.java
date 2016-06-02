package celloud.mongo;

import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class PGSCount {
	private static String host = "localhost";
	private static int port = 27017;
	private static String dbName = "celloud";
	private static String[] columns = { "appId", "appName", "userId", "username", "uploadDate", "dataKey", "fileName",
			"anotherName", "size", "sd", "mapRatio", "mtRatio", "totalReads", "duplicate", "mapReads", "winSize",
			"gcCount", "note", "report" };

	private static String filePath = "/Users/lin/";

	public static void main(String[] args) throws UnknownHostException {
		long start = new Date().getTime();
		Morphia morphia = new Morphia();
		MongoClient mongo = new MongoClient(host, port);
		Datastore dataStore = morphia.createDatastore(mongo, dbName);
		List<Pgs> pgsList = dataStore.createQuery(Pgs.class).retrievedFields(true, columns).asList();
		// TODO 将mongodb中查询出来的日期回退8小时
		// 要彻底解决此问题，需要
		// 1.python插入时时间做处理
		// 2.历史数据时间全部做处理
		if (pgsList != null && pgsList.size() > 0) {
			Calendar c = Calendar.getInstance();
			for (Pgs p : pgsList) {
				c.setTime(p.getUploadDate());
				c.add(Calendar.HOUR_OF_DAY, -8);
				p.setUploadDate(c.getTime());
			}
		}
		ComparePgs asc = new ComparePgs();
		Collections.sort(pgsList, asc);
		StringBuffer sb = new StringBuffer(
				"appId\tappName\tuserId\tusername\tuploadDate\tdataKey\tfileName\tanotherName\tsize\tsd\tmapRatio\tmtRatio\ttotalReads\tduplicate\tmapReads\twinSize\tgcCount\tnote\treport\n");
		for (Pgs pgs : pgsList) {
			sb.append(pgs.getAppId() + "\t" + pgs.getAppName() + "\t" + pgs.getUserId() + "\t" + pgs.getUsername()
					+ "\t" + DateUtils.getString(pgs.getUploadDate()) + "\t" + pgs.getDataKey() + "\t"
					+ pgs.getFileName() + "\t" + pgs.getAnotherName() + "\t" + pgs.getSize() + "\t" + pgs.getSd() + "\t"
					+ pgs.getMapRatio() + "\t" + pgs.getMtRatio() + "\t" + pgs.getTotalReads() + "\t"
					+ pgs.getDuplicate() + "\t" + pgs.getMapReads() + "\t" + pgs.getWinSize() + "\t" + pgs.getGcCount()
					+ "\t" + pgs.getNote() + "\t" + (pgs.getReport() == null ? "" : pgs.getReport().replace("\t", " "))
					+ "\n");
		}
		filePath = filePath + DateUtils.getSimpleString(new Date()) + "count.xls";
		FileTools.createFile(filePath);
		FileTools.appendWrite(filePath, sb.toString());
		long end = new Date().getTime();
		System.out.println(end - start);
	}
}
