package com.example.prueba3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.prueba3.adapters.TabPAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabPAdapter tpa;
    private TabLayout tl;
    private ViewPager vp;
    private Button consejo;
    private Spinner spinner;
    private int trys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int i=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.spinner = findViewById(R.id.spiner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.itemSpinner,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        this.tl = findViewById(R.id.tabLayout);
        this.vp = findViewById(R.id.viewPager);
        this.tpa = new TabPAdapter(getSupportFragmentManager());
        this.vp.setAdapter(this.tpa);
        this.tl.setupWithViewPager(vp);
        this.consejo = findViewById(R.id.consejo);
        consejo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PersonajesFragment frag1 = new PersonajesFragment();
                frag1.onCreate(savedInstanceState);





            }
        });


        this.tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }
}
