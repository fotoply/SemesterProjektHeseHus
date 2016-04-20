/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp14_the_webshop;

/**
 *
 * @author Karim
 */
public class Product {
    String type;
    Double price;
    int itemID;
    boolean currentlySelling;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Product) {
            if(type == ((Product) obj).type && price == ((Product) obj).price && itemID == ((Product) obj).itemID) {
                return true;
            }
        }
        return false;
    }
}
