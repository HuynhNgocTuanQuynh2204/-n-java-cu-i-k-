package Quanlynhankhau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Board extends JFrame implements ActionListener {
    Object[] hienthi = {"id","Họ tên","Mã nhân khẩu","Ngày sinh","Quê quán","CCCD","Nơi thường trú","Ngày chuyển đến","Nghề nghiệp","Dân tộc","Giới tính","Tôn giáo"};
    DefaultTableModel model = new DefaultTableModel(hienthi,0);
    public JTable Hienthi;
	private Connection conn;
	private ResultSet rs;
    public Board() {
        ConnectDB a = new ConnectDB();
        a.Connect();
        
        // Thực hiện truy vấn CSDL
        rs = a.executeQuery("SELECT * FROM nhan_khau");
        try {
            
            
            // Thêm dữ liệu từ truy vấn vào model
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("ho_ten"),
                    rs.getString("ma_nhan_khau"),
                    rs.getString("ngay_sinh"),
                    rs.getString("que_quan"),
                    rs.getString("cccd"),
                    rs.getString("noi_thuong_tru"),
                    rs.getString("ngay_chuyen_den"),
                    rs.getString("nghe_nghiep"),
                    rs.getString("dan_toc"),
                    rs.getString("gioi_tinh"),
                    rs.getString("ton_giao")
                };
                model.addRow(row);
            }
//            Hienthi.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Tạo JTable và đưa vào JScrollPane
        Hienthi = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(Hienthi);
        add(scrollPane);
        setTitle("Quản lý nhân khẩu");
        setSize(1300,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    public static void main(String[] args) {
        new Board();
    }
}
