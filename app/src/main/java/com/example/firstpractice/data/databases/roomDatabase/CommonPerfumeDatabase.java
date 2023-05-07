package com.example.firstpractice.data.databases.roomDatabase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.firstpractice.data.databases.dao.CommonPerfumeDao;
import com.example.firstpractice.data.databases.entity.CommonPerfumeEntity;
import com.example.firstpractice.data.resources.CommonPerfumeModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {CommonPerfumeEntity.class}, version = 1, exportSchema = false)
public abstract class CommonPerfumeDatabase extends RoomDatabase {
    public abstract CommonPerfumeDao commonPerfumeDao();

    private static volatile CommonPerfumeDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    // Singleton
    public static CommonPerfumeDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CommonPerfumeDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CommonPerfumeDatabase.class, "common_perfume_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    // Callback 'onCreate'
    public static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                CommonPerfumeDao dao = INSTANCE.commonPerfumeDao();
                dao.deleteAll();
                dao.insert(new CommonPerfumeEntity("Tom Ford Lost Cherry",26999));
                dao.insert(new CommonPerfumeEntity("LACOSTE L.12.12",7900));
            });
        }
    };
}
