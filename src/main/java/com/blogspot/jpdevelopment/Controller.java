package com.blogspot.jpdevelopment;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class Controller {
	
	@FXML
	private TextField inputField;
	@FXML
	private TextArea outputArea;
	
	public void prettyPrint(ActionEvent actionEvent) {
		outputArea.setText(new Parser(inputField.getText()).print());
	}
	
	public void clear(ActionEvent actionEvent) {
		inputField.clear();
	}
	
	public void prettyPrintAsJson(ActionEvent actionEvent) {
		outputArea.setText(new Parser(inputField.getText()).printAsJson());
	}
}
