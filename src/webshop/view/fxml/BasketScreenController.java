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

    private static final String BASKET_FORMAT_LOCALE = "%-35s %-13s %10s";
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
    public void applyBasket(List<Item> items) {
        basketListView.getItems().add(new Text(String.format(BASKET_FORMAT_LOCALE, "Name", "Quantity", "Total price")));
        for (Item item: items) {
            basketListView.getItems().add(new Text(itemToString(item)));
        }
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
