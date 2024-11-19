package bo.hlva.glotask.presentation.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import bo.hlva.glotask.data.model.Task;
import bo.hlva.glotask.databinding.DialogAddTaskBinding;
import bo.hlva.glotask.utils.AppUtil;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class AddTaskDialog extends BottomSheetDialogFragment {

  private DialogAddTaskBinding binding;
  private OnAddTaskListener listener;

  public AddTaskDialog(OnAddTaskListener listener) {
    this.listener = listener;
  }

  @Override
  @Nullable
  public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedState) {

    // views binding
    binding = DialogAddTaskBinding.inflate(inflater, parent, false);

    return binding.getRoot();
  }

  @Override
  public void onViewCreated(View view, Bundle savedState) {
    super.onViewCreated(view, savedState);

    // clicks buttons
    binding.btnAccept.setOnClickListener(
        v -> {

          // get text input
          String title = binding.edtTitle.getText().toString();
          String description = binding.edtDescription.getText().toString();

          if (!title.isEmpty() && !description.isEmpty()) {
            Task task = new Task(title, description, AppUtil.getCurrentDate());
            listener.onAddTask(task);
            dismiss();
          }
        });
    binding.btnCancel.setOnClickListener(
        v -> {
          dismiss();
        });
  }

  public interface OnAddTaskListener {
    void onAddTask(Task task);
  }
}
