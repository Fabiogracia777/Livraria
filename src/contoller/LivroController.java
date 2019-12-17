package contoller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Livro;
import model.DAO.LivroDAO;

public class LivroController {

    private Livro LivroSelecionado;
    private List<Livro> tabelaDeLivros;
    private LivroDAO lDAO;

    public LivroController() {
        lDAO = new LivroDAO();
    }

    public void listarTodos(DefaultTableModel modeloTabela) {
        modeloTabela.setNumRows(0);
        List<Livro> listaLivros = lDAO.buscarTodos();

        for (Livro l : listaLivros) {
            modeloTabela.addRow(new Object[]{l.getISBN(), l.getTitulo(),
                l.getAutor(), l.getPaginas(),l.getPreco(),l.getCategoria(), l.isStatus() ? "1 - DIsponível" : "2 - Indisponível"});
        }
    }

    public void listarPorId(DefaultTableModel modeloTabela, int id) {
        modeloTabela.setNumRows(0);
        Livro livroBuscado = lDAO.buscarPorId(id);

        modeloTabela.addRow(new Object[]{livroBuscado.getId(), livroBuscado.getISBN(),
            livroBuscado.getTitulo(), livroBuscado.getAutor(), livroBuscado.getPaginas(), 
            livroBuscado.getPreco(),livroBuscado.getCategoria(), livroBuscado.isStatus() ? "1 - DIsponível" : "2 - Indisponível"});
    }
    
    public void listarPorISBN(DefaultTableModel modeloTabela, int ISBN){
        modeloTabela.setNumRows(0);
        Livro livroBuscado = lDAO.buscarPorISBN(ISBN);
        
        modeloTabela.addRow(new Object[]{livroBuscado.getId(), livroBuscado.getISBN(),
            livroBuscado.getTitulo(), livroBuscado.getAutor(), livroBuscado.getPaginas(), 
            livroBuscado.getPreco(),livroBuscado.getCategoria(), livroBuscado.isStatus() ? "1 - DIsponível" : "2 - Indisponível"});
    }
    
    public void salvar(DefaultTableModel modeloTabela, Livro livro, boolean novo ) {
        if( novo ) {
            lDAO.inserir(livro);
        } else {
            lDAO.atualizar(livro);
        }
        this.listarTodos(modeloTabela);
    }
    
    public void excluir(DefaultTableModel modeloTabela, Livro livro ) {
        System.out.println("Excluindo livro No.: " + livro.getId());
        if( livro.getId() != 0 ) {
            lDAO.excluir(livro.getId());
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir as informações.\nLivro não localizado.", "Erro ao excluir", JOptionPane.ERROR_MESSAGE);
        }
        this.listarTodos(modeloTabela);
    }

}

