package bmt.codelympics_.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import bmt.codelympics_.crypto.Encryptor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PageIscriviti {

    @FXML
    private Button btn_annullaAcc;

    @FXML
    private Button btn_iscrivitiGo;

    @FXML
    private CheckBox checkbox_show;

    @FXML
    private Label lbl_error;

    @FXML
    private TextField txtField_email;

    @FXML
    private PasswordField hiddentxtField_psw;

    public TextField txtField_psw;

    @FXML
    private TextField txtField_username;

    @FXML
    private ColorPicker colorChange;
    @FXML
    private Circle colorAvatar;

    // -------------------------------------------
//provavavavavvavava
    Encryptor encryptor = new Encryptor();
    File file = new File("data.csv");
    HashMap<String, String> loginInfo = new HashMap<>();

    @FXML
    void func_Home(MouseEvent event) throws Exception {
        // -----------------cambio stage home--------------------
        Stage stage1 = (Stage) btn_annullaAcc.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bmt/codelympics_/fxml/home.fxml"));
        Parent root = loader.load();
        stage1.setScene(new Scene(root));
    }

    @FXML
    void func_changeVisibility(MouseEvent event) {
        if (checkbox_show.isSelected()) {
            txtField_psw.setText(hiddentxtField_psw.getText());
            txtField_psw.setVisible(true);
            hiddentxtField_psw.setVisible(false);
            return;
        }
        hiddentxtField_psw.setText(txtField_psw.getText());
        hiddentxtField_psw.setVisible(true);
        txtField_psw.setVisible(false);
    }

    @FXML
    void func_goPlayHome(MouseEvent event) throws Exception {
        String username = txtField_username.getText();
        String mail = txtField_email.getText();
        String password = txtField_psw.getText();
        if(controlEqualsUsernameAndMail(username,mail)&&ContrlUsPswMail(username,password,mail)){
         //----------------cambio stage GamesHome-----------
         writeToFile();
         Stage stage1 = (Stage) btn_iscrivitiGo.getScene().getWindow();
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/bmt/codelympics_/fxml/playGames.fxml"));
         Parent root = loader.load();
         stage1.setScene(new Scene(root));
           
        }
        
        
    }
   

    private void seeUsernameAndMail() throws IOException {
        Scanner scanner = new Scanner(file);
        loginInfo.clear();
        loginInfo = new HashMap<>();
        while (scanner.hasNext()) {
            String[] usernameAndMail = scanner.nextLine().split(",");
            loginInfo.put(usernameAndMail[0], usernameAndMail[2]);
        }
        scanner.close();
    }

//uso di GPT https://chatgpt.com/share/ce867cef-dde3-443a-bda8-0c0b41584602
    boolean ContrlUsPswMail(String username,String password,String mail){
        if(!username.matches("[a-zA-Z0-9 ]*")) {lbl_error.setVisible(true);return false;}
        if(password.isBlank()) {lbl_error.setVisible(true);return false;}
        if(!mail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {lbl_error.setVisible(true);return false;}
    
        return true;
    }

    boolean controlEqualsUsernameAndMail(String username,String mail)throws Exception{
        seeUsernameAndMail();
        if(loginInfo.containsKey(username)){lbl_error.setVisible(true);return false;}
        if(loginInfo.containsValue(mail)) {lbl_error.setVisible(true); return false;}
        return true;
    }



    void writeToFile() throws Exception {
        String username = txtField_username.getText();
        String password = hiddentxtField_psw.getText();
        String email = txtField_email.getText();
        Paint colore = colorAvatar.getFill();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(username + "," + encryptor.encryptString(password) + "," + email + "," + colore + "\n");
        writer.close();
        System.out.print("FAttttttttto");
    }

    @FXML
    void setColor(ActionEvent event) {
        Color colore = colorChange.getValue();
        colorAvatar.setFill(colore);
    }

}
