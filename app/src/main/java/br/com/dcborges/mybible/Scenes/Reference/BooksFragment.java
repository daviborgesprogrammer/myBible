package br.com.dcborges.mybible.Scenes.Reference;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.dcborges.mybible.R;
import br.com.dcborges.mybible.dao.BookDAO;
import br.com.dcborges.mybible.domain.Book;

public class BooksFragment extends Fragment implements BookAdapter.BookAdapterListener{
    private RecyclerView recyclerView;
    private List<Book> bookShelf;
    private BookAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.books_fragment, container, false);

//        TextView tv = view.findViewById(R.id.text1);
//        tv.setText("Books");

        recyclerView = view.findViewById(R.id.book_list);

        bookShelf = new ArrayList<Book>();
        mAdapter = new BookAdapter(getActivity(), bookShelf, this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        fetchBooks();

        return view;
    }

    private void fetchBooks() {
        bookShelf.clear();
        bookShelf.addAll(getBookFromDb());
        mAdapter.notifyDataSetChanged();
    }

    public List<Book> getBookFromDb() {
        BookDAO dao = new BookDAO(getActivity(),"nvi.db");
        List<Book> books = dao.selectBooksName();
//        for(Book b :books){
//            Log.d("_TESTE_",b.getName());
//        }
        return books;
    }

    @Override
    public void onContactSelected(Book book) {

    }


}
