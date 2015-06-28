/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.fxml_apoio.ProcurarTipoExameController;
import com.tableview.TblViewTipoExame;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;




/**
 * FXML Controller class
 *
 * @author Victor
 */
public class CadastrarLaudoController implements Initializable {
    @FXML
    private TextField txtNomeTipoExame;
    @FXML
    private TextField txtFator;
    @FXML
    private Button btProcurarTipoExame;
    @FXML
    private Button btInserirExameSolicitado;
    @FXML
    private Button btExcluirExameSolicitado;
    @FXML
    private Button btImprimirAtendimento;
    @FXML
    private TextField txtId;
    @FXML
    private CheckBox cBoxAtivoTipoExame;
    @FXML
    private TableView<TblViewTipoExame> tv_TipoExame;    
    @FXML
    private TableColumn TblClId;    
    @FXML
    private TableColumn TblClTipoExame;    
    @FXML
    private TableColumn TblClFator;
    @FXML
    private TableColumn TblClData;
    @FXML
    private TextField txtQtdeItens;
    @FXML
    private TextField txtTotal;
    @FXML
    private TextField txtTemp;
    @FXML
    private TextField txtTemp2;
    @FXML
    private Label labelMessage;   
    @FXML
    private DatePicker dataLaudo;
    
    private boolean bShowDialog = false;
    private TblViewTipoExame TipoExame;
    
    //private ObservableList<com.entity.TbTipoExame> o_listaTipoExame;
    private ObservableList<TblViewTipoExame> o_listaTipoExame;
    
        
    //private double d;
    private Double d;
    private BigDecimal bd;
    private Integer nItens;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        o_listaTipoExame  = FXCollections.observableArrayList();
        dataLaudo.setValue(LocalDate.now());
        
    
    }
    @FXML
    private void handleButtonProcurarTipoExame(ActionEvent event) throws IOException {
        
        //Mostramos uma nova janela chamada Tipo de Exame
        //String strNomeTipoExame = txtNomeTipoExame.getText();
//        Parent parent;
//
//        parent = FXMLLoader.load(getClass().getResource("/com/fxml_apoio/ProcurarTipoExame.fxml"));
//
//        Scene scene = new Scene(parent);
//        Stage stage = new Stage();
//        stage.setTitle("Procurar Tipo Exame");
//        stage.setScene(scene);
//        stage.show();
        try {
            //txtNomeTipoExame.textProperty().addListener((observable, oldValue, newValue) -> showTipoExameDetails(newValue));
            bShowDialog = ShowTipoExamedialog();
        //
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/fxml_apoio/ProcurarTipoExame.fxml"));     
//
//        Parent root = (Parent)fxmlLoader.load();          
//        ProcurarTipoExameController controller = fxmlLoader.<ProcurarTipoExameController>getController();
//        
//        controller.setTxtProcurarTipoExame(strNomeTipoExame);
//        controller.preencherTableViewTipoExame();
//        
//        Scene scene = new Scene(root); 
//        Stage stage = new Stage();
            
//        stage.setScene(scene);    
//        stage.show();  
       
        
        
        
        } catch (Exception e) {
            e.printStackTrace();
            labelMessage.setText("Erro load fxml");
        }   
            
        
        
//                        alert.setTitle("Confirmation Dialog");
//                        alert.setHeaderText("Look, a Confirmation Dialog");
//                        alert.setContentText("Are you ok with this?");
//                        
//        alert.show();

//                        Optional<ButtonType> result = alert.showAndWait();
//                        if (result.get() == ButtonType.OK){
//                            // ... user chose OK
//                        } else {
//                            // ... user chose CANCEL or closed the dialog
//                        }
        

        } 
    private boolean ShowTipoExamedialog() throws IOException{
        try{
     //-------------------------------------------------------------
        // Load the fxml file and create a new stage for the popup dialog.
        String strNomeTipoExame = txtNomeTipoExame.getText();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainWindowController.class.getResource("/com/fxml_apoio/ProcurarTipoExame.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Create the dialog Stage.
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Tipo de Exame");
        dialogStage.getIcons().add(new Image("/resources/lab_24x24.png"));
        dialogStage.initModality(Modality.WINDOW_MODAL);
        //dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Set the person into the controller.
        ProcurarTipoExameController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        //controller.setPerson(person);
        controller.setTxtProcurarTipoExame(strNomeTipoExame);
        controller.preencherTableViewTipoExame();

        // Show the dialog and wait until the user closes it
        dialogStage.showAndWait();        
        
        txtNomeTipoExame.setText(controller.getNomeTipoExame());
        labelMessage.setText(controller.getLabelTipoExame());
        String strTemp = labelMessage.getText();
        String [] strFinal = strTemp.split(";",4);
        int n = 0;
        for(String str : strFinal){
            switch (n) {
                case 0:
                    txtId.setText(str);
                    //System.out.println("ID = " + str);
                    break;
                case 1: 
                    txtTemp2.setText(str);
                    //System.out.println("Nome = " + str);                    
                    break;
                
                case 2:        
                    txtFator.setText(str);
                    System.out.println("Fator = " + str);
                    break;
                case 3:        
                    if ("S".equals(str)){
                        cBoxAtivoTipoExame.setSelected(true);
                    } else {
                        cBoxAtivoTipoExame.setSelected(false);
                    }
                    //txtTemp.setText(str);
                    //System.out.println("Ativo = " + str);
                    break;
                default:
                    //statements // they are executed if none of the above case is satisfied
                    break;
                
            }
            n++;
          //System.out.println(str);
      }

        return controller.isOkClicked();
            //return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
    * Fills all text fields to show details about the person.
    * If the specified person is null, all text fields are cleared.
    * 
    * @param person the person or null
    */
    private void showTipoExameDetails(TblViewTipoExame TipoExame) {
        
        if (TipoExame != null) {            
            // Fill the labels with info from the person object.
            txtNomeTipoExame.setText(TipoExame.getNomeTipoExame());
//            lastNameLabel.setText(person.getLastName());
//            streetLabel.setText(person.getStreet());
//            postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
//            cityLabel.setText(person.getCity());
//
//            // TODO: We need a way to convert the birthday into a String! 
//            // birthdayLabel.setText(...);
//            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
        } else {
            // Person is null, remove all the text.
            txtNomeTipoExame.setText("");
            
//            lastNameLabel.setText("");
//            streetLabel.setText("");
//            postalCodeLabel.setText("");
//            cityLabel.setText("");
//            birthdayLabel.setText("");
        }
    }
    
    @FXML
    private void handleButtonInserirExameSolicitado(ActionEvent event) throws IOException {
        //o_listaTipoExame  = FXCollections.observableArrayList();
        String strId = txtId.getText() ;
        if (strId.equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Tipo de Exame sem dados");
            alert.setHeaderText("Faltam dados do Tipo de Exame para inserir");
            alert.setContentText("Por favor selecione um Tipo de Exame");
            alert.showAndWait();
        } else {
            
            Integer nId = Integer.parseInt(txtId.getText());
            //Integer nItens;            
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String strDataformatada = (dataLaudo.getValue()).format(formatter);
            
            bd = new BigDecimal(txtFator.getText());
            d = bd.doubleValue();
            try{
            //o_listaTipoExame.add(new TblViewTipoExame(1,"Teste",10.55,"S","01012015"));
            o_listaTipoExame.add(new TblViewTipoExame(nId,txtNomeTipoExame.getText(),d,"S",strDataformatada));
            }
            catch(Exception e){
                System.out.println(e);

            }

            TblClId.setCellValueFactory(new PropertyValueFactory<>("ip_idTipoExame"));        
            TblClTipoExame.setCellValueFactory(new PropertyValueFactory<TblViewTipoExame,String>("sp_nomeTipoExame"));        
            TblClFator.setCellValueFactory(new PropertyValueFactory<TblViewTipoExame,Double>("dp_fatorTipoExame"));        
            TblClData.setCellValueFactory(new PropertyValueFactory<TblViewTipoExame,String>("sp_dataLaudo"));

            tv_TipoExame.setItems(o_listaTipoExame);

            txtNomeTipoExame.setText("");
            txtFator.setText("");
            txtId.setText("");
            cBoxAtivoTipoExame.setSelected(false);

            nItens = tv_TipoExame.getItems().size();

            Somar(d, nItens);
        }
        
        
    
    }
    
    @FXML
    private void handleButtonExcluirExameSolicitado(ActionEvent event) throws IOException {
        int selectedIndex = tv_TipoExame.getSelectionModel().getSelectedIndex();
        if (selectedIndex >=0) {  
            TblViewTipoExame TipoExame = tv_TipoExame.getSelectionModel().getSelectedItem();
            tv_TipoExame.getItems().remove(selectedIndex);
            nItens = tv_TipoExame.getItems().size();
            
            //bd = new BigDecimal(txtTotal.getText());
            bd = new BigDecimal(TipoExame.getFatorTipoExame());
            d = bd.doubleValue();
            Restar(d, nItens);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Nada foi selecionado");
            alert.setHeaderText("Tipo de Exame não foi selecionado");
            alert.setContentText("Por favor selecione um Tipo de Exame da Tabela");
            alert.showAndWait();
        }
        
    
    }
    private void Somar(Double dFator, Integer nItens) throws IOException{
        String strQtde, strTotal;
        strQtde = nItens.toString();
        
        bd = new BigDecimal(txtTotal.getText());
        d = bd.doubleValue();
        d += dFator;
        strTotal = d.toString();
        
        txtQtdeItens.setText(null);
        txtQtdeItens.setText(strQtde);
        txtTotal.setText(null);
        txtTotal.setText(strTotal);
    
    }
    private void Restar(Double dFator, Integer nItens) throws IOException{
                
        String strQtde, strTotal;
        strQtde = nItens.toString();
        
        bd = new BigDecimal(txtTotal.getText());
        d = bd.doubleValue();
        d -= dFator;
        strTotal = d.toString();
        
        txtQtdeItens.setText(null);
        txtQtdeItens.setText(strQtde);
        txtTotal.setText(null);
        txtTotal.setText(strTotal);
    
    }
}
