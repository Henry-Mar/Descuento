/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.descuento.Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author USUARIO
 */

@Entity
@Table (name="Descuento")
public class Descuento implements Serializable {
    @Id
    @SequenceGenerator(name="des_sec", sequenceName="sec_descuento", allocationSize = 1 )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="des_sec")
    
    @Column(name="id")
    private Integer id_descuento;
    
    @Column(name="producto")
    private String producto;
    
    @Column(name="codigo")
    private String codigo;
    
    @Column(name="detalles")
    private String Detalles;
    
    @Column(name="Sucursal")
    private String Sucursal;

    public Integer getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(Integer id_descuento) {
        this.id_descuento = id_descuento;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDetalles() {
        return Detalles;
    }

    public void setDetalles(String Detalles) {
        this.Detalles = Detalles;
    }

    public String getSucursal() {
        return Sucursal;
    }

    public void setSucursal(String Sucursal) {
        this.Sucursal = Sucursal;
    }

    @Override
    public String toString() {
        return "Descuento{" + "id_descuento=" + id_descuento + ", producto=" + producto + ", codigo=" + codigo + ", Detalles=" + Detalles + ", Sucursal=" + Sucursal + '}';
    }
    
    
    
    
    
    
}
