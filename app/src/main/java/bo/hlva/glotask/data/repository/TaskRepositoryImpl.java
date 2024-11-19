package bo.hlva.glotask.data.repository;

import bo.hlva.glotask.data.local.TaskDatabase;
import bo.hlva.glotask.data.model.Task;
import io.reactivex.rxjava3.core.Completable;
import bo.hlva.glotask.domain.repository.TaskRepository;
import io.reactivex.rxjava3.core.Flowable;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {

  private TaskDatabase taskDatabase;

  public TaskRepositoryImpl(TaskDatabase taskDatabase) {
    this.taskDatabase = taskDatabase;
  }

  @Override
  public Completable insertTask(Task task) {
    return taskDatabase.getTaskDao().insertTask(task);
  }

  @Override
  public Completable updateTask(Task task) {
    return taskDatabase.getTaskDao().updateTask(task);
  }

  @Override
  public Completable deleteTask(Task task) {
    return taskDatabase.getTaskDao().deleteTask(task);
  }

  @Override
  public Flowable<Task> itemTask(int id) {
    return taskDatabase.getTaskDao().itemTask(id);
  }

  @Override
  public Flowable<List<Task>> itemsTask() {
    return taskDatabase.getTaskDao().itemsTask();
  }
}
