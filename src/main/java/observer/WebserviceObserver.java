package observer;

import model.Playlist;
import networking.APIManager;

public class WebserviceObserver implements Observer {

    private Subject subject;
    private Playlist playlist;
    public String name;

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public void update() {
        APIManager.getInstance().postPlaylistToWebservice(this.playlist);
    }

}
