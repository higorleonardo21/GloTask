package bo.hlva.glotask.data.local;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import bo.hlva.glotask.data.model.Task;

@Database(
    entities = {Task.class},
    version = 1,
    exportSchema = false)
public abstract class TaskDatabase extends RoomDatabase {

  public static final String DATABASE_NAME = "task";

  private static TaskDatabase INSTANCE;

  public abstract TaskDao getTaskDao();

  public static TaskDatabase getInstance(Context context) {

    INSTANCE = Room.databaseBuilder(context, TaskDatabase.class, DATABASE_NAME).build();

    return INSTANCE;
  }
}
