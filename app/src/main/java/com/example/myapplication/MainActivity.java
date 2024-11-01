package com.example.myapplication;

import static android.app.ProgressDialog.show;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final AlertDialog.Builder dialog=new AlertDialog.Builder( MainActivity.this);
                dialog.setTitle("請選擇功能");
                dialog.setMessage("請根據下方按鈕選擇要顯示的物件");

                dialog.setNeutralButton("取消", new  DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        Toast.makeText (MainActivity.this,  "dialog", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setNegativeButton("自定Toast", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {

                        showToast();
                    }
                });
                dialog.setPositiveButton("顯示list", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        showListDialog();
                    }
                });
                dialog.show();
            }
        });
    }
    private void showToast(){
        Toast toast =new Toast(MainActivity.this);
        toast.setGravity (Gravity.TOP,  0,  50);
        toast.setDuration(Toast.LENGTH_SHORT);
        LayoutInflater inflater=getLayoutInflater();
        View layout= inflater.inflate(R.layout.custom_toast
                ,(ViewGroup)findViewById(R.id.custom_toast_root));
        toast.setView(layout);
        toast.show();
    }
    private void showListDialog()
    {
        final String[] list = {"messsagel", "messsage2", "messsage3", "messsage4", "messsage5"};
        AlertDialog.Builder dialog_list = new AlertDialog.Builder(MainActivity.this);
        dialog_list.setTitle("使用LIST呈現");
        dialog_list.setItems(list, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText( MainActivity.this
                ,"你選得是"+list [1], Toast.LENGTH_SHORT).show();
            }
        });
        dialog_list.show();
    }


}


