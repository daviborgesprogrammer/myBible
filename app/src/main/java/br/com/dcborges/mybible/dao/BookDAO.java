package br.com.dcborges.mybible.dao;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.dcborges.mybible.domain.Book;

public class BookDAO {
    private final String TABLE_BOOK = "books";
    private DbGateway gw;

    public BookDAO(Context ctx,String dbName){
        gw = DbGateway.getInstance(ctx,dbName);
    }

    public List<Book> selectBooksName(){
        List<Book> books = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM "+ TABLE_BOOK,null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String abbrev = cursor.getString(cursor.getColumnIndex("abbrev"));
            String testament = cursor.getString(cursor.getColumnIndex("testament"));
            books.add(new Book(id,name,abbrev,testament));
        }
        cursor.close();
        return books;
    }
}
