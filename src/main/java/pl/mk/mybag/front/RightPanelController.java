/*
* Author: Mateusz Krawiec
* e-mail: mateusz.krawiec.e@gmail.com
* 11 lut 2019
*/

package pl.mk.mybag.front;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import pl.mk.mybag.back.Element;
import pl.mk.mybag.back.State;
import pl.mk.mybag.front.events.EditElementEvent;

public class RightPanelController {

	@FXML
	private GridPane addItemPanel;

	@FXML
	private Label nameLabel;
	@FXML
	private TextField nameTextField;
	@FXML
	private Label containerLabel;
	@FXML
	private CheckBox containerCheckBox;
	@FXML
	private Label weightLabel;
	@FXML
	private TextField weightTextField;
	@FXML
	private Label stateLabel;
	@FXML
	private ComboBox<State> stateComboBox;
	@FXML
	private Button addButton;
	@FXML
	private Button backButton;

	public RightPanelController() {
	}

	@FXML
	public void addButton() {
		EditElementEvent editElementEvent = new EditElementEvent(this, addItemPanel.getParent(),
				EditElementEvent.EDIT_ITEM);
		addItemPanel.fireEvent(editElementEvent);
	}

	@FXML
	public void backButton() {

	}

	public Element getElementFromEditView() {
		String name = "";
		Element newElement;

		if (nameTextField.getText().isEmpty()) {
			// TODO exception: name required
			name = "Element";
		}

		if (weightTextField.getText().isEmpty()) {
			newElement = new Element(name, containerCheckBox.isSelected());
		} else {
			newElement = new Element(name, containerCheckBox.isSelected(), Integer.parseInt(weightTextField.getText()));
		}

		return newElement;
	}

}
