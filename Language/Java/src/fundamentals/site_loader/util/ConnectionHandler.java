package fundamentals.site_loader.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ConnectionHandler {

    private static URLConnection getConnection(String url) throws IOException {

        URLConnection connection = new URL(url).openConnection();
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:47.0) Gecko/20100101 Firefox/47.0");
        connection.setConnectTimeout(50000);
        connection.setReadTimeout(50000);

        return connection;
    }

    private static String readData(BufferedReader bufferedReader) throws IOException {

        String currentString;
        StringBuilder sb = new StringBuilder();
        while (true) {
            currentString = bufferedReader.readLine();
            if (currentString == null) {
                break;
            }
            sb.append(currentString).append("\n");
        }

        return sb.toString();
    }

    public static String getDataFromSource(String urlConnection) {

        String data = "";
        for (int i = 0; i < 5; i++) {
            try {
                BufferedReader bis = new BufferedReader(new InputStreamReader(getConnection(urlConnection).getInputStream()));
                data = readData(bis);
                break;
            } catch (IOException e) {
                System.out.println("Something bad happened! (sad smile)");
                e.printStackTrace();
            }
        }
        return data;
    }

}
