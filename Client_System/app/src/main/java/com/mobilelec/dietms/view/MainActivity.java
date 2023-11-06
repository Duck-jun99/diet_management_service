package com.mobilelec.dietms.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.widget.Button;

import com.mobilelec.dietms.adapter.ItemList;
import com.mobilelec.dietms.R;
import com.mobilelec.dietms.adapter.MyAdapter;
import com.mobilelec.dietms.viewmodel.DBViewModel;
import com.mobilelec.dietms.viewmodel.NetworkViewModel;

public class MainActivity extends AppCompatActivity {

    DBViewModel userViewModel;
    NetworkViewModel networkViewModel;
    RecyclerView rvUser;
    MyAdapter adapter;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeView();


        //OkHttp 통신을 위한 뷰모델
        networkViewModel = new ViewModelProvider(this).get(NetworkViewModel.class);

        networkViewModel.fetchDataFromApi(); // Trigger the API request


        MyAdapter.OnClickListener clickListener = new MyAdapter.OnClickListener() {
            @Override
            public void onClick(ItemList user) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("title", user.title);
                intent.putExtra("text", user.text);
                intent.putExtra("created_date", user.created_date);
                intent.putExtra("published_date", user.published_date);
                intent.putExtra("image", user.image);
                startActivity(intent);
            }
        };

        MyAdapter.OnLongClickListener longClickListener = new MyAdapter.OnLongClickListener() {
            @Override
            public void onLongClick(ItemList user) {
                /*showAlertDialog(user);*/
            }
        };

        adapter = new MyAdapter(clickListener, longClickListener);
        rvUser.setAdapter(adapter);
        rvUser.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rvUser.setHasFixedSize(true);



        networkViewModel.getResponseData().observe(this, itemList ->  {

            adapter.setUsers(itemList);
            //Log.e("TEST DATE",itemList.get(0).createdDate);

        });



        userViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(DBViewModel.class);

/*
        userViewModel.getAll().observe(this, new Observer<List<UserEntity>>() {
            @Override
            public void onChanged(List<UserEntity> userEntities) {
                adapter.setUsers(userEntities);
            }
        });
*/

    }

    void initializeView() {
        rvUser = findViewById(R.id.rvUser);
    }
/*
    void showAlertDialog(final ItemList user) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Delete")
                .setMessage("Do you want to delete user?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        userViewModel.delete(user);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();

        alertDialog.show();
    }
*/
}