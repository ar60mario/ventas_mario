/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.utils;

import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Direccion;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


/**
 *
 * @author Marcela
 */
public class LectorDeExcel {
    
    public static boolean validarExtension(File archivo) {
        String[] splitNombreArchivo = archivo.getName().split("\\.");
        String extension = splitNombreArchivo[splitNombreArchivo.length - 1];
        if (extension.equalsIgnoreCase(Constantes.EXTENSION_EXCEL_1)){
            return true;
        } else {
            return false;
        }        
    }
    
    public static List<Cliente> leerExcelCliente(File file) throws IOException, BiffException, Exception {
        Workbook archivoExcel = Workbook.getWorkbook(file);
        int cantidadFilas = archivoExcel.getSheet(0).getRows();
        Sheet hoja = archivoExcel.getSheet(0);
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        for (int i = 1; i < cantidadFilas; i++) {
            try {
                Cliente cliente = new Cliente();
                cliente.setCodigo(Integer.valueOf(hoja.getCell(0,i).getContents()));
                cliente.setRazonSocial(hoja.getCell(1,i).getContents());
                cliente.setCuit(hoja.getCell(2,i).getContents());
                cliente.setCategoriaAfip(Integer.valueOf(hoja.getCell(3,i).getContents()));
                Direccion direccion = new Direccion();
                direccion.setCalle(hoja.getCell(4,i).getContents());
                direccion.setNumero(hoja.getCell(5,i).getContents());
                direccion.setPisoDto(hoja.getCell(6,i).getContents());
                direccion.setCodigoPostal(hoja.getCell(7,i).getContents());
                direccion.setLocalidad(hoja.getCell(8,i).getContents());
                direccion.setProvincia(hoja.getCell(9,i).getContents());
                cliente.setDireccion(direccion);
                cliente.setActivo(true);
                listaClientes.add(cliente);
            }catch(Exception ex){
                throw new Exception(ex);
            }
        }
        return listaClientes;
    }
   
}
