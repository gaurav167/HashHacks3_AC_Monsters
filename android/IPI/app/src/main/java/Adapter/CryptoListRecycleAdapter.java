package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ModelClass.CryptoListModelClass;

import ws.wolfsoft.cryptostar.AlertCryptoStarActivity;
import ws.wolfsoft.cryptostar.ChartCryptoStarActivity;
import ws.wolfsoft.cryptostar.LoginActivity;
import ws.wolfsoft.cryptostar.R;
import ws.wolfsoft.cryptostar.SignupActivity;
import ws.wolfsoft.cryptostar.SplashScreenActivity;
import ws.wolfsoft.cryptostar.TradeCryptoStarActivity;
import ws.wolfsoft.cryptostar.WSSplashScreenActivity;
import ws.wolfsoft.cryptostar.WalletCryptoStarActivity;


public class CryptoListRecycleAdapter extends RecyclerView.Adapter<CryptoListRecycleAdapter.MyViewHolder> {

    Context context;


    private List<CryptoListModelClass> OfferList;


    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView title;


        public MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);


        }

    }


    public CryptoListRecycleAdapter(Context context, List<CryptoListModelClass> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public CryptoListRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_crypto_list, parent, false);


        return new CryptoListRecycleAdapter.MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        CryptoListModelClass lists = OfferList.get(position);
        holder.title.setText(lists.getTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (position == 0) {
                    Intent i = new Intent(context, SplashScreenActivity.class);
                    context.startActivity(i);
                }else if(position == 1) {
                    Intent i = new Intent(context, LoginActivity.class);
                    context.startActivity(i);
                }else if(position == 2) {
                    Intent i = new Intent(context, SignupActivity.class);
                    context.startActivity(i);
                }else if(position == 4) {
                    Intent i = new Intent(context, TradeCryptoStarActivity.class);
                    context.startActivity(i);
                }else if(position == 5) {
                    Intent i = new Intent(context, WalletCryptoStarActivity.class);
                    context.startActivity(i);
                }else if(position == 6) {
                    Intent i = new Intent(context, AlertCryptoStarActivity.class);
                    context.startActivity(i);
                }else if(position == 7) {
                    Intent i = new Intent(context, ChartCryptoStarActivity.class);
                    context.startActivity(i);
                }

            }

        });


    }


    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}


