package bsu.poznyak.projectmanagementapplication.services;

public class ServiceFactory {

    private ServiceFactory() {
    }

    private static class Holder {
        static final IUserService USER_SERVICE_INSTANCE = new UserService();
    }

    public static IUserService getUserService() {
        return Holder.USER_SERVICE_INSTANCE;
    }
}
