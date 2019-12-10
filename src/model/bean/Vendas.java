
package model.bean;

public class Vendas {
    
    private Livro livro;
    private Vendedor Vendedor;
    private int quantidade;
    private double precoVendido;
    private int id;

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Vendedor getVendedor() {
        return Vendedor;
    }

    public void setVendedor(Vendedor Vendedor) {
        this.Vendedor = Vendedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoVendido() {
        return precoVendido;
    }

    public void setPrecoVendido(double precoVendido) {
        this.precoVendido = precoVendido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
