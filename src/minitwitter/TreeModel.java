/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter;

import java.util.Stack;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author Jacob Romero
 */
public class TreeModel extends DefaultTreeModel implements Visitable {
    public TreeModel(TreeNode root) {
        super(root);
    }
    
    public void addLeaf(TreePath t, String userName) {
        DefaultMutableTreeNode newGroup = new DefaultMutableTreeNode(new User(userName));
        newGroup.setAllowsChildren(false);
        ((DefaultMutableTreeNode)t.getLastPathComponent()).add(newGroup);
    }
    
    public void addGroup(TreePath t, String groupName) {
        DefaultMutableTreeNode newGroup = new DefaultMutableTreeNode(groupName);
        newGroup.setAllowsChildren(true);
        ((DefaultMutableTreeNode)t.getLastPathComponent()).add(newGroup);
    }
    
    public void accept(Visitor v) {
        Stack<TreeNode> children = new Stack<TreeNode>();
        children.push((TreeNode) this.getRoot());
        
        while (!children.empty()) {
            TreeNode currentNode = children.pop();
            v.visit(currentNode);
            for (int i = 0; i < currentNode.getChildCount(); i++) {
                children.push(currentNode);
            }
        }
    }
    
}
