package edu.daffodil.cdc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    int[] icon={R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground};
    String[] name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Dashboard");

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        name=getResources().getStringArray(R.array.dashboard);

        CustomAdapter adapter= new CustomAdapter(this,icon,name);
        recyclerView.setAdapter(adapter);



    }


    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
        LayoutInflater inflate;
        Context context;
        int[] icon;
        String[] name;


        public CustomAdapter(Context context, int[] icon, String[] name) {
            this.context = context;
            this.icon = icon;
            this.name = name;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.dashboard_sample, parent, false);
            return new ViewHolder(v);

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.imageView.setImageResource(icon[position]);
            holder.textView.setText(name[position]);
        }

        @Override
        public int getItemCount() {
            return name.length;
        }

         class ViewHolder extends RecyclerView.ViewHolder{

            ImageView imageView;
            TextView textView;
             ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView=itemView.findViewById(R.id.imageViewId);
                textView=itemView.findViewById(R.id.textViewId);

            }
        }



    }
}
