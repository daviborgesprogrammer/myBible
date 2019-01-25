package br.com.dcborges.mybible.Scenes.Reference;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import br.com.dcborges.mybible.R;
import br.com.dcborges.mybible.Scenes.Reference.BooksFragment;
import br.com.dcborges.mybible.Scenes.Reference.ChaptersFragment;
import br.com.dcborges.mybible.Scenes.Reference.VersesFragment;
import br.com.dcborges.mybible.TabAdapter;

public class ReferenceActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initElements();
        initEvents();
    }

    private void initEvents() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initElements() {
        setContentView(R.layout.activity_reference);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        adapter.add(new BooksFragment(), "Livros");
        adapter.add(new ChaptersFragment(), "Capítulos");
        adapter.add(new VersesFragment(), "Versículos");


        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        tabLayout = findViewById(R.id.tabsReferenceSelect);
        tabLayout.setupWithViewPager(viewPager);
    }
}
