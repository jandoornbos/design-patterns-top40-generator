package model;

import iterator.Iterator;
import iterator.IteratorContainer;
import observer.Observer;
import observer.Subject;

import java.util.ArrayList;


public class Playlist implements Subject, IteratorContainer {

    private String title;
    private ArrayList<Song> songs;

    private ArrayList<Observer> observers;

    /**
     * Constructor
     */
    public Playlist() {
        songs = new ArrayList<Song>();
        observers = new ArrayList<Observer>();
    }

    /**
     * Add a song to the playlist.
     *
     * @param song The song to add.
     */
    public void addSong(Song song) {
        this.songs.add(song);
    }

    /**
     * Get all the songs that are in the playlist.
     *
     * @return Arraylist with all the songs.
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * Get the title of the playlist.
     *
     * @return The title of the playlist.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Set the title of the playlist.
     *
     * @param title Title of the playlist.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Notify all our observers who are observing the playlist.
     */
    public void notifyObservers() {
        System.out.print(this.observers);
        for (Observer observer : this.observers)
        {
            observer.update();
        }
    }

    /**
     * Register a new observer.
     *
     * @param observer The observer to register.
     */
    public void registerObserver(Observer observer)
    {
        observer.setPlaylist(this);
        this.observers.add(observer);
    }

    /**
     * Remove an observer.
     *
     * @param observer The observer to remove.
     */
    public void removeObserver(Observer observer)
    {
        this.observers.remove(observer);
    }

    /**
     * Get the playlist iterator.
     *
     * @return The iterator.
     */
    public PlaylistIterator getIterator() {
        return new PlaylistIterator();
    }

    /**
     * Iterator class for the songs in the playlist.
     */
    private class PlaylistIterator implements Iterator {

        int index;

        /**
         * Check if a next song is available.
         *
         * @return Returns true when a next song is available.
         */
        public boolean hasNext() {
            if (index < songs.size()) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * Check if a previous song is available.
         *
         * @return Returns true when a previous song is available.
         */
        public boolean hasPrevious() {
            if (index > songs.size()) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * Get the next object.
         *
         * @return The next song.
         */
        public Object next() {
            if (this.hasNext()) {
                return songs.get(index++);
            }
            return null;
        }

        /**
         * Get the previous object.
         *
         * @return The previous song.
         */
        public Object previous() {
            if (this.hasPrevious()) {
                return songs.get(index--);
            }
            return null;
        }

    }

}
