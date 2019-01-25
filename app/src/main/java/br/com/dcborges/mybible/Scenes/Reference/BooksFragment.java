package br.com.dcborges.mybible.Scenes.Reference;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.dcborges.mybible.R;

public class BooksFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.books_fragment, container, false);

        TextView tv = view.findViewById(R.id.text1);
        tv.setText("Books");

        return view;
    }
}
