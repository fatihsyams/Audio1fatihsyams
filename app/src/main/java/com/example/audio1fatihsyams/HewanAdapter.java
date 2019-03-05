package com.example.audio1fatihsyams;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

class HewanAdapter extends RecyclerView.Adapter<HewanAdapter.ViewHolder> {
    MediaPlayer player;
    String[] namaHewan;
    int[] soundHewan;
    int[] gambarHewan;
    Context context;

    public HewanAdapter(Context context, String[] namaHewan, int[] gambarHewan, int[] soundHewan) {
        this.context = context;
        this.gambarHewan = gambarHewan;
        this.soundHewan = soundHewan;
        this.namaHewan = namaHewan;
    }

    @NonNull
    @Override
    public HewanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.fragment_layout_hewan, null);
        return new ViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull HewanAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.imgAnimals.setImageResource(gambarHewan[i]);
        viewHolder.nameAnimals.setText(namaHewan[i]);
        viewHolder.soundAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button hwn = v.findViewById(R.id.btn_hewan);

                    Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/" + soundHewan[i]);
                    if(hwn.isClickable()) {
                        player = new MediaPlayer();
                        player.setAudioStreamType(AudioManager.STREAM_MUSIC);


                        try {
                            player.setDataSource(context
                                    , uri);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        }
                        try {
                            player.prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        player.start();
                    }

            }
        });
    }

    @Override
    public int getItemCount() {
        return namaHewan.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAnimals;
        TextView nameAnimals;
        Button soundAnimals;

        public ViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            imgAnimals = itemView.findViewById(R.id.img_hewan);
            nameAnimals = itemView.findViewById(R.id.tv_hewan);
            soundAnimals = itemView.findViewById(R.id.btn_hewan);
        }
    }

    private void off(View... views) {
        for (View v : views) {
            v.setEnabled(false);
        }
    }

    private void on(View...views) {
        for (View v : views) {
            v.setEnabled(true);
        }

    }
}

