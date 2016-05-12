package webshop.model.database;

public class DatabaseFacade {

    private static DatabaseConnector databaseConnector = new PostgresConnectionDriver();
    private static DatabaseFacade instance;

    private DatabaseFacade() {
    }

    public static DatabaseFacade getInstance() {
        if(instance == null) {
            instance = new DatabaseFacade();
        }
        return instance;
    }
}
