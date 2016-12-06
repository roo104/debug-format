/**
 * Copyright Schantz A/S, all rights reserved
 */
package com.blogspot.jpdevelopment.console;

import com.blogspot.jpdevelopment.util.*;

import java.io.*;
import java.sql.*;

public class GtiChangeStatus {
	
	public void changeStatus(String gtiIntr) throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=TopLife";
		String sql = "SELECT bjfd_input.uid, bjfd_root.name, bjfd_input.name\n" +
				"FROM BatchJobFileDir bjfd_root\n" +
				"LEFT JOIN BatchJobFileDir bjfd_input ON bjfd_root.uid = bjfd_input.parent_uid\n" +
				"WHERE bjfd_root.name = 'GTISkiftStatus'";
		
		Connection connection = DriverManager.getConnection(url, "sa", "robertrobot");
		ResultSet resultSet = connection.createStatement().executeQuery(sql);
		
		String parentFolderUid = "";
		
		while (resultSet.next()) {
			parentFolderUid = resultSet.getString(1);
		}
		
		String filePath = "C:/Temp/status_skift.txt";
		String insertDir = "INSERT INTO TopLife.dbo.BatchJobFileDir " +
				"(DTYPE, uid, createTime, createUser, directory, name, size, zip, batchJobEIOperation_uid, parent_uid) " +
				"VALUES " +
				"('BatchJobFileDir', ?, '2016-12-06 16:16:18.3250000', 'admin@schantz.com', 0, ?, 165, 0, null, ?)";
		
		PreparedStatement statement = connection.prepareStatement(insertDir);
		String parentUid = Guid.create().toString();
		statement.setString(1, parentUid);
		statement.setString(2, System.currentTimeMillis() + ".txt");
		statement.setString(3, parentFolderUid);
		
		statement.executeUpdate();
		
		InputStream inputStream = new FileInputStream(new File(filePath));
		
		String insertFile = "INSERT INTO TopLife.dbo.BatchJobData (DTYPE, uid, createTime, createUser, data, batchJobFileDir_uid) VALUES ('BatchJobData', ?, '2016-12-06 16:16:18.3400000', 'admin@schantz.com', ?, ?);";
		PreparedStatement insertFileStatement = connection.prepareStatement(insertFile);
		insertFileStatement.setString(1, Guid.create().toString());
		insertFileStatement.setBlob(2, inputStream);
		insertFileStatement.setString(3, parentUid);
		
		insertFileStatement.executeUpdate();
	}
}
