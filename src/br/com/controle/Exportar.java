/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle;


import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JTable;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


public class Exportar {

        private File file;
        private List<JTable> jTabdados2;
        private List<String> nome_files;
        
            public Exportar(File file, List<JTable> jTabdados2, List<String> nome_files) throws Exception {
        this.file = file;
        this.jTabdados2 = jTabdados2;
        this.nome_files = nome_files;
        if(nome_files.size()!=jTabdados2.size()){
            throw new Exception("Error");
        }
    }
          public boolean export(){
            try{
                DataOutputStream out=new DataOutputStream(new FileOutputStream(file));
                WritableWorkbook w=Workbook.createWorkbook(out);
                for (int index = 0; index <jTabdados2.size();index++) {
                        JTable table= jTabdados2.get(index);
                        WritableSheet s=w.createSheet(nome_files.get(index), 0);
                        for (int i = 0; i < table.getColumnCount(); i++) {
                            for (int j = 0; j < table.getRowCount(); j++) {
                                Object object=table.getValueAt(j,i);
                                s.addCell(new Label(i,j,String.valueOf(object)));
                            }
                        }
                    }
                w.write();
                w.close();
                return true;
            }
            
            catch (IOException | WriteException e){
                return false;
                }
          }  
            
}
