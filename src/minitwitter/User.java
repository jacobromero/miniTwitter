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
import javax.swing.DefaultListModel;

/**
 *
 * @author Jacob Romero
 */
// User will contain a list of 'tweets'
// username
// following users
public class User implements Subject, Observer {
    private HashMap<Integer, Observer> observers;
    private int id;
    private String name;
    private LinkedList<Tweet> tweets;
    private LinkedList<User> following;
    private DefaultListModel<String> followingUsers;
    private Stack<Tweet> messages;
    private DefaultListModel<String> messageList;

    public User(String name) {
        this.name = name;
        this.id = new Random().nextInt();
        tweets = new LinkedList<>();
        following = new LinkedList<>();

        followingUsers = new DefaultListModel<>();
        messageList = new DefaultListModel<>();
        
        messages = new Stack<>();
        observers = new HashMap<>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(LinkedList<Tweet> tweets) {
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
        followingUsers.addElement(o.toString());
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
            observers.get(key).update(this.tweets.getLast());
        }
    }

    @Override
    public void update(Tweet t) {
        messageList.addElement(t.getMessage() + " | Written by: " + t.getPoster());
    }
    
    @Override
    public int getId() {
        return this.id;
    }
    
    public String toString() {
        return this.name;
    }
    
    public void postTweet(String message) {
        this.tweets.add(new Tweet(this, message));
    }
    
    public Stack<Tweet> getMessages() {
        return this.messages;
    }
    
    public void addMessages(LinkedList<Tweet> t) {
        for (Tweet tweet : t) {
            messages.push(tweet);
            messageList.addElement(tweet.toString());
        }
    }
    
    public DefaultListModel<String> getFollowingList() {
        return this.followingUsers;
    }
    
    public DefaultListModel<String> getMessageList() {
        return this.messageList;
    }
}
