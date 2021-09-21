package br.com.controle;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import jxl.WorkbookSettings;
public class BuscaExcell extends Turma{
   
 
     public ArrayList<Turma> rodar() throws IOException, BiffException, ClassNotFoundException, SQLException{   
               ArrayList<Turma> dados = new ArrayList<Turma>();
         WorkbookSettings conf = new WorkbookSettings();
         conf.setEncoding("ISO-8859-1");//codificando os acentos para portugues
         Workbook wb;
         JFileChooser fopen = new JFileChooser( );
          fopen.showOpenDialog(null);
        wb= Workbook.getWorkbook(fopen.getSelectedFile( ),conf);
        Sheet sheet = wb.getSheet(0);//setando a primeira planilha
        int linhas = sheet.getRows();
        Turma t;
        for(int i = 0; i < linhas; i ++ )
        {
            t = new Turma();
           Cell celula1 = sheet.getCell(0, i);
            Cell celula2 = sheet.getCell(1, i);
            Cell celula3 = sheet.getCell(2, i);
            Cell celula4 = sheet.getCell(3, i);
            Cell celula5 = sheet.getCell(4, i);
            Cell celula6 = sheet.getCell(5, i);
            String n1=celula5.getContents();
            String n2=celula6.getContents();

            t.setCurso(celula1.getContents());
            t.setTurma(celula2.getContents());
            t.setDisciplina(celula3.getContents());
            t.setNome(celula4.getContents());
            t.setNota1(celula5.getContents());
            t.setNota2(celula6.getContents());

            dados.add(t);
//            System.out.println(" "+ celula1.getContents()+" "+celula2.getContents()+" "+ celula3.getContents()
//            +" "+celula4.getContents()+" "+celula5.getContents()+" "+celula6.getContents() );
    }
     JOptionPane.showMessageDialog(null, "importato com sucesso ");
   return dados;
     }  
     }