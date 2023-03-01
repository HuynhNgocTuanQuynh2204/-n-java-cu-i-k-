package Quanlynhankhau;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI extends JFrame implements ActionListener {
private JLabel userLabel;
private JTextField userText;
private JLabel passwordLabel;
private JPasswordField passwordText;
private JButton loginButton;
private Connection conn;
public LoginGUI() {
    setTitle("Đăng nhập");
    setSize(300, 150);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 2));

    userLabel = new JLabel("Tài khoản:");
    panel.add(userLabel);

    userText = new JTextField(20);
    panel.add(userText);

    passwordLabel = new JLabel("Mật khẩu:");
    panel.add(passwordLabel);

    passwordText = new JPasswordField(20);
    panel.add(passwordText);

    loginButton = new JButton("Đăng nhập");
    loginButton.addActionListener(this);
    panel.add(loginButton);

    add(panel);

    setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình
    setVisible(true);

    // Kết nối CSDL
    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynhankhau", "root", "220404");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Lỗi kết nối CSDL!");
        System.exit(0);
    }
}

public void actionPerformed(ActionEvent e) {
    String username = userText.getText();
    String password = new String(passwordText.getPassword());

    try {
        // Truy vấn CSDL để kiểm tra tài khoản
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM login WHERE Taikhoan = ? AND Matkhau = ?");
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
            // Chuyển đến giao diện quản lý nhân khẩu
            dispose(); // Đóng giao diện đăng nhập
            Quanlynhankhau qlnkGUI = new Quanlynhankhau();
            qlnkGUI.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu!");
        }

        rs.close();
        stmt.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Lỗi truy vấn CSDL!");
        System.exit(0);
    }
}

public static void main(String[] args) {
    LoginGUI loginGUI = new LoginGUI();
}
}
