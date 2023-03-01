package Quanlynhankhau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Quanlynhankhau extends JFrame implements ActionListener {
    private JLabel idLabel,hoTenLabel, maNhanKhauLabel, ngaySinhLabel, queQuanLabel, cccdLabel, noiThuongTruLabel, ngayChuyenDenLabel, ngheNghiepLabel, danTocLabel, gioiTinhLabel, tonGiaoLabel;
    public JTextField idText,hoTenText, maNhanKhauText, ngaySinhText, queQuanText, cccdText, noiThuongTruText, ngayChuyenDenText, ngheNghiepText, danTocText, gioiTinhText, tonGiaoText;
    private JButton themButton, suaButton, xoaButton, timKiemButton, hienThiButton;
    private JPanel panel;
	public String maNhanKhau;
    public JTable Hienthi;
    public Quanlynhankhau() {
        setTitle("Quản lí nhân khẩu");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
       
        idLabel = new JLabel ("Id:");
        panel.add(idLabel);
        
        idText = new JTextField(10);
        panel.add(idText);
        
        hoTenLabel = new JLabel("Họ và tên:");
        panel.add(hoTenLabel);

        hoTenText = new JTextField(10);
        panel.add(hoTenText);

        maNhanKhauLabel = new JLabel("Mã nhân khẩu:");
        panel.add(maNhanKhauLabel);

        maNhanKhauText = new JTextField(10);
        panel.add(maNhanKhauText);

        ngaySinhLabel = new JLabel("Ngày sinh (yyyy-mm-dd):");
        panel.add(ngaySinhLabel);

        ngaySinhText = new JTextField(10);
        panel.add(ngaySinhText);

        queQuanLabel = new JLabel("Quê quán:");
        panel.add(queQuanLabel);

        queQuanText = new JTextField(10);
        panel.add(queQuanText);

        cccdLabel = new JLabel("CCCD:");
        panel.add(cccdLabel);

        cccdText = new JTextField(10);
        panel.add(cccdText);

        noiThuongTruLabel = new JLabel("Nơi thường trú:");
        panel.add(noiThuongTruLabel);

        noiThuongTruText = new JTextField(10);
        panel.add(noiThuongTruText);

        ngayChuyenDenLabel = new JLabel("Ngày chuyển đến (yyyy-mm-dd):");
        panel.add(ngayChuyenDenLabel);

        ngayChuyenDenText = new JTextField(10);
        panel.add(ngayChuyenDenText);

        ngheNghiepLabel = new JLabel("Nghề nghiệp:");
        panel.add(ngheNghiepLabel);

        ngheNghiepText = new JTextField(10);
        panel.add(ngheNghiepText);

        danTocLabel = new JLabel("Dân tộc:");
        panel.add(danTocLabel);

        danTocText = new JTextField(10);
        panel.add(danTocText);
        gioiTinhLabel = new JLabel("Giới tính:");
        panel.add(gioiTinhLabel);

        gioiTinhText = new JTextField(10);
        panel.add(gioiTinhText);

        tonGiaoLabel = new JLabel("Tôn giáo:");
        panel.add(tonGiaoLabel);

        tonGiaoText = new JTextField(10);
        panel.add(tonGiaoText);

        themButton = new JButton("Thêm");
        panel.add(themButton);
        themButton.addActionListener(this);

        suaButton = new JButton("Sửa");
        panel.add(suaButton);
        suaButton.addActionListener(this);

        xoaButton = new JButton("Xóa");
        panel.add(xoaButton);
        xoaButton.addActionListener(this);

        timKiemButton = new JButton("Tìm kiếm");
        panel.add(timKiemButton);
        timKiemButton.addActionListener(this);

        hienThiButton = new JButton("Hiển thị");
        panel.add(hienThiButton);
        hienThiButton.addActionListener(this);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
    	Quanlynhankhau  Quanlynhankhau  = new Quanlynhankhau ();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == themButton) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynhankhau", "root", "220404");
                Statement statement = conn.createStatement();
                String id = idText.getText();
                String hoTen = hoTenText.getText();
                String maNhanKhau = maNhanKhauText.getText();
                String ngaySinh = ngaySinhText.getText();
                String queQuan = queQuanText.getText();
                String cccd = cccdText.getText();
                String noiThuongTru = noiThuongTruText.getText();
                String ngayChuyenDen = ngayChuyenDenText.getText();
                String ngheNghiep = ngheNghiepText.getText();
                String danToc = danTocText.getText();
                String gioiTinh = gioiTinhText.getText();
                String tonGiao = tonGiaoText.getText();
                String query = "INSERT INTO nhan_khau VALUES ('" + id + "','" + hoTen + "', '" + maNhanKhau + "', '" + ngaySinh + "', '" + queQuan + "', '" + cccd + "', '" + noiThuongTru + "', '" + ngayChuyenDen + "', '" + ngheNghiep + "', '" + danToc + "', '" + gioiTinh + "', '" + tonGiao + "')";
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Thêm nhân khẩu thành công!");
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
            }
        } else if (e.getSource() == suaButton) {
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynhankhau", "root", "220404");
                Statement statement = conn.createStatement();
                String id = idText.getText();
                String hoTen = hoTenText.getText();
                String maNhanKhau = maNhanKhauText.getText();
                String ngaySinh = ngaySinhText.getText();
                String queQuan = queQuanText.getText();
                String cccd = cccdText.getText();
                String noiThuongTru = noiThuongTruText.getText();
                String ngayChuyenDen = ngayChuyenDenText.getText();
                String ngheNghiep = ngheNghiepText.getText();
                String danToc = danTocText.getText();
                String gioiTinh = gioiTinhText.getText();
                String tonGiao = tonGiaoText.getText();
                String query = "UPDATE nhan_khau SET id='" + id +"', ho_ten='" + hoTen + "', ngay_sinh='" + ngaySinh + "', que_quan='" + queQuan + "', cccd='" + cccd + "', noi_thuong_tru='" + noiThuongTru + "', ngay_chuyen_den='" + ngayChuyenDen + "', nghe_nghiep='" + ngheNghiep + "', dan_toc='" + danToc + "', gioi_tinh='" +gioiTinh + "', ton_giao='" + tonGiao + "' WHERE ma_nhan_khau='" + maNhanKhau + "'";

                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Cập nhật thông tin nhân khẩu thành công!");
                conn.close();
                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
                }
                } else if (e.getSource() == xoaButton) {
                try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynhankhau", "root", "220404");
                Statement statement = conn.createStatement();
                String maNhanKhau = maNhanKhauText.getText();
                String query = "DELETE FROM nhan_khau WHERE ma_nhan_khau='" + maNhanKhau + "'";
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Xóa nhân khẩu thành công!");
                conn.close();
                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
                }
                } else if (e.getSource() == timKiemButton) {
                
                new Search();
                } else 
                {
                	new Board();
                	}
                	}
                	}


	