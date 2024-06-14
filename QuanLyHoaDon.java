package DienThoai;

import java.io.IOException;
import java.util.Scanner;

public class QuanLyHoaDon {
	DSHoaDon ds1 = new DSHoaDon();
	DSChiTietHoaDon dscthd1 = new DSChiTietHoaDon(); 

	public void menuHoaDon() throws IOException {
		ds1.docFile();
		Scanner sc = new Scanner(System.in);
		int choice=0,check=1;
		while(check == 1) {
			do {
				System.out.println("===== Menu =====");
				System.out.println("1. Xem danh sách");
				System.out.println("2. Them hoa don");
				System.out.println("3. Xoa hoa don");
				System.out.println("4. Sua thong tin hoa don");
				System.out.println("5. Tim kiem");
				System.out.println("6. Thong ke");
				System.out.println("7. Thoat");
				System.out.println();
				System.out.print("Chon so:");
				choice = sc.nextInt();
				System.out.println("=================");
			} while (choice <1 || choice >7);
			switch (choice) {
				case 1:
					ds1.xuat();
					break;
				case 2:
//					ds1.them();
					break;
				case 3:
					ds1.xoa();
					break;
				
				case 4:
					menuSuaHoaDon();
					break;
				case 5:
					menuTimKiemHoaDon();
					break;
				case 6:
					ds1.ThongKe();
					break;
				case 7:
					check = 0;
					ds1.ghiFile();
					break;
			}
		}
	}
	public void menuTimKiemHoaDon() {
		Scanner sc = new Scanner(System.in);
		int choice=0,check=1;
		while(check == 1) {
			do {
				System.out.println("1. Tim theo ma hoa don");
				System.out.println("2. Tim theo ma khach hang");
				System.out.println("3. Tim theo ma nhan vien");
				System.out.println("4. Tim theo ngay lap");
				System.out.println("5. Thoat");
				System.out.print("Chon so:");
				choice = sc.nextInt();
				System.out.println();
			} while (choice <1 || choice >5);
			switch (choice) {
				case 1:
					ds1.timMaHoaDon();
					break;
				case 2:
					ds1.timMaKH();
					break;
				case 3:
					ds1.timMaNhanVien();
					break;
				case 4:
					ds1.timNgayLap();
					break;	
				case 5:
					check = 0;
					break;
			}
		}
	}
	public void menuSuaHoaDon() {
		Scanner sc = new Scanner(System.in);
		int choice=0,check=1;
		System.out.print("Nhap ma hoa don can sua:");
		String mahoadon = sc.nextLine();
		HoaDon hd1 = ds1.timMaHoaDon(mahoadon);
		if(hd1 == null) {
			check = 0;
			System.out.println("Khong tim thay ma hoa don");
		}
		while(check == 1) {
			do {
				System.out.println("1. Sua Ma Khach Hang");
				System.out.println("2. Sua Ma Nhan Vien");
				System.out.println("3. Sua Ngay Lap");
				System.out.println("4. Thoat");
				System.out.print("Chon so:");
				choice = sc.nextInt();
				System.out.println();
			} while (choice <1 || choice >5);
			switch (choice) {
				case 1:
					ds1.suaMaKH(hd1);
					break;
				case 2:
					ds1.suaMaNhanVien(hd1);
					break;
				case 3:
					ds1.suaNgayLap(hd1);
					break;
				case 4:
					check = 0;
					break;		
			}
		}
	}
	
	
}
