package com.example.mywebtoon;

import static java.sql.DriverManager.println;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Comment1Activity extends AppCompatActivity {

    myDBhelper h = new myDBhelper(this);
    EditText etComm, etRes; Button btnIn, btnDel; SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.comment1);

        etComm = (EditText) findViewById(R.id.etComm);
        etRes = (EditText) findViewById(R.id.etRes);
        btnIn = (Button) findViewById(R.id.btnIn);
        btnDel = (Button) findViewById(R.id.btnDel);

        //입력 버튼
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = h.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO commentTBL VALUES ('"
                            + etComm.getText().toString() + "');");
                sqlDB.close();


                sqlDB = h.getReadableDatabase();
                Cursor c;
                c = sqlDB.rawQuery("SELECT * FROM commentTBL;", null);

                String str = "________________________________________" + "\r\n";
                while (c.moveToNext())
                    str += c.getString(0) + "\r\n";

                etRes.setText(str);

                c.close(); sqlDB.close();
            }
        });

        //삭제 버튼
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = h.getWritableDatabase();

                if(etComm.getText().toString() != "") {
                    sqlDB.execSQL("DELETE FROM commentTBL WHERE comments ='"
                            + etComm.getText().toString() + "';");
                } sqlDB.close();

                Toast.makeText(getApplicationContext(),
                        "삭제됨", Toast.LENGTH_SHORT).show();

                sqlDB = h.getReadableDatabase();
                Cursor c;
                c = sqlDB.rawQuery("SELECT * FROM commentTBL;", null);

                String str = "________________________________________" + "\r\n";
                while (c.moveToNext())
                    str += c.getString(0) + "\r\n";

                etRes.setText(str);

                c.close(); sqlDB.close();
            }
        });

    }

    //myDBhelper 클래스
    public class myDBhelper extends SQLiteOpenHelper {
        public myDBhelper (Context context) {
            super(context, "toonDB", null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE commentTBL (comments CHAR(100) PRIMARY KEY);");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
            db.execSQL("DROP TABLE IF EXISTS commentTBL");
            onCreate(db);
        }
    }
}
