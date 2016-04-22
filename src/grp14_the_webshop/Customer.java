package grp14_the_webshop;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author Grp. 14
 */
public class Customer {
    private String address;
    private String email;
    private byte[] password;
    private int phoneNumber;
    private Date birthday;
    private String name;
    private byte[] salt = new byte[32];
    private List<MemberShipCard> memberShipCards;

    public Customer(String name, String address, String email, String password, Date dayOfBirth, int phoneNumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.birthday = dayOfBirth;
        this.phoneNumber = phoneNumber;
        SecureRandom rnd = new SecureRandom();
        rnd.nextBytes(salt);
        setPassword(password);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();

        Customer c = new Customer("Bob", "bob", "bob", "bob", new Date(), 1);
        System.out.println("Hashed password is: ");
        System.out.println(toBase64(c.getPasswordHash(password)));
        password = input.nextLine();
        System.out.println("And again");
        System.out.println(toBase64(c.getPasswordHash(password)));

    }

    private static String toBase64(byte[] array) {
        return DatatypeConverter.printBase64Binary(array);
    }

    public void createNewOrder() {
        throw new NotImplementedException();
    }

    public void linkMemberShipCard(int id) {
    /*    MemberShipCard e = MemberShipCard.getMemberShipCard(id);
        memberShipCards.add(e);*/
        throw new NotImplementedException();
    }

    public void addProduct(Product product, int amount) {
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

    //TODO implement constant-time comparison to avoid timing attacks
    public boolean isCorrectPassword(String comparisonPassword) {
        return this.password.equals(getPasswordHash(comparisonPassword));
    }

    public void setPassword(String password) {
        this.password = getPasswordHash(password);
    }

    private byte[] getPasswordHash(String password) {
        KeySpec keySpecification = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory secretKeyFactory;
        byte[] hash = new byte[32];
        try {
            secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hash = secretKeyFactory.generateSecret(keySpecification).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return hash;
    }
}
