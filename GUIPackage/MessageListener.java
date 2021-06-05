package GUIPackage;
import ApplicationServicePackage.MessageObject;
import GUIPackage.JavaMVCControllers.MyController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MessageListener implements PropertyChangeListener {

    private MyController controller;

    public MessageListener(MyController controller) {
        this.controller = controller;
    }

    public void propertyChange(PropertyChangeEvent evt) {
        controller.setViewLabel(((MessageObject)evt.getNewValue()).getText());
    }
}
