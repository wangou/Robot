package com.wangou.robot.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wangou.robot.R;
import com.wangou.robot.entity.Response;

import java.util.ArrayList;
import java.util.List;

public class ListItemAdapter extends BaseAdapter {

    private List<Response> objects = new ArrayList<>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ListItemAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Response getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            if (0 == getItemViewType(position)) {
                convertView = layoutInflater.inflate(R.layout.chat_list_item_left, parent, false);
            } else if (1 == getItemViewType(position)) {
                convertView = layoutInflater.inflate(R.layout.chat_list_item_right, parent, false);
            }
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews(getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        Response response = objects.get(position);
        if (response.isCom()) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    private void initializeViews(Response object, ViewHolder holder) {
        holder.chatMsg.setText(object.getText());
    }

    public void setDatas(List<Response> responses) {
        if (responses == null || responses.size() == 0) {
            return;
        }
        objects.clear();
        objects.addAll(responses);
        notifyDataSetChanged();
    }

    public void clearDatas() {
        objects.clear();
    }

    protected class ViewHolder {
        private TextView chatMsg;

        public ViewHolder(View view) {
            chatMsg = (TextView) view.findViewById(R.id.chat_msg);
        }
    }
}
