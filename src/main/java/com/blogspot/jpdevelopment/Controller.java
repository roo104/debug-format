package com.blogspot.jpdevelopment;

import javafx.application.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.text.*;

import java.util.*;
import java.util.stream.*;

public class Controller {
	
	@FXML
	private TextField inputField;
	@FXML
	private TextFlow outputArea;
	
	public void prettyPrint(ActionEvent actionEvent) {
		outputArea.getChildren().add(new Text(new Parser(inputField.getText()).print()));
	}
	
	public void clear(ActionEvent actionEvent) {
		inputField.clear();
	}
	
	public void prettyPrintAsJson(ActionEvent actionEvent) {
		outputArea.getChildren().add(new Text(new Parser(inputField.getText()).printAsJson()));
	}
	
	public void exit(ActionEvent actionEvent) {
		Platform.exit();
	}
	
	public void find(ActionEvent actionEvent) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Find");
		dialog.setHeaderText("Find what:");
		
		Optional<String> result = dialog.showAndWait();
		result.ifPresent(name -> {
			System.out.println("Looking for: " + name);
			String unformattedValue = outputArea.getChildren().stream()
					.map(node -> ((Text) node).getText())
					.collect(Collectors.joining());
			
			
			List<Integer> integers = unformattedValue.chars()
					.filter(i -> i == unformattedValue.indexOf(name, i))
					.boxed()
					.collect(Collectors.toList());
			
			System.out.println("Found at pos: " + integers);
			//System.out.println(unformattedValue);
		});
	}
}
