package Model;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class EmporioGrainUI extends JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;
    private Map<String, String> users;

    public EmporioGrainUI() {
        setTitle("Empório Grão Natural - Cadastro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        users = new HashMap<>();
        users.put("caique1232@gmail.com", "123");

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createLoginPanel(), "Login");
        mainPanel.add(createMainScreenPanel(), "MainScreen");
        mainPanel.add(createRegisterUserPanel(), "RegisterUser");

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Senha:");
        JPasswordField passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Cadastrar Novo Usuário");

        styleButton(loginButton);
        styleButton(registerButton);

        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (users.containsKey(email) && users.get(email).equals(password)) {
                cardLayout.show(mainPanel, "MainScreen");
            } else {
                JOptionPane.showMessageDialog(this, "Credenciais inválidas!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        registerButton.addActionListener(e -> cardLayout.show(mainPanel, "RegisterUser"));

        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        loginPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        loginPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        loginPanel.add(loginButton, gbc);

        gbc.gridy = 3;
        loginPanel.add(registerButton, gbc);

        return loginPanel;
    }

    private JPanel createRegisterUserPanel() {
        JPanel registerPanel = new JPanel(new GridBagLayout());
        registerPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel nameLabel = new JLabel("Nome:");
        JTextField nameField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Senha:");
        JPasswordField passwordField = new JPasswordField(20);

        JButton registerButton = new JButton("Cadastrar");
        JButton backButton = new JButton("Voltar");

        styleButton(registerButton);
        styleButton(backButton);

        registerButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (users.containsKey(email)) {
                JOptionPane.showMessageDialog(this, "Email já cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                users.put(email, password);
                JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
                cardLayout.show(mainPanel, "Login");
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Login"));

        gbc.gridx = 0;
        gbc.gridy = 0;
        registerPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        registerPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        registerPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        registerPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        registerPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        registerPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        registerPanel.add(registerButton, gbc);

        gbc.gridy = 4;
        registerPanel.add(backButton, gbc);

        return registerPanel;
    }

    private JPanel createMainScreenPanel() {
        JPanel mainScreenPanel = new JPanel(new BorderLayout());
        mainScreenPanel.setBackground(Color.ORANGE);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Cadastro de Produto", createProductPanel());
        tabbedPane.addTab("Inserir Promoção", createPromotionPanel());
        tabbedPane.addTab("Cadastrar Venda", createSalePanel());

        mainScreenPanel.add(tabbedPane, BorderLayout.CENTER);
        return mainScreenPanel;
    }

    private JPanel createProductPanel() {
        return createPanelWithCategorySelection("Cadastrar Produto", "Produto", "Preço", "Quantidade");
    }

    private JPanel createPromotionPanel() {
        return createPanelWithCategorySelection("Inserir Promoção", "ID Produto", "Desconto (%)", "Promoção");
    }

    private JPanel createSalePanel() {
        return createPanelWithCategorySelection("Cadastrar Venda", "ID Produto", "Preço Unitário", "Quantidade");
    }

    private JPanel createPanelWithCategorySelection(String buttonLabel, String field1, String field2, String field3) {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBackground(Color.WHITE);

        JLabel field1Label = new JLabel(field1 + ":");
        JTextField field1Field = new JTextField();

        JLabel field2Label = new JLabel(field2 + ":");
        JTextField field2Field = new JTextField();

        JLabel categoryLabel = new JLabel("Categoria:");
        JComboBox<String> categoryComboBox = new JComboBox<>(new String[]{"Farináceos", "Castanhas", "Suplementos", "Temperos"});

        JButton actionButton = new JButton(buttonLabel);
        JButton backButton = new JButton("Voltar");

        styleButton(actionButton);
        styleButton(backButton);

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "MainScreen"));

        panel.add(field1Label);
        panel.add(field1Field);
        panel.add(field2Label);
        panel.add(field2Field);
        panel.add(categoryLabel);
        panel.add(categoryComboBox);
        panel.add(actionButton);
        panel.add(backButton);

        return panel;
    }

    private void styleButton(JButton button) {
        button.setBackground(Color.ORANGE);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EmporioGrainUI::new);
    }
}
