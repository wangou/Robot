package com.wangou.robot.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wangou.robot.R;
import com.wangou.robot.activity.WebActivity;
import com.wangou.robot.constant.Constant;
import com.wangou.robot.entity.Link;
import com.wangou.robot.entity.Response;

import java.util.ArrayList;
import java.util.List;

public class ListItemAdapter extends BaseAdapter {

    private List<Response> objects = new ArrayList<>();

    private Gson gson;
    private Context context;
    private LayoutInflater layoutInflater;

    public ListItemAdapter(Context context) {
        this.context = context;
        this.gson = new Gson();
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
            } else if (2 == getItemViewType(position)) {
                convertView = layoutInflater.inflate(R.layout.url_item, parent, false);
            }
            convertView.setTag(new UrlViewHolder(convertView));
        }
        initializeViews(getItem(position), convertView.getTag());
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        Response response = objects.get(position);
        if (response.isCom()) {
            return 0;
        } else {
            int code = response.getCode();
            if (Constant.CODE_RESPONSE_TEXT == code) {
                return 1;
            } else if (Constant.CODE_RESPONSE_URL == code) {
                return 2;
            }
            return 1;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    private void initializeViews(Response object, Object holder) {
        switch (object.getCode()) {
            case Constant.CODE_RESPONSE_TEXT:
                ViewHolder viewHolder = (ViewHolder) holder;
                viewHolder.chatMsg.setText(object.getResult());
                break;
            case Constant.CODE_RESONSE_COOK:

                break;
            case Constant.CODE_RESPONSE_URL:
                UrlViewHolder urlViewHolder = (UrlViewHolder) holder;
                Link link = gson.fromJson(object.getResult(), Link.class);
                urlViewHolder.chatMsg.setText(link.getText());
                urlViewHolder.textUrl.setText(link.getUrl());
                urlViewHolder.textUrl.setOnClickListener(new UrlClickListener(link.getUrl()));
                break;
            case Constant.CODE_RESPONSE_NEWS:
                break;
        }
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

    private class UrlClickListener implements View.OnClickListener {
        private String url;

        public UrlClickListener(String url) {
            this.url = url;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, WebActivity.class);
            intent.putExtra("url", url);
            context.startActivity(intent);
        }
    }

    protected class ViewHolder {
        protected TextView chatMsg;

        public ViewHolder(View view) {
            chatMsg = (TextView) view.findViewById(R.id.chat_msg);
        }
    }

    private class UrlViewHolder extends ViewHolder {
        private TextView textUrl;

        public UrlViewHolder(View view) {
            super(view);
            textUrl = (TextView) view.findViewById(R.id.url);
        }
    }
}
