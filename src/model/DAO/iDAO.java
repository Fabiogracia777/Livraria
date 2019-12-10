
package model.DAO;

import java.util.List;

public interface iDAO<T> {
    
    T inserir(T obj);
    T atualizar(T obj);
    List<T> buscarTodos();
    T buscarId(int id);
    void excluir(T id);
}
