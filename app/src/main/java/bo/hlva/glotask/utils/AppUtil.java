package bo.hlva.glotask.utils;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.widget.Toast;
import java.util.Date;

public class AppUtil {

  public static void showToast(Context context, String text) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
  }

  public static String getCurrentDate() {

    // get cuurent date
    Date today = Calendar.getInstance().getTime();
    // format date
    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    // get date format
    return formatter.format(today);
  }
}
