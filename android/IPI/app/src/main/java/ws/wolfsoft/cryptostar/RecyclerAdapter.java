package ws.wolfsoft.cryptostar;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    Context context;


    private List<ModelClass> OfferList;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView iteamName, price;

        public MyViewHolder(View view) {
            super(view);

            iteamName = (TextView) view.findViewById(R.id.itemName);
            price = (TextView) view.findViewById(R.id.price);
        }

    }


    public RecyclerAdapter(Context mainActivityContacts, List<ModelClass> offerList) {
        this.OfferList = offerList;
        this.context = mainActivityContacts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler, parent, false);


        return new MyViewHolder(itemView);


    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        ModelClass lists = OfferList.get(position);

        holder.iteamName.setText(lists.getIteamName());
        holder.price.setText(lists.getPrice());


    }

    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}
