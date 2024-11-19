package bo.hlva.glotask.presentation.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bo.hlva.glotask.data.model.Task;
import bo.hlva.glotask.databinding.DialogDetailsTaskBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class DetailsTaskDialog extends BottomSheetDialogFragment {

  private DialogDetailsTaskBinding binding;
  private Task task;

  private OnTaskDetailListener listener;

  public DetailsTaskDialog(Task task, OnTaskDetailListener listener) {
    this.task = task;
    this.listener = listener;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedState) {

    binding = DialogDetailsTaskBinding.inflate(inflater, parent, false);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(View view, Bundle savedState) {
    super.onViewCreated(view, savedState);

    // set data
    binding.tvTitle.setText(task.getTitle());
    binding.tvDescription.setText(task.getDescription());
    binding.btnDelete.setOnClickListener(
        v -> {
          showDeleteDialog();
        });
  }

  private void showDeleteDialog() {
    MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext());
    builder.setMessage("Delete task?.");
    builder.setPositiveButton(
        "Delete",
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int w) {

            listener.onDeleteTask(task);
            builder.create().dismiss();
            dismiss();
          }
        });
    builder.setNegativeButton(
        "Cancel",
        new DialogInterface.OnClickListener() {

          @Override
          public void onClick(DialogInterface dialog, int w) {
            builder.create().dismiss();
          }
        });

    builder.show();
  }

  public interface OnTaskDetailListener {
    void onDeleteTask(Task task);
  }
}
