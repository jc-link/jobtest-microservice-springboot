package cl.jobTestMicroservice.microservice.service;
import cl.jobTestMicroservice.microservice.model.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Service("userService")
public class UserService implements UserInterface{

    private static HttpURLConnection connection;


    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL("http://jsonplaceholder.typicode.com/users");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int httpStatus = connection.getResponseCode();

            if (httpStatus > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray usersJson = new JSONArray(responseContent.toString());

        for(int i = 0; i < usersJson.length(); i++) {
            JSONObject userJson = usersJson.getJSONObject(i);
            String name = userJson.getString("name");
            String username = userJson.getString("username");
            String email = userJson.getString("email");
            String company = userJson.getJSONObject("company").getString("name");
            users.add(new User(name, username, company, email));
        }
        return users;
    }
}
