/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.KeyEvent;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author GREGORIO-PC
 */
public class Validacion {
    
       public Validacion(){};
       
        public void tomarFoco(JTextField cajaTexto)
 {
     cajaTexto.requestFocus();
 }  
    
   public int validarnumero(String a){
 
  try{
  int x=Integer.parseInt(a);
  return 1;
}
catch(InputMismatchException tipoexepcion1){
   JOptionPane.showMessageDialog(null, "Tipo de Dato Incompatibles", "Error", JOptionPane.ERROR_MESSAGE);

}   
catch(NumberFormatException  tipoexepcion2){
   JOptionPane.showMessageDialog(null, "Datos Incompatibles", "Error", JOptionPane.ERROR_MESSAGE);

}
return 0;
}
public  int validarVacio (JTextField campo, String mensaje){
       if (campo.getText().isEmpty())
          { JOptionPane.showMessageDialog(null, mensaje, "Error falta un dato", JOptionPane.ERROR_MESSAGE); 
            return 0; 
          }
       else
            return 1;
   }  

public int validareal(String a){
  try{
  double x=Double.parseDouble(a);
  return 1;
}
catch(InputMismatchException tipoexepcion1){
   JOptionPane.showMessageDialog(null, "Tipo de Dato Incompatibles", "Error", JOptionPane.ERROR_MESSAGE);

}
   
catch(NumberFormatException  tipoexepcion2){
   JOptionPane.showMessageDialog(null, "Datos Incompatibles", "Error", JOptionPane.ERROR_MESSAGE);

}

return 0;
}


public void validaLetra(java.awt.event.KeyEvent evt){
    int k=(int)evt.getKeyChar();
       if ((k < 97 || k > 122) && (k<65 || k>90) && k!=20 && k!=8 && k!=32 && k!=127 && k!=10)
       {
          evt.setKeyChar((char)KeyEvent.VK_CLEAR);
          JOptionPane.showMessageDialog(null,"Sólo debe ingresar letras","Error Datos",JOptionPane.ERROR_MESSAGE);
       }
}
public void inicializar(JTextField a,JTextField b, JTextField c){
      a.setText(null);
      b.setText(null);
      c.setText(null);
      
     }
public  void limpia(JTextField campo){
    campo.setText("");
}

 public int validarEntero (String numero, String mensaje){
   try{
         int numero1 = Integer.parseInt(numero);
         return 1; 
      }
   catch(NumberFormatException ex){
      JOptionPane.showMessageDialog(null,mensaje,"Debe indicar un numero entero", JOptionPane.ERROR_MESSAGE);
      return 0;
       }
}

    
    
}
