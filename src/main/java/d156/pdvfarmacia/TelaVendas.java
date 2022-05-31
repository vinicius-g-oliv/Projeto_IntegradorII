/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package d156.pdvfarmacia;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.ClienteDAO;
import DAO.ItemVendaDAO;
import DAO.ProdutoDAO;
import DAO.VendaDAO;
import Model.Cliente;
import Model.ItemVenda;
import Model.Produto;
import Model.Venda;

/**
 * Classe representa a classe que são realizadas as vendas do PDV
 * @author everyone
 * @see VendaDAO
 */
public class TelaVendas extends javax.swing.JFrame {

    /**
     * Creates new form TelaVendas
     */
    public TelaVendas() {
        initComponents();
        setLocationRelativeTo(null);
        iniciarTabela();
    }

    private void iniciarTabela(){
        DefaultTableModel modelo = (DefaultTableModel) jTblCarrinho.getModel();
        modelo.setNumRows(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblCarrinho = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBuscarCPF = new javax.swing.JButton();
        btnBuscarProduto = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        btnFinalizarCompra = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtBuscarCPF = new javax.swing.JFormattedTextField();
        txtQuantidade = new javax.swing.JFormattedTextField();
        txtBuscarProduto = new javax.swing.JFormattedTextField();
        btnCadastrarCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Venda");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VENDA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("AppleGothic", 1, 36))); // NOI18N

        jTblCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"0001", "Advil", null, null},
                {"0002", "Allegra", null, null},
                {"0003", "Barra de Cereal", null, null},
                {"0004", "Creme Hidratante", null, null},
                {"0005", "Dipirona", null, null},
                {"0006", "Escova de Dente", null, null},
                {"0007", "Fini", null, null},
                {"0008", "Fralda", null, null},
                {"0009", "Lenço Umedecido", null, null},
                {"0010", "Manteiga de Cacau", null, null},
                {"0011", "Máscara de Cílios", null, null},
                {"0012", "Monster", null, null},
                {"0013", "Novalgina", null, null},
                {"0014", null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "PRODUTO", "QUANTIDADE", "VALOR"
            }
        ));
        jScrollPane1.setViewportView(jTblCarrinho);

        jLabel1.setText("CPF:");

        jLabel2.setText("Digite o código do produto:");

        btnBuscarCPF.setText("Buscar");
        btnBuscarCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCPFActionPerformed(evt);
            }
        });

        btnBuscarProduto.setText("Buscar");
        btnBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProdutoActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        jLabel3.setFont(new java.awt.Font("AppleGothic", 1, 24)); // NOI18N
        jLabel3.setText("TOTAL");

        lblTotal.setFont(new java.awt.Font("AppleGothic", 1, 24)); // NOI18N
        lblTotal.setText("00,00");

        jLabel5.setFont(new java.awt.Font("AppleGothic", 1, 24)); // NOI18N
        jLabel5.setText("R$");

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnFinalizarCompra.setText("Finalizar compra");
        btnFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCompraActionPerformed(evt);
            }
        });

        jLabel6.setText("Quantidade:");

        try {
            txtBuscarCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        txtBuscarProduto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        btnCadastrarCliente.setText("Cadastrar");
        btnCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtBuscarCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCadastrarCliente))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 368, Short.MAX_VALUE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnFinalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarProduto)
                            .addComponent(txtBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscarCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCPF)
                            .addComponent(btnCadastrarCliente))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemover)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lblTotal)
                        .addComponent(jLabel5))
                    .addComponent(btnFinalizarCompra)
                    .addComponent(btnCancelar))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarClienteActionPerformed
        // TODO add your handling code here:
        CadastroCliente janelaModal = new CadastroCliente();
        janelaModal.setVisible(true);
    }//GEN-LAST:event_btnCadastrarClienteActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if(txtQuantidade.getText().isEmpty() || txtQuantidade.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Digite a quantidade de produtos");
            return;
        }
        if(txtBuscarProduto.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite o código do produto");
            return;
        }

        Produto produto = new Produto();
        int quantidade = Integer.parseInt(txtQuantidade.getValue().toString());
        try {
            produto = ProdutoDAO.consultarProduto(Integer.parseInt(txtBuscarProduto.getText()));
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar produto:\n"+e);
            return;
        }
        SomarTotal(produto, quantidade);
        atualizarTabela(produto, quantidade);
        limparCamposBuscaQuantidade();
        return;
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void limparCamposBuscaQuantidade() {
        txtBuscarProduto.setText("");
        txtQuantidade.setText("");
    }

    private void SomarTotal(Produto produto, int quantidade) {
        Double valour_un = produto.getPreco();
        Double aux = valour_un * quantidade;
        Double valor_total = Double.parseDouble(lblTotal.getText().replace(",", "."));
        valor_total += aux;
        lblTotal.setText(valor_total.toString().replace(".", ","));
        //adicionar mais um zero na casa decimal se houver somente um
        if(lblTotal.getText().contains(",")){
            if(lblTotal.getText().substring(lblTotal.getText().indexOf(",")+1).length() == 1){
                lblTotal.setText(lblTotal.getText()+"0");
            }
        }

    }

    private void atualizarTabela(Produto produto, int quantidade) {
        DefaultTableModel model = (DefaultTableModel) jTblCarrinho.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            //se o produto já estiver na tabela, soma a quantidade
            if (model.getValueAt(i, 0).equals(produto.getCodigo())) {
                int qtd = Integer.parseInt(model.getValueAt(i, 2).toString());
                qtd += quantidade;
                model.setValueAt(qtd, i, 2);
                return;
            }
        }
        model.addRow(new Object[]{
                produto.getCodigo(),
                produto.getNome(),
                quantidade,
                produto.getPreco()
            }
        );
    }

    private void btnBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProdutoActionPerformed
        //abrir janela CadastroProduto
        CadastroProduto janelaModal = new CadastroProduto();
        janelaModal.setVisible(true);

        if(txtBuscarProduto.getText().isEmpty()){
            return;
        }
        int cod_prod = Integer.parseInt(txtBuscarProduto.getText());
        Produto produto = new Produto();
        try {
            produto = ProdutoDAO.consultarProduto(cod_prod);
            JOptionPane.showMessageDialog(null, 
                "Produto encontrado\n"+
                "Nome: "+produto.getNome()+"\n"+
                "Preço: "+produto.getPreco()+"\n"+
                "QuantidadeEstoque: "+produto.getQuantidadeEstoque()+"\n"
            );
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }
    }//GEN-LAST:event_btnBuscarProdutoActionPerformed

    private void btnFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCompraActionPerformed
        if(verificarCliente() == false){
            return;
        }
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja finalizar a compra?");
        if (resposta == JOptionPane.NO_OPTION) {
            return;
        }
        if(cadastrarVenda() == true && cadastrarItem_Venda() == true){
            JOptionPane.showMessageDialog(this, "Compra finalizada");
        }
    }//GEN-LAST:event_btnFinalizarCompraActionPerformed

    private boolean cadastrarVenda() {
        Venda venda = new Venda();
        Cliente cliente = new Cliente();
        try {
            String cpf = txtBuscarCPF.getText().replace(".", "").replace("-", "");
            cliente = ClienteDAO.consultarCPF(cpf);
            venda.setId_cliente(cliente.getId_cliente());
            Double valor_total = Double.parseDouble(lblTotal.getText().replace(",", "."));
            venda.setValor(valor_total);
            venda.setData(java.sql.Date.valueOf(LocalDate.now()));
            VendaDAO.inserir(venda);
            return true;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar venda:\n"+e);
        }
        return false;
    }

    private boolean cadastrarItem_Venda() {
        for(int i = 0; i < jTblCarrinho.getRowCount(); i++){
            ItemVenda item = new ItemVenda();
            Double valor_unitario = Double.parseDouble(jTblCarrinho.getValueAt(i, 3).toString());
            int quantidade = Integer.parseInt(jTblCarrinho.getValueAt(i, 2).toString());
            valor_unitario = valor_unitario / quantidade;
            //set itemVenda
            item.setId_venda(VendaDAO.getIdVenda());
            item.setQuantidade(Integer.parseInt(jTblCarrinho.getValueAt(i, 2).toString()));
            item.setValorUnitario(valor_unitario);
            try {
                ItemVendaDAO.inserir(item);
                return true;
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir item de venda:\n");
                System.out.println(e);
                return false;
            }
        }
        return false;
    }

    private boolean verificarCliente() {
        if(verificarCampoCPF() == false){
            JOptionPane.showMessageDialog(null, "Digite o CPF para Prosseguir");
            return false;
        }
        String string_cpf = txtBuscarCPF.getText().replace(".", "").replace("-", "").replace(" ", "");
        Cliente cliente = new Cliente();
        try {
            cliente = ClienteDAO.consultarCPF(string_cpf);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar cliente:\n"+e);
            return false;
        }
        if(cliente.getCpf() == null){
            JOptionPane.showMessageDialog(null, "Cliente não Cadastrado\n"+"Proceda com cadastro para finalizar a venda");
            return false;
        }
        return true;
    }

    private boolean verificarCampoCPF() {
        String cpf = txtBuscarCPF.getText().replace(".", "").replace("-", "".replace(" ", ""));
        if(cpf.length() != 11 || cpf.contains(" ") ){
            return false;
        }
        return true;
    }

    private void btnBuscarCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCPFActionPerformed
        if(verificarCliente() == false){
            return;
        }
        JOptionPane.showMessageDialog(null, "Cliente Encontrado");
    }//GEN-LAST:event_btnBuscarCPFActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTblCarrinho.getModel();
        if(jTblCarrinho.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Selecione um produto para remover");
            return;
        }
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja remover o produto?");
        if (resposta == JOptionPane.NO_OPTION) {
            return;
        }
        model.removeRow(jTblCarrinho.getSelectedRow());
        SubtrairTotal();
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void SubtrairTotal() {
        Double total = 0.0;
        for(int i = 0; i < jTblCarrinho.getRowCount(); i++){
            Double valor_unitario = Double.parseDouble(jTblCarrinho.getValueAt(i, 3).toString());
            int quantidade = Integer.parseInt(jTblCarrinho.getValueAt(i, 2).toString());
            total = total + (valor_unitario * quantidade);
        }
        lblTotal.setText(total.toString().replace(".", ","));

        if(lblTotal.getText().contains(",")){
            if(lblTotal.getText().substring(lblTotal.getText().indexOf(",")+1).length() == 1){
                lblTotal.setText(lblTotal.getText()+"0");
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnBuscarCPF;
    private javax.swing.JButton btnBuscarProduto;
    private javax.swing.JButton btnCadastrarCliente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizarCompra;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblCarrinho;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JFormattedTextField txtBuscarCPF;
    private javax.swing.JFormattedTextField txtBuscarProduto;
    private javax.swing.JFormattedTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
