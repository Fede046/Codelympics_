package bmt.codelympics_.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import bmt.codelympics_.crypto.Encryptor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class PageAccedi extends ChangeStage{

    @FXML
    private Button btn_accediGo;

    @FXML
    private Button btn_annullaAcc;

    @FXML
    private Label lbl_error;

    @FXML
    private TextField txtField_username;
    @FXML
    private CheckBox checkbox_show;

    @FXML
    private TextField txtField_email;
    @FXML
    private ImageView img_avatar;
    @FXML
    private ImageView img_avatar2;
    @FXML
    private PasswordField hiddentxtField_psw;

    public TextField txtField_psw;

    // --------------------------------
    File file = new File("data.csv");
    HashMap<String, String> loginInfo = new HashMap<>();
    Encryptor encryptor = new Encryptor();

    @FXML
    void func_Home(MouseEvent event) throws Exception {
         // -----------------cambio stage home--------------------
            fuc_changeStage(btn_annullaAcc, "/bmt/codelympics_/fxml/home.fxml");
    }

    @FXML
    void func_goPlayHome(MouseEvent event) throws Exception {
        String username = txtField_username.getText();
        String password = hiddentxtField_psw.getText();
        updateLoginUsernamesAndPasswords();

        String encryptedPassword = loginInfo.get(username);
        if (encryptor.encryptString(password).equals(encryptedPassword)) {
            System.out.println("successfully login!");
             // -----------------cambio stage gamesHome--------------------
             fuc_changeStage(btn_accediGo, "/bmt/codelympics_/fxml/playGames.fxml");

            
        } else {
            lbl_error.setVisible(true);
        }
    }

   

    @FXML
    void func_changeVisibility(MouseEvent event) {
        if (checkbox_show.isSelected()) {
            txtField_psw.setText(hiddentxtField_psw.getText());
            txtField_psw.setVisible(true);
            hiddentxtField_psw.setVisible(false);
            img_avatar.setVisible(false);
            img_avatar2.setVisible(true);
            return;
        }
        hiddentxtField_psw.setText(txtField_psw.getText());
        hiddentxtField_psw.setVisible(true);
        txtField_psw.setVisible(false);
        img_avatar2.setVisible(false);
        img_avatar.setVisible(true);

    }

    private void updateLoginUsernamesAndPasswords() throws IOException {
        Scanner scanner = new Scanner(file);
        loginInfo.clear();
        loginInfo = new HashMap<>();
        while (scanner.hasNext()) {
            String[] usernameAndPassword = scanner.nextLine().split(",");
            loginInfo.put(usernameAndPassword[0], usernameAndPassword[1]);
        }
        scanner.close();
    }

}
