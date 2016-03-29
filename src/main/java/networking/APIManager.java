package networking;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import model.Playlist;

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
     */
    public void postPlaylistToWebservice(Playlist playlist) {

        // Make some JSON
        String jsonString = "{ \"title\" : \"" + playlist.getTitle() + "\" }";

        Future<HttpResponse<JsonNode>> request = Unirest.post(BASE_URL + "playlist/upload")
                .body(jsonString)
                .asJsonAsync(new Callback<JsonNode>() {

                    public void completed(HttpResponse<JsonNode> httpResponse) {
                        System.out.println("Playlist on server updated");
                    }

                    public void failed(UnirestException e) {
                        System.out.println("Playlist on server updating failed");
                    }

                    public void cancelled() {
                        System.out.println("Upload action cancelled.");
                    }

                });

    }

}
