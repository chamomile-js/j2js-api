package j2js.client;

import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;

public class EventExecution implements Runnable {

    public Event event;
    public EventListener listener;
    
    public EventExecution(Event event, EventListener listener) {
        this.event = event;
        this.listener = listener;
    }

    public void run() {
        listener.handleEvent(event);
    }
    
}
