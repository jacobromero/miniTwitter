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
        // If the node can bew cast to a user, then increment the counter
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
        return count;
    }
    
}
