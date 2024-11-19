package bo.hlva.glotask.presentation.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import bo.hlva.glotask.data.model.Task;
import bo.hlva.glotask.domain.repository.TaskRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

@HiltViewModel
public class TaskViewModel extends ViewModel {

  private TaskRepository taskRepository;
  private CompositeDisposable compositeDisposable;

  private MutableLiveData<List<Task>> _itemsTask = new MutableLiveData<>();
  private MutableLiveData<Boolean> _itemAddTask = new MutableLiveData<>();

  @Inject
  public TaskViewModel(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
    this.compositeDisposable = new CompositeDisposable();
  }

  public LiveData<Boolean> insertTask(Task task) {

    compositeDisposable.add(
        taskRepository
            .insertTask(task)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                () -> {
                  _itemAddTask.setValue(true);
                },
                throwable -> {
                  _itemAddTask.setValue(false);
                }));

    return _itemAddTask;
  }

  public LiveData<List<Task>> getItemsTask() {

    compositeDisposable.add(
        taskRepository
            .itemsTask()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                items -> {
                  _itemsTask.setValue(items);
                },
                throwable -> {
                  _itemsTask.setValue(Collections.emptyList());
                }));

    return _itemsTask;
  }

  @Override
  protected void onCleared() {
    super.onCleared();
    if (compositeDisposable != null) {
      compositeDisposable.clear();
    }
  }
}
