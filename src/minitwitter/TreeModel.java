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

    public void addLeaf(String userName) {
        DefaultMutableTreeNode newUser = new DefaultMutableTreeNode(new User(userName));
        newUser.setAllowsChildren(false);
        ((DefaultMutableTreeNode)this.getRoot()).add(newUser);
    }

    public void addGroup(TreePath t, String name) {
        Group groupName = new Group(name);
        DefaultMutableTreeNode newGroup = new DefaultMutableTreeNode(groupName);
        newGroup.setAllowsChildren(true);
        ((DefaultMutableTreeNode)t.getLastPathComponent()).add(newGroup);
    }
    
    public void addGroup(String name) {
        Group groupName = new Group(name);
        DefaultMutableTreeNode newGroup = new DefaultMutableTreeNode(groupName);
        newGroup.setAllowsChildren(true);
        ((DefaultMutableTreeNode)this.getRoot()).add(newGroup);
    }

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
