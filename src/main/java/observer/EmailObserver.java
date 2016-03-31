package observer;

import model.Playlist;

public class EmailObserver implements Observer {

    private Subject subject;
    private Playlist playlist;
    public String name;

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    /**
     * E-mail our users that there is a new playlist available.
     */
    public void update() {
        // Send e-mails
    }
    
}
