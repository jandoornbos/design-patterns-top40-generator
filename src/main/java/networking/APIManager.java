package networking;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import model.Playlist;
import model.Song;

import java.util.concurrent.Future;

/**
 * Singleton class to talk with API.
 */

public class APIManager
{

    static final String BASE_URL = "http://top40.doornbosagrait.tk/";

    private static APIManager sharedInstance = new APIManager();

    /**
     * Get the shared instance.
     * @return APIManager
     */
    public static APIManager getInstance()
    {
        return sharedInstance;
    }

    /**
     * Constructor.
     */
    private APIManager()
    {
    }

    /**
     * Upload a playlist to the webserver.
     * If succesfully you can see the playlist on a webpage.
     *
     * The consoles prints the {id} of the playlist. URL:
     * http://top40.doornbosagrait.tk/playlist/show/{id}
     *
     * @param playlist The playlist to upload
     */
    public void postPlaylistToWebservice(Playlist playlist) {

        StringBuilder jsonString = new StringBuilder();
        // Make some JSON
        jsonString.append("{ \"title\" : \"" + playlist.getTitle() + "\", \"songs\" : [ ");

        // Loop through the songs
        for (int i = 0; i < playlist.getSongs().size(); i++)
        {

            Song song = playlist.getSongs().get(i);

            jsonString.append("{" +
                    "\"title\" : \"" + song.getTitle() + "\"," +
                    "\"album\" : \"" + song.getAlbum() + "\"," +
                    "\"artist\" : \"" + song.getArtist() + "\"," +
                    "\"url\" : \"" + song.getFile() + "\"");

            // If it is our last song, close our JSON array
            if (i + 1 == playlist.getSongs().size())
            {
                jsonString.append("}");
            }
            else
            {
                jsonString.append("}, ");
            }

        }
        jsonString.append("] }");
        String string = jsonString.toString();
        System.out.println(string);

        // Make the request
        Future<HttpResponse<JsonNode>> request = Unirest.post(BASE_URL + "playlist/upload")
                .body(string)
                .asJsonAsync(new Callback<JsonNode>() {

                    public void completed(HttpResponse<JsonNode> httpResponse)
                    {
                        JsonNode json = httpResponse.getBody();
                        System.out.print(json.toString());
                    }

                    public void failed(UnirestException e)
                    {
                        System.out.println("Playlist on server updating failed");
                    }

                    public void cancelled()
                    {
                        System.out.println("Upload action cancelled.");
                    }

                });

    }

}
