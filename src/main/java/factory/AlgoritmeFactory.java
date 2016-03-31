package factory;


public class AlgoritmeFactory
{
    /**
     * Get the algorithm.
     *
     * @param algoritme The string of the algorithm to use.
     * @return An algorithm.
     */
    public Algoritme getAlgoritme(String algoritme)
    {
        // No string, you no get algorithm
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