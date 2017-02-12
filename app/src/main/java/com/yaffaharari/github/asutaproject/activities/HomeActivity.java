package com.yaffaharari.github.asutaproject.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;
import com.yaffaharari.github.asutaproject.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "HomeActivity";

    String[] SPINNER_LIST1 = {"מרפאות חוץ", "כירורגית", "פנימית"};
    String[] SPINNER_LIST2 = {"רופא", "סיעוד","כח עזר", "ע'ס", "דיאטנית"};
    String[] SPINNER_LIST3 = {"סימנים חיוניים", "אומדנים", "קבלה סיעודית"};

    private Button okBtn;
    private Toolbar toolbar;
    private MaterialBetterSpinner spinner1, spinner2, spinner3;
    private ArrayAdapter<String> arrayAdapter1, arrayAdapter2, arrayAdapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        arrayAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNER_LIST1);
        spinner1 = (MaterialBetterSpinner)
                findViewById(R.id.question1);
        spinner1.setAdapter(arrayAdapter1);


        arrayAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNER_LIST2);
        spinner2 = (MaterialBetterSpinner)
                findViewById(R.id.question2);
        spinner2.setAdapter(arrayAdapter2);

        arrayAdapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNER_LIST3);
        spinner3 = (MaterialBetterSpinner)
                findViewById(R.id.question3);
        spinner3.setAdapter(arrayAdapter3);

        okBtn = (Button)findViewById(R.id.btn_ok);
        okBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String strItemSelected1 = spinner1.getText().toString();
        String strItemSelected2 = spinner2.getText().toString();
        String strItemSelected3 = spinner3.getText().toString();

        Log.w(TAG, strItemSelected1 + " " + strItemSelected2 + " " + strItemSelected3);
        if(strItemSelected1.equals("פנימית") && strItemSelected2.equals("סיעוד")&& strItemSelected3.equals("קבלה סיעודית")){
            Intent intent = new Intent(this, ProcessActivity.class);
            startActivity(intent);
        }else{
           Toast.makeText(this, "erroe, please check your selections", Toast.LENGTH_LONG).show();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       // int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
       //     return true;
      //  }

       return super.onOptionsItemSelected(item);
    }
}
