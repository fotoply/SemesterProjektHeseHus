package webshop.view.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import webshop.model.Inventory.Item;

import java.math.BigDecimal;
import java.util.List;

public class BasketScreenController {

    private static final String BASKET_FORMAT_LOCALE = "%-30s %-16s %-10s";
    @FXML
    private TextField giftcodeTextArea;

    @FXML
    private RadioButton shopAddressRadio;

    @FXML
    private ToggleGroup deliveryToggleGroup;

    @FXML
    private RadioButton ownAddressRadio;

    @FXML
    private ListView<Text> basketListView;

    @FXML
    void initialize() {

    }

    /**
     * Adds the items from a list to the overview of the basket. Will format it.
     * @param items The list of items
     */
    public void applyBasket(List<Item> items, String totalPrice) {
        addItemToBasketList(String.format(BASKET_FORMAT_LOCALE, "Name", "Quantity", "Total price"));
        for (Item item: items) {
            addItemToBasketList(itemToString(item));
        }
        addItemToBasketList(formatTotal(totalPrice));
    }

    private void addItemToBasketList(String itemText) {
        basketListView.getItems().add(new Text(itemText));
    }

    private String formatTotal(String totalPrice) {
        return String.format(BASKET_FORMAT_LOCALE, " ", "Total: ", totalPrice);
    }

    /**
     * Takes the significant information about an item and returns it as a String.
     * @param item
     * @return A formatted String
     */
    private String itemToString(Item item) {
        return String.format(BASKET_FORMAT_LOCALE, item.getProduct().getName(), item.getQuantity(), item.getProduct().getPrice().getAmount().multiply(BigDecimal.valueOf(item.getQuantity())));
    }

    @FXML
    void applyCodeClicked(ActionEvent event) {

    }

    @FXML
    void payLaterClicked(ActionEvent event) {

    }

    @FXML
    void payNowClicked(ActionEvent event) {

    }

}
