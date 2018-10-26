package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ModelClass.CryptoListModelClass;
import ModelClass.WalletModelClass;
import ws.wolfsoft.cryptostar.LoginActivity;
import ws.wolfsoft.cryptostar.R;
import ws.wolfsoft.cryptostar.SignupActivity;
import ws.wolfsoft.cryptostar.SplashScreenActivity;
import ws.wolfsoft.cryptostar.TradeCryptoStarActivity;


public class WalletRecycleAdapter extends RecyclerView.Adapter<WalletRecycleAdapter.MyViewHolder> {

    Context context;


    private List<WalletModelClass> OfferList;


    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView title,icon_type,percentage,price,value;
        ImageView icon,arrow;


        public MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            icon_type = (TextView) view.findViewById(R.id.icon_type);
            percentage = (TextView) view.findViewById(R.id.percentage);
            price = (TextView) view.findViewById(R.id.price);
            value = (TextView) view.findViewById(R.id.value);
            icon = (ImageView) view.findViewById(R.id.icon);
            arrow = (ImageView) view.findViewById(R.id.arrow);



        }

    }


    public WalletRecycleAdapter(Context context, List<WalletModelClass> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public WalletRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_wallet_list, parent, false);


        return new WalletRecycleAdapter.MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        WalletModelClass lists = OfferList.get(position);
        holder.title.setText(lists.getTitle());
        holder.icon.setImageResource(lists.getIcon());
        holder.icon_type.setText(lists.getIcon_type());
        holder.percentage.setText(lists.getPercentage());
        holder.arrow.setImageResource(lists.getArrow());
        holder.price.setText(lists.getPrice());
        holder.value.setText(lists.getValue());




    }


    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}


