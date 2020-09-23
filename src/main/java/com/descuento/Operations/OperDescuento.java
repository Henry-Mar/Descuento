/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.descuento.Operations;

import com.descuento.Dao.DescuentoDao;
import com.descuento.Modelo.Descuento;
import java.util.Scanner;
/**
 *
 * @author USUARIO
 */
public class OperDescuento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        DescuentoDao descuento = new DescuentoDao();
        
        Descuento d1 = null;
        int opcion = -1;
        Scanner entrada = new Scanner(System.in);
        String id, producto, codigo, DETALLES, SUCURSAL;
        
        while (opcion !=0){
            
            try{
            System.out.println("Elige una opcion:\n1.-Listar Productos" + 
          "\n2.-Buscar producto por Id\n" +
                    "3.-Agregar un producto\n" +
                    "4.-Modificar un producto\n"+
                    "5.-Eliminar un producto\n" +
                    "0.-Salir\n");

            opcion = Integer.parseInt(entrada.nextLine());
            
            switch (opcion){
                case 1:
                    System.out.println("\n1.Listado***********");
                    descuento.selectall();
                    break;
                    
                case 2:
                    System.out.println("\n2.Buscar producto por Id***********");
                    System.out.println("Introduce el Id del producto a buscar:");
                    id = entrada.nextLine();
                    d1 = new Descuento();
                    d1.setCodigo(new String (id));
                    d1 = descuento.fyndbyId(d1);
                    System.out.println("Registro encontrado:" + d1);
                    break;
                    
                case 3:
                    System.out.println("\n3.Insertar***********");
                    System.out.println("Introduce los productos a agregar");
                    producto = entrada.nextLine();
                    
                    System.out.println("Introduce el codigo");
                    codigo = entrada.nextLine();
                    
                    System.out.println("Introduce los detalles");
                    DETALLES = entrada.nextLine();
                    
                    System.out.println("Introduce la sucursal");
                    SUCURSAL = entrada.nextLine();
                    
                    /*System.out.println("Introduce numero de DUI");
                    dui = entrada.nextLine();
                    
                    System.out.println("Introduce tipo de sangre");
                    tip_sangre = entrada.nextLine();*/
                                  
                    d1 = new Descuento();
                    d1.setProducto(producto);
                    d1.setCodigo(codigo);
                    d1.setDetalles(DETALLES);
                    d1.setSucursal(SUCURSAL);
                    descuento.Insertar(d1);
                    break;
                    
                    case 4:
                    System.out.println("\n4.Modificar***********");
                    //Buscamos el producto a modificar
                    System.out.println("Introducir el Id del producto a modificar");
                    id = entrada.nextLine();
                    d1= new Descuento();
                    d1.setId_descuento(new Integer(id));
                    descuento.fyndbyId(d1);
                    
                    System.out.println("Introduce el nuevo nombre del producto");
                    producto = entrada.nextLine();
                    
                    System.out.println("Introduce el nuevo codigo");
                    codigo = entrada.nextLine();
                    
                    System.out.println("Introduce los nuevos detalles");
                    DETALLES = entrada.nextLine();
                    
                    System.out.println("Introduce la nueva sucursal");
                    SUCURSAL = entrada.nextLine();
                   
                    
                    d1.setProducto(producto);
                    d1.setCodigo(codigo);
                    d1.setDetalles(DETALLES);
                    d1.setSucursal(SUCURSAL);
                    descuento.actualizar(d1);
                    break;
                    
                case 5:
                    System.out.println("\n5.Eliminar***********");
                    //buscamos la producto a eliminar
                    System.out.println("Introuce el id del producto a eliminar");
                    id= entrada.nextLine();
                    d1 = new Descuento();
                    d1.setId_descuento(new Integer(id));
                    d1 = descuento.fyndbyId(d1);
                    //Eliminar el registro encontrado
                    descuento.eliminar(d1);
                    break;
                    
                case 0:
                    System.out.println("Salida efectuada");
                    System.exit(0);
                    break; 
            
                } 
            
                    System.out.println("\n");
                    
              }catch(Exception ex){
                    System.out.println("Surgio una falla en la ejecucion del programa:" + ex.getMessage());
            }
        }
    }
    
}
