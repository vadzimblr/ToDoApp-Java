package bsu.poznyak.projectmanagementapplication.services;

public class ServiceFactory {

    private ServiceFactory() {
    }

    private static class Holder {
        static final IUserService USER_SERVICE_INSTANCE = new UserService();
        static final ITaskService TASK_SERVICE_INSTANCE = new TaskService();
    }

    public static IUserService getUserService() {
        return Holder.USER_SERVICE_INSTANCE;
    }
    public static ITaskService getTaskService() {
        return Holder.TASK_SERVICE_INSTANCE;
    }
}
