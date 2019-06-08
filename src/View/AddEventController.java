package View;
import javafx.event.Event;
import javafx.event.EventHandler;
import Model.Category;
import Model.Organization;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import sample.Aview;

public class AddEventController extends Aview {

    @FXML
    public TextField txt_eventTitle;
    public ChoiceBox choice_categories;
    public ChoiceBox choice_Organization;
    public TextArea txt_initUpdate;
    public ListView list_categories;

    ObservableList<Organization> organizations;
    ObservableList<Category> categories;
    public void initialize() {
        organizations = getController().getAllOrganizations();
        categories = getController().getAllCategories();
        choice_Organization.setItems(organizations);
        choice_categories.setItems(categories);

        list_categories.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        list_categories.setItems(categories);
        list_categories.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                ObservableList<Category> selectedItems =  list_categories.getSelectionModel().getSelectedItems();

                for(Category s : selectedItems){
                    System.out.println("selected item " + s);
                }

            }

        });
    }

    public void saveclicked(MouseEvent mouseEvent) {
    }

    public void cancelclicked(MouseEvent mouseEvent) {
    }
}
