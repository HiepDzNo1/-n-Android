package com.example.runappstor;

import static java.security.AccessController.getContext;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.runappstor.Database.CreateDatabase;
import com.example.runappstor.Database.LocalDateConverter;
import com.example.runappstor.Entity.User;
import com.example.runappstor.EntityDao.StoryDao;
import com.example.runappstor.EntityDao.UserDao;

import java.time.LocalDate;

public class RegisterActivity extends AppCompatActivity {
    private ImageView imageViewAvatar;
    private Button buttonChooseAvatar, buttonBackLogin;
    private EditText editTextAccount;
    private EditText editTextPassword;
    private RadioGroup radioGroupGender;
    private DatePicker datePickerBirthday;
    private Button buttonSaveProfile;

    private CreateDatabase createDatabase;

    // Khai báo ActivityResultLauncher và Uri cho hình ảnh đã chọn
    private ActivityResultLauncher<String> imagePickerLauncher;
    private Uri selectedImageUri;
    private ImageView ImageViewAvatar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        createDatabase = CreateDatabase.getInstance(this);

        // Ánh xạ các thành phần trong layout
        imageViewAvatar = findViewById(R.id.imageViewAvatar);
        buttonChooseAvatar = findViewById(R.id.buttonChooseAvatar);
        editTextAccount = findViewById(R.id.editTextAccount);
        editTextPassword = findViewById(R.id.editTextPassword);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        datePickerBirthday = findViewById(R.id.datePickerBirthday);
        buttonSaveProfile = findViewById(R.id.buttonSaveProfile);
        buttonBackLogin = findViewById(R.id.buttonBackToLogin);

        // Khởi tạo ActivityResultLauncher
        imagePickerLauncher = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        if (result != null) {
                            selectedImageUri = result;
                            // TODO: Xử lý tải lên hình ảnh avatar từ selectedImageUri
                            ImageView imageViewAvatar = findViewById(R.id.imageViewAvatar);

                            RequestOptions requestOptions = new RequestOptions()
                                    .diskCacheStrategy(DiskCacheStrategy.NONE);

                            Glide.with(RegisterActivity.this)
                                    .load(selectedImageUri)
                                    .apply(requestOptions)
                                    .into(imageViewAvatar);

                            Toast.makeText(RegisterActivity.this, "Image selected successfully", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        // Khởi tạo cơ sở dữ liệu Room

        buttonChooseAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Gọi launcher để mở trình chọn hình ảnh
                imagePickerLauncher.launch("image/*");
            }
        });

        buttonBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // Xử lý sự kiện khi nhấn nút "Save Profile"
        buttonSaveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ các trường nhập liệu
                String account = editTextAccount.getText().toString();
                String password = editTextPassword.getText().toString();
                int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
                RadioButton selectedGenderRadioButton = findViewById(selectedGenderId);
                String gender = selectedGenderRadioButton.getText().toString();

                int year = datePickerBirthday.getYear();
                int month = datePickerBirthday.getMonth();
                int day = datePickerBirthday.getDayOfMonth();

                // Chuyển đổi từ DatePicker thành LocalDate
                LocalDate localDate = LocalDate.of(year, month + 1, day);

                // Chuyển đổi LocalDate thành chuỗi đúng định dạng
                String birthday = LocalDateConverter.fromLocalDate(localDate);


                // Tạo một đối tượng User từ dữ liệu nhập vào
                User user = new User();
                user.setAccount(account);
                user.setPassword(Integer.parseInt(password));
                user.setSex(gender.equals("Male")); // Assuming "Male" and "Female" are the options in the radio group
                user.setBirthday(LocalDate.parse(birthday));

                // Thêm dữ liệu người dùng vào cơ sở dữ liệu
                insertUser(user);

                // Hiển thị thông báo đăng ký thành công
                String message = "Registered account: " + account +
                        "\nGender: " + gender + "\nBirthday: " + day + "/" + (month + 1) + "/" + year;
                Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                // Chuyển sang LoginActivity
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }


    private void insertUser(User user) {
        // Thực hiện thêm dữ liệu người dùng vào cơ sở dữ liệu
        new Thread(new Runnable() {
            @Override
            public void run() {
                createDatabase.userDao().insertAllUser(user);
            }
        }).start();
    }
}