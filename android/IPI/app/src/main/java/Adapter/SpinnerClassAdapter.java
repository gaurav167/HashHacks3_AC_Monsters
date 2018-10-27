package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import ws.wolfsoft.cryptostar.R;

import java.util.ArrayList;

/**
 * Created by wolfsoft1 on 31/1/18.
 */

public class SpinnerClassAdapter extends ArrayAdapter<ItemDataClass> {
    int groupid;
    Context context;
    ArrayList<ItemDataClass> list;
    LayoutInflater inflater;

    public SpinnerClassAdapter(Context context, int groupid, int id, ArrayList<ItemDataClass>
            list) {
        super(context, id, list);
        this.list = list;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupid = groupid;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        View itemView = inflater.inflate(groupid, parent, false);
        TextView textView = (TextView) itemView.findViewById(R.id.data);
        textView.setText(list.get(position).getText());



        return itemView;
    }

    public View getDropDownView(int position, View convertView, ViewGroup
            parent) {
        return getView(position, convertView, parent);

    }
}
