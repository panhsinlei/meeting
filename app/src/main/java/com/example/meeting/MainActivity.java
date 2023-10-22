package com.example.meeting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.core.view.GravityCompat;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化 DrawerLayout 和 ActionBarDrawerToggle
        drawerLayout = findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);


        ImageButton sidebarLauncher = findViewById(R.id.sidebarLauncher);
        ImageButton homeButton = findViewById(R.id.homeButton);
        Button btnRecord = findViewById(R.id.btnRecord);
        Button btnUpload = findViewById(R.id.btnUpload);
        Button btnTranscribe = findViewById(R.id.btnTranscribe);
        Button btnSummarize = findViewById(R.id.btnSummarize);
        NavigationView navigationView = findViewById(R.id.navigationView);

        // 設置側邊欄的開關按鈕
        sidebarLauncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        // 設置 Home 按鈕的點擊事件
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 返回首頁的程式碼
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // 設置 ActionBarDrawerToggle
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 啟動RecordActivity
                Intent intent = new Intent(MainActivity.this, RecordActivity.class);
                startActivity(intent);
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 啟動UploadActivity
                Intent intent = new Intent(MainActivity.this, UploadActivity.class);
                startActivity(intent);
            }
        });

        btnTranscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 啟動TranscribeActivity
                Intent intent = new Intent(MainActivity.this, TranscribeActivity.class);
                startActivity(intent);
            }
        });

        btnSummarize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 啟動SummarizeActivity
                Intent intent = new Intent(MainActivity.this, SummarizeActivity.class);
                startActivity(intent);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // 根據選擇的菜單項目 ID 進行分支處理
                int itemId = item.getItemId();
                if (itemId == R.id.menu_record) {
                    // 點擊 "錄音" 按鈕，啟動 RecordActivity
                    Intent recordIntent = new Intent(MainActivity.this, RecordActivity.class);
                    startActivity(recordIntent);
                } else if (itemId == R.id.menu_upload) {
                    // 點擊 "上傳" 按鈕，啟動 UploadActivity
                    Intent uploadIntent = new Intent(MainActivity.this, UploadActivity.class);
                    startActivity(uploadIntent);
                } else if (itemId == R.id.menu_transcribe) {
                    // 點擊 "轉譯" 按鈕，啟動 TranscribeActivity
                    Intent transcribeIntent = new Intent(MainActivity.this, TranscribeActivity.class);
                    startActivity(transcribeIntent);
                } else if (itemId == R.id.menu_summarize) {
                    // 點擊 "摘要" 按鈕，啟動 SummarizeActivity
                    Intent summarizeIntent = new Intent(MainActivity.this, SummarizeActivity.class);
                    startActivity(summarizeIntent);
                }

                // 在處理完點擊後關閉側邊欄
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }

    // 確保在側邊欄打開時，按返回鍵會關閉側邊欄
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
