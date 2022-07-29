package context;

import java.sql.Connection;
import java.sql.DriverManager;
// ket noi sql sv
public class DbContext {
	
  private final String serverName = "DESKTOP-HH4I0A5\\SQLEXPRESS";
  private final String dbName = "ShoppingDB";
  private final String portNumber = "1433";
  private final String instance = "";
  private final String userId = "sa";
  private final String password = "28011997";
  
  public Connection getConnection() throws Exception{
	String url = "jdbc:sqlserver://" + serverName + ":" + portNumber +"\\" + instance + ";databaseName=" + dbName +";encrypt=false";
	  if(instance == null || instance.trim().isEmpty()) {
		  url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName +";encrypt=false";
	  }
	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	  return DriverManager.getConnection(url, userId, password);
	  
  }
  
  
}
