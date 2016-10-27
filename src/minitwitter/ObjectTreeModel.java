/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter;

import java.util.LinkedList;
import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author Jacob Romero
 */
public class ObjectTreeModel implements TreeModel{
    private Node root;
    private EventListenerList listenerList = new EventListenerList();
    
    public ObjectTreeModel (String data) {
        root = new Node<String>(data);
        root.addChild(new Node("Something2"));
    }

    @Override
    public Object getRoot() {
        return root;
    }
    @Override
    public Object getChild(Object parent, int index) {
        try {
            return ((Node) parent).getChildren().get(index);
        } catch (Exception e) {
            return new Node("");
        }
    }

    @Override
    public int getChildCount(Object parent) {
        return root.getChildren().size();
    }

    @Override
    public boolean isLeaf(Object node) {
        return ((Node) node).getChildren().size() == 0;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        return ((Node) parent).getChildren().indexOf(child);
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        listenerList.add(TreeModelListener.class, l);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        listenerList.remove(TreeModelListener.class, l);
    }
    
}

class Node<T> {
    private T data;
    private LinkedList<Node> children;
    
    public Node(T data) {
        this.data = data;
        children = new LinkedList<Node>();
    }
    
    public T getData() {
        return data;
    }
    
    public LinkedList<Node> getChildren() {
        return children;
    }
    
    public void addChild(Node child) {
        this.children.add(child);
    }
    
    public String toString() {
        return this.data.toString();
    }
}
