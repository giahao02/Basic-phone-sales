package DienThoai;

import java.io.IOException;
import java.util.Scanner;

public class QuanLyCuaHangBanDienThoai {
	Scanner sc = new Scanner(System.in);
	DSDT danhsachdienthoai = new DSDT();
	DSHoaDon danhsachhoadon = new DSHoaDon();
	
	public void menuUser(String makh) throws IOException {
		danhsachhoadon.docFile();
		danhsachdienthoai.docFile();
		int option;
        do{
	        System.out.println("\n-----------MENU USER-------------");
	        System.out.println("1. Xem Danh Sach Dien Thoai");
	        System.out.println("2. Tim Kiem Dien Thoai");
	        System.out.println("3. Lap Hoa Don");
	        System.out.println("4. Xuat Hoa Don");
	        System.out.println("5. Chinh Sua Hoa Don");
	        System.out.println("6. Chinh Sua Thong Tin Nguoi Dung");
	        System.out.println("7. Thoat");
	        System.out.println();
	        System.out.println();
	        System.out.print("Lua chon : ");
	        option = sc.nextInt();
	        System.out.println("---------");
	        
	        switch(option){
            case 1:
            	danhsachdienthoai.xuatThongTinDienThoai();
                break;
            case 2:
            	danhsachdienthoai.timKiemDienThoai();
                break;
            case 3:
            	Scanner sc = new Scanner(System.in);
            	int check = 1,choice;
            	while(check == 1) {
            		danhsachhoadon.them(makh);
            		System.out.println("1.Mua them/ 2.Thoat");
            		choice = sc.nextInt();
            		if(choice == 2) check = 0;
            	}
                break;
            case 4:
            	danhsachhoadon.timMaKH(makh);
            	break;
            case 5:
            	
            case 6:
            case 7:
            	danhsachhoadon.ghiFile();
            	return;
	        }
        }while(true);
	}
}
