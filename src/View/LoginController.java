package View;

import Model.User;
import javafx.scene.control.*;
import sample.Aview;
import sample.Main;
import java.sql.SQLException;


public class LoginController extends Aview {
    public Button LoginButton;
    public TextField Usernamefield;
    public PasswordField Passwordfield;
    public Label erorm2;



    public void Loginclicked() throws SQLException {

        User rs ;
        if (isFilednotempty(Usernamefield.getText(), Passwordfield.getText())) {
            rs = super.getController().search_username(Usernamefield.getText());
            if (rs != null) {
                if (rs.getPassword().equals(Passwordfield.getText())) {
                    erorm2.setText("");
                    Main.loggedUser = rs;

                    Main.switchScene("../View/MainScreen.fxml", Main.getStage(), 660, 430);
                } else {
                    erorm2.setText("*שם משתמש או סיסמא לא נכונים");
                }

            }
            else
                erorm2.setText("*שם משתמש לא קיים");

        } else
            erorm2.setText("*נא להכניס שדות חוקיים");
    }




    private boolean isFilednotempty(String user, String Pass) {
        return !user.isEmpty() && !Pass.isEmpty();
    }





}