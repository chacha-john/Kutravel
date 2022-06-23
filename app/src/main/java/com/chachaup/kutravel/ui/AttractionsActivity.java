package com.chachaup.kutravel.ui;

import static com.chachaup.kutravel.Constants.API_KEY;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.chachaup.kutravel.Constants;
import com.chachaup.kutravel.R;
import com.chachaup.kutravel.adapters.AttractionsListAdapter;
import com.chachaup.kutravel.adapters.EventListAdapter;
import com.chachaup.kutravel.model.attractions.Attraction;
import com.chachaup.kutravel.model.attractions.AttractionSearchResponse;
import com.chachaup.kutravel.model.events.Event;
import com.chachaup.kutravel.network.API;
import com.chachaup.kutravel.network.Client;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AttractionsActivity extends AppCompatActivity {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String keyword;

    private List<Attraction> mAttractions;

    private AttractionsListAdapter mAdapter;
    @BindView(R.id.recyclerViewAttractions)
    RecyclerView mRecyclerView;
    @BindView(R.id.progressBarSearchAttractions)
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String keyword) {
                addToSharedPreferences(keyword);
                API client = Client.getClient();
                Call<AttractionSearchResponse> call = client.getAttractions(keyword,API_KEY);
                call.enqueue(new Callback<AttractionSearchResponse>() {
                    @Override
                    public void onResponse(Call<AttractionSearchResponse> call, Response<AttractionSearchResponse> response) {
                        showProgressBar();
                        if (response.isSuccessful()){
                            if (response.body().getEmbedded() != null){
                                hideProgressBar();
                                mAttractions = response.body().getEmbedded().getAttractions();
                                mAdapter = new AttractionsListAdapter(AttractionsActivity.this, mAttractions);
                                mRecyclerView.setAdapter(mAdapter);
                                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(AttractionsActivity.this);
                                mRecyclerView.setLayoutManager(layoutManager);
                                mRecyclerView.setHasFixedSize(true);
                            }else{
                                Toast.makeText(AttractionsActivity.this,"The event you searched does not exist",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<AttractionSearchResponse> call, Throwable t) {

                    }
                });
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void addToSharedPreferences(String keyword){
        mEditor.putString(Constants.PREFERENCES_KEYWORD, keyword).apply();
    }

    private void showProgressBar(){
        mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
    }

    private void hideProgressBar(){
        mProgressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

}