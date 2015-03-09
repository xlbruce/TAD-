/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 31409695
 */
public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vendedor[] vendedores = new Vendedor[5];
        ListaVendedor lista = new ListaVendedor(10);
        
        for (int i = 0; i < 5; i++) {
            vendedores[i] = new Vendedor(i, null, i*1000);
        }
        
        try {
            lista.insereElemento(new Vendedor(1, "",123));
        } catch (Exception ex) {
            Logger.getLogger(JavaApplication7.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
