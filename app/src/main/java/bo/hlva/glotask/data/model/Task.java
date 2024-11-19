package bo.hlva.glotask.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task")
public class Task {

  @PrimaryKey(autoGenerate = true)
  private int id;

  private String title;
  private String description;
  private String date;

  public Task(String title, String description, String date) {
    this.title = title;
    this.description = description;
    this.date = date;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDate() {
    return this.date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
