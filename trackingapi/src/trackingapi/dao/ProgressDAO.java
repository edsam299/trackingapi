package trackingapi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.gson.JsonObject;

import trackingapi.config.MySQLFactory;

public class ProgressDAO {
	public int saveProgress(JsonObject jsonObject) throws Exception{
		try {
			return 1;
		}catch(Exception e) {
			throw e;
		}finally {
			
		}
	}
	
	public JsonObject searchProgressByLastUpdate(Connection oConn, String date) throws Exception{
		ResultSet rs=null; Statement stmt=null; String sql=null; JsonObject jsonObject=null;
		try {
			sql="SELECT\r\n" + 
					"progresstransaction.id,\r\n" + 
					"progresstransaction.createDate,\r\n" + 
					"progresstransaction.progressDetail,\r\n" + 
					"progresstransaction.statusCode,\r\n" + 
					"progresstransaction.lastupdate\r\n" + 
					"FROM\r\n" + 
					"progresstransaction WHERE cast(lastupdate as date)='"+date+"'";
			System.out.println(sql);
			stmt = oConn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				jsonObject = new JsonObject();
				jsonObject.addProperty("detail", rs.getString("progressDetail"));
				jsonObject.addProperty("lastUpdate", rs.getString("lastUpdate"));
			}
			return jsonObject;
		}catch(Exception e) {
			throw e;
		}finally {
			MySQLFactory.closeResultSet(rs);
			MySQLFactory.closeStatement(stmt);
		}
	}
	
	public static void main(String[] args) throws SQLException {
		Connection oConn=null;
		try {
			oConn=MySQLFactory.getDbCon().conn;
			JsonObject json=new ProgressDAO().searchProgressByLastUpdate(oConn,"2020-04-05");
			System.out.println(json.get("detail"));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MySQLFactory.closeConnection(oConn);
		}
	}
}
