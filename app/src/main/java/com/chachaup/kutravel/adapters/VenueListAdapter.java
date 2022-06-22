package com.chachaup.kutravel.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chachaup.kutravel.R;
import com.chachaup.kutravel.model.venues.Venue;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VenueListAdapter extends RecyclerView.Adapter<VenueListAdapter.VenueViewHolder> {
    private List<Venue> mVenue;
    private Context mContext;

    public VenueListAdapter(Context context, List<Venue> venues){
        mContext = context;
        mVenue = venues;

    }

    @NonNull
    @Override
    public VenueListAdapter.VenueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list_item,parent,false);
        VenueViewHolder viewHolder = new VenueViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VenueListAdapter.VenueViewHolder holder, int position) {
        holder.bindEvent(mVenue.get(position));

    }

    @Override
    public int getItemCount() {
        return mVenue.size();
    }

    public class VenueViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.textViewEventNameItem)TextView mEventNameView;
        @BindView(R.id.textViewEventDescriptionItem) TextView mDescriptionTextView;
        @BindView(R.id.textViewEventTypeItem) TextView mTypeTextView;

        private Context mContext;

        public VenueViewHolder(View view){
            super(view);
            ButterKnife.bind(this,view);
            mContext = view.getContext();
        }

        public void bindEvent(Venue venue){
            mEventNameView.setText(venue.getName());
            mDescriptionTextView.setText(venue.getCity().getName());
            mTypeTextView.setText(venue.getAddress().getLine1());
        }
    }
}
