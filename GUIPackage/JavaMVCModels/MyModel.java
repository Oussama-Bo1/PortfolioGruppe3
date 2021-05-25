package GUIPackage.JavaMVCModels;

import ApplicationServicePackage.MessageObject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MyModel {

    public MyModel() {
        support = new PropertyChangeSupport(this);
    }

    // Observable Properties
    private PropertyChangeSupport support;

    private MessageObject message;

    public String getData(){

        return message.getText();
    }
    
    public boolean writeData(MessageObject data)
    {
        support.firePropertyChange("message", message, data);
        message = data;
        return true;
    }

    //Observable Methods
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

}
