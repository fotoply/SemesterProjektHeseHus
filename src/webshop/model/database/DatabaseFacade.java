package webshop.model.database;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DatabaseFacade {

    private static DatabaseConnector databaseConnector = new PostgresConnectionDriver();
    private static DatabaseFacade instance;

    private DatabaseFacade() {
        databaseConnector.getConnection();
    }

    public static DatabaseFacade getInstance() {
        if(instance == null) {
            instance = new DatabaseFacade();
        }
        return instance;
    }

    public String getCustomerName(int customerId) {
        throw new NotImplementedException();
    }

    public int getCustomerIdFromEmail(String email) {
        throw new NotImplementedException();
    }
}
