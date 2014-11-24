package com.example.williamjm.group1project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        String[] pages={"Nav Menu","About Team Blaze", "Blog", "Upcoming Events", "Social Media"};
        ArrayAdapter<String> stringArrayAdapter=
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, pages);

        Spinner spinny = (Spinner)  findViewById(R.id.NavMenu);
        spinny.setAdapter(stringArrayAdapter);

        AdapterView.OnItemSelectedListener onSpinner =
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent,View view,int position,long id)
                    {
                        if (parent.getSelectedItem().toString().contains("About Team Blaze"))
                        {
                            Intent i = new Intent(parent.getContext(), AboutUsPage.class);
                            startActivity(i);
                        }
                        else if(parent.getSelectedItem().toString().contains("Blog"))
                        {
                            Intent i = new Intent(parent.getContext(), BlogPage.class);
                            startActivity(i);
                        }
                        else if(parent.getSelectedItem().toString().contains("Upcoming Events"))
                        {
                            Intent i = new Intent(parent.getContext(), CalendarPage.class);
                            startActivity(i);
                        }
                        else if(parent.getSelectedItem().toString().contains("Social Media"))
                        {
                            Intent i = new Intent(parent.getContext(), SocialMediaPage.class);
                            startActivity(i);
                        }
                    }
                    @Override
                    public void onNothingSelected( AdapterView<?>  parent)
                    {
                        return;
                    }
                };
        spinny.setOnItemSelectedListener(onSpinner);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
