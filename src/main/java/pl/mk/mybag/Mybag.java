/*
* Author: Mateusz Krawiec
* e-mail: mateusz.krawiec.e@gmail.com
* 14 gru 2018
*
*/

package pl.mk.mybag;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Mybag extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(ClassLoader.getSystemResource("fxml/MBWindow.fxml").toURI().toURL());
		Scene scene = new Scene(root, 700, 500);
		scene.getStylesheets().add("css/MBStyle.css");

		primaryStage.setScene(scene);
		primaryStage.setTitle("MyBag");
		primaryStage.show();

	}
}
