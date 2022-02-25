
//Lớp Manager kế thừa lớp Staff sử dụng chung interface ICaculator với lớp Employee
public class Manager extends  Staff implements ICalculator{
    private String chucDanh;

    // hàm tạo 4 tham số cơ bản để thiết nhập nhanh thông tin nhân viên
    public Manager(String tenNhanVien, String boPhanLamViec, double heSoLuong,String chucDanh){
        super(tenNhanVien, boPhanLamViec, heSoLuong);
        this.chucDanh = chucDanh;
    }

    //Hàm tạo đầy đủ tham số
    public Manager(String tenNhanVien, int tuoiNhanVien, String maNhanVien, String boPhanLamViec, double heSoLuong, int ngayNghiPhep, String ngayLamViec, String chucDanh) {
        super(maNhanVien, tenNhanVien, boPhanLamViec, ngayLamViec, tuoiNhanVien, ngayNghiPhep, heSoLuong);
        this.chucDanh = chucDanh;
    }

    //khai báo lại phương thức displayInformation() hiển thị thông tin nhân viên quản lý
    public void displayInformation() {
        String quanLy = "Ma nv: " + getMaNhanVien() + ", " + "Tên nv: " + getTenNhanVien() + ", " +
                "Tuổi: " + getTuoiNhanVien() + ", " + "Bộ Phận: " + getBoPhanLamViec() + ", " + "HS: " + getHeSoLuong() + ", " +
                "Ngày vào: " + getNgayLamViec() + ", " + "NNP: " + getNgayNghiPhep() + ", " + "Chức danh: " + getChucDanh() + ", " +
                "Lương: " + this.calculator();
        System.out.println(quanLy);
    }

    //Phương thức caculator() tính và trả lại lương quản lý
    public int calculator() {
        double luongNhanVien = 0;
        if (this.chucDanh.equals("business")) {
            luongNhanVien = getHeSoLuong() * coBanQuanLy + trachNhiemBusiness;
        }
        if (this.chucDanh.equals("project")) {
            luongNhanVien = getHeSoLuong() * coBanQuanLy + trachNhiemProject;
        }
        if (this.chucDanh.equals("technical")) {
            luongNhanVien = getHeSoLuong() * coBanQuanLy + trachNhiemTechnical;
        }
        return (int)luongNhanVien;
    }

    public String getChucDanh() {
        return chucDanh;
    }

    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }
}
