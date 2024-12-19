package com.example.robacobres_androidclient.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.robacobres_androidclient.R;
import com.example.robacobres_androidclient.callbacks.ForumCallback;
import com.example.robacobres_androidclient.models.ChatIndividual;
import com.example.robacobres_androidclient.models.Forum;

import java.util.List;

public class MyForumAdapter extends RecyclerView.Adapter<MyForumAdapter.ViewHolder> {

    private List<Forum> messages; // Llista de missatges del fòrum
    private Context context;      // Context de l'activitat
    private ForumCallback callback; // Callback per gestionar esdeveniments
    // Constructor de l'adaptador
    public MyForumAdapter(Context context, List<Forum> messages, ForumCallback callback) {
        this.context = context;
        this.messages = messages;
        this.callback = callback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el layout de cada fila
        View view = LayoutInflater.from(context).inflate(R.layout.row_forum_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Forum forum = messages.get(position); // Obté l'element en funció de la posició
        holder.userName.setText(forum.getName());
        holder.comentario.setText(forum.getComentario());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    // Classe ViewHolder per vincular els components visuals
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView comentario;
        ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Associa els components visuals amb els seus IDs
            userName = itemView.findViewById(R.id.userName);
            comentario = itemView.findViewById(R.id.comentario);
            icon = itemView.findViewById(R.id.icon);
        }
    }

    public void setForumMessages(List<Forum> newMessages) {
        this.messages = newMessages; // Actualitza la llista
        notifyDataSetChanged(); // Notifica al RecyclerView que actualitzi les dades
    }
}
