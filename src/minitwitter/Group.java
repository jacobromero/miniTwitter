/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter;

/**
 *
 * @author Jacob Romero
 */
public class Group {
    private String groupName;

    public Group(String name) {
        this.groupName = name;
    }

    public String getName() {
        return groupName;
    }

    public String toString() {
        return groupName;
    }
}
