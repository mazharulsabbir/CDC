package edu.daffodil.cdc.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;

import edu.daffodil.cdc.R;
import edu.daffodil.cdc.adapters.ExpandableAdapter;
import edu.daffodil.cdc.helper.ChildExpandable;
import edu.daffodil.cdc.helper.ParentExpandable;

/**
 * A simple {@link Fragment} subclass.
 */
public class DepartmentList extends Fragment {
    private static final String TAG = "DepartmentList";

    private static final String FSIT = "Faculty of Science and Information Technology";
    private static final String FE = "Faculty of Engineering";
    private static final String FBE = "Faculty of Business & Entrepreneurship";
    private static final String FAHS = "Faculty of Allied Health Science";
    private static final String FHSS = "Faculty of Humanities & Social Science";


    private View view;
    private RecyclerView recyclerView;

    private String parentItemTitle;


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
        final ArrayList<ParentExpandable> companies = new ArrayList<>();


        ArrayList<ChildExpandable> SIT_products = new ArrayList<>();

        SIT_products.add(new ChildExpandable("Computer Science and Engineering"));
        SIT_products.add(new ChildExpandable("Software Engineering"));
        SIT_products.add(new ChildExpandable("Multimedia & Creative Technology (MCT)"));
        SIT_products.add(new ChildExpandable("General Educational Development"));
        SIT_products.add(new ChildExpandable("Environmental Science and Disaster Management"));
        SIT_products.add(new ChildExpandable("Computing and Information System"));


        final ParentExpandable SIT = new ParentExpandable(FSIT, SIT_products);
        companies.add(SIT);


        ArrayList<ChildExpandable> ENG_products = new ArrayList<>();

        ENG_products.add(new ChildExpandable("Electronics and Telecommunication Engineering"));
        ENG_products.add(new ChildExpandable("Textile Engineering"));
        ENG_products.add(new ChildExpandable("Electrical and Electronic Engineering"));
        ENG_products.add(new ChildExpandable("Department of Architecture"));
        ENG_products.add(new ChildExpandable("Civil Engineering"));


        ParentExpandable ENG = new ParentExpandable(FE, ENG_products);
        companies.add(ENG);


        ArrayList<ChildExpandable> BE_products = new ArrayList<>();

        BE_products.add(new ChildExpandable("Business Administration"));
        BE_products.add(new ChildExpandable("Business Studies"));
        BE_products.add(new ChildExpandable("Real Estate"));
        BE_products.add(new ChildExpandable("Tourism & Hospitality Management"));
        BE_products.add(new ChildExpandable("Innovation & Entrepreneurship"));


        ParentExpandable BE = new ParentExpandable(FBE, BE_products);
        companies.add(BE);

        ArrayList<ChildExpandable> AHS_products = new ArrayList<>();

        AHS_products.add(new ChildExpandable("Department of Pharmacy"));
        AHS_products.add(new ChildExpandable("Nutrition and Food Engineering"));
        AHS_products.add(new ChildExpandable("Department of Public Health"));


        ParentExpandable AHS = new ParentExpandable(FAHS, AHS_products);
        companies.add(AHS);


        ArrayList<ChildExpandable> HSS_products = new ArrayList<>();

        HSS_products.add(new ChildExpandable("Department of English"));
        HSS_products.add(new ChildExpandable("Department of Law"));
        HSS_products.add(new ChildExpandable("Journalism & Mass Communication"));
        HSS_products.add(new ChildExpandable("Department of Development Studies"));


        ParentExpandable HSS = new ParentExpandable(FHSS, AHS_products);
        companies.add(HSS);


        final ExpandableAdapter adapter = new ExpandableAdapter(companies);
        recyclerView.setAdapter(adapter);

        adapter.onChildClickListener(new ExpandableAdapter.OnClickListenerChild() {
            @Override
            public void clickListener(int position, ExpandableGroup group) {
                final ChildExpandable items = (ChildExpandable) group.getItems().get(position);

                Toast.makeText(getContext(),
                        items.getName(),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
