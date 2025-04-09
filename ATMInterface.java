import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ATMInterface {
    private JFrame frame;
    private JTextField amountField;
    private JLabel balanceLabel;
    private double balance = 1000;

    public ATMInterface() {
        createGUI();
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return button;
    }

    private void createGUI() {
        frame = new JFrame("ATM Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // Header Panel
        JPanel headerPanel = new JPanel();
        JLabel headerLabel = new JLabel("Welcome to ATM", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(headerLabel);
        frame.add(headerPanel, BorderLayout.NORTH);

        // Main Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Amount Input
        JPanel amountPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        amountPanel.add(new JLabel("Enter Amount: $"));
        amountField = new JTextField(10);
        amountField.setFont(new Font("Arial", Font.PLAIN, 16));
        amountPanel.add(amountField);
        panel.add(amountPanel);

        // Buttons
        JButton withdrawButton = createStyledButton("Withdraw");
        withdrawButton.addActionListener(this::withdraw);
        panel.add(withdrawButton);

        JButton depositButton = createStyledButton("Deposit");
        depositButton.addActionListener(this::deposit);
        panel.add(depositButton);

        JButton checkBalanceButton = createStyledButton("Check Balance");
        checkBalanceButton.addActionListener(this::checkBalance);
        panel.add(checkBalanceButton);

        // Balance Display
        balanceLabel = new JLabel("Current Balance: $" + balance, JLabel.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        balanceLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        panel.add(balanceLabel);

        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void withdraw(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount <= 0 || amount > balance) {
                JOptionPane.showMessageDialog(frame, "Invalid amount or insufficient funds", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                balance -= amount;
                updateBalance();
                JOptionPane.showMessageDialog(frame, "Withdrawal successful", "Transaction Complete", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deposit(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount <= 0) {
                JOptionPane.showMessageDialog(frame, "Please enter a positive amount", "Invalid Amount", JOptionPane.WARNING_MESSAGE);
            } else {
                balance += amount;
                updateBalance();
                JOptionPane.showMessageDialog(frame, "Deposit successful", "Transaction Complete", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void checkBalance(ActionEvent e) {
        JOptionPane.showMessageDialog(frame, "Your current balance is: $" + balance, "Account Balance", JOptionPane.INFORMATION_MESSAGE);
    }

    private void updateBalance() {
        balanceLabel.setText("Current Balance: $" + balance);
        amountField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ATMInterface::new);
    }
}
