package id.ac.id.telkomuniversity.tass.praktikrecylerview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KlasemenAdapter extends RecyclerView.Adapter {
    private final List<Team> teams;
    private Context context;
    AlertDialog.Builder builder;

    public KlasemenAdapter(Context context, List<Team> teams) {
        this.teams = teams;
        this.context = context;
        builder = new AlertDialog.Builder(context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView team, matches, points;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            team = itemView.findViewById(R.id.team);
            matches = itemView.findViewById(R.id.matches);
            points = itemView.findViewById(R.id.points);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RelativeLayout layout = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_klasemen, parent, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position){
        ViewHolder klasemenHolder = (ViewHolder) holder;
        klasemenHolder.team.setText(teams.get(position).getName());

        String matches = teams.get(position).getWin() +" / " + teams.get(position).getTie() +
                " / " + teams.get(position).getLose();
        klasemenHolder.matches.setText(matches);
        klasemenHolder.points.setText(String.valueOf(teams.get(position).getPoints()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name;
                int win, lose, tie;
                String hasil;
                AlertDialog dialog;

                name = teams.get(position).getName();
                win = teams.get(position).getWin();
                lose = teams.get(position).getLose();
                tie = teams.get(position).getTie();
                hasil = name + "\n \n" +
                        "Menang : " + win + "\n" +
                        "Seri : " + tie + "\n" +
                        "Kalah : " + lose + "\n";

                builder.setMessage(hasil);
                builder.setCancelable(false);
                builder.setNegativeButton("kembali", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }
}

