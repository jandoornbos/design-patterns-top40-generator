package model;

import observer.Observer;
import observer.Subject;

import java.util.ArrayList;


public class Playlist implements Subject {

    private String title;
    private ArrayList<Song> songs;

    private ArrayList<Observer> observers;

    public Playlist() {
        songs = new ArrayList<Song>();
        observers = new ArrayList<Observer>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void notifyObservers() {
        System.out.print(this.observers);
        for (Observer observer : this.observers)
        {
            observer.update();
        }
    }

    public void registerObserver(Observer observer)
    {
        observer.setPlaylist(this);
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer)
    {
        this.observers.remove(observer);
    }

}
