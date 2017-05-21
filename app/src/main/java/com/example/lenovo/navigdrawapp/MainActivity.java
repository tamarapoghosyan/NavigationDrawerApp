package com.example.lenovo.navigdrawapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements Fragment1.OnFragmentInteractionListener,Fragment2.OnFragmentInteractionListener,Fragment3.OnFragmentInteractionListener,Fragment4.OnFragmentInteractionListener {
    private String[] array;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        array=new String[]{"1","2","3","4"};
        drawerLayout= (DrawerLayout) findViewById(R.id.act_main_drawer_layout);
        drawerList= (ListView) findViewById(R.id.act_main_left_drawer);
        frameLayout= (FrameLayout) findViewById(R.id.act_main_conteiner);
        drawerList.setAdapter(new ArrayAdapter<String>(this,R.layout.drawer_item,array));

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String tag=Fragment1.TAG;
                    String name=array[i];
                FragmentManager fragmentManager=getSupportFragmentManager();;
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                Fragment fragment=null;
                if (name.equals("1")){
                    fragment=Fragment1.newInstance("1 Fragment");

                }
                else if(name.equals("2")){
                    fragment=Fragment2.newInstance("2 Fragment");

                }else if(name.equals("3")){
                    fragment=Fragment3.newInstance("3 Fragment");

                }else if(name.equals("4")){
                    fragment=Fragment4.newInstance("4 Fragment");

                }
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.act_main_conteiner, fragment, tag);
                fragmentTransaction.commit();
            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
