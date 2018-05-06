package com.guinproductions.seatingplanner.activities;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.guinproductions.seatingplanner.R;
import com.guinproductions.seatingplanner.adapters.NameListAdapter;
import com.guinproductions.seatingplanner.database.DbPresenter;
import com.guinproductions.seatingplanner.database.DbView;
import com.guinproductions.seatingplanner.models.Name;

import java.util.ArrayList;
import java.util.List;

import static com.guinproductions.seatingplanner.database.DbPresenter.Name.SERVER_NAME;
import static com.guinproductions.seatingplanner.database.DbPresenter.Name.TABLE_NAME;


public class NameLstActivity extends AppCompatActivity {

    public static final String TAG = "NameLstActivity";
    DbView dbView;
//    private ActivityNameLstBinding bindingMain;

    private RecyclerView rvListName;
    private RecyclerView.LayoutManager nameLayoutManger;
    private RecyclerView.Adapter adapter;
    private List<Name> nameListModel;
    private FloatingActionButton fabAddName, fabShowNames;
    private TextView tvNameInput;
    EditText addNameEditText;
    Button saveNameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setContentView(R.layout.activity_name_lst);

        rvListName = findViewById(R.id.nameListRV);
        rvListName.setHasFixedSize(true);
        rvListName.setLayoutManager(new LinearLayoutManager(this));
        rvListName.setAdapter(adapter);

        nameListModel = new ArrayList<>();
        dbView = new DbView(getApplicationContext());

        tvNameInput = findViewById(R.id.nameEditText);
        fabAddName = findViewById(R.id.addNameFab);

        fabShowNames = findViewById(R.id.showNameListFAB);
        fabAddName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToDB();
            }
        });

        fabShowNames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readNameFromDB();
            }
        });
    }

    private void saveToDB() {
        SQLiteDatabase database = new DbView(this).getWritableDatabase();
        ContentValues values = new ContentValues();

        if (tvNameInput.getText().toString().isEmpty()) {
            tvNameInput.setError("Entry Cannot Be Empty");
        } else {
            values.put(SERVER_NAME, tvNameInput.getText().toString());
            String serverName = tvNameInput.getText().toString();
            tvNameInput.setText(" ");

            database.insert(TABLE_NAME, null, values);

            Toast.makeText(this, serverName + " has been add ", Toast.LENGTH_LONG).show();
        }
    }


    private void readNameFromDB() {
        String serverName = tvNameInput.getText().toString();
        SQLiteDatabase database = new DbView(this).getReadableDatabase();


        String[] projection = {
                DbPresenter.Name._ID,
                SERVER_NAME
        };

        String selection =
                SERVER_NAME + "  like ?";

        String[] selectionArgs = {"%" + serverName + "%"};

        Cursor cursor = database.query(
                TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        rvListName.setAdapter(new NameListAdapter(getApplicationContext(), cursor));

    }


    /**
     * Dialog Add New Name
     **/
    private void addNameDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setTitle("Enter Server Name");
        dialog.setContentView(R.layout.dialog_add_server_name);

        /** Initialize DIALOG Views **/
        addNameEditText = dialog.findViewById(R.id.edit_text_add_name);
        saveNameButton = dialog.findViewById(R.id.button_add_name);

        /**Sets onCLICK Save Btn OnClick**/
        saveNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name;
                name = addNameEditText.getText().toString().trim();
                DbView dbView = new DbView(NameLstActivity.this);
                dbView.insertName();
                Intent intent = new Intent(getApplicationContext(), NameLstActivity.class);
                startActivity(intent);


                Toast.makeText(getApplicationContext(), "New Name Added", Toast.LENGTH_LONG).show();
            }
        });

        dialog.show();
    }

    /** Loading
     * dummy data

     private void loadNameRV() {

     for (int i = 1; i <=5; i++){
     String name = "Kimmy";
     Name nameList = new Name();
     nameListModel.add(nameList);
     }
     try {
     adapter = new NameListAdapter(nameListModel, this);
     } catch (IllegalAccessException e) {
     e.printStackTrace();
     }
     rvListName.setAdapter(adapter);
     } */
}