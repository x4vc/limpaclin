/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tableview;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author victorcmaf
 */
public class TblViewPaciente {
    //variables a serem utilizadas no TableView
    private IntegerProperty ip_idPaciente;
    private StringProperty sp_nomePaciente;
    private StringProperty sp_dataNascimentoPaciente;
    private StringProperty sp_sexoPaciente;
    private StringProperty sp_RGPaciente;
    private StringProperty sp_CPFPaciente;

    public TblViewPaciente(Integer idPaciente, String nomePaciente, String dataNascimentoPaciente, String sexoPaciente, String RGPaciente, String CPFPaciente) {
        this.ip_idPaciente = new SimpleIntegerProperty(idPaciente);
        this.sp_nomePaciente = new SimpleStringProperty(nomePaciente);
        this.sp_dataNascimentoPaciente = new SimpleStringProperty(dataNascimentoPaciente);
        this.sp_sexoPaciente = new SimpleStringProperty(sexoPaciente);
        this.sp_RGPaciente = new SimpleStringProperty(RGPaciente);
        this.sp_CPFPaciente = new SimpleStringProperty(CPFPaciente);
    } 
    
    // Metodos para TableView
    public IntegerProperty ip_idPacienteProperty() {          
         return ip_idPaciente; 
     }
    public StringProperty sp_nomePacienteProperty(){
        return sp_nomePaciente;
    }    
    public StringProperty sp_dataNascimentoPacienteProperty(){
        return sp_dataNascimentoPaciente;
    }
    public StringProperty sp_sexoPacienteProperty(){
        return sp_sexoPaciente;
    }
    public StringProperty sp_RGPacienteProperty(){
        return sp_RGPaciente;
    }
    public StringProperty sp_CPFPacienteProperty(){
        return sp_CPFPaciente;
    }
    //------------------------------------------------

    public int getIdPaciente() {
        return this.ip_idPaciente.get();
    }

    public String getNomePaciente() {
        return this.sp_nomePaciente.getValue();
    }

    public String getDataNascimentoPaciente() {
        return this.sp_dataNascimentoPaciente.getValue();
    }

    public String getSexoPaciente() {
        return this.sp_sexoPaciente.getValue();
    }

    public String getRGPaciente() {
        return this.sp_RGPaciente.getValue();
    }

    public String getCPFPaciente() {
        return this.sp_CPFPaciente.getValue();
    }
    
    //Setters criados através da ajuda NetBeans

    public void setIdPaciente(Integer ip_idPaciente) {
        this.ip_idPaciente.set(ip_idPaciente);
    }

    public void setNomePaciente(String sp_nomePaciente) {
        this.sp_nomePaciente.set(sp_nomePaciente);
    }

    public void setDataNascimentoPaciente(String sp_dataNascimentoPaciente) {
        this.sp_dataNascimentoPaciente.set(sp_dataNascimentoPaciente);
    }

    public void setSexoPaciente(String sp_sexoPaciente) {
        this.sp_sexoPaciente.set(sp_sexoPaciente);
    }

    public void setRGPaciente(String sp_RGPaciente) {
        this.sp_RGPaciente.set(sp_RGPaciente);
    }

    public void setCPFPaciente(String sp_CPFPaciente) {
        this.sp_CPFPaciente.set(sp_CPFPaciente);
    }
    
    
    
}
