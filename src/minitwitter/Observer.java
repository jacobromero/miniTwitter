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
public interface Observer {
    public void update(Tweet t);
    public int getId();
}
