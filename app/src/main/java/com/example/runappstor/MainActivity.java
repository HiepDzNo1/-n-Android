package com.example.runappstor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.runappstor.Database.CreateDatabase;
import com.example.runappstor.Entity.ListStory;
import com.example.runappstor.Entity.Story;
import com.example.runappstor.EntityDao.ListStoryDao;
import com.example.runappstor.EntityDao.StoryDao;
import com.example.runappstor.RestfulAPI.CallAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
        //lớp dùng để test
    private CreateDatabase createDatabase;
    private ListStoryDao listStoryDao;
    private StoryDao storyDao;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tesst);
        // Tạo một đối tượng CreateDatabase từ cơ sở dữ liệu Room
        createDatabase = CreateDatabase.getInstance(MainActivity.this);
        listStoryDao = createDatabase.listStoryDao();
        storyDao = createDatabase.storyDao();



        // Gọi API và xử lý kết quả bằng cách truyền callback
        CallAPI apiCaller = new CallAPI();

//                apiCaller.CallListStory(new Callback<List<ListStory>>() {
//            @Override
//            public void onResponse(Call<List<ListStory>> call, Response<List<ListStory>> response) {
//                if (response.isSuccessful()) {
//                    List<ListStory> listStories = response.body();
//                    listStoryDao.insertAllStory(listStories);
//                    // Xử lý dữ liệu từ API ở đây
//                } else {
//                    // Xử lý lỗi khi yêu cầu không thành công
//                    int statusCode = response.code();
//                    String errorMessage = "Có lỗi xảy ra. Mã lỗi: " + statusCode;
//                    // Hiển thị thông báo lỗi cho người dùng hoặc ghi vào log
//                    Log.e("API Error", errorMessage);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<ListStory>> call, Throwable t) {
//                // Xử lý lỗi khi gửi yêu cầu đến server
//                Log.e("API Request", "Error sending request to server: " + t.getMessage());
//            }
//        });

        //goi Story
//        apiCaller.CallStory(new Callback<List<Story>>() {
//            @Override
//            public void onResponse(Call<List<Story>> callS, Response<List<Story>> responseS) {
//                if (responseS.isSuccessful()) {
//                    List<Story> infoStory = responseS.body();
//                    storyDao.insertAllInformationStory(infoStory);
//                    // Xử lý dữ liệu từ API ở đây
//                } else {
//                    // Xử lý lỗi khi yêu cầu không thành công
//                    int statusCode = responseS.code();
//                    String errorMessage = "Có lỗi xảy ra. Mã lỗi: " + statusCode;
//                    // Hiển thị thông báo lỗi cho người dùng hoặc ghi vào log
//                    Log.e("API Error", errorMessage);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Story>> callS, Throwable tS) {
//                // Xử lý lỗi khi gửi yêu cầu đến server
//                Log.e("API Request", "Error sending request to server: " + tS.getMessage());
//            }
//        });


    }


}





