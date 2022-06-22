package com.chachaup.kutravel.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chachaup.kutravel.R;
import com.chachaup.kutravel.model.events.Event;
import com.chachaup.kutravel.ui.EventDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventViewHolder> {
    private List<Event> mEvents;
    private Context mContext;

    public EventListAdapter(Context context, List<Event> events){
        mContext = context;
        mEvents = events;

    }

    @NonNull
    @Override
    public EventListAdapter.EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list_item,parent,false);
        EventViewHolder viewHolder = new EventViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventListAdapter.EventViewHolder holder, int position) {
        holder.bindEvent(mEvents.get(position));

    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        @BindView(R.id.imageViewEventItem) ImageView mEventImageView;
        @BindView(R.id.textViewEventNameItem)TextView mEventNameView;
        @BindView(R.id.textViewEventDescriptionItem) TextView mDescriptionTextView;
        @BindView(R.id.textViewEventTypeItem) TextView mTypeTextView;

        private Context mContext;

        public EventViewHolder(View view){
            super(view);
            ButterKnife.bind(this,view);
            mContext = view.getContext();

            view.setOnClickListener(this);
        }

        public void bindEvent(Event event){
            mEventNameView.setText(event.getName());
            mDescriptionTextView.setText(event.getDescription());
            mTypeTextView.setText(event.getType());
            Picasso.get().load(event.getImages().get(5).getUrl()).into(mEventImageView);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, EventDetailActivity.class);
            intent.putExtra("events", Parcels.wrap(mEvents));
            mContext.startActivity(intent);
        }
    }

}
