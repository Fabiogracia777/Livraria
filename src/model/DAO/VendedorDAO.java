package model.DAO;

import java.util.List;
import model.bean.Vendedor;

public class VendedorDAO implements iDAO<Vendedor> {

    private final String INSERT = "INSERT INTO vendedor(CPF, NOME, ENDERECO, STATUS) VALUES (?,?,?,?)";
    private final String UPDATE = "UPDATE vendedor SET CPF=?, NOME=?, ENDERECO=?, STATUS=?";
    private final String DELETE = "DELETE FROM vendedor WHERE ID =?";
    private final String LISTALL = "SELECT * FROM tabela";
    private final String LISTBYID = "SELECT * FROM tabela WHERE ID=?";

    @Override
    public Vendedor inserir(Vendedor obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Vendedor atualizar(Vendedor obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Vendedor> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Vendedor buscarId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(Vendedor id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
