/*
* Author: Mateusz Krawiec
* e-mail: mateusz.krawiec.e@gmail.com
* 11 lut 2019
*
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

public class RightPanelController {

	@FXML private GridPane addItemPanel;
	
	@FXML private Label nameLabel;
	@FXML private TextField nameTextField;
	@FXML private Label containerLabel;
	@FXML private CheckBox containerCheckBox;
	@FXML private Label weightLabel;
	@FXML private TextField weightTextField;
	@FXML private Label stateLabel;
	@FXML private ComboBox<State> stateComboBox;
	@FXML private Button addButton;
	@FXML private Button backButton;
	
	public RightPanelController() { }
	
	@FXML public void addButton() {
		Element newElement = new Element(nameTextField.getText(), Integer.parseInt(weightTextField.getText()), containerCheckBox.isSelected());
		
	}
	
	@FXML public void backButton() {
		
	}
	
}
