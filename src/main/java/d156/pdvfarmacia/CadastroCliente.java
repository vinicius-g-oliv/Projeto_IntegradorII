/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package d156.pdvfarmacia;

import java.util.Date;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Client;

import DAO.ClienteDAO;
import Model.Cliente;

/**
 * Classe representa a classe de cadastro de clientes da farmácia
 * @author everyone
 * @see Clientes
 * @see ClienteDAO
 */
public class CadastroCliente extends javax.swing.JFrame {

    /**
     * Creates new form CadastroCliente
     */

    public CadastroCliente() {
        
        initComponents();

    }

    public CadastroCliente(Cliente cliente) {
        initComponents();
        mostrarValores(cliente);
        this.btnConcluir.setText("Alterar");
        this.txtCPF.setEnabled(false);
    }

    private void mostrarValores(Cliente cliente) {
        this.txtNome.setText(cliente.getNome()+"");
        this.txtCPF.setText(cliente.getCpf()+"");
        this.txtEndereco.setText(cliente.getEndereco()+"");
        this.txtComplemento.setText(cliente.getComplemento()+"");
        this.txtCEP.setText(cliente.getCep().toString());
        this.txtEmail.setText(cliente.getEmail()+"");
        this.txtNumero.setText(String.valueOf(cliente.getNumero())+"");
        try {
            String data_convertida = converterDateParaString(cliente.getDataNascimento());
            this.txtNascimento.setText(data_convertida);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro ao converter data\n"+e);
            e.printStackTrace();
        }
        if(cliente.getEstadoCivil().equals("Solteira(o)")){
            this.cboCivil.setSelectedIndex(1);
        }
        if(cliente.getEstadoCivil().equals("Casada(o)")){
            this.cboCivil.setSelectedIndex(2);
        }
        if(cliente.getEstadoCivil().equals("Viúva(o)")){
            this.cboCivil.setSelectedIndex(3);
        }
        if(cliente.getSexo().equals("Masculino")){
            this.cboSexo.setSelectedIndex(1);
        }
        if(cliente.getSexo().equals("Feminino")){
            this.cboSexo.setSelectedIndex(2);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtNascimento = new javax.swing.JFormattedTextField();
        txtCPF = new javax.swing.JFormattedTextField();
        cboCivil = new javax.swing.JComboBox<>();
        cboSexo = new javax.swing.JComboBox<>();
        txtEmail = new javax.swing.JTextField();
        jButtonPróximo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCEP = new javax.swing.JFormattedTextField();
        txtComplemento = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        btnConcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        txtNumero = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Cliente");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Clientes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("AppleGothic", 1, 24))); // NOI18N

        jLabel1.setText("*Nome:");

        jLabel2.setText("*CPF:");

        jLabel3.setText("Data de Nascimento:");

        jLabel4.setText("Estado Civil:");

        jLabel5.setText("*Sexo:");

        jLabel6.setText("*E-mail:");

        try {
            txtNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cboCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----- Selecione-----", "Solteira(o)", "Casada(o)", "Viuva(o)" }));

        cboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Selecione----", "Masculino", "Feminino", "Prefiro não informar" }));

        jButtonPróximo.setText("Próximo");
        jButtonPróximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPróximoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtCPF)
                                        .addGap(44, 44, 44))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEmail))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 309, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonPróximo)))
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jButtonPróximo)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dados Básicos", jPanel2);

        jLabel7.setText("*CEP:");

        jLabel8.setText("*Endereço:");

        jLabel9.setText("*Número:");

        jLabel10.setText("*Complemento:");

        try {
            txtCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCEP.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        btnConcluir.setText("Concluir");
        btnConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        txtNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtNumero.setToolTipText("");
        txtNumero.setActionCommand("<Not Set>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConcluir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 124, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnConcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Endereço", jPanel1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirActionPerformed
        if(validarCamposObrigatórios() == false){
            JOptionPane.showMessageDialog(this,"Preencha todos os campos obrigatórios (*)");
            return;
        }
        if(!txtEmail.getText().contains("@") && !txtEmail.getText().contains(".")){
            JOptionPane.showMessageDialog(null, "Email inválido");
            return;
        }
        if(txtNascimento.toString() == null || txtNascimento.toString().equals("00/00/0000")){
            JOptionPane.showMessageDialog(null, "Data de nascimento inválida");
            return;
        }

        Model.Cliente cliente = new Model.Cliente();
        cliente = setCliente(cliente);
        if(btnConcluir.getText().equals("Alterar") && validarCamposObrigatórios() == true && desejaAlterar() == true){
            try{
                ClienteDAO.alterar(cliente);
                JOptionPane.showMessageDialog(this, "Cliente alterado com sucesso!");
                return;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente: " + e.getMessage());
            }
            return;
        }
        try {
            ClienteDAO.inserir(cliente);
            JOptionPane.showMessageDialog(this,"Cadastro Concluido");
            limparCampos();
            // limpa os campos
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this,"Erro ao conectar com o banco de dados\n"+e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnConcluirActionPerformed

    private boolean desejaAlterar() {
        //deseja alterar dadaos?
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja alterar os dados?", "Alterar", JOptionPane.YES_NO_OPTION);
        if(resposta == JOptionPane.YES_OPTION){
            return true;
        }
        return false;
    }

    private void limparCampos() {
        txtNome.setText("");
        cboCivil.setSelectedIndex(0);
        cboSexo.setSelectedIndex(0);
        txtCPF.setValue(null);
        txtEmail.setText("");
        txtNascimento.setValue(null);
        txtCEP.setText("");
        txtEndereco.setText("");
        txtNumero.setText("");
        txtComplemento.setText("");
    }

    private Cliente setCliente(Cliente cliente) {
        String tipoNascimento = txtNascimento.getText().toString();
        String tipoNome = txtNome.getText().toString();
        String tipoCPF = txtCPF.getText().toString();
        String tipoEstadoCivil = cboCivil.getSelectedItem().toString();
        String tipoSexo = cboSexo.getSelectedItem().toString();
        String tipoEmail = txtEmail.getText().toString();
        String tipoCEP = txtCEP.getText().toString().replace("-", "").replace(" ", "");
        String tipoEndereco = txtEndereco.getText().toString();
        String tipoComplemento = txtComplemento.getText().toString();
        int tipoNumero = Integer.parseInt(txtNumero.getText().toString());
        try {
            cliente.setDataNascimento(converterParaDate(tipoNascimento));
        } catch (ParseException e) {
            System.out.println(
                "Erro ao converter data de nascimento do cliente: " + e.getMessage()
            );
        }
        cliente.setNome(tipoNome);
        cliente.setCpf(tipoCPF.replace(".", "").replace("-", ""));
        cliente.setEstadoCivil(tipoEstadoCivil);
        cliente.setSexo(tipoSexo);
        cliente.setEmail(tipoEmail);
        cliente.setCep(tipoCEP.replace("-", "").replace(" ", ""));
        cliente.setComplemento(tipoComplemento);
        cliente.setEndereco(tipoEndereco);
        cliente.setNumero(tipoNumero);
        return cliente;
    }

    private boolean validarCamposObrigatórios() {
        if(
            cboSexo.getSelectedIndex() <= 0 ||
            txtNome.getText().isEmpty() ||
            txtCPF.getText().isEmpty() ||
            txtEmail.getText().isEmpty() ||
            txtCEP.getText().isEmpty() ||
            txtEndereco.getText().isEmpty() ||
            txtNumero.getText().isEmpty() ||
            txtNascimento.getText().isEmpty() ||
            txtCPF.getText().toString().replace(".", "").replace("-", "").length() != 11
        ){
            return false;
        }
        return true;
    }

    private void jButtonPróximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPróximoActionPerformed
        /**
        * leva à próxima aba
        */
        this.jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButtonPróximoActionPerformed

    private java.sql.Date converterParaDate(String string) throws ParseException {
        // trocando de dd/MM/yyyy para yyyy-MM-dd
        string = 
        string.substring(6, 10) + "-" +
        string.substring(3, 5) + "-" +
        string.substring(0, 2);
        // converter para data
        Date dt_nasc = new SimpleDateFormat("yyyy-MM-dd").parse(string);
        java.sql.Date dt_nasc_sql = new java.sql.Date(dt_nasc.getTime());
        return dt_nasc_sql;
    }

    private String converterDateParaString(java.sql.Date date) throws ParseException {
        // converter para string
        Date dt_nasc = new SimpleDateFormat("yyyy-MM-dd").parse(date.toString());
        String dt_nasc_string = new SimpleDateFormat("dd/MM/yyyy").format(dt_nasc);
        return dt_nasc_string;
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
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cboCivil;
    private javax.swing.JComboBox<String> cboSexo;
    private javax.swing.JButton jButtonPróximo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JFormattedTextField txtCEP;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JFormattedTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
