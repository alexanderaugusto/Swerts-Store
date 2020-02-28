package br.inatel.swertsstore.model;

/*
    *** CLASSE PRINCIPAL - SWERTS STORE***

*/

import br.inatel.swertsstore.controller.UsuarioDAO;
import br.inatel.swertsstore.view.TelaLogin;

public class SwertsStore {

    public static void main(String[] args) {
        //Exibe a tela de login; 
        TelaLogin telaInicio = new TelaLogin();
        telaInicio.setVisible(true);
        
    }

}
