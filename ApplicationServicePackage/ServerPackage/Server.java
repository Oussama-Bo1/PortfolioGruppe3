package ApplicationServicePackage.ServerPackage;

import ApplicationServicePackage.MessageObject;

import java.net.*;
import java.io.*;

public class Server {
    private MessageObject message;

    public Server() {
        listen();
    }

    private void listen() {

        Socket client = null;

        ObjectOutputStream out = null;
        ObjectInputStream in = null;

        try {
            ServerSocket server = new ServerSocket(8888);
            client = server.accept();
            out = new ObjectOutputStream(client.getOutputStream());
            in = new ObjectInputStream(client.getInputStream());

            message = (MessageObject) in.readObject();

            out.close();
            in.close();
            client.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public MessageObject getMessage()
    {
        return message;
    }
}
