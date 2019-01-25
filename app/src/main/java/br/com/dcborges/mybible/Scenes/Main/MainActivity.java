package br.com.dcborges.mybible.Scenes.Main;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import br.com.dcborges.mybible.R;
import br.com.dcborges.mybible.Scenes.Reference.ReferenceActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout layoutBookSelect;
    TextView bookSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        layoutBookSelect = findViewById(R.id.layout_book_select);
        bookSelect = findViewById(R.id.book_select);

        layoutBookSelect.setOnClickListener(this);
        setSupportActionBar(toolbar);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.sizeText:{
                Toast.makeText(this, "Text Size", Toast.LENGTH_SHORT)
                        .show();
                break;
            }
            case R.id.search:{
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT)
                        .show();
                break;
            }
            default:
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== layoutBookSelect.getId()){
            Intent intent = new Intent(getBaseContext(),ReferenceActivity.class);
            intent.putExtra("reference",bookSelect.getText().toString());
            startActivityForResult(intent,1234);
        }
    }
}
