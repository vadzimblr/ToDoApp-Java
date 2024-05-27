package bsu.poznyak.projectmanagementapplication.services;

import bsu.poznyak.projectmanagementapplication.dao.DaoFactory;
import bsu.poznyak.projectmanagementapplication.dao.IUserDaoRepository;
import bsu.poznyak.projectmanagementapplication.models.User;

import java.util.Optional;

public class UserService implements IUserService{
    private User user;
    private final static int MIN_USERNAME_LENGTH = 4;
    private final static int MIN_PASSWORD_LENGTH = 6;
    private final IUserDaoRepository<User> userDaoRepository = DaoFactory.getUserDaoRepository();

    @Override
    public Optional<User> Register(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty() ||
                username.length() < MIN_USERNAME_LENGTH || password.length() < MIN_PASSWORD_LENGTH) {
            return Optional.empty();
        }
        if (userDaoRepository.getByUsername(username).isPresent()) {
            return Optional.empty();
        }
        var newUser = new User(null, username, password);
        userDaoRepository.insert(newUser);
        return Optional.of(newUser);
    }

    @Override
    public Optional<User> Login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return Optional.empty();
        }
        var user = userDaoRepository.getByUsername(username);
        if(user.isEmpty() || !password.equals(user.get().getPassword()))
        {
            return Optional.empty();
        }
        return user;
    }


}

