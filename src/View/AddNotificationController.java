package View;

import Model.Notification;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import sample.Aview;
import sample.Main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class AddNotificationController extends Aview {
    public TextField UserId;
    public TextField EventId;
    public TextField Time;
    public TextField date;
    public TextArea body;
    public Label err;


    public void initialize()
    {


        UserId.setText(Main.loggedUser.getUserId());
        EventId.setText(String.valueOf(Main.EventId));
        date.setText(new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime()));
        Time.setText(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));
    }


    public void send() {
        if (body.getText().isEmpty())
            err.setText("*נא להכניס שדות חוקיים");
        else
        {
            int i= getController().AddNotification(new Notification(Integer.parseInt(UserId.getText()),Integer.parseInt(EventId.getText()),body.getText(),Time.getText(),date.getText(), "Active"));
            if(i==1)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"The Notification is Add!");  //new alert object
                alert.setResizable(false);
                Optional<ButtonType> result = alert.showAndWait();
                Main.switchScene("../View/MainScreen.fxml", Main.getStage(), 620, 400);





            }
        }

    }

    public void Back(ActionEvent actionEvent)
    {
        Main.switchScene("../View/MainScreen.fxml", Main.getStage(), 620, 400);
    }
}