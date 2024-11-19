package bo.hlva.glotask.domain.repository;

import bo.hlva.glotask.data.model.Task;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import java.util.List;

public interface TaskRepository {

  Completable insertTask(Task task);

  Completable updateTask(Task task);

  Completable deleteTask(Task task);

  Flowable<Task> itemTask(int id);

  Flowable<List<Task>> itemsTask();
}
