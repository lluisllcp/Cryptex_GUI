/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import Ventanas.Interfa2;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Lluís CP - aw.lluiscerda@gmail.com
 *
 */
public class Utiles {

//------------------- SALIDA PROGRAMA------------------------------
    public static final String deseaSalir() {
        if (JOptionPane.showConfirmDialog(null, "Esta segur de sortir?", "ALERTA!",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            // SI
            System.exit(0);
        } else {
            // NO
        }
        return null;
    }
//----------------- CREAR CARPETA -------------------------------

    public static final String carpeta() {
        String strCadenaCar1 = "";
        String strCadenaCar2 = "";

        File archivo = new File("hidden");
        if (archivo.exists()) {
            if (archivo.isDirectory()) {
                strCadenaCar1 += "La carpeta ja existeix \n";
                strCadenaCar1 += "Guarde els arxius a ocular dins Hidden";
                Interfa2.jTextPane1.setText(strCadenaCar1);
            }
        } else {
            archivo.mkdir();

            strCadenaCar2 += "No existia el directori, pero ha sigut creat!!\n";
            strCadenaCar2 += "Guarde els arxius a ocultar dins Hidden";
            Interfa2.jTextPane1.setText(strCadenaCar2);
        }
        return null;
    }

//---------------------- RENOMBRAR CARPETA ----------------------------
    public static final String Renombre() {
        String strCadenaRe1 = "";
        String strCadenaRe2 = "";

        File oldfile = new File("hidden");
        File newfile = new File("Printers.{2227a280-3aea-1069-a2de-08002b30309d}");

        File archivo = new File("hidden");
        if (!archivo.exists()) {
            strCadenaRe1 += "Al tanto! ... La carpeta no existeix!!";
            Interfa2.jTextPane1.setText(strCadenaRe1);
        } else if (oldfile.renameTo(newfile)) {

            strCadenaRe2 += "Carpeta renombrada";
            Interfa2.jTextPane1.setText(strCadenaRe2);
        }
        return null;
    }
//----------------------- ATRIBUTOS -------------------------------------

    public static final String Cmd() {
        try {
            String archivo = "Printers.{2227a280-3aea-1069-a2de-08002b30309d}";
            Runtime.getRuntime().exec("attrib +h +s" + "Printers.{2227a280-3aea-1069-a2de-08002b30309d}");
        } catch (IOException e) {
        }
        return null;
    }

// --------------------- PASSWORD --------------------------------------
    public static final String Pass() {
        String strCadenaPass1 = "";
        String strCadenaPass2 = "";

        var pf = new JPasswordField();
        int toor = JOptionPane.showConfirmDialog(null, pf, "Escriu contrasenya",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        String username, password;

        password = String.valueOf(pf.getPassword());
        if (password.equals("toor")) {
            Utiles.Revertir();
            Utiles.CmdRevert();
            strCadenaPass1 += "Revertit";
            Interfa2.jTextPane1.setText(strCadenaPass1);
        } else {
            strCadenaPass2 += "Contrasenya ERRONEA";
            Interfa2.jTextPane1.setText(strCadenaPass2);
        }
        return null;
    }

//---------------------- REVERTIR CARPETA ----------------------------
    public static final String Revertir() {
        String strCadenaRev1 = "";
        String strCadenaRev2 = "";

        File oldfile = new File("Printers.{2227a280-3aea-1069-a2de-08002b30309d}");
        File newfile = new File("hidden");
        if (oldfile.renameTo(newfile)) {
            strCadenaRev1 += "Archivu renombrat";
            Interfa2.jTextPane1.setText(strCadenaRev1);
        } else {
            strCadenaRev2 = "Error al renombrar";
            Interfa2.jTextPane1.setText(strCadenaRev2);

        }
        return null;
    }
//----------------------- REVERTIR ATRIBUTOS -----------------------------

    public static final String CmdRevert() {
        try {
            String archivo = "Printers.{2227a280-3aea-1069-a2de-08002b30309d}";
            Runtime.getRuntime().exec("attrib -h -s" + "Printers.{2227a280-3aea-1069-a2de-08002b30309d}");
        } catch (IOException e) {
        }
        return null;
    }

//------------------------ CONTINUAR --------------------------------------
    public static final String deseaCont() {
        if (JOptionPane.showConfirmDialog(null, "Vol ocultar la carpeta?", "ALERTA!",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            // SI
        } else {
            // NO
        }
        return null;
    }

// ------------------- BORRAR DIRECTORIO ---------------------------------------
    public static final String Borrar() {
        String strCadenaRmdir1 = "";
        String strCadenaRmdir2 = "";
        String strCadenaRmdir3 = "";

        File archivo = new File("hidden");
        if (!archivo.exists()) {
            strCadenaRmdir1 += "La carpeta no existeix";
            Interfa2.jTextPane1.setText(strCadenaRmdir1);
//            }
        } else {
            if (archivo.delete()) {
                strCadenaRmdir2 += "El directori ha sigut borrat correctament";
                Interfa2.jTextPane1.setText(strCadenaRmdir2);
            } else {
                strCadenaRmdir3 += "El directori no s'ha pogut borrar";
                Interfa2.jTextPane1.setText(strCadenaRmdir3);
            }
        }
        return null;
    }
}
