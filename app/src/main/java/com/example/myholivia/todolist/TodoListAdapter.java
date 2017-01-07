package com.example.myholivia.todolist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myholivia.todolist.models.Todo;

import java.util.List;

/**
 * Created by myholivia on 1/6/17.
 */

public class TodoListAdapter extends BaseAdapter {

    private Context context;
    private List<Todo> data;

    public TodoListAdapter(Context context, List<Todo> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       ViewHolder vh;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.main_list_item, viewGroup, false);

            vh = new ViewHolder();

            vh.todoText = (TextView) view.findViewById(R.id.main_list_item_text);

            view.setTag(vh);

        } else {
            vh = (ViewHolder) view.getTag();
        }

        Todo todo = data.get(i);
        vh.todoText.setText(todo.text );
        return view;
    }

    private static class ViewHolder {
        TextView todoText;
    }
}
