package trackingapi.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @desc A singleton database access class for MySQL
 * @author Ramindu
 */
public final class MySQLFactory {
    public Connection conn;
    private Statement statement;
    public static MySQLFactory db;
    private MySQLFactory() {
        String url= "jdbc:mysql://localhost:3306/";
        String dbName = "tracking";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "root";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
    /**
     *
     * @return MysqlConnect Database connection object
     */
    public static synchronized MySQLFactory getDbCon() {
        if ( db == null ) {
            db = new MySQLFactory();
        }
        return db;
 
    }
    /**
     *
     * @param query String The query to be executed
     * @return a ResultSet object containing the results or null if not available
     * @throws SQLException
     */
    public ResultSet query(String query) throws SQLException{
        statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }
    /**
     * @desc Method to insert data to a table
     * @param insertQuery String The Insert query
     * @return boolean
     * @throws SQLException
     */
    public int insert(String insertQuery) throws SQLException {
        statement = db.conn.createStatement();
        int result = statement.executeUpdate(insertQuery);
        return result;
    }
    
    public static void closeConnection(Connection oConn) throws SQLException{
    	try {
    		if(oConn!=null) {
    			oConn.close();
    		}
    	}catch(SQLException e) {
    		throw e;
    	}
    }
    public static void closeStatement(Statement stmt) throws SQLException{
    	try {
    		if(stmt!=null) {
    			stmt.close();
    		}
    	}catch(SQLException e) {
    		throw e;
    	}
    }
    public static void closeResultSet(ResultSet rs) throws SQLException{
    	try {
    		if(rs!=null) {
    			rs.close();
    		}
    	}catch(SQLException e) {
    		throw e;
    	}
    }
    
    public static void main(String[] args) {
		System.out.println(MySQLFactory.getDbCon());
		
	}
 
}