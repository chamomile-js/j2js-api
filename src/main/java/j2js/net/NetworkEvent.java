package j2js.net;

import j2js.w3c.dom.events.Event;

public interface NetworkEvent extends Event {
    
    public HttpRequest getHttpRequest();


}
