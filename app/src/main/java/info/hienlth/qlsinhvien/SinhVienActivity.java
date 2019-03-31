package info.hienlth.qlsinhvien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class SinhVienActivity extends AppCompatActivity {

    Button btnThem;
    ImageButton btnClearAll;
    EditText txtMaSV, txtDiem, txtHoTen;
    ListView lvDSSinhVien;
    RadioButton rdNu;
    ArrayList<SinhVien> arrSinhVien = new ArrayList<SinhVien>();
    MyArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinh_vien);

        btnThem = (Button)findViewById(R.id.btnThem);
        btnClearAll = (ImageButton)findViewById(R.id.btnClearAll);
        lvDSSinhVien = (ListView)findViewById(R.id.lvDSSV);
        txtMaSV = (EditText)findViewById(R.id.txtvMaSV);
        txtDiem = (EditText)findViewById(R.id.txtvDiem);
        txtHoTen = (EditText)findViewById(R.id.txtvHoTen);
        rdNu = (RadioButton)findViewById(R.id.radNu);

        adapter = new MyArrayAdapter(
                this,
                R.layout.sinhvienlayout,
                arrSinhVien
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

                //reset Text
                txtMaSV.setText("");
                txtHoTen.setText("");
                txtDiem.setText("");
                txtMaSV.clearFocus();
            }
        });

        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ta nên đi ngược danh sách, kiểm tra phần tử nào checked
                //thì xóa đúng vị trí đó ra khỏi arrEmployee
                for(int i = lvDSSinhVien.getChildCount() - 1; i >=0; i--)
                {
                    //lấy ra dòng thứ i trong ListView
                    //Dòng thứ i sẽ có 3 phần tử: ImageView, LinerLayout, Checkbox
                    v = lvDSSinhVien.getChildAt(i);
                    //Ta chỉ lấy CheckBox ra kiểm tra
                    CheckBox chk = (CheckBox) v.findViewById(R.id.chkitem);
                    //Nếu nó Checked thì xóa ra khỏi arrEmployee
                    if(chk.isChecked())
                    {
                        //xóa phần tử thứ i ra khỏi danh sách
                        arrSinhVien.remove(i);
                    }
                }
                adapter.notifyDataSetChanged();

            }
        });
    }
}
