package com.example.robacobres_androidclient.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.net.Uri;
import android.widget.VideoView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.robacobres_androidclient.R;
import com.example.robacobres_androidclient.models.Item;
import com.example.robacobres_androidclient.models.Video;
import com.example.robacobres_androidclient.services.ServiceBBDD;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.ViewHolder> {
    private List<Video> videoList;
    private Context context;
    private ServiceBBDD service;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView Description;
        VideoView videoView;

        public ViewHolder(View v) {
            super(v);
            Description = itemView.findViewById(R.id.Descripcion);
            videoView = itemView.findViewById(R.id.videoView);
        }
    }

    public VideosAdapter(List<Video> videoList) {
        this.videoList = videoList;
    }

    @Override
    public VideosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.videoview, parent, false);
        // set the view's size, margins, paddings and layout parameters
        VideosAdapter.ViewHolder vh = new VideosAdapter.ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(VideosAdapter.ViewHolder holder, final int position) {
        Video video = videoList.get(position);
        holder.Description.setText(video.getDescripcion());

        // Configurar el VideoView con la URL del video
        Uri videoUri = Uri.parse(video.getUrl());
        holder.videoView.setVideoURI(videoUri);
        // Iniciar la reproducción automáticamente
        holder.videoView.setOnPreparedListener(mediaPlayer -> {
            mediaPlayer.setLooping(true); // Opcional: para reproducir en bucle
            holder.videoView.start();
        });
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }
}


