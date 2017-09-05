package com.example.lenovo.fetchgrouplistwithimage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "http://nimbyisttechnologies.com/jaskirat/ci/p&p/";
    private static Retrofit retrofit = null;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    public ArrayList<FetchGroupList> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();

    }
    public void getData()
    {
        recyclerView = (RecyclerView) findViewById(R.id.first_recycler_view);
        DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
       // divider.setDrawable(ContextCompat.getDrawable(getBaseContext(), R.drawable.shape));
        recyclerView.addItemDecoration(divider);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadData();
    }
    public void loadData()
    {
        HashMap<String, String> map = new HashMap<>();
        map.put("user_id", "38");
        Call<MyPojo> call = getClient().fetchGroupList(map);

        call.enqueue(new Callback<MyPojo>() {
            @Override
            public void onResponse(Call<MyPojo> call, Response<MyPojo> response) {

                MyPojo obj=response.body();

                data=new ArrayList(obj.getFetch_group_list());
                adapter=new MyAdapter(data);
                recyclerView.setAdapter(adapter);
               // Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<MyPojo> call, Throwable t) {

            }
        });
//
//        GetXMLTask task = new GetXMLTask();
//        task.execute(URL);
    }

    public static MyApi getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        MyApi apiService =
                retrofit.create(MyApi.class);
        return apiService;
    }
    }

