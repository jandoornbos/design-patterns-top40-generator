package observer;

public class WebserviceObserver implements Observer {

    private Subject subject;
    public String name;

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void update() {
        // Update webservice
    }

}
