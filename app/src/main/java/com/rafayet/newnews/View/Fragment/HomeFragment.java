package com.rafayet.newnews.View.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rafayet.newnews.Controller.ApiUtilities;
import com.rafayet.newnews.Model.NewsData;
import com.rafayet.newnews.Model.NewsDetailsModel;
import com.rafayet.newnews.R;
import com.rafayet.newnews.View.Adapter.PagerAdapter;
import com.rafayet.newnews.View.Adapter.RecyclerViewAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    String api_key = "34c979cec59d4293aa80094a95f2fdce";
    ArrayList<NewsDetailsModel> newsDetailsModelArrayList;
    RecyclerViewAdapter recyclerViewAdapter;
    String country="us";
    private RecyclerView recyclerViewofHome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefragment, null);

        recyclerViewofHome =view.findViewById(R.id.rcv_Home);
        newsDetailsModelArrayList = new ArrayList<>();
        recyclerViewofHome.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewAdapter = new RecyclerViewAdapter(getContext(), newsDetailsModelArrayList);
        recyclerViewofHome.setAdapter(recyclerViewAdapter);
        findNews();
        return view;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getNews(country, "100", api_key).enqueue(new Callback<NewsData>() {
            @Override
            public void onResponse(Call<NewsData> call, Response<NewsData> response) {
                Toast.makeText(getContext(), "hii", Toast.LENGTH_SHORT).show();
                newsDetailsModelArrayList.addAll(response.body().getArticles());
                recyclerViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NewsData> call, Throwable t) {
                Toast.makeText(getContext(), "Hello", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
