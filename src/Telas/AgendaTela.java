/*
 * Tela usada para o crud da agenda.
 */
package Telas;

import DAO.Conexao;
import Modelo.Usuario;
import Validacao.Validador;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dimpeny
 */
public class AgendaTela extends javax.swing.JFrame {

    Usuario usuario;

    List<String> listaCpf = new ArrayList<>();

    String velhaData = "";

    /**
     * Creates new form Agenda
     *
     * @param usuario É o usuário passado pela tela de login.
     */
    public AgendaTela(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        this.setTitle("Agenda | Usuário: " + usuario.getNome() + "| ID: " + usuario.getId());
        carregarCampoClientes();
        carregarTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jMenu1 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoCpf = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("###.###.###-##");
            campoCpf = new javax.swing.JFormattedTextField(cpf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        campoData = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter data = new javax.swing.text.MaskFormatter("##/##/####");
            campoData = new javax.swing.JFormattedTextField(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        botaoRegistrar = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAgenda = new javax.swing.JTable();
        campoHora = new javax.swing.JComboBox<>();
        campoCliente = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAgenda = new javax.swing.JMenu();
        menuClientes = new javax.swing.JMenu();

        jLabel4.setText("jLabel4");

        jTextField4.setText("jTextField4");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CPF");

        jLabel2.setText("Nome");

        jLabel3.setText("Data:");

        campoCpf.setEditable(false);

        campoData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDataActionPerformed(evt);
            }
        });

        botaoRegistrar.setText("Registrar");
        botaoRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRegistrarActionPerformed(evt);
            }
        });

        botaoEditar.setText("Editar");
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarActionPerformed(evt);
            }
        });

        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        botaoLimpar.setText("Limpar");
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });

        tabelaAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome", "Data", "Hora"
            }
        ));
        tabelaAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAgendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAgenda);

        campoHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[Selecione]", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45" }));

        campoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "[Selecione]" }));
        campoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoClienteActionPerformed(evt);
            }
        });

        menuAgenda.setText("Agenda");
        menuAgenda.setToolTipText("Tela atual");
        menuAgenda.setEnabled(false);
        menuAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAgendaMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuAgenda);

        menuClientes.setText("Clientes");
        menuClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuClientesMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuClientes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoRegistrar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoLimpar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoData))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(campoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 98, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(campoHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoExcluir))
                            .addComponent(botaoEditar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoRegistrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(botaoEditar)
                    .addComponent(campoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoExcluir)
                    .addComponent(campoHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campoDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDataActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        // TODO add your handling code here
        editarAgenda();
        carregarTabela();
        limparCampos();
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed
        limparCampos();
        carregarTabela();
    }//GEN-LAST:event_botaoLimparActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        excluirAgenda();
        carregarTabela();

    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void botaoRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRegistrarActionPerformed
        registrarAgenda();
        carregarTabela();

    }//GEN-LAST:event_botaoRegistrarActionPerformed

    private void menuAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAgendaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuAgendaMouseClicked

    private void menuClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuClientesMouseClicked
        if (!camposPreenchidos()) {
            new ClientesTela(usuario).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Há campos ainda preenchidos.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_menuClientesMouseClicked

    private void tabelaAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAgendaMouseClicked
        carregarDados();
    }//GEN-LAST:event_tabelaAgendaMouseClicked

    private void campoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoClienteActionPerformed
        carregarCpfCliente();
    }//GEN-LAST:event_campoClienteActionPerformed

    /**
     * Método usado para inserir um novo registro na agenda
     */
    private void registrarAgenda() {
        if (dataValida(campoData.getText()) && Validador.cpfValido(campoCpf.getText()) && campoHora.getSelectedIndex() != 0 && campoCliente.getSelectedIndex() != 0 && dataHoraUnicas()) {
            Connection c = Conexao.conectarBD();
            String sql = "INSERT INTO agenda (cliente_cpf,data_vacinacao) VALUES (?,?)";
            if (c != null) {
                try {
                    try (PreparedStatement ps = c.prepareStatement(sql)) {
                        String dataHora = campoData.getText() + " " + campoHora.getSelectedItem();
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd hh:mm");
                        Date dataFormatada = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(dataHora);
                        String dataBD = formato.format(dataFormatada);

                        ps.setString(1, campoCpf.getText());
                        ps.setString(2, dataBD);

                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Agendamento registrado com sucesso!", "Sucesso", JOptionPane.PLAIN_MESSAGE);
                        limparCampos();
                    }
                    c.close();
                } catch (HeadlessException | SQLException | ParseException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } finally {
                    carregarTabela();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao conectar na base.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else if (campoCpf.getText().equals("   .   .   -  ")) {
            JOptionPane.showMessageDialog(this, "Atenção: O campo CPF não pode estar em branco.", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else if (!dataValida(campoData.getText())) {
            JOptionPane.showMessageDialog(this, "Atenção: A data '" + campoData.getText() + "' é invalida.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Método usado para excluir um agendamento
     */
    private void excluirAgenda() {
        if (dataValida(campoData.getText()) && Validador.cpfValido(campoCpf.getText()) && campoHora.getSelectedIndex() != 0 && campoCliente.getSelectedIndex() != 0 && JOptionPane.showConfirmDialog(null, "Você tem certeza?", "Atenção",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            Connection c = Conexao.conectarBD();
            String sql = "DELETE FROM agenda WHERE data_vacinacao = ? AND cliente_cpf = ?";
            if (c != null) {
                try {
                    try (PreparedStatement ps = c.prepareStatement(sql)) {
                        String dataHora = campoData.getText() + " " + campoHora.getSelectedItem();
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                        Date dataFormatada = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(dataHora);
                        String dataBD = formato.format(dataFormatada);

                        ps.setString(1, dataBD);
                        ps.setString(2, campoCpf.getText());

                        System.out.println(ps);
                        ps.executeUpdate();

                        JOptionPane.showMessageDialog(this, "Agendamento excluido", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                    c.close();
                } catch (ParseException | HeadlessException | SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                } finally {
                    carregarTabela();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao conectar na base.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Método utilizado para editar um agendamento
     */
    private void editarAgenda() {
        if (dataValida(campoData.getText()) && Validador.cpfValido(campoCpf.getText()) && campoHora.getSelectedIndex() != 0 && campoCliente.getSelectedIndex() != 0 && dataHoraUnicas()) {
            Connection c = Conexao.conectarBD();
            String sql = "INSERT INTO agenda (cliente_cpf,data_vacinacao) VALUES (?,?)";
            String sqlEx = "DELETE FROM agenda WHERE data_vacinacao = ? AND cliente_cpf = ?";
            if (c != null) {
                try {
                    try (PreparedStatement ps = c.prepareStatement(sql)) {
                        String dataHora = campoData.getText() + " " + campoHora.getSelectedItem();
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd hh:mm");
                        Date dataFormatada = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(dataHora);
                        String dataBD = formato.format(dataFormatada);

                        ps.setString(1, campoCpf.getText());
                        ps.setString(2, dataBD);

                        System.out.println(ps);
                        ps.executeUpdate();

                        try (PreparedStatement psEx = c.prepareStatement(sqlEx)) {
                            psEx.setString(1, velhaData.replaceAll("/", "-"));
                            psEx.setString(2, campoCpf.getText());

                            System.out.println(psEx);
                            psEx.executeUpdate();
                        }

                        JOptionPane.showMessageDialog(this, "Agendamento editado", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                    c.close();
                } catch (ParseException | HeadlessException | SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                } finally {
                    carregarTabela();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao conectar na base.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Método utilizado para carregar o CPF do cliente no campo CPF ao
     * selecionar um cliente no campoCliente
     */
    private void carregarCpfCliente() {
        int index = campoCliente.getSelectedIndex() - 1;
        if (index >= 0 && !listaCpf.isEmpty()) {
            campoCpf.setText(listaCpf.get(index));
        }
    }

    /**
     * Método utilizado para preencher o dropdown campoCliente listaCpf é
     * utilizado para guardar os CPFs dos clientes em ordem
     */
    private void carregarCampoClientes() {
        try {
            try (Connection con = Conexao.conectarBD()) {
                String sql = "select cpf,nome from cliente order by nome";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    listaCpf.add(rs.getString(1));
                    campoCliente.addItem(rs.getString(2));
                }
                ps.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro carregar campo Cliente!", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao carregar campo Cliente: " + e);
        }
    }

    /**
     * Método utilizado para carrega a tabela de agendamentos.
     */
    private void carregarTabela() {
        Connection c = Conexao.conectarBD();
        DefaultTableModel model = (DefaultTableModel) tabelaAgenda.getModel();
        model.setNumRows(0);
        String sql = "SELECT c.cpf, c.nome, date_format(a.data_vacinacao,'%d/%m/%Y') data_v, date_format(a.data_vacinacao,'%H:%i') hora_v FROM cliente c INNER JOIN agenda a ON c.cpf = a.cliente_cpf ORDER BY c.nome";
        if (c != null) {
            try {
                try (PreparedStatement ps = c.prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        model.addRow(new Object[]{
                            rs.getString("cpf"),
                            rs.getString("nome"),
                            rs.getString("data_v"),
                            rs.getString("hora_v")
                        });
                    }
                }
                c.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar na base.", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
        if (model.getRowCount() == 0) {
            model.addRow(new Object[]{
                ""
            });
        }
    }

    /**
     * Valida se a data informada é valida para prevenir inserir datas como
     * 32/13/2021 por exemplo.
     *
     * @param data data de nascimento informada.
     * @return true se a data for valida, senão retorna false.
     */
    public boolean dataValida(String data) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
            LocalDate d = LocalDate.parse(data, formatter);
            System.out.println("Data/Hora valida: " + data);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Data/Hora invalida: " + data);
            JOptionPane.showMessageDialog(this, "Data '" + data + "' não é valida.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }

        return false;
    }

    private void limparCampos() {
        campoData.setText("");
        campoCpf.setText("");
        campoCliente.setSelectedIndex(0);
        campoHora.setSelectedIndex(0);
    }

    /**
     * Método chamado para carregar as informações do cliente nos campos ao
     * clicar na tabela.
     */
    private void carregarDados() {
        int linha = tabelaAgenda.getSelectedRow();
        if (tabelaAgenda.getValueAt(linha, 0).toString().equals("")) {
            JOptionPane.showMessageDialog(this, "Nenhuma agenda encontrada.", "Atenção!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        campoCpf.setText(tabelaAgenda.getValueAt(linha, 0).toString());
        carregarDadosCampoCliente(campoCpf.getText());

        campoData.setText(tabelaAgenda.getValueAt(linha, 2).toString());
        carregarDadoCampoHora(tabelaAgenda.getValueAt(linha, 3).toString());

        try {
            String dataHora = campoData.getText() + " " + campoHora.getSelectedItem();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd hh:mm");
            Date dataFormatada = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(dataHora);
            velhaData = formato.format(dataFormatada);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Campo utilizado para carregar o campoCliente ao chamar o método Carregar
     * Dados.
     *
     * @param cpf É o CPF do cliente.
     */
    private void carregarDadosCampoCliente(String cpf) {
        for (int i = 0; i < listaCpf.size(); i++) {
            if (cpf.equals(listaCpf.get(i))) {
                campoCliente.setSelectedIndex(i + 1);
                break;
            }
        }
    }

    /**
     * É o método utilizado para carregar o campoHora ao chamar o método
     * Carregar Dados
     *
     * @param hora
     */
    public void carregarDadoCampoHora(String hora) {
        for (int i = 0; i < campoHora.getItemCount(); i++) {
            if (hora.equals(campoHora.getItemAt(i))) {
                campoHora.setSelectedIndex(i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Usuario usuario = new Usuario(0, "EXAMPLE USER");
        java.awt.EventQueue.invokeLater(() -> {
            new AgendaTela(usuario).setVisible(true);
        });
    }

    private boolean dataHoraUnicas() {
        boolean unica = false;
        Connection c = Conexao.conectarBD();
        DefaultTableModel model = (DefaultTableModel) tabelaAgenda.getModel();
        model.setNumRows(0);
        String sql = "SELECT count(data_vacinacao) FROM agenda WHERE data_vacinacao = ?";
        if (c != null) {
            try {
                try (PreparedStatement ps = c.prepareStatement(sql)) {
                    String dataHora = campoData.getText() + " " + campoHora.getSelectedItem();
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd hh:mm");
                    Date dataFormatada = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(dataHora);
                    String dataBD = formato.format(dataFormatada);

                    ps.setString(1, dataBD);

                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        unica = rs.getInt("count(data_vacinacao)") == 0;
                    }
                }
                c.close();
            } catch (ParseException | SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar na base.", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
        if (!unica) {
            JOptionPane.showMessageDialog(this, "Data e hora já registradas, por favor escolha outra data ou horário.", "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
        return unica;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoRegistrar;
    private javax.swing.JComboBox<String> campoCliente;
    private javax.swing.JTextField campoCpf;
    private javax.swing.JTextField campoData;
    private javax.swing.JComboBox<String> campoHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JMenu menuAgenda;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JTable tabelaAgenda;
    // End of variables declaration//GEN-END:variables

    private boolean camposPreenchidos() {
        return !(campoCpf.getText().equals("   .   .   -  ") || campoData.getText().equals("  /  /    ") || campoHora.getSelectedIndex() == 0 || campoCliente.getSelectedIndex() == 0);
    }
}
