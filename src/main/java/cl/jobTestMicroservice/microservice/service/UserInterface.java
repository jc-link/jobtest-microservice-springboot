package cl.jobTestMicroservice.microservice.service;

import cl.jobTestMicroservice.microservice.model.User;

import java.util.List;


public interface UserInterface {
    List<User> getUsers();
}
