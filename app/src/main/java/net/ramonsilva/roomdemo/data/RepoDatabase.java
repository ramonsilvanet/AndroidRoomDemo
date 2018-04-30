package net.ramonsilva.roomdemo.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import net.ramonsilva.roomdemo.data.converters.DateConverter;
import net.ramonsilva.roomdemo.data.dao.RepoDao;
import net.ramonsilva.roomdemo.data.entity.Repo;
import net.ramonsilva.roomdemo.data.entity.User;

@Database(entities = { Repo.class, User.class}, version = 2)
@TypeConverters(DateConverter.class)
public abstract class RepoDatabase extends RoomDatabase {

    private static final String DB_NAME = "repoDatabase.db";
    private static volatile RepoDatabase instance;

    public static synchronized RepoDatabase getInstance(Context context){
        if( instance == null ){
            instance = create(context);
        }

        return instance;
    }

    static synchronized RepoDatabase create(Context context){
        return Room.databaseBuilder(context,
                RepoDatabase.class,
                DB_NAME).build();
    }

    public abstract RepoDao getRepoDao();
}
