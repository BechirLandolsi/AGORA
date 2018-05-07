package Socket;


import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import Message.ChatMessage;
import Message.MessageType;
import Room.Room;





@ServerEndpoint(value = "/chat")
public class ChatEndpoint {
    private Logger log = Logger.getLogger(ChatEndpoint.class.getSimpleName());
    private Room room = Room.getRoom();

    private static String name ;
    private String msg;
    @OnOpen
    public void open(final Session session, EndpointConfig config) {}

    @OnMessage
    public void onMessage(final Session session, final String messageJson) {
        ObjectMapper mapper = new ObjectMapper();
        ChatMessage chatMessage = null;
        try {
            chatMessage = mapper.readValue(messageJson, ChatMessage.class);
        } catch (IOException e) {
            String message = "Badly formatted message";
            try {
                session.close(new CloseReason(CloseReason.CloseCodes.CANNOT_ACCEPT, message));
            } catch (IOException ex) { log.severe(ex.getMessage()); }
        } ;

        Map<String, Object> properties = session.getUserProperties();
        if (chatMessage.getMessageType() == MessageType.LOGIN) {
            String name = chatMessage.getMessage();
            properties.put("name", name);
            room.join(session);
            room.sendMessage(name + " - Joined the chat room");
            this.name=name;
        }
        else {
            String name = (String)properties.get("name");
            room.sendMessage(name + " - " + chatMessage.getMessage());
            msg=chatMessage.getMessage();
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        room.leave(session);
        room.sendMessage((String)session.getUserProperties().get("name") + " - Left the room");
    }

    @OnError
    public void onError(Session session, Throwable ex) { log.info("Error: " + ex.getMessage()); }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        ChatEndpoint.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}