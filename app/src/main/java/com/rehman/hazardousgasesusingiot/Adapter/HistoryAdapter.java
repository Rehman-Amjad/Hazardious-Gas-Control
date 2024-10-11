package com.rehman.hazardousgasesusingiot.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rehman.hazardousgasesusingiot.R;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder>
{
    private Context context;
    private List<HistoryModel> mDatalist;

    public HistoryAdapter(Context context, List<HistoryModel> mDatalist) {
        this.context = context;
        this.mDatalist = mDatalist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myview= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);


        return new MyViewHolder(myview);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        HistoryModel user=mDatalist.get(position);


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] imageBytes = baos.toByteArray();
        imageBytes = Base64.decode(user.getImg(), Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);

        holder.imageView.setImageBitmap(decodedImage);

        holder.tvId.setText("ID:" + user.getId());
        holder.tv_vmq2.setText("MQ-2 sensor value:" + user.getVMQ2());
        holder.tv_vmqone.setText("MQ-137 sensor value: :" + user.getVMQ137());

        holder.tv_vmq4.setText("MQ-4 sensor value:" + user.getVMQ4());
        holder.tv_vmq5.setText("MQ-5 sensor value:" + user.getVMQ5());
        holder.tv_vmq3.setText("MQ-3 sensor value:" + user.getVMQ3());
        holder.tv_vmq6.setText("MQ-6 sensor value:" + user.getVMQ6());

        holder.tv_fire.setText("Humidity :" + user.getVHumidity());
        holder.tv_temp.setText("Temperature :" + user.getVtemp());

        holder.tv_DateTime.setText("DateTime: "+ user.getDateTime());

    }

    @Override
    public int getItemCount() {
        return mDatalist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvId,tv_fire,tv_vmqone,tv_DateTime,tv_vmq2,tv_vmq3,tv_vmq4,tv_vmq5,tv_vmq6,tv_temp;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.card_image);
            tvId=itemView.findViewById(R.id.tvId);
            tv_fire=itemView.findViewById(R.id.tv_fire);
            tv_vmqone=itemView.findViewById(R.id.tv_vmqone);
            tv_DateTime=itemView.findViewById(R.id.tv_DateTime);
            tv_vmq2=itemView.findViewById(R.id.tv_vmq2);
            tv_vmq3=itemView.findViewById(R.id.tv_vmq3);
            tv_vmq4=itemView.findViewById(R.id.tv_vmq4);
            tv_vmq5=itemView.findViewById(R.id.tv_vmq5);
            tv_vmq6=itemView.findViewById(R.id.tv_vmq6);
            tv_temp=itemView.findViewById(R.id.tv_temp);

        }
    }
}
