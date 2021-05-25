package GUIPackage.JavaMVCControllers;

import ApplicationServicePackage.ClientPackage.Client;
import ApplicationServicePackage.ServerPackage.Server;
import GUIPackage.JavaMVCViews.*;
import GUIPackage.JavaMVCModels.*;
import GUIPackage.MessageListener;

public class MyController {
    private boolean receiving = false;
    private Server server;
    private MyModel model;
    private MyForm view;
    private MessageListener listener;

    public MyController() {
        model = new MyModel();
    }

    public void startApplication() {
        view = new MyForm(this);
        view.setVisible(true);
        listener = new MessageListener(this);
    }
    
    public void receiveMessage() {
        receiving = true;
        try {
            server = new Server();
            model.addPropertyChangeListener(listener);
            model.writeData(server.getMessage());
            receiving = false;
            model.removePropertyChangeListener(listener);
        } catch (Exception er) {
            receiving = false;
        }
    }
    
    public boolean sendMessage(String message) {
        try {
            if(!receiving) {
                Client client = new Client();
                client.send(43, 62, message);
            }
            else
            {
                return false;
            }

            return true;

        } catch (Exception er) {
            return false;
        }
    }

    public void setViewLabel(String text)
    {
        view.setMyLabel(text);
    }
}
