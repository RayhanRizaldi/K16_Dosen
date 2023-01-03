package com.tbptb_b.k16_dosen;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.tbptb_b.k16_dosen.retrofit.LogoutResponse;
import com.tbptb_b.k16_dosen.retrofit.RetrofitClient;
import com.tbptb_b.k16_dosen.retrofit.StoryClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserProfile extends AppCompatActivity {

    private ImageView pict_dosen;
    private static final int PICK_IMAGE=1;
    String tokenboi, token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);



//        pict_dosen = (ImageView) findViewById(R.id.pict_dosen);
//        pict_dosen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent gallery = new Intent();
//                gallery.setType("image/*");
//                gallery.setAction(Intent.ACTION_GET_CONTENT);
//
//                startActivityForResult(Intent.createChooser(gallery, "Pilih Gambar"), PICK_IMAGE);
//            }
//        });

        Button button = findViewById(R.id.update_profile_button);
        pict_dosen = findViewById(R.id.pict_dosen);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetContent.launch("image/*");

            }
        });

        Button logout = findViewById(R.id.logout_bro);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StoryClient mainInterface = RetrofitClient.getService();
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.kelompok_15.tb_ptb.SHARED_KEY",MODE_PRIVATE);
                tokenboi = sharedPreferences.getString("token","");
                token = "SAMPAI JUMPA!!" + tokenboi;
                Toast.makeText(UserProfile.this, token, Toast.LENGTH_SHORT).show();

                Call<LogoutResponse> call = mainInterface.logout(token);
                call.enqueue(new Callback<LogoutResponse>() {
                    @Override
                    public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {

                        LogoutResponse logoutResponse = response.body();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("TOKEN");
                        editor.apply();
                        finish();
                        Toast.makeText(UserProfile.this, "LogOUT!! BYE", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UserProfile.this, LoginActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<LogoutResponse> call, Throwable t) {

                    }
                });

            }
        });
    }

    ActivityResultLauncher<String> mGetContent = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    if (result != null){
                        pict_dosen.setImageURI(result);
                    }
                }
            }
    );

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_gradient));
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}