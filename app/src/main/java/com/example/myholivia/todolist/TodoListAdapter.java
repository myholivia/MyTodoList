package com.example.myholivia.todolist;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.myholivia.todolist.Util.UIUtils;
import com.example.myholivia.todolist.models.Todo;

import java.util.List;

/**
 * Created by myholivia on 1/6/17.
 */

public class TodoListAdapter extends BaseAdapter {

    private MainActivity activity;
    private List<Todo> data;

    public TodoListAdapter(MainActivity activity, List<Todo> data) {
        this.activity = activity;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertview, ViewGroup viewGroup) {
       ViewHolder vh;
        if (convertview == null) {
            convertview = activity.getLayoutInflater().inflate(R.layout.main_list_item, viewGroup, false);
            vh = new ViewHolder();

            vh.todoText = (TextView) convertview.findViewById(R.id.main_list_item_text);
            vh.doneCheckbox = (CheckBox) convertview.findViewById(R.id.main_list_item_check);
            convertview.setTag(vh);

        } else {
            vh = (ViewHolder) convertview.getTag();
        }

        final Todo todo = (Todo) getItem(position);
        vh.todoText.setText(todo.text );
        vh.doneCheckbox.setChecked(todo.done);
        UIUtils.setTextViewStrikeThrough(vh.todoText, todo.done);
        vh.doneCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                activity.updateTodo(position, isChecked);
            }
        });

        convertview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, TodoEditActivity.class);
                intent.putExtra(TodoEditActivity.KEY_TODO, todo);
                activity.startActivityForResult(intent, MainActivity.REQ_CODE_TODO_EDIT);
            }
        });
        return convertview;
    }

    private static class ViewHolder {
        TextView todoText;
        CheckBox doneCheckbox;
    }
}
