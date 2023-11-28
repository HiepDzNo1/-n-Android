package com.example.runappstor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.runappstor.Database.CreateDatabase;
import com.example.runappstor.Entity.User;
import com.example.runappstor.EntityDao.UserDao;

public class LoginActivity extends AppCompatActivity {
    private CreateDatabase createDatabase;
    private Button buttonLogin, buttonSignUp;
    private EditText editTextAccount, editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        createDatabase = CreateDatabase.getInstance(this);

        buttonLogin = findViewById(R.id.buttonLogin);
        editTextAccount = findViewById(R.id.editTextAccout);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy mã tài khoản và mật khẩu từ trường nhập liệu
                String account = editTextAccount.getText().toString();
                String password = editTextPassword.getText().toString();

                // Thực hiện kiểm tra đăng nhập
                if (checkLogin(account, password)) {
                    // Đăng nhập thành công
                    // Chuyển sang InterfaceActivity và truyền dữ liệu mã tài khoản
                    int userId = getUserIdByAccountAndPassword(account, password);
                    Intent intent = new Intent(LoginActivity.this, InterfaceActivity.class);
                    intent.putExtra("userId", userId);
                    startActivity(intent);
                } else {
                    // Đăng nhập không thành công
                    Toast.makeText(LoginActivity.this, "Invalid account or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang SignUpActivity để đăng ký tài khoản mới
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean checkLogin(String account, String password) {
        // Thực hiện truy vấn dữ liệu từ cơ sở dữ liệu sử dụng Room DAO
        UserDao userDao = createDatabase.userDao();
        userDao.getUserByAccountAndPassword(account, password);

        return true;
    }

    private int getUserIdByAccountAndPassword(String account, String password) {
        // Thực hiện truy vấn dữ liệu từ cơ sở dữ liệu sử dụng Room DAO
        UserDao userDao = createDatabase.userDao();
        return userDao.getIdUserByAccountAndPassword(account, password);
    }
}