package com.rafayet.newnews.View.Adapter;
import static androidx.core.content.ContextCompat.startActivities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rafayet.newnews.Model.NewsDetailsModel;
import com.rafayet.newnews.R;
import com.rafayet.newnews.webviewActivity;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<NewsDetailsModel> newsDetailsModelArrayList;


    public RecyclerViewAdapter(Context context, ArrayList<NewsDetailsModel> newsDetailsModelArrayList) {
        this.context = context;
        this.newsDetailsModelArrayList = newsDetailsModelArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_items, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, webviewActivity.class);
                intent.putExtra("url", newsDetailsModelArrayList.get(position).getUrl());
                Log.e("@@@@", newsDetailsModelArrayList.get(position).getUrl());
                context.startActivity(intent);
                //view.getContext().startActivities(new Intent[]{intent});
                //view.getContext().startActivity(intent);
            }
        });

        holder.tvTime.setText("Publied at:-" + newsDetailsModelArrayList.get(position).getPublishedAt());
        holder.tvAuthor.setText(newsDetailsModelArrayList.get(position).getAuthor());
        holder.tvHeading.setText(newsDetailsModelArrayList.get(position).getTitle());
        holder.tvContent.setText(newsDetailsModelArrayList.get(position).getDescription());
        Glide.with(context).load(newsDetailsModelArrayList.get(position).getUrlToImage()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return newsDetailsModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvHeading, tvContent, tvAuthor, tvTime;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHeading = itemView.findViewById(R.id.tvHeadlines);
            tvContent = itemView.findViewById(R.id.tv_mainContent);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvTime = itemView.findViewById(R.id.tvTime);
            imageView = itemView.findViewById(R.id.IvImages);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
