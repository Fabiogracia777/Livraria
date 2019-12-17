package livraria;

import DB.Connect;
import view.Iniciar;

public class Livraria {

    public static void main(String[] args) {
        // Criar conexão e banco
        new Connect("root","","NovaLivraria");
        
        // Abrir tela de Menu
        Iniciar viewIniciar = new Iniciar();
        viewIniciar.setVisible(true);
    }
    
}
