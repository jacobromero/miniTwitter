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
class PositiveTotal implements Visitor {
    private int count = 0;
    
    @Override
    public void visit(Object node) {
        // If the node can be cast to a user, then extract the messages and check for "Positive" tweets made by the user.
        try {
            DefaultMutableTreeNode dn = ((DefaultMutableTreeNode) node);
            User u = (User) dn.getUserObject();

            for (Tweet t : u.getTweets()) {
                // Tweets containing the words "good" or "fun" are considered positive.
                if (t.getMessage().toLowerCase().contains("good") || t.getMessage().toLowerCase().contains("fun")) {
                    count++;
                }
            }
        }
        catch (Exception e) {
        }
    }

    @Override
    public int getResults() {
        return count;
    }
    
}
