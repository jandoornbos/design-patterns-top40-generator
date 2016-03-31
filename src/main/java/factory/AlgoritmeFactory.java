package factory;


public class AlgoritmeFactory
{
    public Algoritme getAlgoritme(String algoritme)
    {
        if (algoritme == null)
        {
            return null;
        }
        if (algoritme.equals("DutchPlaylistAlgoritme"))
        {
            return new DutchPlaylistAlgoritme();
        }
        else if (algoritme.equals("EnglishPlaylistAlgoritme"))
        {
            return new EnglishPlaylistAlgoritme();
        }
        return null;
    }
}