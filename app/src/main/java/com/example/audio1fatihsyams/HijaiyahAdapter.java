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
import android.widget.ImageView;

import java.io.IOException;

class HijaiyahAdapter extends RecyclerView.Adapter<HijaiyahAdapter.MyViewHolder> {

    MediaPlayer player;
    int[] sound = {R.raw.fatah_a,R.raw.fatah_ba,R.raw.fatah_ta,R.raw.fatah_tsa
            ,R.raw.fatah_ja,R.raw.fatah_ha,R.raw.fatah_kho,R.raw.fatah_da,R.raw.fatah_dza};
    int[] gambar = {R.drawable.alif,R.drawable.ba,R.drawable.ta,R.drawable.tsa,R.drawable.jim,R.drawable.kaf,R.drawable.kho,R.drawable.dal,R.drawable.dzal};

    Context context;
    public HijaiyahAdapter(Context context) {
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_hijaiyah_layout, null);
        return new MyViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        myViewHolder.imageView.setImageResource(gambar[i]);
        myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/" + sound[i]);
                if(myViewHolder.imageView.isClickable()) {
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
        return gambar.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_hijaiyah);
        }
    }
}
