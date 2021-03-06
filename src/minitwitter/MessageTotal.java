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
public class MessageTotal implements Visitor {
    private int count = 0;

    @Override
    public void visit(Object node) {
        // If the tree node being passed into the visit can be cast to a user then increment the counter by 1
        try {
            DefaultMutableTreeNode dn = ((DefaultMutableTreeNode) node);
            User u = (User) dn.getUserObject();
            
            count += u.getMessages().size();
        }
        catch (Exception e) {
            
        }
    }
    
    public int getResults() {
        return count;
    }
}
