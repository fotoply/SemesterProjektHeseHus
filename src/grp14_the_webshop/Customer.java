
package grp14_the_webshop;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;

/**
 *
 * @author Grp. 14
 */
public class Customer {
    String address;
    String email;
    String password;
    int phoneNumber;
    Date birthday;
    String name;
    
    public Customer(String name, String address, String email, String password, Date dayOfBirth, int phoneNumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        this.birthday = dayOfBirth;
        this.phoneNumber = phoneNumber;        
        
    }
    
    public void createNewOrder(){
        throw new NotImplementedException();
    }
    
    public void linkMemberShipCard(){
        throw new NotImplementedException();
    }
    
    public void addProduct(Product product, int amount){
        throw new NotImplementedException();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
