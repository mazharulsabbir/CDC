package edu.daffodil.cdc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    GridView gridView;

    int[] icon={R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground};
    String[] name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView=findViewById(R.id.gridView);
        name=getResources().getStringArray(R.array.dashboard);

        CustomAdapter adapter= new CustomAdapter(this,icon,name);
        gridView.setAdapter(adapter);

    }


    private class CustomAdapter extends BaseAdapter {
        LayoutInflater inflate;
        Context context;
        int[] icon;
        String[] name;

        public CustomAdapter(Context context, int[] icon, String[] name) {
            this.context = context;
            this.icon = icon;
            this.name = name;
        }

        @Override
        public int getCount() {
            return name.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView==null){
                inflate= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
               convertView= inflate.inflate(R.layout.dashboard_sample,parent,false);

            }

            ImageView img=convertView.findViewById(R.id.imageViewId);
            TextView textView=convertView.findViewById(R.id.textViewId);


            img.setImageResource(icon[position]);
            textView.setText(name[position]);


            return convertView;
        }
    }
}
