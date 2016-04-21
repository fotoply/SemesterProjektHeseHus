package grp14_the_webshop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grp.14
 */
public class MemberShipCard {

    private int memberShipID;
    private List<MemberShipCard> memberShipCard = new ArrayList();

    public MemberShipCard(int id) {
        this.memberShipID = id;
        memberShipCard.add(this);
    }

    public MemberShipCard getMemberShipCard(int id) {
        return memberShipCard.get(id);
    }
}
