package com.example.fhskamra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdpter extends RecyclerView.Adapter<RecyclerAdpter.ViewHolder> {

    private static String Tag="RecyclerView";
    private Context pcontext;
    private ArrayList<project_retrieve> projectArrayList;
    public RecyclerAdpter(Context pcontext, ArrayList<project_retrieve> projectArrayList) {
        this.pcontext = pcontext;
        this.projectArrayList = projectArrayList;
    }
    @NonNull
    @Override
    public RecyclerAdpter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.project_retrieve,parent,false);
       return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtDetail.setText(projectArrayList.get(position).getDetails());
            holder.txtTitle.setText(projectArrayList.get(position).getName());
            Picasso.get().load(projectArrayList.get(position).getImage()).into(holder.imgproj);
    }
    @Override
    public int getItemCount() {

        return projectArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView imgproj;
            TextView txtTitle,txtDetail;
            public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgproj=itemView.findViewById(R.id.img_projectret);
            txtTitle=itemView.findViewById(R.id.txt_title_projret);
            txtDetail=itemView.findViewById(R.id.txt_detail_projret);
        }
    }
}
