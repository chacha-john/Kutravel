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
import com.chachaup.kutravel.adapters.VenueListAdapter;
import com.chachaup.kutravel.model.venues.Venue;
import com.chachaup.kutravel.model.venues.VenueSearchResponse;
import com.chachaup.kutravel.network.API;
import com.chachaup.kutravel.network.Client;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VenueActivity extends AppCompatActivity {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String keyword;

    private List<Venue> mVenues;

    private VenueListAdapter mAdapter;
    @BindView(R.id.recyclerViewVenue)
    RecyclerView mRecyclerView;
    @BindView(R.id.progressBarSearchVenue)
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue);
        ButterKnife.bind(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
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
                Call<VenueSearchResponse> call = client.getVenues(keyword,"US",API_KEY);
                call.enqueue(new Callback<VenueSearchResponse>() {
                    @Override
                    public void onResponse(Call<VenueSearchResponse> call, Response<VenueSearchResponse> response) {
                        showProgressBar();
                        if (response.isSuccessful()){
                            if (response.body().getEmbedded() != null){
                                hideProgressBar();
                                mVenues = response.body().getEmbedded().getVenues();
                                mAdapter = new VenueListAdapter(VenueActivity.this, mVenues);
                                mRecyclerView.setAdapter(mAdapter);
                                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(VenueActivity.this);
                                mRecyclerView.setLayoutManager(layoutManager);
                                mRecyclerView.setHasFixedSize(true);

                            } else{
                                Toast.makeText(VenueActivity.this,"The venue yo are looking for does not exist",Toast.LENGTH_SHORT).show();
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<VenueSearchResponse> call, Throwable t) {

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