package net.ramonsilva.roomdemo.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import net.ramonsilva.roomdemo.data.entity.Repo;

import java.util.List;

@Dao
public interface RepoDao {


    @Query("select * from repo")
    List<Repo> getAllRepos();

    @Query("SELECT * FROM repo WHERE id=:id")
    Repo getRepo(int id);

    @Query("SELECT * FROM repo")
    Cursor getRepoCursor();

    @Query("select * from repo where name=:name")
    List<Repo> getRepoByName(String name);

    @Query("select * from repo where name=:name limit :max")
    List<Repo> getRepoByName(int max, String... name);

    @Insert
    void insert(Repo... repos);

    @Update
    void update(Repo... repos);

    @Delete
    void delete(Repo... repos);

    @Query("select * from repo where userId = :userId")
    List<Repo> findRepositoriesForUser(final int userId);

}
