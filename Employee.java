
//Lớp Employ kế thừa lớp Staff sử dụng chung interface ICaculator với lớp Manager
public class Employee extends Staff implements ICalculator{
     private double gioLamThem;

    // hàm tạo 4 tham số cơ bản để thiết nhập nhanh thông tin nhân viên
    public Employee(String tenNhanVien, String boPhanLamViec, double heSoLuong,double gioLamThem){
        super(tenNhanVien, boPhanLamViec, heSoLuong);
        this.gioLamThem = gioLamThem;
    }

    //Hàm tạo đầy đủ tham số
    public Employee(String tenNhanVien, int tuoiNhanVien, String maNhanVien, String boPhanLamViec, double heSoLuong, int ngayNghiPhep, String ngayLamViec, double gioLamThem){
        super(maNhanVien, tenNhanVien, boPhanLamViec, ngayLamViec, tuoiNhanVien, ngayNghiPhep, heSoLuong);
        this.gioLamThem = gioLamThem;
    }


    //khai báo lại phương thức displayInformation() hiển thị thông tin nhân viên
    public void displayInformation() {
        String nhanVien = "Ma nv: " + getMaNhanVien() + ", " + "Tên nv: " + getTenNhanVien() + ", " +
                "Tuổi: " + getTuoiNhanVien() + ", " + "Bộ Phận: " + getBoPhanLamViec() + ", " + "HS: " + getHeSoLuong() + ", " +
                "Ngày vào: " + getNgayLamViec() + ", " + "NNP: " + getNgayNghiPhep() + ", " + "Giờ LT: " + getGioLamThem() + ", " +
                "Lương: " + this.calculator();
        System.out.println(nhanVien);
    }

    // Phương thức calculaor() để tính và trả lại lương nhân viên
    public int calculator() {
        double luongNhanVien = getHeSoLuong() * coBanNhanVien + this.gioLamThem * luongLamThem;
        return (int)luongNhanVien;
    }

    public double getGioLamThem() {
        return gioLamThem;
    }

    public void setGioLamThem(double gioLamThem) {
        this.gioLamThem = gioLamThem;
    }
}
