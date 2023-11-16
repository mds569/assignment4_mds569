package com.example.assignment4_mds569;

import java.util.ArrayList;
import java.util.HashMap;

public class PublishSubscribe {

    private HashMap<String, ArrayList<Subscriber>> subs;

    public PublishSubscribe(){
        this.subs = new HashMap<String, ArrayList<Subscriber>>();
    }

    public void addSubscriber(String chnl, Subscriber subscriber){
        createChannel(chnl);
        if (!subs.get(chnl).contains(subscriber)) {
            subs.get(chnl).add(subscriber);
        }
    }

    public void removeSubscriber(String chnl, Subscriber subscriber){
        if (subs.containsKey(chnl)) {
            if (!subs.get(chnl).isEmpty()) {
                subs.get(chnl).remove(subscriber);
            }
        }
    }

    public void createChannel(String chnl){
        if (!subs.containsKey(chnl)) {
            subs.put(chnl, new ArrayList<Subscriber>());
        }
    }

    public void publish(String chnl){
        if (subs.containsKey(chnl)) {
            if (!subs.get(chnl).isEmpty()) {
                ArrayList<Subscriber> toUpdate = subs.get(chnl);
                for (Subscriber subscriber : toUpdate) {
                    subscriber.getNotification(chnl);
                }
            }
        }
    }
}
