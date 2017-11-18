package com.thereza.retrofit2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thereza.retrofit2.model.User;
import com.thereza.retrofit2.service.UserClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText name,email,address,phoneNo,password;
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= (EditText) findViewById(R.id.input_name);
        email= (EditText) findViewById(R.id.input_email);
        address= (EditText) findViewById(R.id.input_address);
        phoneNo= (EditText) findViewById(R.id.input_mobile);
        password= (EditText) findViewById(R.id.input_password);

        loginBtn= (Button) findViewById(R.id.btn_signup);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user=new User(
                        name.getText().toString(),
                        email.getText().toString(),
                        address.getText().toString(),
                        phoneNo.getText().toString(),
                        password.getText().toString()
                );

                createAccount(user);
            }
        });

    }

    public void createAccount(User user){
        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl("http://localhost:8080/api")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit= builder.build();

        UserClient client = retrofit.create(UserClient.class);
        Call<User> call= client.createAccount(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(getApplicationContext(),"Yeah!! User Created! User ID: "+response.body(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
