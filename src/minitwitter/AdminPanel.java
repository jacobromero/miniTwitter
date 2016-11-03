/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.JDialog;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author Jacob Romero
 */
// Singleton Class
public class AdminPanel extends javax.swing.JFrame {
    private static AdminPanel INSTANCE;
    
    public static AdminPanel getInstance() {
        if (INSTANCE == null) {
            synchronized (AdminPanel.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AdminPanel();
                }
            }
        }
        
        return INSTANCE;
    }

    /**
     * Creates new form AdminPanel
     */
    private AdminPanel() {
        initComponents();

        // Add visitors for the aggregation buttons
        VisitHandler visitor = new VisitHandler();
        messageTotalButton.addActionListener(visitor);
        userTotalButton.addActionListener(visitor);
        groupTotalButton.addActionListener(visitor);
        positivePercentButton.addActionListener(visitor);

        ((TreeModel) jTree1.getModel()).addLeaf("Jacob Romero");
        
        for (int i = 0; i < jTree1.getRowCount(); i++) {
            jTree1.expandRow(i);
        }
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        addUserTextArea = new javax.swing.JTextArea();
        addUserButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        addGroupTextArea = new javax.swing.JTextArea();
        addGroupButton = new javax.swing.JButton();
        userViewButton = new javax.swing.JButton();
        positivePercentButton = new javax.swing.JButton();
        messageTotalButton = new javax.swing.JButton();
        userTotalButton = new javax.swing.JButton();
        groupTotalButton = new javax.swing.JButton();
        errorText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTree1.setModel(new TreeModel(new DefaultMutableTreeNode("Root")));
        jScrollPane1.setViewportView(jTree1);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        addUserTextArea.setColumns(20);
        addUserTextArea.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        addUserTextArea.setTabSize(4);
        addUserTextArea.setToolTipText("Enter a user name to add");
        jScrollPane2.setViewportView(addUserTextArea);

        addUserButton.setText("Add User");
        addUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addUserButtonMouseClicked(evt);
            }
        });

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        addGroupTextArea.setColumns(20);
        addGroupTextArea.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        addGroupTextArea.setRows(1);
        addGroupTextArea.setTabSize(4);
        addGroupTextArea.setToolTipText("Enter a user name to add");
        jScrollPane3.setViewportView(addGroupTextArea);

        addGroupButton.setText("Add Group");
        addGroupButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addGroupButtonMouseClicked(evt);
            }
        });

        userViewButton.setText("Open User View");
        userViewButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userViewButtonMouseClicked(evt);
            }
        });

        positivePercentButton.setText("Show Positive Percentage");

        messageTotalButton.setText("Show Message Total");

        userTotalButton.setText("Show User Total");

        groupTotalButton.setText("Show Total Groups");

        errorText.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(messageTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(positivePercentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(groupTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(userViewButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addGroupButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addUserButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(errorText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(addGroupButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(userViewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorText, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(groupTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(messageTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(positivePercentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Opens User Panel if the selection from the JTree is a leaf and not the root node
    private void userViewButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userViewButtonMouseClicked
        TreePath[] tp = jTree1.getSelectionPaths();
        
        if (tp != null) {
            for (TreePath t : tp) {
                if (((DefaultMutableTreeNode) t.getLastPathComponent()).isLeaf() && ((DefaultMutableTreeNode) t.getLastPathComponent()).getLevel() != 0) {
                    System.out.println(((User)((DefaultMutableTreeNode)t.getLastPathComponent()).getUserObject()).getId());
                    errorText.setText("");
                    new UserUi((User) ((DefaultMutableTreeNode)t.getLastPathComponent()).getUserObject(), (TreeModel) jTree1.getModel()).setVisible(true);

                    for (int i = 0; i < jTree1.getRowCount(); i++) {
                        jTree1.expandRow(i);
                    }
                } else {
                    errorText.setText("Selection may not be a group.");
                }
            }
        } else {
            errorText.setText("Select a user from the Tree.");
        }
    }//GEN-LAST:event_userViewButtonMouseClicked

    // Adds a group to the JTree as long as the selected item allows for having children
    private void addGroupButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addGroupButtonMouseClicked
        TreePath[] tp = jTree1.getSelectionPaths();
        for (TreePath t : tp) {
            if (((DefaultMutableTreeNode) t.getLastPathComponent()).getAllowsChildren()) {
                ((TreeModel)jTree1.getModel()).addGroup(t, addGroupTextArea.getText());
                
                addGroupTextArea.setText("");
            } else {
                addGroupTextArea.setText("");                
            }
        }
        ((DefaultTreeModel)jTree1.getModel()).reload();
    }//GEN-LAST:event_addGroupButtonMouseClicked

    // Adds a user to the Jtree as long as the selected item allows for the node to have children
    private void addUserButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserButtonMouseClicked
        TreePath[] tp = jTree1.getSelectionPaths();

        if (tp != null) {
            for (TreePath t : tp) {
                if (((DefaultMutableTreeNode) t.getLastPathComponent()).getAllowsChildren()) {
                    ((TreeModel)jTree1.getModel()).addLeaf(t, addUserTextArea.getText());
                    addUserTextArea.setText("");
                } else {
                    addUserTextArea.setText("");
                }
            }
        } else {
            ((TreeModel)jTree1.getModel()).addLeaf(addUserTextArea.getText());
            addUserTextArea.setText("");
        }
        ((DefaultTreeModel)jTree1.getModel()).reload();
    }//GEN-LAST:event_addUserButtonMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            getInstance().setVisible(true);
        });
    }

    private class VisitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == messageTotalButton) {
                MessageTotal mt = new MessageTotal();
                ((TreeModel) jTree1.getModel()).accept(mt);
                new DataDialog("Total messages - " + mt.getResults()).setVisible(true);
            } else if (e.getSource() == groupTotalButton) {
                GroupTotal gt = new GroupTotal();
                ((TreeModel) jTree1.getModel()).accept(gt);
                new DataDialog("Total groups - " + gt.getResults()).setVisible(true);
            } else if (e.getSource() == userTotalButton) {
                UserTotal ut = new UserTotal();
                ((TreeModel) jTree1.getModel()).accept(ut);
                new DataDialog("Total users - " + ut.getResults()).setVisible(true);
            } else if (e.getSource() == positivePercentButton) {
                PositiveTotal pt = new PositiveTotal();
                ((TreeModel) jTree1.getModel()).accept(pt);
                new DataDialog("Total positive messages - " + pt.getResults()).setVisible(true);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addGroupButton;
    private javax.swing.JTextArea addGroupTextArea;
    private javax.swing.JButton addUserButton;
    private javax.swing.JTextArea addUserTextArea;
    private javax.swing.JLabel errorText;
    private javax.swing.JButton groupTotalButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTree jTree1;
    private javax.swing.JButton messageTotalButton;
    private javax.swing.JButton positivePercentButton;
    private javax.swing.JButton userTotalButton;
    private javax.swing.JButton userViewButton;
    // End of variables declaration//GEN-END:variables
}

