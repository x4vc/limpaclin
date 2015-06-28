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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import com.db.TipoExameQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.tableview.TblViewTipoExame;
import java.math.BigDecimal;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Victor
 */
public class TipoExameController implements Initializable {
    
    @FXML
    private Label LblTipoExamePesquisar;    
    @FXML
    private TextField txtProcurarTipoExame;    
    @FXML
    private Button btProcurarTipoExame;    
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
    private Label labelMessage;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNomeTipoExame;
    @FXML
    private TextField txtFator;    
    @FXML
    private CheckBox cBoxAtivoTipoExame;
    @FXML
    private Button btAddTipoExame;
    @FXML
    private Button btSalvar;
    @FXML
    private Button btUpdateTipoExame;
    @FXML
    private Button btCancelar;
    @FXML
    private Button btFecharTipoExame;
    @FXML
    private Button btAtualizar;
    
    private List<com.entity.TbTipoExame> l_listaTipoExame = new ArrayList<>();
    private TipoExameQuery consulta;//  = new TipoExameQuery();
    
    //private ObservableList<com.entity.TbTipoExame> o_listaTipoExame;
    private ObservableList<TblViewTipoExame> o_listaTipoExame;
    
    private String strAtivoTipoExame, strMessage, strNomeTipoExame;
    private Boolean bSelected, bCondicao;
    private int newId, atualId;
    private double d;
    private BigDecimal bd; // the value you get
    
    @FXML
    private void handleButtonFecharTipoExame(ActionEvent event) {
        Stage stage = (Stage) btFecharTipoExame.getScene().getWindow();
        stage.close();        
    }
    @FXML
    private void handleButtonProcurarTipoExame(ActionEvent event) {
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
            
            //labelMessage.setText("O campo Nome do Tipo de Exame não pode estar vazio");     
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Tipo de Exame");
            alert.setHeaderText("O campo Nome do Tipo de Exame não pode estar vazio");
            alert.setContentText("Por favor, preencher o campo Nome do Tipo de Exame");
            alert.showAndWait();
            
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

            //labelMessage.setText("Procurando Nomes do tipo Exame");
            
        }
    }
    
    @FXML
    private void handleButtonAddTipoExame(ActionEvent event) {
        txtId.clear();                            
        txtId.setEditable(false);
        txtNomeTipoExame.clear();
        txtNomeTipoExame.setEditable(true);
        txtFator.clear();                            
        txtFator.setEditable(true);
        cBoxAtivoTipoExame.setText("Ativado");
        cBoxAtivoTipoExame.setSelected(true);
        cBoxAtivoTipoExame.setDisable(false);
        btSalvar.setVisible(true);
        btAtualizar.setVisible(false);
        btCancelar.setVisible(true);
        btUpdateTipoExame.setDisable(true);
        btFecharTipoExame.setDisable(true);
        labelMessage.setText(null);
        btAddTipoExame.setDisable(true);
        tv_TipoExame.setDisable(true);
        btProcurarTipoExame.setDisable(true);
        txtProcurarTipoExame.setEditable(false);
            
        }
    @FXML
    private void handleButtonUpdateTipoExame(ActionEvent event) {
        if(txtNomeTipoExame.getText().equals("") || txtFator.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Tipo de Exame");
            alert.setHeaderText("Atualizar Tipo de Exame");
            alert.setContentText("Favor selecionar um Tipo de Exame para realizar atualização");
            alert.showAndWait();
            
        } else {
            //txtId.clear();                            
            txtId.setEditable(false);
            //txtNomeTipoExame.clear();
            txtNomeTipoExame.setEditable(true);
            //txtFator.clear();                            
            txtFator.setEditable(true);
            //cBoxAtivoTipoExame.setText("Ativado");
            //cBoxAtivoTipoExame.setSelected(true);
            cBoxAtivoTipoExame.setDisable(false);
            btSalvar.setVisible(false);
            btAtualizar.setVisible(true);
            btCancelar.setVisible(true);
            btUpdateTipoExame.setDisable(true);
            btFecharTipoExame.setDisable(true);
            labelMessage.setText(null);
            btAddTipoExame.setDisable(true);
            tv_TipoExame.setDisable(true);
            btProcurarTipoExame.setDisable(true);
            txtProcurarTipoExame.setEditable(false);
        }
            
    }
    @FXML
    private void handleButtonCancelarTipoExame(ActionEvent event) {
        txtId.clear();                            
        txtId.setEditable(false);
        txtNomeTipoExame.clear();
        txtNomeTipoExame.setEditable(false);
        txtFator.clear();                            
        txtFator.setEditable(false);
        cBoxAtivoTipoExame.setText("Ativado");
        cBoxAtivoTipoExame.setSelected(true);
        cBoxAtivoTipoExame.setDisable(true);
        btSalvar.setVisible(false);
        btAtualizar.setVisible(false);
        btCancelar.setVisible(false);
        btUpdateTipoExame.setDisable(false);
        btFecharTipoExame.setDisable(false);
        labelMessage.setText(null);
        btAddTipoExame.setDisable(false);
        tv_TipoExame.setDisable(false);
        btProcurarTipoExame.setDisable(false);
        txtProcurarTipoExame.setEditable(true);
        
    }
    @FXML
    private void handleButtonSalvarTipoExame(ActionEvent event) {
        if(txtNomeTipoExame.getText().equals("") || txtFator.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Tipo de Exame");
            alert.setHeaderText("Salvar Tipo de Exame");
            alert.setContentText("Favor preencher os campos Nome e Fator");
            alert.showAndWait();
            
        } else {
            // Criamos objeto cliente da clase TbCliente
            BigDecimal bd = new BigDecimal(txtFator.getText());
            d = bd.doubleValue(); // The double you want  
            bSelected = cBoxAtivoTipoExame.isSelected();       

            if (bSelected){
                strAtivoTipoExame = "S";

            } else {
                strAtivoTipoExame = "N";
            }


            consulta  = new TipoExameQuery();
            newId = consulta.SalvarTipoExame(txtNomeTipoExame.getText(), bd, bSelected);
            if(newId>0){
                //labelMessage.setText("Dados salvos com sucesso!!!");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Tipo de Exame");
                alert.setHeaderText("Salvar Tipo de Exame");
                alert.setContentText("Dados salvos com sucesso!!!");
                alert.showAndWait();
                o_listaTipoExame.add(new TblViewTipoExame(newId,txtNomeTipoExame.getText(),d,strAtivoTipoExame,"01012015"));
            } else {
                //labelMessage.setText("Erro!!!. Dados não foram salvos");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Tipo de Exame");
                alert.setHeaderText("Salvar Tipo de Exame");
                alert.setContentText("Erro!!!. Dados não foram salvos");
                alert.showAndWait();
            }


            // Resetamos os botões no seu estado original
            txtId.clear();                            
            txtId.setEditable(false);
            txtNomeTipoExame.clear();
            txtNomeTipoExame.setEditable(false);
            txtFator.clear();                            
            txtFator.setEditable(false);
            cBoxAtivoTipoExame.setText("Ativado");
            cBoxAtivoTipoExame.setSelected(true);
            cBoxAtivoTipoExame.setDisable(true);
            btSalvar.setVisible(false);
            btAtualizar.setVisible(false);
            btCancelar.setVisible(false);
            btUpdateTipoExame.setDisable(false);
            btFecharTipoExame.setDisable(false);
            btAddTipoExame.setDisable(false);
            tv_TipoExame.setDisable(false);
            btProcurarTipoExame.setDisable(false);
            txtProcurarTipoExame.setEditable(true);
        }
        
    }
     @FXML
    private void handleButtonAtualizarTipoExame(ActionEvent event) {
        if(txtNomeTipoExame.getText().equals("") || txtFator.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Tipo de Exame");
            alert.setHeaderText("Atualizar Tipo de Exame");
            alert.setContentText("Favor preencher os campos Nome e Fator");
            alert.showAndWait();
            
        } else {
            // Criamos objeto cliente da clase TbCliente
            int Indice;
            BigDecimal bd = new BigDecimal(txtFator.getText());
            d = bd.doubleValue(); // The double you want  
            bSelected = cBoxAtivoTipoExame.isSelected();
            atualId = Integer.parseUnsignedInt(txtId.getText());

            if (bSelected){
                strAtivoTipoExame = "S";

            } else {
                strAtivoTipoExame = "N";
            }       

            consulta  = new TipoExameQuery();
            newId = consulta.UpdateTipoExame(atualId, txtNomeTipoExame.getText(), bd, bSelected);
            if(newId>0){
                //labelMessage.setText("Dados salvos com sucesso!!!");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Tipo de Exame");
                alert.setHeaderText("Atualizar Tipo de Exame");
                alert.setContentText("Dados atualizados com sucesso!!!");
                alert.showAndWait();

                //Atualizamos o TableView
                if(tv_TipoExame.getSelectionModel().getSelectedItem() != null){
                    Indice  = tv_TipoExame.getSelectionModel().getSelectedIndex();
                    TblViewTipoExame TipoExame = tv_TipoExame.getSelectionModel().getSelectedItem();
                    TipoExame.setIdTipoExame(atualId);
                    TipoExame.setNomeTipoExame(txtNomeTipoExame.getText());
                    TipoExame.setFatorTipoExame(d);
                    TipoExame.setTipoExameAtivo(strAtivoTipoExame);

                    o_listaTipoExame.set(Indice, TipoExame);
                }                    
            } else {
                //labelMessage.setText("Erro!!!. Dados não foram salvos");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Tipo de Exame");
                alert.setHeaderText("Atualizar Tipo de Exame");
                alert.setContentText("Erro!!!. Dados não foram atualizados");
                alert.showAndWait();
            }

            // Resetamos os botões no seu estado original
            //txtId.clear();                            
            txtId.setEditable(false);
            //txtNomeTipoExame.clear();
            txtNomeTipoExame.setEditable(false);
            //txtFator.clear();                            
            txtFator.setEditable(false);
            cBoxAtivoTipoExame.setText(strAtivoTipoExame);
            cBoxAtivoTipoExame.setSelected(bSelected);
            cBoxAtivoTipoExame.setDisable(true);
            btSalvar.setVisible(false);
            btAtualizar.setVisible(false);
            btCancelar.setVisible(false);
            btUpdateTipoExame.setDisable(false);
            btFecharTipoExame.setDisable(false);
            btAddTipoExame.setDisable(false);
            tv_TipoExame.setDisable(false);
            btProcurarTipoExame.setDisable(false);
            txtProcurarTipoExame.setEditable(true);
        }
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
        consulta  = new TipoExameQuery();   
        l_listaTipoExame = consulta.listaTipoExame();
        o_listaTipoExame  = FXCollections.observableArrayList();    
        
        btSalvar.setVisible(false);
        btAtualizar.setVisible(false);
        btCancelar.setVisible(false);
        labelMessage.setText(null);
        tv_TipoExame.setDisable(false);
        
        btFecharTipoExame.setCancelButton(true);
        
        //CheckBox cBoxAtivoTipoExame = new CheckBox();
//        cBoxAtivoTipoExame.setIndeterminate(false);
//        cBoxAtivoTipoExame.setSelected(true);

        
        
        /*Integer Id;
        String nome;
        String Ativo;*/
        //tv_TipoExame = new TableView();
        for(com.entity.TbTipoExame l : l_listaTipoExame){
            bd = l.getFatorTipoExame();
            d = bd.doubleValue(); // The double you want        
            /*Id = l.getIdTipoExame();
            nome = l.getNomeTipoExame();
            Ativo = l.getTipoExameAtivo();*/
            
            o_listaTipoExame.add(new TblViewTipoExame(l.getIdTipoExame(),l.getNomeTipoExame(),d,l.getTipoExameAtivo(),"01012015"));
            //o_listaTipoExame.add(new TblViewTipoExame(Id,nome,d,Ativo));           
            
        }        
        //TblClId = new TableColumn("Id Tipo Exame");
        TblClId.setCellValueFactory(new PropertyValueFactory<TblViewTipoExame,Integer>("ip_idTipoExame"));
        //TblClTipoExame = new TableColumn("Tipo Exame");
        TblClTipoExame.setCellValueFactory(new PropertyValueFactory<TblViewTipoExame,String>("sp_nomeTipoExame"));
        //TblClFator = new TableColumn("Fator");
        TblClFator.setCellValueFactory(new PropertyValueFactory<TblViewTipoExame,Double>("dp_fatorTipoExame"));
        //TblClAtivo = new TableColumn("Ativo");
        TblClAtivo.setCellValueFactory(new PropertyValueFactory<TblViewTipoExame,String>("sp_tipoExameAtivo"));
        
        //tv_TipoExame.getColumns().addAll(TblClId, TblClTipoExame,TblClFator,TblClAtivo);
        tv_TipoExame.setItems(o_listaTipoExame);
        
        
        //Código para saber os valores dos campos da fila selecionada
        
//        TblViewTipoExame TipoExame = tv_TipoExame.getSelectionModel().getSelectedItem();
//        txtNomeTipoExame.appendText(TipoExame.getNomeTipoExame());
//        labelMessage.setText(TipoExame.getNomeTipoExame());
        
        tv_TipoExame.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
            //Check whether item is selected and set value of selected item to Label
                try{
                    if(tv_TipoExame.getSelectionModel().getSelectedItem() != null)
                        {    
                            TblViewTipoExame TipoExame = tv_TipoExame.getSelectionModel().getSelectedItem();
                            txtId.clear();
                            txtId.setText(Integer.toString(TipoExame.getId()));
                            txtId.setEditable(false);
                            txtNomeTipoExame.clear();
                            txtNomeTipoExame.setText(TipoExame.getNomeTipoExame());
                            txtNomeTipoExame.setEditable(false);
                            txtFator.clear();
                            txtFator.setText(Double.toString(TipoExame.getFatorTipoExame()));
                            txtFator.setEditable(false);

                            strAtivoTipoExame = TipoExame.getTipoExameAtivo(); 

                            if("S".equals(strAtivoTipoExame)){
                                //labelMessage.setText(strAtivoTipoExame);
                                cBoxAtivoTipoExame.setText("Ativado");
                                cBoxAtivoTipoExame.setSelected(true);
                                cBoxAtivoTipoExame.setDisable(true);
                                

                            }else {
                                //labelMessage.setText(strAtivoTipoExame);
                                cBoxAtivoTipoExame.setText("Desativado");
                                cBoxAtivoTipoExame.setSelected(false);
                                cBoxAtivoTipoExame.setDisable(true);
                            }
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                        //labelMessage.setText("Error on get row Data");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Tipo de Exame");
                        alert.setHeaderText("TableView");
                        alert.setContentText("Error on get row Data");
                        alert.showAndWait();
                    }   
                }
            });        
        } catch (Exception e) {
            e.printStackTrace();
            //labelMessage.setText("Error on Building TableView Data");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Tipo de Exame");
            alert.setHeaderText("TableView");
            alert.setContentText("Error on Building TableView Data");
            alert.showAndWait();
        }
    } 
    
    
}
