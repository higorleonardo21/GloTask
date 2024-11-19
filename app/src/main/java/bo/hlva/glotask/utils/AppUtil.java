package bo.hlva.glotask.utils;

import android.content.Context;
import android.widget.Toast;

public class AppUtil {

  public static void showToast(Context context, String text) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
  }
}
