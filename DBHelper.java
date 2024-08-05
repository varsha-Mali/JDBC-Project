package org.AlumniaSystem.Config;
import java.sql.*;
public class DBHelper
{
     protected DBConfig db=DBConfig.getDBInstance();
     protected Connection conn=DBConfig.getConnection();
     protected PreparedStatement stmt=DBConfig.getStatement();
     protected ResultSet rs=DBConfig.getResultSet();
}
