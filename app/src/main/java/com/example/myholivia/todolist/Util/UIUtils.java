package com.example.myholivia.todolist.Util;

import android.graphics.Paint;
import android.widget.TextView;

/**
 * Created by myholivia on 1/7/17.
 */

public class UIUtils {

    public static void setTextViewStrikeThrough(TextView tv, boolean strikeThrough) {
        if (strikeThrough) {
            tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            tv.setPaintFlags(tv.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
