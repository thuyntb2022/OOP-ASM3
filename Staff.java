import java.util.Scanner;
//Lớp Staff là lớp abstract chứa các phương thức chung cho lớp con Employee và Manager thừa kế
public abstract class Staff {
    private String maNhanVien;
    private  String tenNhanVien;
    private String boPhanLamViec;
    private String ngayLamViec;
    private int tuoiNhanVien;
    private int ngayNghiPhep;
    private double heSoLuong;

    //Hàm tạo đầy đủ tham số
    public Staff(String maNhanVien, String tenNhanVien, String boPhanLamViec, String ngayLamViec, int tuoiNhanVien, int ngayNghiPhep, double heSoLuong) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.boPhanLamViec = boPhanLamViec;
        this.ngayLamViec = ngayLamViec;
        this.tuoiNhanVien = tuoiNhanVien;
        this.ngayNghiPhep = ngayNghiPhep;
        this.heSoLuong = heSoLuong;
    }

    //Hàm tạo 3 tham số cơ bản
    public Staff(String tenNhanVien, String boPhanLamViec, double heSoLuong) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.boPhanLamViec = boPhanLamViec;
        this.ngayLamViec = ngayLamViec;
        this.tuoiNhanVien = tuoiNhanVien;
        this.ngayNghiPhep = ngayNghiPhep;
        this.heSoLuong = heSoLuong;
    }

    // phương thức abstract được xây dựng bởi lớp kế thừa
    public abstract void displayInformation();

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public String getBoPhanLamViec() {
        return boPhanLamViec;
    }

    public String getNgayLamViec() {
        return ngayLamViec;
    }

    public int getTuoiNhanVien() {
        return tuoiNhanVien;
    }

    public int getNgayNghiPhep() {
        return ngayNghiPhep;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public void setBoPhanLamViec(String boPhanLamViec) {
        this.boPhanLamViec = boPhanLamViec;
    }

    public void setNgayLamViec(String ngayLamViec) {
        this.ngayLamViec = ngayLamViec;
    }

    public void setTuoiNhanVien(int tuoiNhanVien) {
        this.tuoiNhanVien = tuoiNhanVien;
    }

    public void setNgayNghiPhep(int ngayNghiPhep) {
        this.ngayNghiPhep = ngayNghiPhep;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }
}
