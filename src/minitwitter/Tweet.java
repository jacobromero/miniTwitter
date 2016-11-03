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
public class Tweet {
    private String message;
    private User poster;
    
    public Tweet(User poster, String content) {
        this.poster = poster;
        this.message = content;
    }
    
    public String getMessage() {
        return message;
    }
    
    public User getPoster() {
        return poster;
    }
    
}
