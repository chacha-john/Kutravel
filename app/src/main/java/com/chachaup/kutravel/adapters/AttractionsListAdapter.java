package com.chachaup.kutravel.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chachaup.kutravel.R;
import com.chachaup.kutravel.model.attractions.Attraction;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AttractionsListAdapter extends RecyclerView.Adapter<AttractionsListAdapter.AttractionsViewHolder>{
    private Context mContext;
    private List<Attraction> mAttractions;

    public AttractionsListAdapter(Context context, List<Attraction> attractions){
        this.mContext = context;
        this.mAttractions = attractions;
    }
    @NonNull
    @Override
    public AttractionsListAdapter.AttractionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list_item,parent,false);
        AttractionsViewHolder viewHolder = new AttractionsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AttractionsListAdapter.AttractionsViewHolder holder, int position) {
        holder.bindEvent(mAttractions.get(position));
    }

    @Override
    public int getItemCount() {
        return mAttractions.size();
    }

    public class AttractionsViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imageViewEventItem)
        ImageView mAttractionImageView;
        @BindView(R.id.textViewEventNameItem)
        TextView mAttractionNameView;
        @BindView(R.id.textViewEventDescriptionItem) TextView mDescriptionTextView;
        @BindView(R.id.textViewEventTypeItem) TextView mTypeTextView;

        public AttractionsViewHolder(View view){
            super(view);
            ButterKnife.bind(this,view);
            mContext = view.getContext();


        }

        public void bindEvent(Attraction attraction){
            mAttractionNameView.setText(attraction.getName());
            mDescriptionTextView.setText(attraction.getClassifications().get(0).getSegment().getName());
            mTypeTextView.setText(attraction.getClassifications().get(0).getGenre().getName());
            Picasso.get().load(attraction.getImages().get(5).getUrl()).into(mAttractionImageView);
        }
    }
}
