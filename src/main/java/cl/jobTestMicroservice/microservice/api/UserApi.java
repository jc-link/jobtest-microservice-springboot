package cl.jobTestMicroservice.microservice.api;

import cl.jobTestMicroservice.microservice.model.User;
import cl.jobTestMicroservice.microservice.service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("user")
public class UserApi {


    @Autowired
    @Qualifier("userService")
    private UserInterface userInterface;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/getusers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers() {
        return userInterface.getUsers();
    }

}
