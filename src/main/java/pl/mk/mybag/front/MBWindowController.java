/*
* Author: Mateusz Krawiec
* e-mail: mateusz.krawiec.e@gmail.com
* 14 gru 2018
*
*/

package pl.mk.mybag.front;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import pl.mk.mybag.back.Element;
import pl.mk.mybag.back.State;

public class MBWindowController {
	
	@FXML private GridPane root;
	@FXML private MenuBar bar;
	@FXML private VBox leftPanel;
	@FXML private ScrollPane scrollLeft;
	@FXML private VBox elementsPanel;	
	@FXML private GridPane rightPanel;
	@FXML private GridPane addItemPanel;
	@FXML private Label labelRight;
	@FXML private Button addItemButton;

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
	
	private ArrayList<Element> elementList = new ArrayList<Element>();

	public MBWindowController() { }

	public void initialize() {
		bar.prefWidthProperty().bind(root.widthProperty());
		bar.setPrefHeight(100);

		initLeftPanel();

		addItemPanel.setVisible(false);
	}

	public void initLeftPanel() {
		leftPanel.prefHeightProperty().bind(root.heightProperty());
		scrollLeft.setHbarPolicy(ScrollBarPolicy.NEVER);

		elementsPanel.prefHeightProperty().bind(leftPanel.heightProperty());
		elementsPanel.setPadding(new Insets(15));
		elementsPanel.setSpacing(10);
		
		addItemButton.setText("+");
		addItemButton.prefWidthProperty().bind(leftPanel.widthProperty());

		for(int i = 0; i < 8; i++) {
			addItem(new Element("Element " + i));
		}

		addItemsToPanel(elementList);
	}
	
	public void initAddItemPanel() {
		
	}

	@FXML public void info() {
		rightPanel.setVisible(false);
	}

	@FXML public void addItemButton() {
		addItemPanel.setVisible(true);
		rightPanel.setVisible(false);
	}

	@FXML public void addButton() {
		Element newElement = new Element(nameTextField.getText(), Integer.parseInt(weightTextField.getText()), containerCheckBox.isSelected());
	}

	@FXML public void backButton() {
		
	}

	private void addItem(Element element) {
		elementList.add(element);
	}

	private void addItemsToPanel(ArrayList<Element> elementList) {
		for (Element e : elementList) {
			elementsPanel.getChildren().add(e);
		}
	}
}
