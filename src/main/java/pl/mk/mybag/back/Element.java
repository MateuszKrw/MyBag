/*
* Author: Mateusz Krawiec
* e-mail: mateusz.krawiec.e@gmail.com
* 14 gru 2018
*
*/

package pl.mk.mybag.back;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class Element extends HBox {

	private String name;
	private State state;
	private ImageView icon;
	private boolean container;
	private double weight;
	private Label nameLabel;

	public Element() {
		super();

		name = "";
		state = State.NOTNEEDED;
		container = false;
		weight = 0;
		nameLabel = new Label();
		icon = new ImageView();

		setSpacing(5);
		BorderStroke bs = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(2.0),
				new BorderWidths(1));
		Border border = new Border(bs);
		setBorder(border);
		setIcon();

		this.getChildren().addAll(icon, nameLabel);
	}

	public Element(String name) {
		this();
		this.name = name;
		this.nameLabel.setText(name);
	}

	public Element(String name, boolean container) {
		this(name);
		this.container = container;

	}

	public Element(String name, boolean container, double weight) {
		this(name, container);
		this.weight = weight;
	}

	public boolean isContainer() {
		return container;
	}

	public void setContainer(boolean container) {
		this.container = container;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setIcon() {
		try {
			switch (state) {
			case NOTNEEDED:
				icon = new ImageView(new Image(new FileInputStream("src/main/resources/icons/notneeded.bmp")));
				break;
			case NOTAVALIABLE:
				icon = new ImageView(new Image(new FileInputStream("src/main/resources/icons/notneeded.bmp")));
				break;
			case AWAITED:
				icon = new ImageView(new Image(new FileInputStream("src/main/resources/icons/awaited.bmp")));
				break;
			case BEFOREDISPATCH:
				icon = new ImageView(new Image(new FileInputStream("src/main/resources/icons/beforedispatch.bmp")));
				break;
			case PACKED:
				icon = new ImageView(new Image(new FileInputStream("src/main/resources/icons/packed.bmp")));
				break;
			case CONFIRMED:
				icon = new ImageView(new Image(new FileInputStream("src/main/resources/icons/packed.bmp")));
				break;
			default:
				icon = null;
				break;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String toString() {
		final String nameOut = this.getName() + " " + this.getWeight() + " kg";
		return nameOut;
	}

	public double getElementSize() {
		return getHeight();
	}
}
