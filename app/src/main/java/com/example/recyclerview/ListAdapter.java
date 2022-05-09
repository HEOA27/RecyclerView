package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> implements View.OnClickListener {
private List<ListElement> mData;
private LayoutInflater mInflater;
private Context context;
private View.OnClickListener listener;



public ListAdapter(List<ListElement>itemList, Context context){
    this.mInflater=LayoutInflater.from(context);
    this.context=context;
    this.mData=itemList;
}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
       View view=mInflater.inflate(R.layout.list_element, null);
       view.setOnClickListener(this);

       return new ListAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, int position) {
    holder.bindData(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData.size();

    }

    public void setItems(List<ListElement> items){mData=items;}

    public void setOnClickListener(View.OnClickListener listener){
    this.listener=listener;
    }
    @Override
    public void onClick(View view) {
        if(listener !=null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    ImageView iconImage;
    TextView nombre, telefono, correo;
    ViewHolder(View itemView){
     super(itemView);
     iconImage=itemView.findViewById(R.id.iconImageView);
     nombre=itemView.findViewById(R.id.nameTextView);
     telefono=itemView.findViewById(R.id.telefonoTextView);
     correo=itemView.findViewById(R.id.correoTextView);


    }
    void bindData(final ListElement item){
    nombre.setText(item.getNombre());
    telefono.setText(item.getTelefono());
    correo.setText(item.getCorreo());
    }
    }
}
