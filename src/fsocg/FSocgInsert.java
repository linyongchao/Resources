package fsocg;

import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class FSocgInsert {
	private static String host = "localhost";
	private static int port = 27017;
	private static String dbName = "celloud";

	public static <T> void save(T t) {
		Morphia morphia = new Morphia();
		MongoClient mongo = null;
		try {
			mongo = new MongoClient(host, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		Datastore dataStore = morphia.createDatastore(mongo, dbName);
		dataStore.save(t);
	}
}
