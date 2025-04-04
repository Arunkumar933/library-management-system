/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.Date;
import javax.swing.JOptionPane;

 
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {  
        initComponents();
    }
     public void getBookDetails(){
         int bookid =Integer.parseInt(txt_BookId.getText());
         
         try {
             Connection con =DBConnection.getConnection();
             PreparedStatement pst =con.prepareStatement("select * from book_details where book_id = ?");
            pst.setInt(1,bookid);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                lbl_BookId.setText(rs.getString("book_id"));
                lbl_BookName.setText(rs.getString("book_name"));
                lbl_Author.setText(rs.getString("author"));
                lbl_quantity.setText(rs.getString("quantity"));
            }else{
                lbl_bookError.setText("invaild book Id");
            }
         }catch (Exception e){
             
             e.printStackTrace();
         }
     }
     
     public void getStudentDetails(){
         int studentid =Integer.parseInt(txt_studentId.getText());
         
         try {
             Connection con =DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from student_details where student_Id = ?");
            pst.setInt(1,studentid);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
               lbl_StudentId.setText(rs.getString("student_Id"));
                lbl_StudentName.setText(rs.getString("name"));
                lbl_course.setText(rs.getString("course"));
                lbl_branch.setText(rs.getString("branch"));
            }else{
                  lbl_studedntName.setText("invaild student Id"); 
                    }
         }catch (Exception e){
             e.printStackTrace();
         }
     }
     
     //insert issue book details to database
       public boolean issueBook(){
           boolean isIssued =false;
           int bookId = Integer.parseInt(txt_BookId.getText());
           int studentId = Integer.parseInt( txt_studentId.getText());
           String bookName = lbl_BookName.getText();
           String studentName = lbl_StudentName.getText();
           
           Date uIssueDate = date_IssueDate.getDatoFecha();
           Date uDueDate = date_DueDate.getDatoFecha();
              
           
               Long l1  = uIssueDate.getTime();
               Long l2 = uDueDate.getTime();
              java.sql.Date sIssueDate =  new java.sql.Date(11);
              java.sql.Date sDueDate =  new java.sql.Date(12);
              
              
              try{
                   Connection con =DBConnection.getConnection();
                  String sql ="insert into issue_book_details(book_id,book_name,student_id,student_name,"
                          +"issue_date,due_date,status)values(?,?,?,?,?,?,?)";
                  
                  PreparedStatement pst =con.prepareStatement(sql);
                  pst.setInt(1,bookId );
                  pst.setString(2,bookName);
                  pst.setInt(3,studentId );
                  pst.setString(4,studentName );
                  pst.setDate(5,sIssueDate );
                  pst.setDate(6,sDueDate );  
                  pst.setString(7,"pending" );
                  
                  
                  int rowCount= pst.executeUpdate();
                  if (rowCount > 0) {
                      isIssued =true;
                  }else{
                      isIssued =false;
                  }
                            
                            
              }catch (Exception e){
                  e.printStackTrace();
                  
              }
           return isIssued;
       }
       public void  updateBookCount(){
             int bookId = Integer.parseInt(txt_BookId.getText());
             try {
              Connection con =DBConnection.getConnection();
              String sql = " update book_details set quantity = quantity-1 where  book_id = ?";
              PreparedStatement pst = con.prepareStatement(sql);
              pst.setInt(1,bookId);
              
              int rowCount = pst.executeUpdate();
              if(rowCount>0){
              JOptionPane.showMessageDialog(this,"boook count updated" );
              int initialCount =Integer.parseInt(lbl_quantity.getText());
              lbl_quantity.setText(Integer.toString (initialCount-1)); 
              }else{
               JOptionPane.showMessageDialog(this,"can't book updated" );   
              
              }
             }
              catch (Exception e){
                      
                      e.printStackTrace();
                      }
       }
       
       
       public boolean isAlreadyIssued(){
           boolean isAlreadyIssued =false;
           int bookId = Integer.parseInt(txt_BookId.getText());
           int studentId =Integer.parseInt(txt_studentId.getText());
           try{
               Connection con = DBConnection.getConnection();
               String sql ="select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
               PreparedStatement pst =con.prepareStatement(sql);
               pst.setInt(1,bookId );
               pst.setInt(2, studentId);
               pst.setString(3,"pending");
               
               
               ResultSet rs =pst.executeQuery();
               if(rs.next()) {
                  isAlreadyIssued=true;
               } else{
                   isAlreadyIssued=false;
               }
           }catch(Exception e){
                       e.printStackTrace();
                       }
           return isAlreadyIssued;
       }
       
       
       
       
    /**
     * 
     * 
     * 
     * 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_branch = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_studedntName = new javax.swing.JLabel();
        lbl_StudentId = new javax.swing.JLabel();
        lbl_StudentName = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        lbl_BookId = new javax.swing.JLabel();
        lbl_BookName = new javax.swing.JLabel();
        lbl_Author = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_BookId = new app.bolivia.swing.JCTextField();
        date_DueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel13 = new javax.swing.JLabel();
        date_IssueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel18 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 0, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LIBRARY_MANAGEMENT_SYSTEM/src/AddNewBookIcons/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel2.setText("Student Details");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 290, 100));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 310, 5));

        lbl_branch.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 230, 30));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(" Student Id :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 110, 30));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Student name :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 140, 30));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("course :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 70, 30));

        lbl_studedntName.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        lbl_studedntName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_studedntName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, 190, 30));

        lbl_StudentId.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        lbl_StudentId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_StudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 230, 30));

        lbl_StudentName.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        lbl_StudentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_StudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 210, 30));

        lbl_course.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 230, 30));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("branch:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 100, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 370, 700));

        jPanel5.setBackground(new java.awt.Color(255, 0, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LIBRARY_MANAGEMENT_SYSTEM/src/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel12.setText("Book Details");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 260, 100));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 310, 5));

        lbl_quantity.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 230, 30));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText(" Book Id :");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 90, 30));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Book name :");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 110, 30));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Author :");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 80, 30));

        lbl_bookError.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 190, 40));

        lbl_BookId.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        lbl_BookId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_BookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 230, 30));

        lbl_BookName.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        lbl_BookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_BookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 220, 30));

        lbl_Author.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        lbl_Author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_Author, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 230, 30));

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Quantity :");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 140, 30));

        jPanel8.setBackground(new java.awt.Color(0, 0, 204));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel7.setText("Back");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -2, 110, 40));

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 700));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LIBRARY_MANAGEMENT_SYSTEM/src/AddNewBookIcons/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel3.setText("Student Details");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 290, 100));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LIBRARY_MANAGEMENT_SYSTEM/src/AddNewBookIcons/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel8.setText("Student Details");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 290, 100));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LIBRARY_MANAGEMENT_SYSTEM/src/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel1.setText("Issue Book");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 66, 200, 60));

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 130, 290, 5));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText(" Due Date :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 430, 100, 30));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));
        txt_studentId.setForeground(new java.awt.Color(204, 204, 204));
        txt_studentId.setText("enter student Id");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 280, 270, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Book Id :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 220, 80, 30));

        txt_BookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));
        txt_BookId.setForeground(new java.awt.Color(204, 204, 204));
        txt_BookId.setText("enter book id");
        txt_BookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_BookIdFocusLost(evt);
            }
        });
        txt_BookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BookIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_BookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 220, 270, -1));

        date_DueDate.setColorBackground(new java.awt.Color(255, 0, 0));
        date_DueDate.setColorButtonHover(new java.awt.Color(255, 0, 0));
        date_DueDate.setColorForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(date_DueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 430, 270, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Student ID :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 280, 100, 30));

        date_IssueDate.setColorBackground(new java.awt.Color(255, 0, 0));
        date_IssueDate.setColorButtonHover(new java.awt.Color(255, 0, 0));
        date_IssueDate.setColorForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(date_IssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 360, 270, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("Issue Date :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 360, 100, 30));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 0, 0));
        rSMaterialButtonCircle1.setText("ISSUE BOOK");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 510, 310, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 700));

        setSize(new java.awt.Dimension(1187, 707));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_BookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BookIdActionPerformed
   
    }//GEN-LAST:event_txt_BookIdActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
   
    if(lbl_quantity.getText().equals("0")) {
     JOptionPane.showMessageDialog(this, "book is not available");   
    }   else{
         if(isAlreadyIssued()== false){
        if(issueBook() ==true){
         JOptionPane.showMessageDialog(this, "book issued successfullt");
         updateBookCount();
     }  else{
         JOptionPane.showMessageDialog(this, "can't issue book"); 
     }     
    }                                                       
     else{
        JOptionPane.showMessageDialog(this, "this student already has this book"); 
     }     
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

     }
    private void txt_BookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_BookIdFocusLost
     if (!txt_BookId.getText().equals("")){
       getBookDetails();       
     }
    }//GEN-LAST:event_txt_BookIdFocusLost

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
          if (!txt_studentId.getText().equals("")){
       getStudentDetails();       
     }
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        HomePage home =new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_DueDate;
    private rojeru_san.componentes.RSDateChooser date_IssueDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_Author;
    private javax.swing.JLabel lbl_BookId;
    private javax.swing.JLabel lbl_BookName;
    private javax.swing.JLabel lbl_StudentId;
    private javax.swing.JLabel lbl_StudentName;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studedntName;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private app.bolivia.swing.JCTextField txt_BookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
