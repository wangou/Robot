package com.wangou.robot.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wangou.robot.R;
import com.wangou.robot.activity.WebActivity;
import com.wangou.robot.constant.Constant;
import com.wangou.robot.entity.Cook;
import com.wangou.robot.entity.Link;
import com.wangou.robot.entity.News;
import com.wangou.robot.entity.Response;
import com.wangou.robot.view.MyListView;

import java.util.ArrayList;
import java.util.Collections;
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
        switch (object.getCode()) {
            case Constant.CODE_RESPONSE_TEXT:
                holder.chatMsg.setText(object.getResult());
                holder.textUrl.setVisibility(View.GONE);
                holder.lisView.setVisibility(View.GONE);
                break;
            case Constant.CODE_RESONSE_COOK:
                Cook cook = gson.fromJson(object.getResult(), Cook.class);
                Cook.ListBean bean = cook.getList().get(0);
                holder.chatMsg.setText(cook.getText());
                holder.textUrl.setText(bean.getName());
                holder.textUrl.setVisibility(View.VISIBLE);
                holder.lisView.setVisibility(View.GONE);
                holder.textUrl.setOnClickListener(new UrlClickListener(bean.getDetailurl()));
                break;
            case Constant.CODE_RESPONSE_URL:
                Link link = gson.fromJson(object.getResult(), Link.class);
                holder.chatMsg.setText(link.getText());
                holder.textUrl.setText(link.getUrl());
                holder.textUrl.setVisibility(View.VISIBLE);
                holder.lisView.setVisibility(View.GONE);
                holder.textUrl.setOnClickListener(new UrlClickListener(link.getUrl()));
                break;
            case Constant.CODE_RESPONSE_NEWS:
                News news = gson.fromJson(object.getResult(), News.class);
                final List<News.ListBean> beanList = news.getList();
                holder.chatMsg.setText(news.getText());
                holder.textUrl.setVisibility(View.GONE);
                holder.lisView.setVisibility(View.VISIBLE);
                holder.lisView.setAdapter(new ArrayAdapter<>(context,
                        R.layout.news_item, R.id.text, beanList));
                holder.lisView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(context, WebActivity.class);
                        intent.putExtra("url", beanList.get(i).getDetailurl());
                        context.startActivity(intent);
                    }
                });
                break;
        }
    }

    public void setDatas(List<Response> responses) {
        if (responses == null || responses.size() == 0) {
            return;
        }
        Collections.reverse(responses);
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
        private TextView chatMsg;
        private TextView textUrl;
        private MyListView lisView;

        public ViewHolder(View view) {
            chatMsg = (TextView) view.findViewById(R.id.chat_msg);
            textUrl = (TextView) view.findViewById(R.id.url);
            lisView = (MyListView) view.findViewById(R.id.listView);
        }
    }
}
