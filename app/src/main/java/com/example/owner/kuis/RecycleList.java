package com.example.owner.kuis;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecycleList extends AppCompatActivity {
    public RecyclerView myRecyclerView;
    public RecyclerView.LayoutManager mLayoutManager;
    public RecyclerView.Adapter mAdapter;
    List<Player> players= new ArrayList<>();
    private Player playerItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_list);

        myRecyclerView = (RecyclerView)findViewById(R.id.recycleLayout);
        mLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(mLayoutManager);

        playerItem = new Player("Bustomi Arifin","CF | 40 ",R.drawable.bustomi,"Ahmad Bustomi (lahir di Jombang, Jawa Timur, 13 Juli 1985; umur 31 tahun) adalah seorang pemain sepak bola Indonesia. Saat ini dia bermain untuk Mitra Kukar di Liga Super Indonesia. Dia biasa berposisi sebagai Midfielder. Pemain idola Bustomi adalah Bima Sakti yang pernah menjadi rekan satu tim di Persema Malang dan Andrea Pirlo");
        players.add(playerItem);
        playerItem = new Player("Bustomi Arifin","CF | 40 ",R.drawable.gonzales,"Cristian Gérard Alfaro Gonzáles (lahir di Montevideo, Uruguay, 30 Agustus 1976; umur 40 tahun) adalah seorang pemain sepak bola Indonesia yang bermain untuk Arema Indonesia dan tim nasional Indonesia. Ia berposisi sebagai penyerang tengah maupun penyerang tunggal. Ia telah 4 kali meraih gelar pencetak gol terbanyak Liga Indonesia dan telah mencetak 173 gol. Sebelumnya, ia merupakan warga negara Uruguay, namun sejak 1 November 2010, ia resmi menjadi warga negara Indonesia. Ia juga salah satu penyerang yang paling mematikan sepanjang sejarah kompetisi sepak bola Indonesia");
        players.add(playerItem);
        playerItem = new Player("Bustomi Arifin","CF | 40 ",R.drawable.bustomi,"bustomi bustomi bustomi bustomi bustomi bustomi bustomi bustomi bustomi bustomi bustomi bustomi");
        players.add(playerItem);
        playerItem = new Player("Bustomi Arifin","CF | 40 ",R.drawable.gonzales,"gonzales gonzales gonzales gonzales gonzales gonzales gonzales gonzales gonzales gonzales");
        players.add(playerItem);
        mAdapter= new PlayerAdapter(players,getApplicationContext());
        myRecyclerView.setAdapter(mAdapter);
    }
    public static class Player{
        private String playerName,playerInfo,details;
        private  int playerImages;
        public Player(String playerName, String playerInfo, int playerImages, String details) {
            this.playerName = playerName;
            this.playerInfo = playerInfo;
            this.playerImages= playerImages;
            this.details = details;
        }
        public int getPlayerImages() {
            return playerImages;
        }

        public void setPlayerImages(int playerImages) {
            this.playerImages = playerImages;
        }

        public String getPlayerName() {

            return playerName;
        }

        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }

        public String getPlayerInfo() {
            return playerInfo;
        }

        public void setPlayerInfo(String playerInfo) {
            this.playerInfo = playerInfo;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }
    public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder>{
        Context context;
        List<Player> players;
        public PlayerAdapter(List<Player> players, Context context) {
            this.players= players;
            this.context= context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = myRecyclerView.getChildAdapterPosition(view);
                    if (pos >= 0 && pos < getItemCount()) {

                        Intent intent= new Intent(context,DetailsPlayer.class);
                        intent.putExtra("playerName",players.get(pos).getPlayerName());
                        intent.putExtra("playerInfo",players.get(pos).getPlayerInfo());
                        intent.putExtra("playerImage",players.get(pos).getPlayerImages());
                        intent.putExtra("playerDetails",players.get(pos).getDetails());
                        startActivity(intent);
                    }
                }
            });
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Player pl= players.get(position);
            holder.playerName.setText(pl.getPlayerName());
            holder.playerInfo.setText(pl.getPlayerInfo());
            holder.playerImage.setImageResource(pl.getPlayerImages());

        }

        @Override
        public int getItemCount() {
            return players.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView playerImage;
            public TextView playerName,playerInfo;
            public ViewHolder(View itemView) {
                super(itemView);
                playerName=(TextView)itemView.findViewById(R.id.playerName);
                playerInfo=(TextView)itemView.findViewById(R.id.playerInfo);
                playerImage=(ImageView) itemView.findViewById(R.id.playerImages);

            }
        }
    }
}
