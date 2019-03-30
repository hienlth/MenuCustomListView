package info.hienlth.qlsinhvien;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter {
    Activity context = null;
    ArrayList<SinhVien> myArray = null;
    int layoutId;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        /*Mapping 1 item trong mảng myArray vào layout
        * nói cách khác: Hiển thị tên, điểm, mã số đúng chỗ trong layout*/

        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);

        if(myArray.size() > 0 && position >= 0) {
            //lấy sv đang chọn
            final SinhVien sv = myArray.get(position);

            //kiếm và map các control trong layout con
            ImageView ivHinh = (ImageView)convertView.findViewById(R.id.imgitem);
            TextView txtHoTen = (TextView)convertView.findViewById(R.id.txtHoTen);
            TextView txtDiem = (TextView)convertView.findViewById(R.id.txtDiem);

            //gán giá trị
            txtHoTen.setText(sv.getHoTen() + " =" + sv.getMaSV());
            txtDiem.setText(sv.getDiem() + "(" + sv.XepLoai() + ")");
//            if(sv.isGioiTinh())
//            {
//                ivHinh.setImageResource(R.drawable.icon_male);
//            }
//            else
//                ivHinh.setImageResource(R.drawable.icon_female);
        }

        return convertView;
    }

    public MyArrayAdapter(Activity context, ArrayList<SinhVien> myArray, int layoutId) {
        super(context, layoutId, myArray);
        this.context = context;
        this.myArray = myArray;
        this.layoutId = layoutId;
    }
}
