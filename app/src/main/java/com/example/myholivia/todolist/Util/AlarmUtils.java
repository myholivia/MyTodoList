package com.example.myholivia.todolist.Util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.example.myholivia.todolist.AlarmReceiver;
import com.example.myholivia.todolist.TodoEditActivity;
import com.example.myholivia.todolist.models.Todo;

import java.util.Calendar;

/**
 * Created by myholivia on 1/7/17.
 */

public class AlarmUtils {

    public static void setAlarm(Context context, Todo todo) {
        Calendar c = Calendar.getInstance();
        if (todo.remindDate.compareTo(c.getTime()) < 0) {
            return;
        }

        AlarmManager alarmMgr = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.putExtra(TodoEditActivity.KEY_TODO, todo);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        alarmMgr.set(AlarmManager.RTC_WAKEUP, todo.remindDate.getTime(), alarmIntent);
    }
}
