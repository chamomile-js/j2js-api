package j2js.net;

import org.w3c.dom.events.Event;

public interface NetworkEvent extends Event {
    
    public HttpRequest getHttpRequest();


}
