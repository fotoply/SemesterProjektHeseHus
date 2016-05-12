package webshop.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Handles transferring to and from persistent data.
 */
public class PersistenceFacade {
    private static PersistenceFacade instance;

    private PersistenceFacade() {

    }

    public static PersistenceFacade getInstance() {
        if(instance == null) {
            instance = new PersistenceFacade();
        }
        return instance;
    }

    public Customer getFromId(int customerId) {
        throw new NotImplementedException();
    }
}
