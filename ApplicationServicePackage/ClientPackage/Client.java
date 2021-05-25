package ApplicationServicePackage.ClientPackage;

import ApplicationServicePackage.MessageObject;

import java.net.*;
import java.io.*;

public class Client {

    public void send(int senderID, int recepientID, String text) {
        Socket client = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;

        try {

            client = new Socket("127.0.0.1", 8888);
            out = new ObjectOutputStream(client.getOutputStream());
            in = new ObjectInputStream(client.getInputStream());

            MessageObject message = new MessageObject(senderID, recepientID, text);
            out.writeObject(message);
            out.flush();

            out.close();
            in.close();
            client.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
}
