/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Jacob Romero
 */
public class UserTotal implements Visitor{
    private int count = 0;
    
    @Override
    public void visit(Object node) {
        try {
            DefaultMutableTreeNode dn = ((DefaultMutableTreeNode) node);
            User u = (User) dn.getUserObject();
            
            count++;
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public int getResults() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}