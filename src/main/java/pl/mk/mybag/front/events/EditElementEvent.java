/*
* Author: Mateusz Krawiec
* e-mail: mateusz.krawiec.e@gmail.com
* 16 lut 2019
*
*/

package pl.mk.mybag.front.events;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;
import pl.mk.mybag.back.Element;
import pl.mk.mybag.front.RightPanelController;

public class EditElementEvent extends Event {

	/**
	 * Event passing new Element to the list of items
	 */
	private static final long serialVersionUID = 1416471559115044532L;

	private Element element;
	public final static EventType<EditElementEvent> EDIT_ITEM = new EventType<>(Event.ANY, "NEW_ITEM");

	public EditElementEvent(Object source, EventTarget target, EventType<? extends Event> eventType) {
		super(source, target, eventType);

		this.element = ((RightPanelController) source).getElementFromEditView();
	}

	public Element getElementFromEvent() {
		return element;
	}

}
