package bo.hlva.glotask.di;

import android.content.Context;
import bo.hlva.glotask.data.local.TaskDatabase;
import bo.hlva.glotask.data.repository.TaskRepositoryImpl;
import bo.hlva.glotask.domain.repository.TaskRepository;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@InstallIn(SingletonComponent.class)
@Module
public class AppModule {

  @Provides
  @Singleton
  public static TaskDatabase provideTaskDatabase(@ApplicationContext Context context) {
    return TaskDatabase.getInstance(context);
  }

  @Provides
  @Singleton
  public static TaskRepository provideTaskRepository(TaskDatabase taskDatabase) {
    return new TaskRepositoryImpl(taskDatabase);
  }
}
