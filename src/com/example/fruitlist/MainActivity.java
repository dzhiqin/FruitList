package com.example.fruitlist;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ArrayList<Fruit> fruitList=new ArrayList<Fruit>();
	private FruitAdapter fruitAdapter;
	private ListView myListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		myListView=(ListView)findViewById(R.id.fruit_list);
		fruitAdapter=new FruitAdapter(this,R.layout.myfruit_layout,getData());
		myListView.setAdapter(fruitAdapter);
		/*//´øÑ¡Ôñ¿òµÄListView
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,new String[]{"111","222","222","333"});	
		myListView.setAdapter(adapter);
		myListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
		*/
	
	myListView.setOnItemClickListener(new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Fruit item=(Fruit)parent.getItemAtPosition(position);
			String itemName=item.getName();
			Toast.makeText(MainActivity.this, itemName, Toast.LENGTH_SHORT).show();
			
		}
		
	});
	}


	private ArrayList<Fruit> getData() {
	//	fruitList=new ArrayList<Fruit>();
		fruitList.add(new Fruit("pear",R.drawable.pear));
		fruitList.add(new Fruit("pineapple",R.drawable.pineapple));
		fruitList.add(new Fruit("strawberry",R.drawable.strawberry));
		fruitList.add(new Fruit("watermelon",R.drawable.watermelon));
		return fruitList;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
