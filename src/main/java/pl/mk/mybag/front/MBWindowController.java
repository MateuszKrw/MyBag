/*
* Author: Mateusz Krawiec
* e-mail: mateusz.krawiec.e@gmail.com
* 14 gru 2018
*
*/

package pl.mk.mybag.front;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import pl.mk.mybag.back.Element;

public class MBWindowController {
	
	@FXML private GridPane root;
	@FXML private MenuBar bar;
	@FXML private VBox leftPanel;
	@FXML private ScrollPane scrollLeft;
	@FXML private VBox elementsPanel;	
	@FXML private GridPane rightPanel;
	@FXML private Label labelRight;
	@FXML private Button addItemButton;

	private ArrayList<Element> elementList = new ArrayList<Element>();

	public MBWindowController() { }

	public void initialize() {
		bar.prefWidthProperty().bind(root.widthProperty());
		bar.setPrefHeight(100);

		initLeftPanel();
	}

	public void initLeftPanel() {
		leftPanel.prefHeightProperty().bind(root.heightProperty());
		scrollLeft.setHbarPolicy(ScrollBarPolicy.NEVER);

		elementsPanel.prefHeightProperty().bind(leftPanel.heightProperty());
		elementsPanel.setPadding(new Insets(15));
		elementsPanel.setSpacing(10);
		
		addItemButton.setText("+");
		addItemButton.prefWidthProperty().bind(leftPanel.widthProperty());

		for(int i = 0; i < 4; i++) {
			addItem(new Element("Element " + i));
		}
		addItemsToPanel(elementList);
	}

	@FXML public void info() {
		rightPanel.setVisible(false);
	}

	@FXML public void showAddItemPanel() throws IOException, URISyntaxException {
//		FXMLLoader fxmlloader = new FXMLLoader();
		Node node = (Node) FXMLLoader.load(ClassLoader.getSystemResource("fxml/RightPanel.fxml").toURI().toURL());
		rightPanel.getChildren().setAll(node);
		rightPanel.setVisible(true);
//		rightPanel.
	}


	@FXML public void newPackingClicked() {
		
	}
	
	@FXML public void savePackingClicked() {
		
	}
	
	@FXML public void openPackingClicked() {
		
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
