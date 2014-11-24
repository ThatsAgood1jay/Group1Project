package com.example.williamjm.group1project;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.StackView;

import java.util.ArrayList;


/**
 * Created by user on 11/12/14.
 */
public class SocialMediaPage extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social_media_page);

        String[] country = {"Nav Menu", "About Team Blaze", "Blog", "Upcoming Events", "Home"};
        ArrayAdapter<String> stringArrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, country);

        Spinner spinny = (Spinner) findViewById(R.id.NavMenu);
        spinny.setAdapter(stringArrayAdapter);

        AdapterView.OnItemSelectedListener onSpinner =
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (parent.getSelectedItem().toString().contains("About Team Blaze")) {
                            Intent i = new Intent(parent.getContext(), AboutUsPage.class);
                            startActivity(i);
                        } else if (parent.getSelectedItem().toString().contains("Blog")) {
                            Intent i = new Intent(parent.getContext(), BlogPage.class);
                            startActivity(i);
                        } else if (parent.getSelectedItem().toString().contains("Upcoming Events")) {
                            Intent i = new Intent(parent.getContext(), CalendarPage.class);
                            startActivity(i);
                        } else if (parent.getSelectedItem().toString().contains("Home")) {
                            Intent i = new Intent(parent.getContext(), MyActivity.class);
                            startActivity(i);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        return;
                    }
                };

        spinny.setOnItemSelectedListener(onSpinner);

        StackView stk = (StackView) this.findViewById(R.id.stackView1);

        final ArrayList<StackItem> items = new ArrayList<StackItem>();
        //remember to make drawables for this!
        items.add(new StackItem("Twitch.tv", this.getResources().getDrawable(R.drawable.twitch)));
        items.add(new StackItem(" ", null));

        items.add(new StackItem("Youtube", this.getResources().getDrawable(R.drawable.youtube)));
        items.add(new StackItem(" ", null));

        items.add(new StackItem("Facebook", this.getResources().getDrawable(R.drawable.facebook)));
        items.add(new StackItem(" ", null));

        items.add(new StackItem("CSL Standings", this.getResources().getDrawable(R.drawable.cslbanner)));
        items.add(new StackItem(" ", null));

        items.add(new StackItem("Home Site", this.getResources().getDrawable(R.drawable.bg)));

        StackAdapter adapt = new StackAdapter(this, R.layout.item, items);
        stk.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                Log.d("inside on item", "click listener");


                if (a.getSelectedItem().toString().contains("Facebook")) {

                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groups/utarlingtonsc2/?fref=ts"));
                    startActivity(i);
                }

            }
        });


        stk.setAdapter(adapt);
        stk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               Log.d("inside method","in on item selected");

                if (parent.getSelectedItem().toString().contains("Facebook")) {

                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groups/utarlingtonsc2/?fref=ts"));
                    startActivity(i);
                }

            /*    else if (parent.getSelectedItem().toString().contains("Twitch.tv")) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://http://www.twitch.tv/shadow_smile"));
                    startActivity(i);
                }

                else if (parent.getSelectedItem().toString().contains("Youtube")) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groups/utarlingtonsc2/?fref=ts"));
                    startActivity(i);
                }

                else if (parent.getSelectedItem().toString().contains("CSL Standings")) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cstarleague.com/lol/standings/1"));
                    startActivity(i);
                }

                else if (parent.getSelectedItem().toString().contains("Home Site")) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mavorgs.collegiatelink.net/organization/esports"));
                    startActivity(i);
                }*/
            }
            @Override
            public void onNothingSelected(AdapterView parent) {
                //Do Stuff
            }
        });
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


