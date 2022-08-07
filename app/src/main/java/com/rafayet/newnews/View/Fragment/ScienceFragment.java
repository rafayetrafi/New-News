package com.rafayet.newnews.View.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rafayet.newnews.Controller.ApiUtilities;
import com.rafayet.newnews.Model.NewsData;
import com.rafayet.newnews.Model.NewsDetailsModel;
import com.rafayet.newnews.R;
import com.rafayet.newnews.View.Adapter.RecyclerViewAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScienceFragment extends Fragment {

    String api_key = "34c979cec59d4293aa80094a95f2fdce";
    ArrayList<NewsDetailsModel> newsDetailsModelArrayList;
    RecyclerViewAdapter recyclerViewAdapter;
    String country="us";
    private RecyclerView recyclerViewofScience;
    private String category = "science";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sciencefragment, null);


        recyclerViewofScience = view.findViewById(R.id.rcv_Science);
        newsDetailsModelArrayList = new ArrayList<>();
        recyclerViewofScience.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewAdapter = new RecyclerViewAdapter(getContext(), newsDetailsModelArrayList);
        recyclerViewofScience.setAdapter(recyclerViewAdapter);
        findNews();
        return view;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country, category, "100", api_key).enqueue(new Callback<NewsData>() {
            @Override
            public void onResponse(Call<NewsData> call, Response<NewsData> response) {
                if (response.isSuccessful()){
                    newsDetailsModelArrayList.addAll(response.body().getArticles());
                    recyclerViewAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<NewsData> call, Throwable t) {

            }
        });
    }
}
