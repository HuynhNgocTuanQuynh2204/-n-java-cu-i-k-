package Quanlynhankhau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Search extends JFrame implements ActionListener {
    Object[] timkiem = {"id","Họ tên","Mã nhân khẩu","Ngày sinh","Quê quán","CCCD","Nơi thường trú","Ngày chuyển đến","Nghề nghiệp","Dân tộc","Giới tính","Tôn giáo"};
    DefaultTableModel model = new DefaultTableModel(timkiem,0);
    public JTable Hienthi;
	private Connection conn;
	private ResultSet rs;
	public Quanlynhankhau quanlynhankhau;
	private String maNhanKhau;
    public Search() {
        ConnectDB a = new ConnectDB();
        a.Connect();
        maNhanKhau = JOptionPane.showInputDialog("Nhập mã nhân khẩu cần tìm kiếm:");
        if (maNhanKhau != null) {
        	 rs = a.executeQuery("SELECT * FROM nhan_khau Where ma_nhan_khau='"+maNhanKhau+"'");
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
//                 Hienthi.setModel(model);
             } catch (SQLException e) {
                 e.printStackTrace();
             }
             
             // Tạo JTable và đưa vào JScrollPane
             Hienthi = new JTable(model);
             JScrollPane scrollPane = new JScrollPane(Hienthi);
             add(scrollPane);
      
        }else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy nhân khẩu!");
            }
        

        // Thực hiện truy vấn CSDL
       
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
        new Search();
    }
}
