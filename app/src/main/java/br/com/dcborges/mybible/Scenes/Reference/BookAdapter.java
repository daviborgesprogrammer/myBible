package br.com.dcborges.mybible.Scenes.Reference;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import br.com.dcborges.mybible.R;
import br.com.dcborges.mybible.domain.Book;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{
    private Context context;
    private List<Book> bookList;
    private BookAdapterListener listener;

    public class BookViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public BookViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.name_book);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // send selected contact in callback
                    listener.onContactSelected(bookList.get(getAdapterPosition()));
                }
            });
        }
    }

    public  BookAdapter(Context context,List<Book> bookList,BookAdapterListener listener){
        this.context = context;
        this.bookList = bookList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_book_list,parent,false);
        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        final Book book = bookList.get(position);
        holder.name.setText(book.getName());
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public interface BookAdapterListener{
        void onContactSelected(Book book);
    }
}
