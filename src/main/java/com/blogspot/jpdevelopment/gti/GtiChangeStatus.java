/**
 * Copyright Schantz A/S, all rights reserved
 */
package com.blogspot.jpdevelopment.gti;

import com.blogspot.jpdevelopment.batch.*;
import com.blogspot.jpdevelopment.util.*;

import java.io.*;
import java.sql.*;
import java.time.*;
import java.time.format.*;

public class GtiChangeStatus {
	
	private static String DATE_FORAMT = "yyyyMMdd";
	
	public void changeStatus(String gtiIntr, String status, LocalDate date, final String serverName, String username, String password) throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=TopLife";
		String sql = "SELECT bjfd_input.uid, bjfd_root.name, bjfd_input.name\n" +
				"FROM BatchJobFileDir bjfd_root\n" +
				"LEFT JOIN BatchJobFileDir bjfd_input ON bjfd_root.uid = bjfd_input.parent_uid\n" +
				"WHERE bjfd_root.name = 'GTISkiftStatus' and bjfd_input.name = 'input'";
		
		Connection connection = DriverManager.getConnection(url, username, password);
		ResultSet resultSet = connection.createStatement().executeQuery(sql);
		
		String parentFolderUid = "";
		
		if (resultSet.next()) {
			parentFolderUid = resultSet.getString(1);
		}
		String fileContent = createFileContent(gtiIntr, status, date);
		
		
		String insertDir = "INSERT INTO BatchJobFileDir " +
				"(DTYPE, uid, createTime, createUser, directory, name, size, zip, batchJobEIOperation_uid, parent_uid) " +
				"VALUES " +
				"('BatchJobFileDir', ?, ?, 'admin@schantz.com', 0, ?, ?, 0, null, ?)";
		
		PreparedStatement statement = connection.prepareStatement(insertDir);
		String parentUid = Guid.create().toString();
		statement.setString(1, parentUid);
		statement.setTimestamp(2, DateUtils.asSqlDateTime(LocalDateTime.now()));
		statement.setString(3, System.currentTimeMillis() + ".txt");
		statement.setInt(4, fileContent.length());
		statement.setString(5, parentFolderUid);
		
		statement.executeUpdate();
		
		String insertFile = "INSERT INTO BatchJobData (DTYPE, uid, createTime, createUser, data, batchJobFileDir_uid) VALUES ('BatchJobData', ?, ?, 'admin@schantz.com', ?, ?);";
		PreparedStatement insertFileStatement = connection.prepareStatement(insertFile);
		insertFileStatement.setString(1, Guid.create().toString());
		insertFileStatement.setTimestamp(2, DateUtils.asSqlDateTime(LocalDateTime.now()));
		insertFileStatement.setBlob(3, new ByteArrayInputStream(fileContent.getBytes()));
		insertFileStatement.setString(4, parentUid);
		
		insertFileStatement.executeUpdate();
		
		BatchJobServiceService batchJobServiceService = new BatchJobServiceService();
		BatchJobService servicePort = batchJobServiceService.getBatchJobServicePort();
		servicePort.startBatchJob("1", "GTI: GTISkiftStatus");
	}
	
	private String createFileContent(String gtiIntr, String status, LocalDate date) {
		String formattedDate = date.format(DateTimeFormatter.ofPattern(DATE_FORAMT));
		return String.format("%s, ,%s,%s,%s", gtiIntr, status, formattedDate, formattedDate);
	}
}
