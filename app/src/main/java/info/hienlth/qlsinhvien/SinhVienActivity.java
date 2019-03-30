package info.hienlth.qlsinhvien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class SinhVienActivity extends AppCompatActivity {

    Button btnThem;
    EditText txtMaSV, txtDiem, txtHoTen;
    ListView lvDSSinhVien;
    RadioButton rdNu;
    ArrayList<SinhVien> arrSinhVien = new ArrayList<SinhVien>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinh_vien);

        btnThem = (Button)findViewById(R.id.btnThem);
        lvDSSinhVien = (ListView)findViewById(R.id.lvDSSV);
        txtMaSV = (EditText)findViewById(R.id.txtvMaSV);
        txtDiem = (EditText)findViewById(R.id.txtvDiem);
        txtHoTen = (EditText)findViewById(R.id.txtvHoTen);
        rdNu = (RadioButton)findViewById(R.id.radNu);

        final  MyArrayAdapter adapter = new MyArrayAdapter(
                SinhVienActivity.this,
                arrSinhVien,
                R.layout.sinhvienlayout
        );
        lvDSSinhVien.setAdapter(adapter);
        //Thêm sự kiện click button Thêm
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Kiểm tra nhập liệu
                if((txtMaSV.getText().length() == 0) ||
                        (txtHoTen.getText().length() == 0) ||
                        (txtDiem.getText().length() == 0))
                {
                    Toast.makeText(SinhVienActivity.this, "Dữ liệu không hợp lệ", Toast.LENGTH_SHORT).show();
                    return;//kết thúc sự kiện
                }
                //Tạo mới
                SinhVien sv = new SinhVien();
                sv.setMaSV(txtMaSV.getText().toString());
                sv.setHoTen(txtHoTen.getText() + "");
                sv.setDiem(Double.parseDouble(txtDiem.getText().toString()));
                sv.setGioiTinh(rdNu.isChecked());
                Log.i("SV", sv.toString());
                //Thêm vào mảng
                arrSinhVien.add(sv);
                //cập nhật listview
                adapter.notifyDataSetChanged();
            }
        });
    }
}
