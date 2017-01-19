package com.blogspot.jpdevelopment;

import com.jcabi.manifests.*;
import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		String version = "";
		try {
			version = Manifests.read("Management-Version");
		} catch (Exception e) {
			
		}
		
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
		stage.setTitle("Management console - " + version);
		stage.setScene(new Scene(root, 1000, 800));
		stage.setResizable(false);
		stage.show();
	}
}
