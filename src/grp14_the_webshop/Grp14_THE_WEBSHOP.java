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
public class Grp14_THE_WEBSHOP {
    
     private int memberShipCardID = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //RIP
        create100MemberShipCards();
    }
    
    private void create100MemberShipCards() {
        for (int i = 0; i < 100; i++) {
            new MemberShipCard(memberShipCardID++);
        }
    }
}
