package webshop.view.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import webshop.model.Inventory.Item;
import webshop.view.GUIController;

import java.math.BigDecimal;
import java.util.List;

public class BasketScreenController {

    private static final String BASKET_FORMAT_LOCALE = "%-36s%-16s%-14s";
    @FXML
    private TextField giftcodeTextArea;

    @FXML
    private RadioButton shopAddressRadio;

    @FXML
    private ToggleGroup deliveryToggleGroup;

    @FXML
    private RadioButton ownAddressRadio;

    @FXML
    private ListView<Label> basketListView;

    @FXML
    void initialize() {

    }

    /**
     * Adds the items from a list to the overview of the basket. Will format it.
     *
     * @param items The list of items
     */
    public void applyBasket(List<Item> items, String totalPrice) {
        addItemToBasketList(String.format(BASKET_FORMAT_LOCALE, "Name", "Quantity", "Total price"));
        for (Item item : items) {
            addItemToBasketList(formatItem(item));
        }
        addItemToBasketList(formatTotal(totalPrice));
    }

    private void addItemToBasketList(String itemText) {
        Label item = new Label(itemText);
        basketListView.getItems().add(item);
    }

    private String formatTotal(String totalPrice) {
        totalPrice = totalPrice.trim();
        return String.format(BASKET_FORMAT_LOCALE, " ", "Total: ", totalPrice);
    }

    /**
     * Takes the significant information about an item and returns it as a String.
     *
     * @param item
     * @return A formatted String
     */
    private String formatItem(Item item) {
        return String.format(BASKET_FORMAT_LOCALE, item.getProduct().getName().trim(), item.getQuantity(), item.getProduct().getPrice().getAmount().multiply(BigDecimal.valueOf(item.getQuantity())));
    }

    @FXML
    void applyCodeClicked(ActionEvent event) {
        GUIController.getWebshopInstance().applyGiftCard(1);

    }

    @FXML
    void payLaterClicked(ActionEvent event) {

    }

    @FXML
    void payNowClicked(ActionEvent event) {

    }

}
