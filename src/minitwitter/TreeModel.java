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
// Custom tree model that will extend the default tree model
public class TreeModel extends DefaultTreeModel implements Visitable {
    public TreeModel(TreeNode root) {
        super(root);
    }

    // Given a specific tree path, add the new leaf into the path
    public DefaultMutableTreeNode addLeaf(TreePath t, String userName) {
        DefaultMutableTreeNode newUser = new DefaultMutableTreeNode(new User(userName));
        // Leaves will not be allowed to hold children
        newUser.setAllowsChildren(false);
        ((DefaultMutableTreeNode)t.getLastPathComponent()).add(newUser);
        
        // return the newly created user to allow for chaining
        return newUser;
    }

    // Add a leaf directly to the root of the tree
    public DefaultMutableTreeNode addLeaf(String userName) {
        DefaultMutableTreeNode newUser = new DefaultMutableTreeNode(new User(userName));
        newUser.setAllowsChildren(false);
        ((DefaultMutableTreeNode)this.getRoot()).add(newUser);
        return newUser;
    }

    // Add a group to the specified path in the tree
    public DefaultMutableTreeNode addGroup(TreePath t, String name) {
        Group groupName = new Group(name);
        DefaultMutableTreeNode newGroup = new DefaultMutableTreeNode(groupName);
        //Groups are allowed to have children.
        newGroup.setAllowsChildren(true);
        ((DefaultMutableTreeNode)t.getLastPathComponent()).add(newGroup);
        
        // return the newly created group to allow for chaining
        return newGroup;
    }
    
    // Add a group directly to the root node
    public DefaultMutableTreeNode addGroup(String name) {
        Group groupName = new Group(name);
        DefaultMutableTreeNode newGroup = new DefaultMutableTreeNode(groupName);
        newGroup.setAllowsChildren(true);
        ((DefaultMutableTreeNode)this.getRoot()).add(newGroup);

        return newGroup;
    }

    // Accept and visitors to the tree
    public void accept(Visitor v) {
        Stack<DefaultMutableTreeNode> children = new Stack<DefaultMutableTreeNode>();
        children.push(((DefaultMutableTreeNode) this.getRoot()));

        while (!children.empty()) {
            TreeNode currentNode = children.pop();
            v.visit(currentNode);
            for (int i = 0; i < currentNode.getChildCount(); i++) {
                children.push((DefaultMutableTreeNode) currentNode.getChildAt(i));
            }
        }
    }

    public User getUser(String name) {
        Stack<DefaultMutableTreeNode> children = new Stack<DefaultMutableTreeNode>();
        children.push(((DefaultMutableTreeNode) this.getRoot()));

        while (!children.empty()) {
            DefaultMutableTreeNode currentNode = children.pop();

            try {
                User u = (User) currentNode.getUserObject();
                if (u.getName().equals(name)) {
                    return u;
                }
            } catch (Exception e) {

            }
            
            for (int i = 0; i < currentNode.getChildCount(); i++) {
                children.push((DefaultMutableTreeNode) currentNode.getChildAt(i));
            }
        }

        return null;
    }
}
