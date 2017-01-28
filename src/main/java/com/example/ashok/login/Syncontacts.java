package com.example.ashok.login;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.view.View;
public class Syncontacts extends AppCompatActivity
{
    ListView lv;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syncontacts);

        lv = (ListView) findViewById(R.id.listView);
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null, null, null, null);
        String[] fr ={ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER,ContactsContract.CommonDataKinds.Phone._ID};
        int [] to={android.R.id.text1,android.R.id.text2};
        SimpleCursorAdapter listadapter=new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,cur,fr,to);
        lv.setAdapter(listadapter);
    }
   // public void onItemClick(AdapterView<?> parent, View view, int position, long id)
   // {
       // Intent i=new Intent(this,Secondactivity.class);
        //Toast.makeText(this,"Selected",Toast.LENGTH_LONG).show();
        //startActivity(i);
    //}
}