/*
* Author: Mateusz Krawiec
* e-mail: mateusz.krawiec.e@gmail.com
* 16 lut 2019
*
*/

package pl.mk.mybag.front;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;
import pl.mk.mybag.back.Element;

public class AddElementEvent extends Event {

	/**
	 *  Event passing new Element to the list of items
	 */
	private static final long serialVersionUID = 1416471559115044532L;

	private Element element;
	public final EventType<AddElementEvent> NEW_ITEM = new EventType<>(Event.ANY, "NEW_ITEM");

	public AddElementEvent(Object source, EventTarget target, EventType<? extends Event> eventType) {
		super(source, target, eventType);
		// TODO Auto-generated constructor stub
	}

	private Element getElement() {
		return element;
	}


}
