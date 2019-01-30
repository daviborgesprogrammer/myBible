package br.com.dcborges.mybible.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.dcborges.mybible.Controller.DBHelper;

public class DbGateway {
    private static DbGateway gw;
    private SQLiteDatabase db;

    private DbGateway(Context ctx,String dbName){
        DBHelper helper = new DBHelper(ctx,dbName);
        db = helper.getWritableDatabase();
    }

    public static DbGateway getInstance(Context ctx,String dbName){
        if(gw == null)
            gw = new DbGateway(ctx,dbName);
        return gw;
    }

    public SQLiteDatabase getDatabase(){
        return this.db;
    }
}
