/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tableview;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 *
 * @author Victor
 */
public class TblViewTipoExame {
    //variables a serem utilizadas no TableView
    private IntegerProperty ip_idTipoExame;
    private StringProperty sp_nomeTipoExame;
    private DoubleProperty dp_fatorTipoExame;
    private StringProperty sp_tipoExameAtivo;
    private StringProperty sp_dataLaudo;
    //------------------------------------------

    public TblViewTipoExame(Integer idTipoExame, String nomeTipoExame, Double fatorTipoExame, String tipoExameAtivo, String dataLaudo) {
        this.ip_idTipoExame = new SimpleIntegerProperty(idTipoExame);
        this.sp_nomeTipoExame = new SimpleStringProperty(nomeTipoExame);
        this.dp_fatorTipoExame = new SimpleDoubleProperty(fatorTipoExame);
        this.sp_tipoExameAtivo = new SimpleStringProperty(tipoExameAtivo);
        this.sp_dataLaudo = new SimpleStringProperty(dataLaudo);
    }
    
    // Metodos para TableView
    public IntegerProperty ip_idTipoExameProperty() {          
         return ip_idTipoExame; 
     }
    public StringProperty sp_nomeTipoExameProperty(){
        return sp_nomeTipoExame;
    }
    public DoubleProperty dp_fatorTipoExameProperty(){
        return dp_fatorTipoExame;
    }
    public StringProperty sp_tipoExameAtivoProperty(){
        return sp_tipoExameAtivo;
    }
    public StringProperty sp_dataLaudoProperty(){
        return sp_dataLaudo;
    }
    //------------------------------------------------
    
    public int getId() {
        return this.ip_idTipoExame.get();
            //return this.id.get();
    }
    public String getNomeTipoExame() {
        return this.sp_nomeTipoExame.getValue();
       
    }
    public Double getFatorTipoExame(){
        return this.dp_fatorTipoExame.get();
    }
    public String getTipoExameAtivo(){
        return this.sp_tipoExameAtivo.getValue();
    }
     public String getDataLaudo(){
        return this.sp_dataLaudo.getValue();
    }
    //Setters criados através da ajuda NetBeans
    public void setIdTipoExame(Integer ip_idTipoExame) {
        this.ip_idTipoExame.set(ip_idTipoExame);
    }

    public void setNomeTipoExame(String sp_nomeTipoExame) {
        this.sp_nomeTipoExame.set(sp_nomeTipoExame);
    }

    public void setFatorTipoExame(Double dp_fatorTipoExame) {
        this.dp_fatorTipoExame.set(dp_fatorTipoExame);
    }

    public void setTipoExameAtivo(String sp_tipoExameAtivo) {
        this.sp_tipoExameAtivo.set(sp_tipoExameAtivo);
    }
    public void setDataLaudo(String sp_dataLaudo) {
        this.sp_dataLaudo.set(sp_dataLaudo);
    }
    
}
