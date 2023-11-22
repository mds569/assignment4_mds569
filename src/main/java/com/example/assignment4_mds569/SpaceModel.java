package com.example.assignment4_mds569;

import java.util.ArrayList;

public class SpaceModel {

    private ArrayList<Asteroid> asteroids;

    private ArrayList<Star> stars;

    PublishSubscribe pubSub;

    public SpaceModel()
    {
        asteroids = new ArrayList<Asteroid>();
        stars = new ArrayList<Star>();
    }

    // Create new Asteroid object
    public void createAsteroid()
    {
        Asteroid asteroid = new Asteroid();
        asteroids.add(asteroid);
        pubSub.publish("create");
    }

    // Delete an Asteroid at a specific index
    public void deleteAsteroid(int index)
    {
        if (index <= asteroids.size())
        {
            asteroids.remove(index);
            pubSub.publish("delete");
        }
    }

    // Return list of Asteroids
    public ArrayList<Asteroid> getAsteroids() {return this.asteroids;}

    // Return Asteroid at index
    public Asteroid getAsteroid(int index) {return this.asteroids.get(index);}

    // Create new Star object
    public void createStar()
    {
        Star star = new Star();
        stars.add(star);
        pubSub.publish("create");
    }

    // Delete a Star at a specific index
    public void deleteStar(int index)
    {
        if (index <= stars.size())
        {
            stars.remove(index);
            pubSub.publish("delete");
        }
    }

    // Return list of Stars
    public ArrayList<Star> getStars() {return this.stars;}

    // Return Star at index
    public Star getStar(int index) {return this.stars.get(index);}

    // Set the PublishSubscribe object for this model
    public void setPubSub(PublishSubscribe publishSubscribe) {
        this.pubSub = publishSubscribe;
    }
}
