package com.pixelart.week1weekendexercise;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ListView listView;
    ArrayList<Products> products = new ArrayList<>();
    Adapter adapter;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment


        listView = view.findViewById(R.id.lvHome);
        createProducts();

        return view;
    }

    public void createProducts()
    {
        Products p;
        int id;
        String name = "Featured Product ";
        String description ;

        for (id = 1; id < 15 +1; id++)
        {
            description = "This is the description for product "+ id;
            p = new Products(id,name + id, description);
            products.add(p);
        }

        adapter = new Adapter(getContext(), products);
        listView.setAdapter(adapter);
    }

}

//Custom Adapter class
class Adapter extends BaseAdapter
{

    Context context;
    ArrayList<Products> products ;

    public Adapter(Context context, ArrayList<Products> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.home_custom_layout, parent, false);
        }

        Products product = (Products) getItem(position);
        TextView name = convertView.findViewById(R.id.tvName);
        TextView description = convertView.findViewById(R.id.tvDescription);

        name.setText(product.getName());
        description.setText(product.getDescription());

        return convertView;
    }
}
