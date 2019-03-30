package info.hienlth.qlsinhvien;

public class SinhVien {
    private String MaSV;
    private String HoTen;
    private double Diem;
    private boolean GioiTinh;

    public void setMaSV(String maSV) {
        MaSV = maSV;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public void setDiem(double diem) {
        Diem = diem;
    }

    public void setGioiTinh(boolean gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getMaSV() {
        return MaSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public double getDiem() {
        return Diem;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public String XepLoai()
    {
        if(Diem < 4) return "D";
        if(Diem < 5.5) return "C";
        if(Diem < 7.8) return "B";//3
        if(Diem < 8.5) return "B+";//3.5
        return "A";//4
    }
    @Override
    public String toString() {
        return "SinhVien{" +
                "MaSV='" + MaSV + '\'' +
                ", HoTen='" + HoTen + '\'' +
                ", Diem=" + Diem +
                ", GioiTinh=" + GioiTinh +
                '}';
    }

    public SinhVien(){

    }

    public SinhVien(String maSV, String hoTen, double diem, boolean gioiTinh) {
        MaSV = maSV;
        HoTen = hoTen;
        Diem = diem;
        GioiTinh = gioiTinh;
    }
}
