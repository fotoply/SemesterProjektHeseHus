
package grp14_the_webshop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author Grp. 14
 */
public class CustomerManager {
    
    private List<Customer> CustomerList;
    
    public CustomerManager() {
        CustomerList = new ArrayList();
    }
    
    public void createNewOrder(){
        throw new NotImplementedException();
    }
    
    public void createCustomer(String name, String address, int phoneNumber, String email, String password, Date dayOfBirth){
        throw new NotImplementedException();
    }
    
    public Customer findCustomer(int customerID){
        
        throw new NotImplementedException();
    }
    
    public void deleteCustomer(int customerID){
        throw new NotImplementedException();
    }
    
    public void addproduct(Product product, int amount, int customerID){
        throw new NotImplementedException();
    }
}