/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.db.PacienteQuery;
import com.tableview.TblViewPaciente;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

    
/**
 * FXML Controller class
 *
 * @author victorcmaf
 */
public class PacienteController implements Initializable {
    
    @FXML
    private Label LblNomePacientePesquisar;    
    @FXML
    private TextField txtProcurarPaciente;    
    @FXML
    private Button btProcurarPaciente;    
    @FXML
    private TableView<TblViewPaciente> tv_Paciente;    
    @FXML
    private TableColumn TblClId;    
    @FXML
    private TableColumn TblClRG;    
    @FXML
    private TableColumn TblClNomePaciente;        
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNomePaciente;
    @FXML
    private TextField txtRG;        
    @FXML
    private DatePicker dtNascimento;        
    @FXML
    private TextField txtCPF;
    @FXML
    private Button btAddPaciente;
    @FXML
    private Button btSalvar;
    @FXML
    private Button btUpdatePaciente;
    @FXML
    private Button btCancelar;
    @FXML
    private Button btFecharPaciente;
    @FXML
    private Button btAtualizar;
    
    private List<com.entity.TbPaciente> l_listaPaciente = new ArrayList<>();
    private PacienteQuery consulta;//  = new TipoExameQuery();
        
    private ObservableList<TblViewPaciente> o_listaPaciente;
    
    private Boolean bCondicao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO             
        Botoes_VisibleFalse();        
        btFecharPaciente.setCancelButton(true);
        
        consulta  = new PacienteQuery();   
        l_listaPaciente = consulta.listaPaciente();
        o_listaPaciente  = FXCollections.observableArrayList();    
        
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        Date data;
        String strDataformatada; // = (dataLaudo.getValue()).format(formatter);
        
        for(com.entity.TbPaciente l : l_listaPaciente){
            
            data = l.getDtNascimentoPaciente();
            strDataformatada = dataFormatada.format(data);
            
            
            o_listaPaciente.add(new TblViewPaciente(l.getIdPaciente(),l.getNomePaciente(),strDataformatada,l.getSexoPaciente(),l.getRgPaciente(),l.getCPFpaciente()));                 
            
        }        
        
        TblClId.setCellValueFactory(new PropertyValueFactory<TblViewPaciente,Integer>("ip_idPaciente"));
        TblClRG.setCellValueFactory(new PropertyValueFactory<TblViewPaciente,String>("sp_RGPaciente"));        
        TblClNomePaciente.setCellValueFactory(new PropertyValueFactory<TblViewPaciente,String>("sp_nomePaciente"));
        
        tv_Paciente.setItems(o_listaPaciente);
    }   
    
    public void Botoes_VisibleFalse(){
        btSalvar.setVisible(false);
        btAtualizar.setVisible(false);
        btCancelar.setVisible(false);        
        tv_Paciente.setDisable(false);
        
    }
    
    @FXML
    private void handleButtonProcurarPaciente(ActionEvent event) {
        bCondicao = txtProcurarPaciente.getText().isEmpty();
        String strNomePaciente = txtProcurarPaciente.getText();
        consulta  = new PacienteQuery();
        if (bCondicao){
            
            //Se for == empty então resetamos o TableView para mostrar todos os registros
            l_listaPaciente = consulta.listaPaciente();
            o_listaPaciente  = FXCollections.observableArrayList(); 
        
            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            Date data;
            String strDataformatada; // = (dataLaudo.getValue()).format(formatter);

            for(com.entity.TbPaciente l : l_listaPaciente){
                data = l.getDtNascimentoPaciente();
                strDataformatada = dataFormatada.format(data);

                o_listaPaciente.add(new TblViewPaciente(l.getIdPaciente(),l.getNomePaciente(),strDataformatada,l.getSexoPaciente(),l.getRgPaciente(),l.getCPFpaciente()));                 
            }        

            TblClId.setCellValueFactory(new PropertyValueFactory<TblViewPaciente,Integer>("ip_idPaciente"));
            TblClRG.setCellValueFactory(new PropertyValueFactory<TblViewPaciente,String>("sp_RGPaciente"));        
            TblClNomePaciente.setCellValueFactory(new PropertyValueFactory<TblViewPaciente,String>("sp_nomePaciente"));

            tv_Paciente.setItems(o_listaPaciente);
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Paciente");
            alert.setHeaderText("O campo Nome do Paciente não pode estar vazio");
            alert.setContentText("Por favor, preencher o campo Nome do Paciente");
            alert.showAndWait();
        }
        else {
            l_listaPaciente = consulta.listaProcurarNomePaciente(strNomePaciente);
            o_listaPaciente  = FXCollections.observableArrayList(); 
        
            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            Date data;
            String strDataformatada; // = (dataLaudo.getValue()).format(formatter);

            for(com.entity.TbPaciente l : l_listaPaciente){
                data = l.getDtNascimentoPaciente();
                strDataformatada = dataFormatada.format(data);

                o_listaPaciente.add(new TblViewPaciente(l.getIdPaciente(),l.getNomePaciente(),strDataformatada,l.getSexoPaciente(),l.getRgPaciente(),l.getCPFpaciente()));                 
            }        

            TblClId.setCellValueFactory(new PropertyValueFactory<TblViewPaciente,Integer>("ip_idPaciente"));
            TblClRG.setCellValueFactory(new PropertyValueFactory<TblViewPaciente,String>("sp_RGPaciente"));        
            TblClNomePaciente.setCellValueFactory(new PropertyValueFactory<TblViewPaciente,String>("sp_nomePaciente"));

            tv_Paciente.setItems(o_listaPaciente);
        }
            
    }
    
}
