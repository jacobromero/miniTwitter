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
public class GroupTotal implements Visitor {
    private int count = 0;

    @Override
    public void visit(Object node) {
        // Visits each node, if the node cannot be cast to the group type, then don't count it.
        try {
           DefaultMutableTreeNode dn = ((DefaultMutableTreeNode) node);
            Group u = (Group) dn.getUserObject();
            
            count++; 
        } catch (Exception e) {
            
        }
    }
    
    @Override
    public int getResults() {
        return count;
    }
}
