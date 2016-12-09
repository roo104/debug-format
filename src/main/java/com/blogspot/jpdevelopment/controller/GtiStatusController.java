/**
 * Copyright Schantz A/S, all rights reserved
 */
package com.blogspot.jpdevelopment.controller;

import com.blogspot.jpdevelopment.gti.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class GtiStatusController {
	
	@FXML
	private TextField gtiIntr;
	@FXML
	private ChoiceBox<GtiStatus> newStatus;
	@FXML
	private DatePicker date;
	
	public void changeStatus(ActionEvent actionEvent) throws Exception {
		GtiChangeStatus gtiChangeStatus = new GtiChangeStatus();
		gtiChangeStatus.changeStatus(gtiIntr.getText(), newStatus.getValue().getValue(), date.getValue());
	}
}
