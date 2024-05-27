package bsu.poznyak.projectmanagementapplication.dao;

import bsu.poznyak.projectmanagementapplication.models.User;

import java.util.Optional;

public interface IUserDaoRepository<T> extends IDaoRepository<T>{
    Optional<User> getByUsername(String username);

}
