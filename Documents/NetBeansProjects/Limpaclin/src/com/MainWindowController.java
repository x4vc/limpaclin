/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.tableview.TblViewTipoExame;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Victor
 */
public class MainWindowController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    MenuItem MenuItemCadastrarLaudo; 
            
    @FXML
    MenuItem MenuItemTipoExame;
    
    @FXML
    MenuItem MenuItemPaciente;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleMenuItemCadastrarLaudo(ActionEvent event) throws IOException{
        //Mostramos uma nova janela chamada Tipo de Exame
        Parent parent;

        parent = FXMLLoader.load(getClass().getResource("/com/CadastrarLaudo.fxml"));

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Cadastro Atendimento Laboratorial");
        stage.getIcons().add(new Image("/resources/lab_24x24.png"));
        stage.setScene(scene);
        stage.show();
        
    }
    @FXML
    private void handleMenuItemTipoExameAction(ActionEvent event) throws IOException{
        //Mostramos uma nova janela chamada Tipo de Exame
        Parent parent;

        parent = FXMLLoader.load(getClass().getResource("/com/TipoExame.fxml"));

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Tipo de Exame");
        stage.getIcons().add(new Image("/resources/lab_24x24.png"));
        stage.setScene(scene);
        stage.show();
        
    }
     @FXML
    private void handleMenuItemPacientesAction(ActionEvent event) throws IOException{
        //Mostramos uma nova janela chamada Tipo de Exame
        Parent parent;

        parent = FXMLLoader.load(getClass().getResource("/com/Paciente.fxml"));

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Paciente");
        stage.getIcons().add(new Image("/resources/lab_24x24.png"));
        stage.setScene(scene);
        stage.show();
        
    }
    
}
