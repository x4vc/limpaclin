/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fxml_apoio;

import com.db.TipoExameQuery;
import com.tableview.TblViewTipoExame;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Victor
 */
public class ProcurarTipoExameController implements Initializable {
    @FXML
    Label LblTipoExamePesquisar;
    @FXML
    private Label labelMessage;
    @FXML
    private TextField txtProcurarTipoExame;    
    @FXML
    private Button btProcurarTipoExameApoio;    
    @FXML
    private TableView<TblViewTipoExame> tv_TipoExame;    
    @FXML
    private TableColumn TblClId;    
    @FXML
    private TableColumn TblClTipoExame;    
    @FXML
    private TableColumn TblClFator;
    @FXML
    private TableColumn TblClAtivo;
    @FXML
    private Button btSelecionarTipoExame;
    
    private List<com.entity.TbTipoExame> l_listaTipoExame = new ArrayList<>();
    private TipoExameQuery consulta;//  = new TipoExameQuery();
    
    //private ObservableList<com.entity.TbTipoExame> o_listaTipoExame;
    private ObservableList<TblViewTipoExame> o_listaTipoExame;
    
    private Boolean bCondicao;
    private String strNomeTipoExame;
    private double d;
    private BigDecimal bd; // the value you get
    
    private Stage dialogStage;
    private TblViewTipoExame TipoExame;
    private boolean okClicked = false;
     
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //preencherTableViewTipoExame();
            
    }
    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setTxtProcurarTipoExame(String strNomeTipoExame) {
        //this.txtProcurarTipoExame = txtProcurarTipoExame.setText(strNomeTipoExame);
        txtProcurarTipoExame.setText(strNomeTipoExame);
    }
    
    public void preencherTableViewTipoExame(){
        bCondicao = txtProcurarTipoExame.getText().isEmpty();
        consulta  = new TipoExameQuery();
        if (bCondicao){
            
            l_listaTipoExame = consulta.listaTipoExame();
            o_listaTipoExame  = FXCollections.observableArrayList();
            
            for(com.entity.TbTipoExame l : l_listaTipoExame){
                bd = l.getFatorTipoExame();
                d = bd.doubleValue(); // The double you want                   

                o_listaTipoExame.add(new TblViewTipoExame(l.getIdTipoExame(),l.getNomeTipoExame(),d,l.getTipoExameAtivo(),"01012015"));                        
            }        
        
            TblClId.setCellValueFactory(new PropertyValueFactory<TblViewTipoExame,Integer>("ip_idTipoExame"));        
            TblClTipoExame.setCellValueFactory(new PropertyValueFactory<TblViewTipoExame,String>("sp_nomeTipoExame"));        
            TblClFator.setCellValueFactory(new PropertyValueFactory<TblViewTipoExame,Double>("dp_fatorTipoExame"));        
            TblClAtivo.setCellValueFactory(new PropertyValueFactory<TblViewTipoExame,String>("sp_tipoExameAtivo"));
            tv_TipoExame.setItems(o_listaTipoExame);
    } else {
            strNomeTipoExame = txtProcurarTipoExame.getText();           
            
            l_listaTipoExame = consulta.listaProcurarNomeTipoExame(strNomeTipoExame);            
            o_listaTipoExame  = FXCollections.observableArrayList();
            
            for(com.entity.TbTipoExame l : l_listaTipoExame){
                bd = l.getFatorTipoExame();
                d = bd.doubleValue(); // The double you want                   

                o_listaTipoExame.add(new TblViewTipoExame(l.getIdTipoExame(),l.getNomeTipoExame(),d,l.getTipoExameAtivo(),"01012015"));                        
            }        
        
            TblClId.setCellValueFactory(new PropertyValueFactory<TblViewTipoExame,Integer>("ip_idTipoExame"));        
            TblClTipoExame.setCellValueFactory(new PropertyValueFactory<TblViewTipoExame,String>("sp_nomeTipoExame"));        
            TblClFator.setCellValueFactory(new PropertyValueFactory<TblViewTipoExame,Double>("dp_fatorTipoExame"));        
            TblClAtivo.setCellValueFactory(new PropertyValueFactory<TblViewTipoExame,String>("sp_tipoExameAtivo"));
            tv_TipoExame.setItems(o_listaTipoExame);
        }
    }
    /**
     * Called when the user clicks Selecionar.
     */
    @FXML
    private void handleSelecionar() {
        TblViewTipoExame selectedTipoExame = tv_TipoExame.getSelectionModel().getSelectedItem();
        if (selectedTipoExame != null) {
            try {
                 
                txtProcurarTipoExame.setText(selectedTipoExame.getNomeTipoExame());
                setTipoExame(selectedTipoExame);
                
//                int ID = selectedTipoExame.getId();
//                TipoExame.setIdTipoExame(ID);
//            TipoExame.setIdTipoExame(selectedTipoExame.getId());
//            TipoExame.setNomeTipoExame(selectedTipoExame.getNomeTipoExame());
//            TipoExame.setFatorTipoExame(selectedTipoExame.getFatorTipoExame());
//            TipoExame.setTipoExameAtivo(selectedTipoExame.getTipoExameAtivo());
            } catch (Exception e) {
                        e.printStackTrace();
                        labelMessage.setText("Error on get row Data");
            } 
                
            okClicked = true;
            dialogStage.close();
            
//            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
//            if (okClicked) {
//                showPersonDetails(selectedPerson);
//            }

        } else {
            // Nothing selected.
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Nada foi selecionado");
            alert.setHeaderText("Nenhum Tipo de Exame foi selecionado");
            alert.setContentText("Por favor, selecione um Tipo de Exame da tabela");
            alert.showAndWait();
        }
        
    }
    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }    
    public void setTipoExame(TblViewTipoExame tblTipoExame){
        labelMessage.setText(null);
        int n = tblTipoExame.getId();
        String strNome = tblTipoExame.getNomeTipoExame();
        d = tblTipoExame.getFatorTipoExame();
        String strAtivo = tblTipoExame.getTipoExameAtivo();
        String strLabel = "";
        strLabel = Integer.toString(n) + ";"+ strNome + ";" +Double.toString(d) + ";" + strAtivo;
        labelMessage.setText(strLabel);
        this.TipoExame = tblTipoExame;
        TipoExame.setIdTipoExame(tblTipoExame.getId());
        TipoExame.setNomeTipoExame(tblTipoExame.getNomeTipoExame());
        TipoExame.setFatorTipoExame(tblTipoExame.getFatorTipoExame());
        TipoExame.setTipoExameAtivo(tblTipoExame.getTipoExameAtivo());        
    }
    public String getNomeTipoExame(){        
        return txtProcurarTipoExame.getText();
    }
    public String getLabelTipoExame(){        
        return labelMessage.getText();
    }
    @FXML
    private void handleButtonProcurarTipoExame(ActionEvent event) throws IOException {
        preencherTableViewTipoExame();
    }
}
