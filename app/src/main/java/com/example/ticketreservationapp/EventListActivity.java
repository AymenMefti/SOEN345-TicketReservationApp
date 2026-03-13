package com.example.ticketreservationapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import java.util.ArrayList;
import java.util.List;

public class EventListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EventAdapter adapter;
    private List<Event> eventList = new ArrayList<>();
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EventAdapter(eventList);
        recyclerView.setAdapter(adapter);

        db = FirebaseFirestore.getInstance();
        loadEvents();
    }

    private void loadEvents() {
        db.collection("events").get().addOnSuccessListener(queryDocumentSnapshots -> {
                    eventList.clear();
                    for (QueryDocumentSnapshot doc : queryDocumentSnapshots) {
                        Event event = doc.toObject(Event.class);
                        eventList.add(event);
                    }
                    adapter.notifyDataSetChanged();
                }).addOnFailureListener(e -> {
                    e.printStackTrace();
                });
    }
}