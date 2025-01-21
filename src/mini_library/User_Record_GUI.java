/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mini_library;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class User_Record_GUI extends javax.swing.JFrame {

    /**
     * Creates new form User_Record_GUI
     */
    ArrayList<User> userList = new ArrayList<>();
    DefaultTableModel model;

    public User_Record_GUI() {
        initComponents();
        model = (DefaultTableModel) table.getModel();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        useridTF = new javax.swing.JTextField();
        nameTF = new javax.swing.JTextField();
        phoneNoTF = new javax.swing.JTextField();
        emailTF = new javax.swing.JTextField();
        maleRB = new javax.swing.JRadioButton();
        femaleRB = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        insertBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        displayAllBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("USER RECORD");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("User ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Gender");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Phone No.");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Email");

        useridTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        nameTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        phoneNoTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        emailTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        buttonGroup.add(maleRB);
        maleRB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        maleRB.setText("Male");
        maleRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRBActionPerformed(evt);
            }
        });

        buttonGroup.add(femaleRB);
        femaleRB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        femaleRB.setText("Female");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailTF)
                    .addComponent(phoneNoTF)
                    .addComponent(nameTF)
                    .addComponent(useridTF)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(maleRB, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(femaleRB, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(useridTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(maleRB)
                    .addComponent(femaleRB))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(phoneNoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        insertBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        insertBtn.setText("INSERT");
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });

        updateBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        updateBtn.setText("UPDATE");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        searchBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        searchBtn.setText("SEARCH");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(255, 0, 51));
        deleteBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        displayAllBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        displayAllBtn.setText("DISPLAY ALL");
        displayAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayAllBtnActionPerformed(evt);
            }
        });

        resetBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        resetBtn.setText("RESET");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(displayAllBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(insertBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(insertBtn)
                .addGap(18, 18, 18)
                .addComponent(updateBtn)
                .addGap(18, 18, 18)
                .addComponent(searchBtn)
                .addGap(18, 18, 18)
                .addComponent(deleteBtn)
                .addGap(18, 18, 18)
                .addComponent(displayAllBtn)
                .addGap(18, 18, 18)
                .addComponent(resetBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Name", "Gender", "Phone No.", "Email"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void clearAllField() {
        useridTF.setText("");
        nameTF.setText("");
        phoneNoTF.setText("");
        emailTF.setText("");
        buttonGroup.clearSelection();
    }

    public boolean isUserIDExist(int userID) {
        for (User u : userList) {
            if (u.getUserID() == userID) {
                return true;
            }
        }
        return false;
    }

    public boolean isSomeFieldEmpty() {
        String useridStr = useridTF.getText();
        String name = nameTF.getText();
        String phoneNo = phoneNoTF.getText();
        String email = emailTF.getText();

        if (useridStr.isEmpty() || name.isEmpty() || phoneNo.isEmpty() || email.isEmpty() || (!maleRB.isSelected() && !femaleRB.isSelected())) {
            return true;
        }

        return false;
    }

//    public User searchUser(String searchToken) {
//        for (User user : userList) {
//            if (user.getUserID() == Integer.parseInt(searchToken) || user.getName().equals(searchToken)) {
//                model.addRow(new Object[]{user.getUserID(), user.getName(), user.getGender(), user.getPhoneNumber(), user.getEmail()});
//            }
//            return user;
//        }
//        return null;
//    }
    public User searchBy(Tester t) {
        for (User user : userList) {
            if (t.test(user)) {
                model.addRow(new Object[]{user.getUserID(), user.getName(), user.getGender(), user.getPhoneNumber(), user.getEmail()});
                return user;
            }
        }
        return null;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Admin_Portal_GUI().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void maleRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleRBActionPerformed

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        // TODO add your handling code here:
        try {
            String useridStr = useridTF.getText();

            int userID = Integer.parseInt(useridStr);
            String name = nameTF.getText();
            String phoneNo = phoneNoTF.getText();
            String email = emailTF.getText();
            String gender = null;

            //check first if userID already existed
            if (isUserIDExist(userID)) {
                JOptionPane.showMessageDialog(null, "There is an existing user with that User ID!");
                return;
            }

            //check if all field is filled before creating the object
            if (isSomeFieldEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter all details!");
                return;
            }

            if (maleRB.isSelected()) {
                gender = "Male";
            } else if (femaleRB.isSelected()) {
                gender = "Female";
            }

            User newUser = new User(userID, name, gender, phoneNo, email);
            userList.add(newUser);

            model.insertRow(model.getRowCount(), new Object[]{userID, name, gender, phoneNo, email});
            JOptionPane.showMessageDialog(null, "User is added!");
            clearAllField();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter an integer value for User ID!");
            clearAllField();
        }
    }//GEN-LAST:event_insertBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        // TODO add your handling code here:
        clearAllField();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        if (userList.size() == 0) {
            JOptionPane.showMessageDialog(null, "There is no user in the list to be searched.");
            return;
        }

        int choice = JOptionPane.showConfirmDialog(null, "Click 'Yes' to search based on User ID and Click 'No' to search based on name!", "Search for User", JOptionPane.YES_NO_OPTION);
        model.setRowCount(0);

        try {
            if (choice == JOptionPane.YES_OPTION) {
                String id = JOptionPane.showInputDialog(null, "Enter User ID to be searched.");

                if (id != null) {

                    Tester<User> testID = user -> user.getUserID() == Integer.parseInt(id.trim());

                    if (searchBy(testID) != null) {
                        JOptionPane.showMessageDialog(null, "User is found.");

                    } else {
                        JOptionPane.showMessageDialog(null, "User is not found.");

                    }
                }

            } else {
                String name = JOptionPane.showInputDialog(null, "Enter name to be searched.");
                if (name != null) {
                    Tester<User> testName = user -> user.getName().equalsIgnoreCase(name.trim());
                    searchBy(testName);

                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Make sure you entered the correct input.");
            return;
        }

//        String useridStr = useridTF.getText();
//        String name = nameTF.getText();
//
//        if (useridStr.isEmpty() && name.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Please enter the User ID or name to be searched!");
//            return;
//        }
//
//        if (searchUser(useridStr) != null || searchUser(name) != null) {
//            JOptionPane.showMessageDialog(null, "User is found!");
//        } else {
//            JOptionPane.showMessageDialog(null, "User is not found!");
//        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void displayAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayAllBtnActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);

        for (User user : userList) {
            model.insertRow(model.getRowCount(), new Object[]{user.getUserID(), user.getName(), user.getGender(), user.getPhoneNumber(), user.getEmail()});
        }
    }//GEN-LAST:event_displayAllBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        if (userList.size() == 0) {
            JOptionPane.showMessageDialog(null, "There is no user in the list to be updated.");
            return;
        }

        if (isSomeFieldEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a row to be updated first!");
            return;
        }

        int id = Integer.parseInt(useridTF.getText());

        if (!isUserIDExist(id)) {
            JOptionPane.showMessageDialog(null, "There is no such user is found with this User ID: " + id);
            return;
        }

        String name = nameTF.getText();
        String phoneNo = phoneNoTF.getText();
        String email = emailTF.getText();

        int choice = JOptionPane.showConfirmDialog(null, "You are editing this user information. \nDo you want to apply these changes?", "Update User Information", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            for (User user : userList) {
                if (user.getUserID() == id) {
                    user.setName(name);
                    user.setPhoneNumber(phoneNo);
                    user.setEmail(email);

                    if (maleRB.isSelected()) {
                        user.setGender("Male");
                    } else {
                        user.setGender("Female");
                    }
                    model.setRowCount(0);
                    model.addRow(new Object[]{user.getUserID(), user.getName(), user.getGender(), user.getPhoneNumber(), user.getEmail()});
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Update is successful.");

        } else {
            JOptionPane.showMessageDialog(null, "No changes is made.");
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        String id = useridTF.getText();
        String name = nameTF.getText();
        User searchedUser = null;

        if (userList.size() == 0) {
            JOptionPane.showMessageDialog(null, "There is no user in the list to be deleted.");
            return;
        }

        if (isSomeFieldEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a row to be deleted first!");
            return;
        }

        int choice = JOptionPane.showConfirmDialog(null, "You are deleting this user information! \nThis changes is permanent.\nDo you really want to delete this?", "Delete User Information", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {

            if (!id.isEmpty()) {
                Tester<User> testID = user -> user.getUserID() == Integer.parseInt(id);
                searchedUser = searchBy(testID);
            } else {
                Tester<User> testName = user -> user.getName().equalsIgnoreCase(name);
                searchedUser = searchBy(testName);
            }

            model.setRowCount(0);
            userList.remove(searchedUser);
            JOptionPane.showMessageDialog(null, "Delete is successful.");

        } else {
            JOptionPane.showMessageDialog(null, "Deletion is cancelled. No item is deleted.");
        }
        displayAllBtnActionPerformed(evt);
        clearAllField();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        //get selected row value from table
        String useridToTF = table.getValueAt(table.getSelectedRow(), 0).toString();
        String nameToTF = table.getValueAt(table.getSelectedRow(), 1).toString();
        String genderToTF = table.getValueAt(table.getSelectedRow(), 2).toString();
        String phoneNoToTF = table.getValueAt(table.getSelectedRow(), 3).toString();
        String emailToTF = table.getValueAt(table.getSelectedRow(), 4).toString();

        //set the value selected from table into textField
        useridTF.setText(useridToTF);
        nameTF.setText(nameToTF);
        phoneNoTF.setText(phoneNoToTF);
        emailTF.setText(emailToTF);

        if (genderToTF.equalsIgnoreCase("Male")) {
            maleRB.setSelected(true);
        } else {
            femaleRB.setSelected(true);
        }
    }//GEN-LAST:event_tableMouseClicked

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
            java.util.logging.Logger.getLogger(User_Record_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Record_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Record_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Record_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Record_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton displayAllBtn;
    private javax.swing.JTextField emailTF;
    private javax.swing.JRadioButton femaleRB;
    private javax.swing.JButton insertBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton maleRB;
    private javax.swing.JTextField nameTF;
    private javax.swing.JTextField phoneNoTF;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTable table;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField useridTF;
    // End of variables declaration//GEN-END:variables

}
