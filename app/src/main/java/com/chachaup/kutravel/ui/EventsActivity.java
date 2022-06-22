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
import android.widget.SearchView;
import android.widget.Toast;

import com.chachaup.kutravel.Constants;
import com.chachaup.kutravel.R;
import com.chachaup.kutravel.adapters.EventListAdapter;
import com.chachaup.kutravel.model.events.Event;
import com.chachaup.kutravel.model.events.EventSearchResponse;
import com.chachaup.kutravel.network.API;
import com.chachaup.kutravel.network.Client;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventsActivity extends AppCompatActivity {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String keyword;

    private List<Event> mEvents;

    private EventListAdapter mAdapter;
    @BindView(R.id.recyclerViewEvents)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        MenuItem menuItem = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String keyword) {
                addToSharedPreferences(keyword);
                API client = Client.getClient();
                Call<EventSearchResponse> call = client.getEvents(keyword,"US", API_KEY);
                call.enqueue(new Callback<EventSearchResponse>() {
                    @Override
                    public void onResponse(Call<EventSearchResponse> call, Response<EventSearchResponse> response) {
                        if (response.isSuccessful()){
                            if (response.body().getEmbedded() != null){
                                mEvents = response.body().getEmbedded().getEvents();
                                mAdapter = new EventListAdapter(EventsActivity.this, mEvents);
                                mRecyclerView.setAdapter(mAdapter);
                                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(EventsActivity.this);
                                mRecyclerView.setLayoutManager(layoutManager);
                                mRecyclerView.setHasFixedSize(true);
                            }else{
                                Toast.makeText(EventsActivity.this,"The event you searched does not exist",Toast.LENGTH_SHORT).show();
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<EventSearchResponse> call, Throwable t) {

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
}