package com.chachaup.kutravel.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chachaup.kutravel.R;
import com.chachaup.kutravel.model.events.Event;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventDetailFragment extends Fragment {
    @BindView(R.id.ImageViewEventDetail)
    ImageView mEventImage;
    @BindView(R.id.buttonBookmarkEventDetail)
    Button mBookmark;
    @BindView(R.id.buttonExitEventDetail) Button mExit;
    @BindView(R.id.textViewEndDateEventDetail)
    TextView mEndDate;
    @BindView(R.id.textViewStartDateEventDetail) TextView mStartDate;
    @BindView(R.id.textViewEventDescriptionEventDetail) TextView mDescription;
    @BindView(R.id.textViewEventAddressEventDetail) TextView mAddress;
    @BindView(R.id.textViewEventTicketEventDetail) TextView mTicket;

    private Event mEvent;


    public EventDetailFragment() {
        // Required empty public constructor
    }

    public static EventDetailFragment newInstance(Event event){
        EventDetailFragment fragment = new EventDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("event", Parcels.wrap(event));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mEvent = Parcels.unwrap(getArguments().getParcelable("event"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_detail, container, false);
        ButterKnife.bind(this, view);
        Picasso.get().load(mEvent.getImages().get(5).getUrl()).into(mEventImage);
        mAddress.setText(mEvent.getPlace().getAddress().toString());
        mDescription.setText(mEvent.getDescription());
        mStartDate.setText(mEvent.getDates().getStart().toString());
        mEndDate.setText(mEvent.getDates().getEnd().toString());

        return view;
    }
}