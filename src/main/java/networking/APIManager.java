package networking;

public class APIManager {

    private static APIManager sharedInstance = new APIManager();

    public static APIManager getInstance() {
        return sharedInstance;
    }

    private APIManager() {

    }

}
