package com.app.jiogameapp.adapter;


import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.app.jiogameapp.R;
import com.app.jiogameapp.model.DataVal;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public  class AdapterView extends RecyclerView.Adapter<AdapterView.ViewHolder>{
    Context con;
    ArrayList<DataVal> modelData;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_viewlist, parent, false);
        return new ViewHolder(itemView);
    }
    public AdapterView(ArrayList<DataVal> modelData, Context con) {
        this.modelData=modelData;
        this.con=con;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {
        //------------------settin data-------------------------------------------
        DataVal dataVal=modelData.get(position);
        holder.image_view.setBackgroundResource(0);
        Glide.with(holder.itemView.getContext())
                .load(dataVal.getImage())
                .into(holder.image_view);
        holder.company_name.setText(dataVal.getCompany_name());
        holder.game_name.setText(dataVal.getName());
        //---------------------setting click on view
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //--------------------setting bottom sheet
               LayoutInflater inflater=LayoutInflater.from(con);
                View view1 = inflater.inflate(R.layout.bottom_layout, null);
                BottomSheetDialog dialog = new BottomSheetDialog(con);
                dialog.setContentView(view1);
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelData.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image_view;
        TextView game_name,company_name;
        public ViewHolder(View itemView) {
            super(itemView);
            image_view=(ImageView)itemView.findViewById(R.id.image_game);
            game_name=itemView.findViewById(R.id.game_name);
            company_name=itemView.findViewById(R.id.company_name);
        }
    }


    //-------------------------------------------------------------------------------------------------



}
