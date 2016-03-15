package observer;

public class EmailObserver implements Observer {

    private Subject subject;
    public String name;

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void update() {
        // Send e-mails
    }
    
}
