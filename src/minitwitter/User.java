/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitwitter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

/**
 *
 * @author Jacob Romero
 */
// User will contain a list of 'tweets'
// username
// following users
public class User implements Subject, Observer, Node {
    private HashMap<Integer, Observer> observers;
    private int id;
    private String name;
    private LinkedList<String> tweets;
    private LinkedList<User> following;
    private Stack<String> messages;

    public User(String name) {
        this.name = name;
        this.id = new Random().nextInt();
        tweets = new LinkedList<String>();
        following = new LinkedList<User>();
        messages = new Stack<String>();
        observers = new HashMap<Integer, Observer>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<String> getTweets() {
        return tweets;
    }

    public void setTweets(LinkedList<String> tweets) {
        this.tweets = tweets;
    }

    public LinkedList<User> getFollowing() {
        return following;
    }

    public void setFollowing(LinkedList<User> following) {
        this.following = following;
    }

    @Override
    public void attach(Observer o) {
        observers.put(o.getId(), o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o.getId());
    }

    @Override
    public void notifyObservers() {
        // update all user following
        for (int key : observers.keySet()) {
            observers.get(key).update();
        }
    }

    @Override
    public void update() {
        messages.push("Update");
    }

    @Override
    public int getId() {
        return this.id;
    }
    
    public String toString() {
        return this.name;
    }
    
    public void postTweet(String message) {
        this.tweets.add(message);
    }
}
