package com.pixelart.week1weekendexercise;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsFragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayList<Products> products = new ArrayList<>();
    ProductsAdapter adapter;


    public ProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);

        listView = view.findViewById(R.id.lvProducts);
        createProducts();

        return view;
    }

    public void createProducts()
    {
        Products p;
        int id;
        String name = "Product ";
        String description ;
        double price = 4.00;

        for (id = 1; id < 25 +1; id++)
        {
            price = price + id;
            description = "This is the description for product "+ id;
            p = new Products(id,name + id, description, price);
            products.add(p);
        }

        adapter = new ProductsAdapter(getContext(), products);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Products selectedProduct = products.get(position);
        Toast.makeText(getContext(), "Clicked "+ selectedProduct.getName(), Toast.LENGTH_LONG).show();
    }
}


//Custom Adapter class
class ProductsAdapter extends BaseAdapter
{

    Context context;
    ArrayList<Products> products ;

    public ProductsAdapter(Context context, ArrayList<Products> products) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.products_custom_layout, parent, false);
        }

        Products product = (Products) getItem(position);
        TextView name = convertView.findViewById(R.id.tvName);
        TextView description = convertView.findViewById(R.id.tvDescription);
        TextView price = convertView.findViewById(R.id.tvPrice);

        name.setText(product.getName());
        description.setText(product.getDescription());
        price.setText("£" + product.getPrice());

        return convertView;
    }
}