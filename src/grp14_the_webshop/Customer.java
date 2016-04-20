
package grp14_the_webshop;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Grp. 14
 */
public class Customer {
    String address;
    String email;
    byte[] password;
    int phoneNumber;
    Date birthday;
    String name;
    byte[] salt;
    
    public Customer(String name, String address, String email, String password, Date dayOfBirth, int phoneNumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.birthday = dayOfBirth;
        this.phoneNumber = phoneNumber;
        SecureRandom rnd = new SecureRandom();
        byte[] saltArray = new byte[32];
        rnd.nextBytes(saltArray);
        setPassword(password);
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

    public boolean isCorrectPassword(String comparisonPassword) {
        return this.password.equals(getPasswordHash(comparisonPassword));
    }

    public void setPassword(String password) {
        this.password = getPasswordHash(password);
    }

    public byte[] getPasswordHash(String password) {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory f = null;
        byte[] hash = new byte[32];
        try {
            f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hash = f.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return hash;
    }
}
