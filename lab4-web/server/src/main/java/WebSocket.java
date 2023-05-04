import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/socket")
public class WebSocket {
    @OnMessage
    public String handleTextString(String message){
        System.out.print("New TextMessage Recieve");
        return message;
    }

    @OnMessage(maxMessageSize = 1024000)
    public byte[] handleBinaryMessage(byte[] buffer){
        return buffer;
    }
}
