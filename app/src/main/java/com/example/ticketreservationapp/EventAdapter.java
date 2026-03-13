package com.example.ticketreservationapp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<Event> eventList;

    public EventAdapter(List<Event> eventList) {
        this.eventList = eventList;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
    }

    public void onBindViewHolder(EventViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.tvTitle.setText(event.getTitle());
        holder.tvDate.setText("\uD83D\uDCC5 " + event.getDate() + " @ " + event.getDateTime());
        holder.tvLocation.setText("\uD83D\uDCCD" + event.getLocation());
        holder.tvCategory.setText("\uD83C\uDFF7" + event.getCategory());
    }
    public int getItemCount() {
        return eventList.size();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDate, tvLocation, tvCategory;

        public EventViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvCategory = itemView.findViewById(R.id.tvCategory);
        }
    }
}
