package observer;

import model.Playlist;

public interface Observer {

    void update();

    void setSubject(Subject subject);

    void setPlaylist(Playlist playlist);

}