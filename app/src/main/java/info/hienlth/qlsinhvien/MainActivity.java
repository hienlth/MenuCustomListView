package info.hienlth.qlsinhvien;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnPopUp, btnContextMenu;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //load menu
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mnuQLSV:
                Intent it = new Intent(MainActivity.this, SinhVienActivity.class);
                startActivity(it);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.itemRed:
                btnContextMenu.setBackgroundColor(
                        getResources().getColor(R.color.clrRed));
                break;
            case R.id.itemBlue:
                btnContextMenu.setBackgroundColor(
                        getResources().getColor(R.color.clrBlue));
                break;
            case R.id.itemGreen:
                btnContextMenu.setBackgroundColor(
                        getResources().getColor(R.color.clrGreen));
                break;
            case R.id.itemMagenta:
                btnContextMenu.setBackgroundColor(
                        getResources().getColor(R.color.clrMagenta));
                break;
            case R.id.itemYellow:
                btnContextMenu.setBackgroundColor(
                        getResources().getColor(R.color.clrYellow));
                break;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.my_context_menu, menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPopUp = (Button)findViewById(R.id.btnPopUpMenu);

        btnPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Tạo popup menu
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,v);
                popupMenu.inflate(R.menu.mnupopup);
                //gắn sự kiện cho menu popup
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(MainActivity.this,
                                "Vừa chọn: " + menuItem.getTitle(),
                                Toast.LENGTH_LONG).show();
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

        btnContextMenu = (Button)findViewById(R.id.btnContextMenu);
        //đăng ký menu ngữ cảnh cho view
        registerForContextMenu(btnContextMenu);
    }
}
