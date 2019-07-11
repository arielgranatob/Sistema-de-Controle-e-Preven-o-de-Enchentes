/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scpe;

import View.JFrmLogin;
import View.JFrmRelatorioData;
import View.JFrmTableRelatorios;

/**
 *
 * @author italo
 */
public class SCPE {

    private static void callLogin() {
        JFrmLogin jfrmtableLogin = new JFrmLogin();
        jfrmtableLogin.setVisible(true);

        //JFrmTableRelatorios jfrmRelatorios = new JFrmTableRelatorios();
        //jfrmRelatorios.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        callLogin();
    }

}
