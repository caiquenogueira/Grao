import javax.swing.*;
import java.awt.*;

/**
 * Classe principal que cria a interface gráfica para o cadastro
 * de usuários e produtos do Empório Grão Natural.
 */
public class EmporioGrainUI extends JFrame {

    private JPanel mainPanel;

    /**
     * Construtor da classe EmporioGrainUI.
     * Configura o título, tamanho da janela e adiciona abas para
     * o cadastro de usuários e produtos.
     */
    public EmporioGrainUI() {
        setTitle("Empório Grão Natural - Cadastro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Painel principal que contém as abas
        mainPanel = new JPanel();
        JTabbedPane tabbedPane = new JTabbedPane();

        // Adiciona as abas ao painel
        tabbedPane.addTab("Cadastro de Usuário", createUserPanel());
        tabbedPane.addTab("Cadastro de Produto", createProductPanel());

        mainPanel.add(tabbedPane);
        add(mainPanel);

        setVisible(true);
    }

    /**
     * Cria o painel para o cadastro de usuários.
     *
     * @return JPanel configurado com campos e botão de cadastro.
     */
    private JPanel createUserPanel() {
        JPanel userPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        // Componentes do formulário de usuário
        JLabel nameLabel = new JLabel("Nome:");
        JTextField nameField = new JTextField();

        JLabel cpfLabel = new JLabel("CPF:");
        JTextField cpfField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Senha:");
        JPasswordField passwordField = new JPasswordField();

        JButton registerUserButton = new JButton("Cadastrar Usuário");

        // Ação do botão de cadastro de usuário
        registerUserButton.addActionListener(e -> {
            String name = nameField.getText();
            String cpf = cpfField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            // Criação da entidade Usuario
            Usuario usuario = new Usuario(name, cpf, email, password);
            System.out.println(usuario);  // Exibe informações no console
            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
        });

        // Adiciona os componentes ao painel
        userPanel.add(nameLabel);
        userPanel.add(nameField);
        userPanel.add(cpfLabel);
        userPanel.add(cpfField);
        userPanel.add(emailLabel);
        userPanel.add(emailField);
        userPanel.add(passwordLabel);
        userPanel.add(passwordField);
        userPanel.add(new JLabel()); // Espaçamento
        userPanel.add(registerUserButton);

        return userPanel;
    }

    /**
     * Cria o painel para o cadastro de produtos.
     *
     * @return JPanel configurado com campos e botão de cadastro.
     */
    private JPanel createProductPanel() {
        JPanel productPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        // Componentes do formulário de produto
        JLabel productNameLabel = new JLabel("Nome do Produto:");
        JTextField productNameField = new JTextField();

        JLabel productPriceLabel = new JLabel("Preço:");
        JTextField productPriceField = new JTextField();

        JLabel productStockLabel = new JLabel("Quantidade em Estoque:");
        JTextField productStockField = new JTextField();

        JLabel productClassLabel = new JLabel("Classe do Produto:");
        JComboBox<String> productClassCombo = new JComboBox<>(
                new String[]{"Castanhas", "Farináceos", "Suplementos", "Temperos"}
        );

        JButton registerProductButton = new JButton("Cadastrar Produto");

        // Ação do botão de cadastro de produto
        registerProductButton.addActionListener(e -> {
            String productName = productNameField.getText();
            double productPrice = Double.parseDouble(productPriceField.getText());
            int productStock = Integer.parseInt(productStockField.getText());
            String productClass = (String) productClassCombo.getSelectedItem();

            Produto produto;

            // Herança: criação de um objeto conforme a classe selecionada
            if (productClass.equals("Castanhas")) {
                produto = new Castanha(productName, productPrice, productStock);
            } else if (productClass.equals("Farináceos")) {
                produto = new Farinaceos(productName, productPrice, productStock);
            } else if (productClass.equals("Suplementos")) {
                produto = new Suplemento(productName, productPrice, productStock);
            } else {
                produto = new Tempero(productName, productPrice, productStock);
            }

            System.out.println(produto);  // Exibe informações no console
            JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
        });

        // Adiciona os componentes ao painel
        productPanel.add(productNameLabel);
        productPanel.add(productNameField);
        productPanel.add(productPriceLabel);
        productPanel.add(productPriceField);
        productPanel.add(productStockLabel);
        productPanel.add(productStockField);
        productPanel.add(productClassLabel);
        productPanel.add(productClassCombo);
        productPanel.add(new JLabel()); // Espaçamento
        productPanel.add(registerProductButton);

        return productPanel;
    }

    /**
     * Método principal que inicializa a aplicação gráfica.
     *
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(EmporioGrainUI::new);
    }
}
