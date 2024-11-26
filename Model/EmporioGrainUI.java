package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe principal que cria a interface gráfica para o cadastro
 * de usuários, produtos, promoções e vendas do Empório Grão Natural.
 */
public class EmporioGrainUI extends JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;

    // Tela de login
    private JPanel loginPanel;

    // Tela principal após login (Cadastro de Produto, Promoção, Venda)
    private JPanel mainScreenPanel;

    // Tela para cadastro de novo usuário
    private JPanel registerUserPanel;

    public EmporioGrainUI() {
        setTitle("Empório Grão Natural - Cadastro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Inicializa o CardLayout para alternar entre as telas
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Criação da tela de login
        loginPanel = createLoginPanel();

        // Criação da tela principal após login
        mainScreenPanel = createMainScreenPanel();

        // Tela de cadastro de novo usuário
        registerUserPanel = createRegisterUserPanel();

        // Adiciona as telas ao painel principal
        mainPanel.add(loginPanel, "Login");
        mainPanel.add(mainScreenPanel, "MainScreen");
        mainPanel.add(registerUserPanel, "RegisterUser");

        // Adiciona o painel principal à janela
        add(mainPanel);
        setVisible(true);
    }

    /**
     * Cria a tela de login.
     *
     * @return JPanel configurado com campos e botão de login.
     */
    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        // Componentes do formulário de login
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Senha:");
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Cadastrar Novo Usuário");

        // Ação do botão de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Verificar as credenciais de login
                if (email.equals("caique1232@gmail.com") && password.equals("123")) {
                    cardLayout.show(mainPanel, "MainScreen");
                } else {
                    JOptionPane.showMessageDialog(EmporioGrainUI.this, "Credenciais inválidas!");
                }
            }
        });

        // Ação do botão de cadastro de novo usuário
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "RegisterUser");
            }
        });

        // Adiciona os componentes ao painel de login
        loginPanel.add(emailLabel);
        loginPanel.add(emailField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel()); // Espaçamento
        loginPanel.add(loginButton);
        loginPanel.add(new JLabel()); // Espaçamento
        loginPanel.add(registerButton);

        return loginPanel;
    }

    /**
     * Cria a tela para o cadastro de um novo usuário.
     *
     * @return JPanel configurado com campos e botão de cadastro de usuário.
     */
    private JPanel createRegisterUserPanel() {
        JPanel registerUserPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        // Componentes do formulário de cadastro de novo usuário
        JLabel nameLabel = new JLabel("Nome:");
        JTextField nameField = new JTextField();

        JLabel cpfLabel = new JLabel("CPF:");
        JTextField cpfField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Senha:");
        JPasswordField passwordField = new JPasswordField();

        JButton registerButton = new JButton("Cadastrar");

        // Ação do botão de cadastro de novo usuário
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String cpf = cpfField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Simula o cadastro de um novo usuário (exibindo no console)
                System.out.println("Novo usuário cadastrado: " + name + ", CPF: " + cpf + ", Email: " + email);

                // Retorna à tela de login após cadastro
                JOptionPane.showMessageDialog(EmporioGrainUI.this, "Usuário cadastrado com sucesso!");
                cardLayout.show(mainPanel, "Login");
            }
        });

        // Adiciona os componentes ao painel de cadastro de novo usuário
        registerUserPanel.add(nameLabel);
        registerUserPanel.add(nameField);
        registerUserPanel.add(cpfLabel);
        registerUserPanel.add(cpfField);
        registerUserPanel.add(emailLabel);
        registerUserPanel.add(emailField);
        registerUserPanel.add(passwordLabel);
        registerUserPanel.add(passwordField);
        registerUserPanel.add(new JLabel()); // Espaçamento
        registerUserPanel.add(registerButton);

        return registerUserPanel;
    }

    /**
     * Cria o painel principal após login (Cadastro de Produto, Promoção, Venda).
     *
     * @return JPanel configurado com as abas de cadastro e promoção.
     */
    private JPanel createMainScreenPanel() {
        JPanel mainScreenPanel = new JPanel();
        JTabbedPane tabbedPane = new JTabbedPane();

        // Adiciona as abas ao painel
        tabbedPane.addTab("Cadastro de Produto", createProductPanel());
        tabbedPane.addTab("Inserir Promoção", createPromotionPanel());
        tabbedPane.addTab("Cadastrar Venda", createSalePanel());

        mainScreenPanel.add(tabbedPane);
        return mainScreenPanel;
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
        JComboBox<String> productClassCombo = new JComboBox<>(new String[]{"Castanhas", "Farináceos", "Suplementos", "Temperos"});

        JButton registerProductButton = new JButton("Cadastrar Produto");

        // Ação do botão de cadastro de produto
        registerProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = productNameField.getText();
                double productPrice = Double.parseDouble(productPriceField.getText());
                int productStock = Integer.parseInt(productStockField.getText());
                String productClass = (String) productClassCombo.getSelectedItem();

                // Herança: criação de um objeto conforme a classe selecionada
                Produto produto;

                if (productClass.equals("Castanhas")) {
                    produto = new Castanha(productName, productPrice, productStock);
                } else if (productClass.equals("Farináceos")) {
                    produto = new Farinaceos(productName, productPrice, productStock);
                } else if (productClass.equals("Suplementos")) {
                    produto = new Suplemento(productName, productPrice, productStock);
                } else {
                    produto = new Tempero(productName, productPrice, productStock);
                }

                System.out.println(produto);
                JOptionPane.showMessageDialog(EmporioGrainUI.this, "Produto cadastrado com sucesso!");
            }
        });

        // Adiciona os componentes ao painel de cadastro de produto
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
     * Cria o painel para inserir promoções.
     *
     * @return JPanel configurado com campos e botão de inserção de promoção.
     */
    private JPanel createPromotionPanel() {
        JPanel promotionPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        // Componentes do formulário de promoção
        JLabel promoCodeLabel = new JLabel("Código da Promoção:");
        JTextField promoCodeField = new JTextField();

        JLabel discountLabel = new JLabel("Desconto (%)");
        JTextField discountField = new JTextField();

        JButton applyPromotionButton = new JButton("Aplicar Promoção");

        // Ação do botão de aplicar promoção
        applyPromotionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String promoCode = promoCodeField.getText();
                double discount = Double.parseDouble(discountField.getText());

                System.out.println("Promoção aplicada: " + promoCode + " com desconto de " + discount + "%");
                JOptionPane.showMessageDialog(EmporioGrainUI.this, "Promoção aplicada com sucesso!");
            }
        });

        // Adiciona os componentes ao painel de promoção
        promotionPanel.add(promoCodeLabel);
        promotionPanel.add(promoCodeField);
        promotionPanel.add(discountLabel);
        promotionPanel.add(discountField);
        promotionPanel.add(new JLabel()); // Espaçamento
        promotionPanel.add(applyPromotionButton);

        return promotionPanel;
    }

    /**
     * Cria o painel para cadastrar vendas.
     *
     * @return JPanel configurado com campos e botão de cadastro de venda.
     */
    private JPanel createSalePanel() {
        JPanel salePanel = new JPanel(new GridLayout(4, 2, 10, 10));

        // Componentes do formulário de venda
        JLabel saleProductLabel = new JLabel("Produto Vendido:");
        JTextField saleProductField = new JTextField();

        JLabel salePriceLabel = new JLabel("Preço de Venda:");
        JTextField salePriceField = new JTextField();

        JLabel saleQuantityLabel = new JLabel("Quantidade Vendida:");
        JTextField saleQuantityField = new JTextField();

        JButton registerSaleButton = new JButton("Cadastrar Venda");

        // Ação do botão de cadastro de venda
        registerSaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String saleProduct = saleProductField.getText();
                double salePrice = Double.parseDouble(salePriceField.getText());
                int saleQuantity = Integer.parseInt(saleQuantityField.getText());

                // Calcula o total da venda
                double totalSale = salePrice * saleQuantity;

                // Exibe as informações da venda no console
                System.out.println("Venda cadastrada: Produto: " + saleProduct + " | Preço: R$" + salePrice + " | Quantidade: " + saleQuantity + " | Total: R$" + totalSale);
                
                // Exibe uma mensagem de sucesso
                JOptionPane.showMessageDialog(EmporioGrainUI.this, "Venda cadastrada com sucesso!");
            }
        });

        // Adiciona os componentes ao painel de venda
        salePanel.add(saleProductLabel);
        salePanel.add(saleProductField);
        salePanel.add(salePriceLabel);
        salePanel.add(salePriceField);
        salePanel.add(saleQuantityLabel);
        salePanel.add(saleQuantityField);
        salePanel.add(new JLabel()); // Espaçamento
        salePanel.add(registerSaleButton);

        return salePanel;
    }

    // Método principal para iniciar a aplicação
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmporioGrainUI(); // Cria e exibe a interface gráfica
            }
        });
    }
}
