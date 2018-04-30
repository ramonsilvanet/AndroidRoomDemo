package net.ramonsilva.roomdemo.data.entity;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    public final int id;

    public final String login;
    public final String avatarUrl;

    public User(final int id, final String login, final String avatarUrl){
        this.id = id;
        this.login = login;
        this.avatarUrl = avatarUrl;
    }
}
