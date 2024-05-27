package bsu.poznyak.projectmanagementapplication.dao;

import bsu.poznyak.projectmanagementapplication.models.User;
import bsu.poznyak.projectmanagementapplication.services.IUserService;
import bsu.poznyak.projectmanagementapplication.services.ServiceFactory;
import bsu.poznyak.projectmanagementapplication.services.UserService;

import java.util.Optional;

public class DaoFactory {
    private DaoFactory(){}
    private static IGetConnection CONNECTION_POOL = null;
    private static class Holder {
        static final IUserDaoRepository<User> USER_DAO_REPOSITORY = new UserDAO(CONNECTION_POOL);
    }
    public static IUserDaoRepository<User> getUserDaoRepository() {
        return getUserDaoRepository(Optional.empty());
    }
    public static IUserDaoRepository<User> getUserDaoRepository(Optional<IGetConnection> connectionPool) {
        CONNECTION_POOL = connectionPool.orElseGet(ConnectionPool::new);
        return DaoFactory.Holder.USER_DAO_REPOSITORY;
    }
}
