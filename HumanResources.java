import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

//lớp chứa phương thức main để hiển thị các đối tượng
public class HumanResources {
    //Khai báo ArrayList lưu trữ các đối tượng nhân viên
    ArrayList<Staff> humanResourcesArrayList = new ArrayList<>();
    //Khai báo ArrayList lưu trữ các đối tượng bộ phận
    ArrayList<Department> boPhan = new ArrayList<Department>();

    //Phương thức main điều khiển chương trình
    public static void main(String[] args) {
        /*Tạo đối tượng HumanResources có chứa ArrayList để lưu trữ thông tin các đối tượng nhân viên
          và có thể sử dụng các phương thức hiển thị theo yêu cầu*/
        HumanResources humanResources = new HumanResources();
        Scanner sc = new Scanner(System.in);
        System.out.print("Bạn nhập bao nhiêu nhân viên ? ");
        int tongSoNhanVien = sc.nextInt();
        int i = 0;
        //Nhập thông tin nhân viên với số lượng nhân viên tùy chọn
        do {
            humanResources.themNhanVienMoi();
            i++;
        } while (i < tongSoNhanVien);
        //lựa chọn các tùy chọn hiển thị
        do {
            System.out.println("Bạn muốn hiển thị danh sách thế nào ?(Hãy chọn số thứ tự theo danh sách sau ");
            System.out.println("1. Danh sách nhân viên hiện có trong công ty.");
            System.out.println("2. Hiển thị các bộ phận trong công ty.");
            System.out.println("3. Hiển thị các nhân viên theo từng bộ phận.");
            System.out.println("4. Tìm kiếm thông tin theo tên.");
            System.out.println("5. Hiển thị bảng lương của nhân viên toàn công ty theo thứ tự giảm dần.");
            System.out.println("6. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.");
            System.out.println("7. Thêm nhân viên mới.");
            int sott = sc.nextInt();
            i = 0;
            if (sott == 1){
                humanResources.danhSachNV();
                i = 1;
            }
            if (sott == 2){
                humanResources.hienThiBoPhan();
                i = 1;
            }
            if (sott == 3){
                humanResources.hienThiTheoBoPhan();
                i = 1;
            }
            if (sott == 4){
                humanResources.timKiemNhanVienTheoTen();
                i = 1;
            }
            if (sott == 5){
                humanResources.hienThiBangLuongGiamDan();
                i = 1;
            }
            if (sott == 6){
                humanResources.hienThiBangLuongTangDan();
                i = 1;
            }
            if (sott == 7){
                humanResources.themNhanVienMoi();
                i = 1;
            }
            System.out.print("Hãy nhấn \"ok\" để hiển thị lựa chọn ");
            String hi = sc.next();
        } while ( i != 0);
    }

    // phương thức thêm nhân viên
    public void themNhanVienMoi() {
        Scanner nhanVienMoi = new Scanner(System.in);
        System.out.println("Mời bạn nhập thông tin sau: ");
        System.out.print("Họ và tên: ");
        String tenNhanVien = nhanVienMoi.nextLine();
        System.out.print("Bộ phận làm việc: ");
        String boPhanLamViec = nhanVienMoi.nextLine();
        System.out.print("Hệ số lương: ");
        double heSoLuong = nhanVienMoi.nextDouble();
        System.out.print("Giờ làm thêm: ");
        double gioLamThem = nhanVienMoi.nextDouble();
        System.out.print("Chức danh: ");
        String chucDanh = nhanVienMoi.next();

        if (chucDanh.equals("business") || chucDanh.equals("project") || chucDanh.equals("technical")) {
            humanResourcesArrayList.add(new Manager(tenNhanVien, boPhanLamViec, heSoLuong, chucDanh));
        } else {
            humanResourcesArrayList.add(new Employee(tenNhanVien, boPhanLamViec, heSoLuong, gioLamThem));
        }
        thietLapBoPhan(boPhanLamViec);
    }

    //Hiển thị danh sách nhân viên trong công ty
    public void danhSachNV() {
        System.out.println("Danh sách nhân viên: ");
//        this.hienThiChung();
        for (int i = 0; i < humanResourcesArrayList.size(); i++) {
            int stt = i + 1;
            Staff x = humanResourcesArrayList.get(i);
            System.out.print(stt + ". ");
            x.displayInformation();
        }
        System.out.println();
    }

    //Hiển thị danh sách các bộ phận trong công ty
    public  void hienThiBoPhan() {
        System.out.println("Danh sách bộ phận: ");
        System.out.println(boPhan.toString());
    }

    //Hiển thị danh sách các nhân viên theo từng bộ phận
    public void hienThiTheoBoPhan(){
        System.out.println("Danh sách nhân viên theo bộ phận: ");
        for (int i = 0; i < boPhan.size(); i++) {
            int stt = 0;
   //         System.out.println(stt + "         ");
            for (int j = 0; j < humanResourcesArrayList.size(); j++) {
                Staff x = humanResourcesArrayList.get(j);
                if (x.getBoPhanLamViec().equals(boPhan.get(i).getTenBoPhan())) {
                    stt++;
                    System.out.print(stt + ". ");
                    x.displayInformation();
                }
            }
        }
        System.out.println();
    }

    //Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên
    public void timKiemNhanVienTheoTen(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Hãy nhập tên bạn muốn tìm kiếm ");
        String tenTimKiem = sc.nextLine();
        int stt = 0;
        for (int i = 0; i < humanResourcesArrayList.size(); i++) {
            Staff x = humanResourcesArrayList.get(i);
            if (x.getTenNhanVien().equals(tenTimKiem)) {
                stt += 1;
                System.out.print(stt + ". ");
                x.displayInformation();
            }
        }
        if (stt == 0) {
            System.out.println("Không tìm thấy nhân viên tên " + tenTimKiem + " trong công ty!");
        }
        System.out.println();
    }

    // Hiển thị bảng lương của nhân viên theo thứ tự tăng dần
    public void hienThiBangLuongTangDan() {
        Comparator<Staff> luongTangDan = new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                int d = 0;
               if (o1 instanceof Employee) {
                    if (o2 instanceof Employee) {
                        d = ((Employee) o1).calculator() - ((Employee) o2).calculator();
                    }
                    if (o2 instanceof Manager) {
                        d = ((Employee) o1).calculator() - ((Manager) o2).calculator();
                    }
                } else {
                    if (o2 instanceof Employee) {
                        d = ((Manager) o1).calculator() - ((Employee) o2).calculator();
                    } else {
                        d = ((Manager) o1).calculator() - ((Manager) o2).calculator();
                    }
                }
                return d;
            }
        };
        humanResourcesArrayList.sort(luongTangDan);
        danhSachNV();
    }

    // Hiển thị danh sách nhân viên theo lương giảm dần
    public void hienThiBangLuongGiamDan() {
        Comparator<Staff> luongGiamDan = new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                int d = 0;
                if (o1 instanceof Employee) {
                    if (o2 instanceof Employee) {
                        d = ((Employee) o2).calculator() - ((Employee) o1).calculator();
                    }
                    if (o2 instanceof Manager) {
                        d = ((Manager) o2).calculator() - ((Employee) o1).calculator();
                    }
                } else {
                    if (o2 instanceof Employee) {
                        d = ((Employee) o2).calculator() - ((Manager) o1).calculator();
                    } else {
                        d = ((Manager) o2).calculator() - ((Manager) o1).calculator();
                    }
                }
                return d;
            }
        };
        humanResourcesArrayList.sort(luongGiamDan);
        danhSachNV();
    }

    //Thiết lập các bộ phận trong công ty
    public void thietLapBoPhan(String tenBoPhan) {
        if (boPhan.size() == 0) {
            boPhan.add(new Department(tenBoPhan,1, 1));
        } else {
            for (int i = 0; i < boPhan.size(); i++) {
                Department x = boPhan.get(i);
                int soLuongNhanVien = x.getSoLuongNhanVien();
                if (x.getTenBoPhan().equals(tenBoPhan)) {
                    soLuongNhanVien += 1;
                    x.setSoLuongNhanVien(soLuongNhanVien);
                } else {
                    int k = 0;
                    for (int j = 0; j < boPhan.size(); j++) {
                        if (boPhan.get(j).getTenBoPhan().equals(tenBoPhan)) {
                            k++;
                        }
                    }
                    if (k == 0) {
                        boPhan.add(new Department(tenBoPhan, boPhan.size() + 1, 0));
                    }
                }
            }
        }
    }

}

