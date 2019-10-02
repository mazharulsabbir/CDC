package edu.daffodil.cdc.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.daffodil.cdc.Adapters.ProductAdapter;
import edu.daffodil.cdc.R;
import edu.daffodil.cdc.helper.Company;
import edu.daffodil.cdc.helper.Product;

/**
 * A simple {@link Fragment} subclass.
 */
public class DepartmentList extends Fragment {


    View view;
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_department_list, container, false);


        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        setData();

        return view;
    }

    private void setData() {
        ArrayList<Company> companies=new ArrayList<>();


        ArrayList<Product> SIT_products=new ArrayList<>();

        SIT_products.add(new Product("Computer Science and Engineering"));
        SIT_products.add(new Product("Software Engineering"));
        SIT_products.add(new Product("Multimedia & Creative Technology (MCT)"));
        SIT_products.add(new Product("General Educational Development"));
        SIT_products.add(new Product("Environmental Science and Disaster Management"));
        SIT_products.add(new Product("Computing and Information System"));


        Company SIT=new Company("Faculty of Science and Information Technology",SIT_products);
        companies.add(SIT);


        ArrayList<Product> ENG_products=new ArrayList<>();

        ENG_products.add(new Product("Electronics and Telecommunication Engineering"));
        ENG_products.add(new Product("Textile Engineering"));
        ENG_products.add(new Product("Electrical and Electronic Engineering"));
        ENG_products.add(new Product("Department of Architecture"));
        ENG_products.add(new Product("Civil Engineering"));


        Company ENG=new Company("Faculty of Engineering",ENG_products);
        companies.add(ENG);


        ProductAdapter adapter=new ProductAdapter(companies);
        recyclerView.setAdapter(adapter);
    }


}
