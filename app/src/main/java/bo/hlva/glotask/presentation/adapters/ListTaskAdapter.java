package bo.hlva.glotask.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import bo.hlva.glotask.data.model.Task;
import bo.hlva.glotask.databinding.CardItemTaskBinding;
import java.util.Collections;
import java.util.List;

public class ListTaskAdapter extends RecyclerView.Adapter<ListTaskAdapter.ViewHolder> {

  private List<Task> items = Collections.EMPTY_LIST;

  private OnItemTaskListener listener;

  public ListTaskAdapter(OnItemTaskListener listener) {
    this.listener = listener;
  }

  public void submitData(List<Task> items) {
    this.items = items;
    notifyDataSetChanged();
  }

  @Override
  public ListTaskAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    CardItemTaskBinding binding = CardItemTaskBinding.inflate(inflater, parent, false);

    return new ListTaskAdapter.ViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(ListTaskAdapter.ViewHolder holder, int position) {

    // get item
    Task task = items.get(position);

    holder.binding.tvTitle.setText(task.getTitle());
    holder.binding.tvDescription.setText(task.getDescription());

    // click item
    holder
        .binding
        .getRoot()
        .setOnClickListener(
            view -> {
              listener.onItemClick(task);
            });

    // long click
    holder
        .binding
        .getRoot()
        .setOnLongClickListener(
            new View.OnLongClickListener() {
              @Override
              public boolean onLongClick(View v) {

                listener.onLongClick(task);

                return true;
              }
            });
  }

  @Override
  public int getItemCount() {
    return items.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    private CardItemTaskBinding binding;

    public ViewHolder(CardItemTaskBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }
  }

  public interface OnItemTaskListener {
    void onItemClick(Task task);

    void onLongClick(Task task);
  }
}
