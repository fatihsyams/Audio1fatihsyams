package com.example.audio1fatihsyams;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

class BuahAdapter extends RecyclerView.Adapter<BuahAdapter.ViewHolder>{
    MediaPlayer player;
    String[] nameBuah;
    int[] imageBuah;
    Context context;
    int[] suaraBuah;

    public BuahAdapter(Context context, String[] namaBuah, int[] gambarBuah, int[] suaraBuah) {
        this.context = context;
        this.nameBuah = namaBuah;
        this.imageBuah = gambarBuah;
        this.suaraBuah = suaraBuah;
    }

    @NonNull
    @Override
    public BuahAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_layout_buah, null);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull final BuahAdapter.ViewHolder viewHolder, final int i) {
            viewHolder.namaBuah.setText(nameBuah[i]);
            viewHolder.gambarBuah.setImageResource(imageBuah[i]);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/" + suaraBuah[i]);
                    if(viewHolder.itemView.isClickable()) {
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
        return nameBuah.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView namaBuah;
        ImageView gambarBuah;
        public ViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            namaBuah = itemView.findViewById(R.id.tv_buah);
            gambarBuah = itemView.findViewById(R.id.img_buah);

        }
    }
}
