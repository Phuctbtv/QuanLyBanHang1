/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.qlbh.view;


import com.mycompany.qlbh.model.KhachHang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Phuc
 */
public class KhachHangPanel extends javax.swing.JPanel {
    List<String> LoaiKhachHang = new ArrayList<>();
    private Object buttonGroup1;
    List <KhachHang> KhachHang = new ArrayList<>();
    /**
     * Creates new form jpnKhachHang
     */
   public void addKhachHang() {
    KhachHang s = new KhachHang();
    s.setMaKhachHang(Integer.parseInt(txtma.getText()));
    s.setTenKhachHang(txtten.getText());
    s.setGioiTinh(rdtnNam.isSelected()); // Sử dụng giá trị của radio button để xác định giới tính
    s.setDiaChi(txtdiachi.getText());
    s.setSoDienThoai(txtsdt.getText());
    s.setLoaiKhachHang((String) cbxloai.getSelectedItem());
    s.setGhiChu(txtghichu.getText());
    s.setChuThich(txtchuthich.getText());
    KhachHang.add(s);
}

  public void showDetail() {
    int selectedRow = jTable1.getSelectedRow();
    
    // Kiểm tra xem có dòng nào được chọn không
    if (selectedRow != -1) {
        // Lấy khách hàng tương ứng từ danh sách KhachHang dựa trên chỉ mục được chọn
        KhachHang khachHang = KhachHang.get(selectedRow);
        
        // Cập nhật thông tin của khách hàng vào các trường văn bản và các phần tử khác trên giao diện
        txtma.setText(String.valueOf(khachHang.getMaKhachHang()));
        txtten.setText(khachHang.getTenKhachHang());
        txtdiachi.setText(khachHang.getDiaChi());
        txtsdt.setText(khachHang.getSoDienThoai());
        txtghichu.setText(khachHang.getGhiChu());
        txtchuthich.setText(khachHang.getChuThich());
        // Đặt lại trạng thái của radio button giới tính dựa trên giá trị của khách hàng
        if (khachHang.isGioiTinh()) {
            rdtnNam.setSelected(true);
            rdtnNu.setSelected(false);
        } else {
            rdtnNam.setSelected(false);
            rdtnNu.setSelected(true);
        }
        
        // Đặt lại giá trị của combobox loại khách hàng
        String loaiKhachHang = khachHang.getLoaiKhachHang();
        cbxloai.setSelectedItem(loaiKhachHang);
    } else {
        // Nếu không có dòng nào được chọn, hiển thị thông báo yêu cầu chọn một khách hàng
        JOptionPane.showMessageDialog(null, "Vui lòng chọn một khách hàng từ bảng để xem thông tin chi tiết.");
    }
}

public void displayKhachHang() {
    // Lấy model của bảng
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    
    // Xóa dữ liệu cũ trong bảng
    model.setRowCount(0);
    
    int STT = 1; // Biến đếm thứ tự khách hàng
    
    // Duyệt qua danh sách khách hàng và thêm từng khách hàng vào bảng
    for (KhachHang khachHang : KhachHang) {
        // Tạo một mảng đối tượng để chứa thông tin của khách hàng
        Object[] rowData = new Object[]{
            STT++, // Thêm STT vào dòng dữ liệu mới
            khachHang.getMaKhachHang(),
            khachHang.getTenKhachHang(),
            khachHang.isGioiTinh()? "Nam" : "Nữ", // Chuyển đổi giới tính thành chuỗi
            khachHang.getDiaChi(),
            khachHang.getSoDienThoai(),
            khachHang.getLoaiKhachHang(),
            khachHang.getGhiChu(),
            khachHang.getChuThich()
        };
        
        // Thêm hàng mới vào model của bảng
        model.addRow(rowData);
    }
}
  public void removeKhachHang(){
      int i= jTable1.getSelectedRow();//lay dong chon
      KhachHang.remove(i);//xoa trong list
      
  }
  public void updateKhachHang(){
      //lay ve chi so duoc chon
      int i=jTable1.getSelectedRow();
      // tao 1 kh
      KhachHang s=KhachHang.get(i);
      //cap nhat tung truong du lieu
      s.setMaKhachHang(Integer.parseInt(txtma.getText()));
    s.setTenKhachHang(txtten.getText());
    s.setGioiTinh(rdtnNam.isSelected()); // Sử dụng giá trị của radio button để xác định giới tính
    s.setDiaChi(txtdiachi.getText());
    s.setSoDienThoai(txtsdt.getText());
    s.setLoaiKhachHang((String) cbxloai.getSelectedItem());
    s.setGhiChu(txtghichu.getText());
    s.setChuThich(txtchuthich.getText());
  }
public void reset() {
    // Đặt lại giá trị của các thành phần nhập liệu, checkbox, radio button, vv. vào giá trị mặc định
    txtma.setText("");
    txtten.setText("");
    txtdiachi.setText("");
    txtsdt.setText("");
    txtghichu.setText("");
    txtchuthich.setText("");
    
    // Đặt lại giá trị của các radio button hoặc checkbox nếu cần
    rdtnNam.setSelected(true); // Đặt lại giá trị mặc định cho radio button Nam
    rdtnNu.setSelected(false); // Đặt lại giá trị mặc định cho radio button Nữ

    // Đặt lại giá trị của JComboBox nếu cần
    cbxloai.setSelectedIndex(0); // Đặt lại giá trị mặc định cho JComboBox

    // Đặt lại giá trị trong bảng (nếu cần)
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Xóa tất cả các dòng trong bảng

    // Gợi ý: Bạn có thể thêm các thao tác khác tùy thuộc vào các thành phần cụ thể trong giao diện người dùng của bạn.
}

    public KhachHangPanel() {
        initComponents();
        buttonGroup2.add(rdtnNam);
        buttonGroup2.add(rdtnNu);
        LoaiKhachHang.add("VIP");
        LoaiKhachHang.add("Thuong");
        cbxloai.removeAllItems();
        for(String loai : LoaiKhachHang){
            cbxloai.addItem(loai);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtma = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lsloai = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtten = new javax.swing.JTextField();
        txtdiachi = new javax.swing.JTextField();
        txtsdt = new javax.swing.JTextField();
        txtghichu = new javax.swing.JTextField();
        rdtnNam = new javax.swing.JRadioButton();
        rdtnNu = new javax.swing.JRadioButton();
        cbxloai = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtchuthich = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Khách Hàng", "Tên Khách hàng", "giới tính", "Địa chỉ", "SĐT", "Loại Khách Hàng", "Ghi chú", "Chú thích"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Mã KH");

        txtma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên KH");

        jLabel3.setText("giới Tính");

        jLabel4.setText("Địa chỉ");

        jLabel5.setText("SĐT");

        lsloai.setText("Loại Khách Hàng");

        jLabel7.setText("Ghi chú");

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        rdtnNam.setText("Nam");

        rdtnNu.setText("Nữ");
        rdtnNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdtnNuActionPerformed(evt);
            }
        });

        cbxloai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Chú Thích");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel6))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtma)
                    .addComponent(txtten)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdtnNam)
                        .addGap(40, 40, 40)
                        .addComponent(rdtnNu))
                    .addComponent(txtchuthich, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lsloai))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtdiachi)
                                    .addComponent(txtsdt)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(txtghichu, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                        .addGap(12, 12, 12)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtchuthich, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lsloai)
                                        .addComponent(cbxloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18))
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rdtnNam)
                                        .addComponent(rdtnNu))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtghichu, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(140, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void txtmaActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
         addKhachHang();
         displayKhachHang();
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        updateKhachHang();
        displayKhachHang();
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        reset();
        displayKhachHang();
    }                                        

    private void rdtnNuActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        removeKhachHang();
        displayKhachHang();
    }                                        


    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbxloai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lsloai;
    private javax.swing.JRadioButton rdtnNam;
    private javax.swing.JRadioButton rdtnNu;
    private javax.swing.JTextField txtchuthich;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtghichu;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txtten;
    // End of variables declaration                   
}


