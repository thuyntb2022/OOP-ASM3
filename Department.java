
//Lớp Department bao gồm các thành phần cơ bản của đối tượng bộ phận
public class Department {
    private String tenBoPhan;
    private int maBoPhan;
    private int soLuongNhanVien;

    //Hàm tạo đối tượng bộ phận
    public Department(String tenBoPhan, int maBoPhan, int soLuongNhanVien) {
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
        this.soLuongNhanVien = soLuongNhanVien;
    }

    // Phương thức toString() hiển thị thông tin bộ phận
    @Override
    public String toString() {
        return "Bộ phận: " + tenBoPhan + "   " + "Mã BP: " + maBoPhan + "   " + "Số lượng nv:" + soLuongNhanVien + "\n";
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }

    public void setMaBoPhan(int maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    public void setSoLuongNhanVien(int soLuongNhanVien) {
        this.soLuongNhanVien = soLuongNhanVien;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public int getMaBoPhan() {
        return maBoPhan;
    }

    public int getSoLuongNhanVien() {
        return soLuongNhanVien;
    }
}
