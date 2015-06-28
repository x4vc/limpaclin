/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.db.LoginQuery;
import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 *
 * @author Victor
 */
public class LoginController implements Initializable {
    
    @FXML
    private TextField TxtUsername;
    @FXML
    private PasswordField PwdSenha;
    @FXML
    private Label labelUsername;
    @FXML
    private Label labelSenha;
    @FXML
    private Button btOk;
    @FXML
    private Label labelMessage;
    
    private List<com.entity.TbUsername> listaUsuarios = new ArrayList<>();
    private LoginQuery consulta  = new LoginQuery();  
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        listaUsuarios = consulta.listaUsername();
        btOk.setDefaultButton(true);
    }    
    
    @FXML
    private void handleButtonOKAction(ActionEvent event) throws IOException {
               
        for(com.entity.TbUsername l : listaUsuarios){
            if(TxtUsername.getText().equals(l.getNomeUsuario())){
                if(PwdSenha.getText().equals(l.getSenha())){
                    //Ocultamos a janela de login
                    (((Node)event.getSource()).getScene()).getWindow().hide();
                    
                    
                    //Mostramos uma nova janela chamada MainWindow
                    Parent parent;
                    
                    parent = FXMLLoader.load(getClass().getResource("/com/MainWindow.fxml"));
                    
                   
                    Scene scene = new Scene(parent);
                    Stage stage = new Stage();
                    stage.setTitle("Limpaclin");
                    //set icon
                    stage.getIcons().add(new Image("/resources/lab_24x24.png"));
                    
                    stage.setScene(scene);
                    stage.show();
                } else {
                    // Show the error message.
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Senha errada");
                    alert.setContentText("Por favor preencha o campo com a senha correta");
                    alert.showAndWait();                    
                }
                
            } else {
                // Show the error message.
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Usuário errado");
                alert.setContentText("Por favor preencha o campo com usuário correto");
                alert.showAndWait();
            }
        }       
     
    }  
}
