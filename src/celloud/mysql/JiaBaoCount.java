package celloud.mysql;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import utils.FileTools;

public class JiaBaoCount {
	public static void main(String[] args) throws SQLException {
		//count by month
		//		String sql = "select left(f.create_date,7) as month,count(*) as num,sum(size) as size from tb_file f,tb_user u,tb_user_company_relat r where f.user_id = u.user_id and u.user_id = r.user_id and r.company_id = 6 and f.file_id<39512 and f.state = 0 group by month;";
		//select delete data
		String sql = "select f.file_id,f.file_name,f.size,u.username,f.create_date from tb_file f,tb_user u,tb_user_company_relat r where f.user_id = u.user_id and u.user_id = r.user_id and r.company_id = 6 and f.file_id<39512 and f.state = 0 order by f.create_date asc;";
		List<Map<String, String>> list = MysqlUtils.query(sql);
		StringBuffer sb = new StringBuffer();
		sb.append("file_id\tfile_name\tsize\tusername\tcreate_date\n");
		for (Map<String, String> rs : list) {
			sb.append(rs.get("file_id")).append("\t").append(rs.get("file_name")).append("\t").append(rs.get("size"))
					.append("\t").append(rs.get("username")).append("\t").append(rs.get("create_date")).append("\n");
			//			sb.append(rs.get("month")).append("\t").append(rs.get("num")).append("\t").append(rs.get("size"))
			//					.append("\n");
		}
		String result = "/Users/lin/jiabao.xls";
		File file = new File(result);
		if (file.exists()) {
			file.delete();
		}
		FileTools.createFile(result);
		FileTools.appendWrite(result, sb.toString());
		System.out.println("over");
	}

}
