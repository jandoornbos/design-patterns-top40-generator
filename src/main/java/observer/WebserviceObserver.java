package observer;

import networking.APIManager;

public class WebserviceObserver implements Observer {

    private Subject subject;
    public String name;

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void update() {
        APIManager.getInstance().postPlaylistToWebservice();
    }

}
