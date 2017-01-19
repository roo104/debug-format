/**
 * Copyright Schantz A/S, all rights reserved
 */
package com.blogspot.jpdevelopment.controller;

import java.net.*;
import java.time.*;
import java.util.*;

import com.blogspot.jpdevelopment.gti.*;
import javafx.application.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import org.slf4j.*;

public class GtiStatusController implements Initializable {
	
	private static final Logger log = LoggerFactory.getLogger(GtiStatusController.class);
	
	@FXML
	private TextField gtiIntr;
	@FXML
	private ChoiceBox<GtiStatus> newStatus;
	@FXML
	private DatePicker date;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		date.setValue(LocalDate.now());
	}
	
	public void changeStatus(ActionEvent actionEvent) throws Exception {
		Platform.runLater(() -> {
			try {
				if (validInvocation()) {
					GtiChangeStatus gtiChangeStatus = new GtiChangeStatus();
					gtiChangeStatus.changeStatus(new GtiStatusChange(gtiIntr.getText(), newStatus.getValue().getValue(), date.getValue()));
					Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
					dialog.setHeaderText("Status update complete");
					dialog.setContentText("GTI interessent with id " + gtiIntr.getText() + " has changed status to " + newStatus.getValue().getName());
					dialog.show();
				}
			} catch (Exception e) {
				log.error("Error changing GTI status", e);
				Alert dialog = new Alert(Alert.AlertType.ERROR);
				dialog.setHeaderText("Error updating status");
				dialog.setContentText("Error message: " + e.getMessage());
				dialog.show();
			}
		});
	}
	
	private boolean validInvocation() {
		boolean validInvocation = true;
		
		StringBuilder sb = new StringBuilder();
		if (gtiIntr.getText().isEmpty()) {
			validInvocation = false;
			sb.append("- Missing GTI interessentnummer\n");
		}
		if (newStatus.getValue() == null) {
			validInvocation = false;
			sb.append("- Choose a status\n");
		}
		if (date.getValue() == null) {
			validInvocation = false;
			sb.append("- Pick an event date");
		}
		
		if (!validInvocation) {
			Alert dialog = new Alert(Alert.AlertType.WARNING);
			dialog.setHeaderText("Missing information");
			dialog.setContentText(sb.toString());
			dialog.show();
		}
		
		return validInvocation;
	}
}
