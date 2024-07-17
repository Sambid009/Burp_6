package com.earth.burp6;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button button_AlertDialog, button_CustomDialog, btn_positive, btn_negative, button_PopUpMenu, button_ContextMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button_AlertDialog = findViewById(R.id.button_AlertDialog);

        button_AlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                AlertDialog alertDialog = builder.create();
                builder.setTitle("Are you sure");
                builder.setMessage("Do you really want to continue? enter ok or press continue");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Yes is cicked", Toast.LENGTH_SHORT).show();

                        dialog.cancel();


                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "No is cicked", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                    }
                });

                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(MainActivity.this, "Cancel is cicked", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                builder.show();

            }
        });

        //-------------------------------Custom Dialog-----------------------
        button_CustomDialog = findViewById(R.id.button_CustomDialog);

        button_CustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);

                dialog.setContentView(R.layout.custom_alert_dialog_layout);

                btn_positive = dialog.findViewById(R.id.btnPositive);
                btn_negative = dialog.findViewById(R.id.btnNegative);

                btn_positive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Ok Button Clicked", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                btn_negative.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Cancel Button Clicked", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                //dialog.setCancelable(false);
                dialog.show();

            }
        });

        //------------------------------------PopupMenu-----------------------

        button_PopUpMenu = findViewById(R.id.button_PopUpMenu);

        button_PopUpMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, button_PopUpMenu);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menue, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.menu_one) {
                            Toast.makeText(MainActivity.this, "Menue1 Selected", Toast.LENGTH_SHORT).show();
                        }
                        if (id == R.id.menu_two) {
                            Toast.makeText(MainActivity.this, "Menue2 Selected", Toast.LENGTH_SHORT).show();
                        }
                        if (id == R.id.menu_three) {
                            Toast.makeText(MainActivity.this, "Menue3 Selected", Toast.LENGTH_SHORT).show();
                        }

                        // Toast.makeText(PopupMenuBar.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        //-----------------------------------ContextMenue------------------------

        button_ContextMenu = findViewById(R.id.button_ContextMenu);

        button_ContextMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start ListViewActivity
                Intent sambid = new Intent(MainActivity.this, ContextViewMenuBar.class);
                startActivity(sambid);
            }
        });


    }
}