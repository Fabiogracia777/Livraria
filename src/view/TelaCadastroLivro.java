package view;

import contoller.LivroController;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.bean.Livro;
import model.bean.Vendedor;

/**
 *
 * @author USUARIO
 */
public class TelaCadastroLivro extends javax.swing.JInternalFrame {

    private javax.swing.table.DefaultTableModel tabelaModelo;
    private LivroController lController;
    private Livro lSelecionado = new Livro();
    private boolean podeEditar = false;

    public TelaCadastroLivro() {
        this.CriarTabelaModelo();
        initComponents();
        lController = new LivroController();
        lController.listarTodos(tabelaModelo);
        limparCampos();

    }

    public void CriarTabelaModelo() {

        this.tabelaModelo = new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null, null}
                },
                new String[]{
                    "ID", "ISBN", "Título", "Autor", "Categoria", "Paginas", "Preço", "Status"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.Integer.class,
                java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.Integer.class,
                java.lang.Double.class, java.lang.String.class
            };

            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        };
    }

    public void limparCampos() {
        lSelecionado = new Livro(); // Limpar livro selecionado

        ISBNText.setText("");
        TituloText.setText("");
        AutorText.setText("");
        PaginasText.setText("");
        CategoriasText.setText("");
        PrecoText.setText("");
        String status_index = "Disponível";
        statusLista.getModel().setSelectedItem(status_index);

        //tabelaDeLivros.getSelectionModel().clearSelection();
        this.desabilitarCamposEdicao();
        lController.listarTodos(tabelaModelo);
    }

    public void desabilitarCamposEdicao() {
        this.ISBNText.setEnabled(false);
        this.TituloText.setEnabled(false);
        this.AutorText.setEnabled(false);
        this.PaginasText.setEnabled(false);
        this.CategoriasText.setEnabled(false);
        this.PrecoText.setEnabled(false);
        this.statusLista.setEnabled(false);

        this.podeEditar = false;

    }

    public void habilitarCamposEdicao() {
        this.ISBNText.setEnabled(true);
        this.TituloText.setEnabled(true);
        this.AutorText.setEnabled(true);
        this.PaginasText.setEnabled(true);
        this.CategoriasText.setEnabled(true);
        this.PrecoText.setEnabled(true);
        this.statusLista.setEnabled(true);

        this.podeEditar = true;

    }

    public void preencherLivro(Livro l, int id, int ISBN, String titulo, String autor, int paginas, String categoria, double preco, boolean status) {
        if (ISBN != 0 && titulo != null && autor != null && paginas != 0 && categoria != null && preco != 0) {
            l.setId(id);
            
            l.setISBN(ISBN); 
            l.setTitulo(titulo);
            l.setAutor(autor);
            
            l.setPaginas(paginas);
            l.setCategoria(categoria);
            
            l.setPreco(preco);
            l.setStatus(status);
        } else {
            this.limparCampos();
        }
    }
    
    public void preencherSelecionado(ListSelectionEvent e) {
        int linha = tabelaDeLivros.getSelectedRow();
        try {
            int id = Integer.parseInt(tabelaModelo.getValueAt(linha, 0).toString());
            int ISBN = Integer.parseInt(tabelaModelo.getValueAt(linha, 1).toString());
            String titulo = tabelaModelo.getValueAt(linha, 2).toString();
            String autor = tabelaModelo.getValueAt(linha, 3).toString();
            int paginas = Integer.parseInt(tabelaModelo.getValueAt(linha, 4).toString());
            String categoria = tabelaModelo.getValueAt(linha, 5).toString();
            double preco = Double.parseDouble(tabelaModelo.getValueAt(linha, 6).toString());
            boolean status = tabelaModelo.getValueAt(linha, 7).toString().equals("Disponível");

            this.preencherLivro(lSelecionado, id, ISBN, titulo, autor, paginas, categoria, preco, status);

            this.preencherCampos();
            this.habilitarCamposEdicao();
        } catch (Exception erro) {
            this.limparCampos();
        }
    }
    
    public void preencherCampos() {
        ISBNText.setText(String.valueOf(lSelecionado.getISBN()));
        TituloText.setText(lSelecionado.getTitulo());
        AutorText.setText(lSelecionado.getAutor());
        CategoriasText.setText(lSelecionado.getAutor());
        PaginasText.setText(String.valueOf(lSelecionado.getPaginas()));
        PrecoText.setText(String.valueOf(lSelecionado.getPreco()));
        String status_index = lSelecionado.isStatus() ? "Disponível" : "Indisponível";
        statusLista.getModel().setSelectedItem(status_index);
    }
    
    @SuppressWarnings("unchecked")
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelDeFunçoes = new javax.swing.JPanel();
        BTNNovo = new javax.swing.JButton();
        BTNSalvar = new javax.swing.JButton();
        BTNProcurar = new javax.swing.JButton();
        BTNExcluir = new javax.swing.JButton();
        BTNSair = new javax.swing.JButton();
        DadosDoLivro = new javax.swing.JPanel();
        Status = new javax.swing.JLabel();
        CategoriasText = new javax.swing.JTextField();
        PrecoText = new javax.swing.JTextField();
        PaginasText = new javax.swing.JTextField();
        AutorText = new javax.swing.JTextField();
        TituloText = new javax.swing.JTextField();
        ISBNText = new javax.swing.JTextField();
        ISBN = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        Autor = new javax.swing.JLabel();
        Paginas = new javax.swing.JLabel();
        Preco = new javax.swing.JLabel();
        Categorias = new javax.swing.JLabel();
        statusLista = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDeLivros = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(770, 505));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PainelDeFunçoes.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        BTNNovo.setText("NOVO");
        BTNNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNNovoActionPerformed(evt);
            }
        });

        BTNSalvar.setText("SALVAR");
        BTNSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSalvarActionPerformed(evt);
            }
        });

        BTNProcurar.setText("PROCURAR");
        BTNProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNProcurarActionPerformed(evt);
            }
        });

        BTNExcluir.setText("EXCLUIR");
        BTNExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNExcluirActionPerformed(evt);
            }
        });

        BTNSair.setText("SAIR");
        BTNSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelDeFunçoesLayout = new javax.swing.GroupLayout(PainelDeFunçoes);
        PainelDeFunçoes.setLayout(PainelDeFunçoesLayout);
        PainelDeFunçoesLayout.setHorizontalGroup(
            PainelDeFunçoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelDeFunçoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelDeFunçoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTNNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTNSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTNProcurar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTNExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelDeFunçoesLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(BTNSair)
                .addGap(48, 48, 48))
        );
        PainelDeFunçoesLayout.setVerticalGroup(
            PainelDeFunçoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelDeFunçoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTNNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(BTNSair)
                .addGap(38, 38, 38))
        );

        getContentPane().add(PainelDeFunçoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 177, -1, -1));

        DadosDoLivro.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do livro"));

        Status.setText("STATUS");

        CategoriasText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriasTextActionPerformed(evt);
            }
        });

        ISBN.setText("ISBN");

        Titulo.setText("TÍTULO");

        Autor.setText("AUTOR");

        Paginas.setText("PAGINAS");

        Preco.setText("PREÇO");

        Categorias.setText("CATEGORIAS");

        statusLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponível", "Indisponível" }));

        javax.swing.GroupLayout DadosDoLivroLayout = new javax.swing.GroupLayout(DadosDoLivro);
        DadosDoLivro.setLayout(DadosDoLivroLayout);
        DadosDoLivroLayout.setHorizontalGroup(
            DadosDoLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DadosDoLivroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DadosDoLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DadosDoLivroLayout.createSequentialGroup()
                        .addComponent(Preco)
                        .addGap(18, 18, 18)
                        .addComponent(PrecoText, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DadosDoLivroLayout.createSequentialGroup()
                        .addGroup(DadosDoLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ISBN)
                            .addComponent(Titulo)
                            .addComponent(Autor)
                            .addComponent(Paginas))
                        .addGap(18, 18, 18)
                        .addGroup(DadosDoLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TituloText, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ISBNText, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AutorText, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PaginasText, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DadosDoLivroLayout.createSequentialGroup()
                        .addComponent(Categorias)
                        .addGap(18, 18, 18)
                        .addComponent(CategoriasText, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DadosDoLivroLayout.createSequentialGroup()
                        .addComponent(Status)
                        .addGap(18, 18, 18)
                        .addComponent(statusLista, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(261, Short.MAX_VALUE))
        );
        DadosDoLivroLayout.setVerticalGroup(
            DadosDoLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DadosDoLivroLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(DadosDoLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ISBN)
                    .addComponent(ISBNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DadosDoLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TituloText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Titulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DadosDoLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AutorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Autor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DadosDoLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PaginasText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Paginas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DadosDoLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrecoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Preco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DadosDoLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CategoriasText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Categorias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DadosDoLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Status)
                    .addComponent(statusLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        getContentPane().add(DadosDoLivro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 176, -1, -1));

        tabelaDeLivros.setModel(tabelaModelo);
        tabelaDeLivros.getTableHeader().setReorderingAllowed(false);
        tabelaDeLivros.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                preencherSelecionado(e);
            }
        });
        jScrollPane1.setViewportView(tabelaDeLivros);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 734, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CategoriasTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriasTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoriasTextActionPerformed

    private void BTNSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSalvarActionPerformed
        
         if (!this.podeEditar) {
            JOptionPane.showMessageDialog(this, "Selecione um livro na tabela ou clique em NOVO.\nÉ preciso preencher todos os campos.");
            return;
        }

        int id = lSelecionado.getId();
        int ISBN = Integer.parseInt(ISBNText.getText());
        String titulo = TituloText.getText();
        String autor = AutorText.getText();
        int paginas = Integer.parseInt(PaginasText.getText());
        String categoria = CategoriasText.getText();
        double preco = Double.parseDouble(PrecoText.getText());
        boolean status = statusLista.getSelectedItem().toString().equals("Disponível");
        
        //INSERT INTO livro(ISBN, TITULO, AUTOR, PAGINAS, PRECO, CATEGORIA, STATUS) VALUES (?, ?, ?, ?, ?, ?, ?)

        this.preencherLivro(lSelecionado, id, ISBN, titulo, autor, paginas, categoria, preco, status);

        if (lSelecionado != null && !(titulo.equals("") || autor.equals(""))) {
            System.out.println(lSelecionado);
            if (this.tabelaModelo == null) {
                System.out.println("A tabela é nula");
            }
            if (lSelecionado.getId() != 0) {
                // atualizar
                lController.salvar(this.tabelaModelo, lSelecionado, false);
            } else {
                // criar novo
                lController.salvar(this.tabelaModelo, lSelecionado, true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "É preciso preencher todos os campos.");
        }
        
        
        limparCampos();
    }//GEN-LAST:event_BTNSalvarActionPerformed

    private void BTNNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNNovoActionPerformed
        this.habilitarCamposEdicao();
        this.ISBNText.requestFocus();
    }//GEN-LAST:event_BTNNovoActionPerformed

    private void BTNProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNProcurarActionPerformed
         Object[] possibilities = {"Todos", "Pelo Código", "Pelo ISBN"};
        String escolha = (String) JOptionPane.showInputDialog(
                this,
                "Escolha o tipo de busca\n"
                + "que deseja efetuar",
                "Buscar Livro",
                JOptionPane.QUESTION_MESSAGE,
                null,
                possibilities,
                possibilities[0]);
        
        escolha = escolha == null ? "" : escolha;

        switch (escolha) {
            case "Pelo Código":
                int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Código do Livro: "));
                lController.listarPorId(tabelaModelo, id);
                break;
            case "Pelo ISBN":
                int ISBN = Integer.parseInt(JOptionPane.showInputDialog(this, "ISBN do Livro: "));
                lController.listarPorISBN(tabelaModelo, ISBN);
                break;
            default:
                lController.listarTodos(tabelaModelo);
        }
    }//GEN-LAST:event_BTNProcurarActionPerformed

    private void BTNExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNExcluirActionPerformed
        if (lSelecionado == null) {
            JOptionPane.showMessageDialog(this, "O livro selecionado não existe no banco de dados.\nTente selecionar um livro da tabela abaixo." );
        } else {
            lController.excluir(tabelaModelo, lSelecionado);
        }

        limparCampos();
    }//GEN-LAST:event_BTNExcluirActionPerformed

    private void BTNSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Autor;
    private javax.swing.JTextField AutorText;
    private javax.swing.JButton BTNExcluir;
    private javax.swing.JButton BTNNovo;
    private javax.swing.JButton BTNProcurar;
    private javax.swing.JButton BTNSair;
    private javax.swing.JButton BTNSalvar;
    private javax.swing.JLabel Categorias;
    private javax.swing.JTextField CategoriasText;
    private javax.swing.JPanel DadosDoLivro;
    private javax.swing.JLabel ISBN;
    private javax.swing.JTextField ISBNText;
    private javax.swing.JLabel Paginas;
    private javax.swing.JTextField PaginasText;
    private javax.swing.JPanel PainelDeFunçoes;
    private javax.swing.JLabel Preco;
    private javax.swing.JTextField PrecoText;
    private javax.swing.JLabel Status;
    private javax.swing.JLabel Titulo;
    private javax.swing.JTextField TituloText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> statusLista;
    private javax.swing.JTable tabelaDeLivros;
    // End of variables declaration//GEN-END:variables
}
