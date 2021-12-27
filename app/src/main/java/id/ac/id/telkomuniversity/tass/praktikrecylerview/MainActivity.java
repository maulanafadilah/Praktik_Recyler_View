package id.ac.id.telkomuniversity.tass.praktikrecylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView klasemenRecyler;
    private RecyclerView.Adapter klasemenAdapter;
    private RecyclerView.LayoutManager klasemenLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        klasemenRecyler = findViewById(R.id.lisklasemen);
        klasemenRecyler.setHasFixedSize(true);
        klasemenLayoutManager = new LinearLayoutManager(this);
        klasemenRecyler.setLayoutManager(klasemenLayoutManager);

        klasemenAdapter = new KlasemenAdapter(this,populateTeams());
        klasemenRecyler.setAdapter(klasemenAdapter);
    }

    private List<Team> populateTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(Team.generateTeam("Milan", 5, 2, 0));
        teams.add(Team.generateTeam("Sassuolo", 4, 3, 0));
        teams.add(Team.generateTeam("Napoli", 5, 0, 2));
        teams.add(Team.generateTeam("Roma", 4, 2, 1));
        teams.add(Team.generateTeam("Juventus", 3, 4, 0));
        return teams;
    }

    RequestQueue mRequestQueue = Volley.newRequestQueue(this);

    StringRequest mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    });

}