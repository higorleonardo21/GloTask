package bo.hlva.glotask.presentation.main;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import bo.hlva.glotask.data.model.Task;
import bo.hlva.glotask.databinding.ActivityMainBinding;
import bo.hlva.glotask.presentation.adapters.ListTaskAdapter;
import bo.hlva.glotask.presentation.dialogs.AddTaskDialog;
import bo.hlva.glotask.presentation.dialogs.DetailsTaskDialog;
import bo.hlva.glotask.presentation.viewmodels.TaskViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity
    implements ListTaskAdapter.OnItemTaskListener,
        AddTaskDialog.OnAddTaskListener,
        DetailsTaskDialog.OnTaskDetailListener {

  private ActivityMainBinding binding;
  private TaskViewModel taskViewModel;

  private ListTaskAdapter lisTaskAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Inflate and get instance of binding
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    // set content view to binding's root
    setContentView(binding.getRoot());

    // init viewmodel
    taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);

    setupViews();
  }

  private void setupViews() {
    setSupportActionBar(binding.toolbar);

    binding.fab.setOnClickListener(
        view -> {
          AddTaskDialog dialog = new AddTaskDialog(this);
          dialog.show(getSupportFragmentManager(), "add_task");
        });

    // get list task
    lisTaskAdapter = new ListTaskAdapter(this);
    binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
    binding.recyclerview.setHasFixedSize(true);
    binding.recyclerview.setAdapter(lisTaskAdapter);

    taskViewModel
        .getItemsTask()
        .observe(
            this,
            list -> {
              lisTaskAdapter.submitData(list);
            });
  }

  @Override
  public void onItemClick(Task task) {
    DetailsTaskDialog dialog = new DetailsTaskDialog(task, this);
    dialog.show(getSupportFragmentManager(), "details_task");
  }

  @Override
  public void onLongClick(Task task) {}

  @Override
  public void onAddTask(Task task) {
    taskViewModel.insertTask(task);
  }

  @Override
  public void onDeleteTask(Task task) {
    taskViewModel.deleteTask(task);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    this.binding = null;
  }
}
