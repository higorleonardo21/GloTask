package bo.hlva.glotask.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import bo.hlva.glotask.data.model.Task;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import java.util.List;

@Dao
public interface TaskDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Completable insertTask(Task task);

  @Update()
  Completable updateTask(Task task);

  @Delete()
  Completable deleteTask(Task task);

  @Query("SELECT * FROM task WHERE id =:id")
  Flowable<Task> itemTask(int id);

  @Query("SELECT * FROM task")
  Flowable<List<Task>> itemsTask();
}
