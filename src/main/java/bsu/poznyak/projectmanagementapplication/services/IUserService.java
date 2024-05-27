package bsu.poznyak.projectmanagementapplication.services;

import bsu.poznyak.projectmanagementapplication.models.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> Register(String username, String password);
    Optional<User> Login(String username, String password);
}
