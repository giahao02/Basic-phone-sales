/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DienThoai;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class QuanLyDT {
    Scanner sc = new Scanner(System.in);
    DSDT dt = new DSDT();
    public void menuDT() throws IOException{
        dt.docFile();
        int option;
        do{
        System.out.println("\n-----------MENU-------------");
        System.out.println("1. Nhap Danh Sach Dien Thoai");
        System.out.println("2. Xem Danh Sach Dien Thoai");
        System.out.println("3. Them Dien Thoai");
        System.out.println("4. Sua Thong Tin Dien Thoai");
        System.out.println("5. Xoa Dien Thoai");
        System.out.println("6. Tim Kiem Dien Thoai");
        System.out.println("7. Thoat");
        System.out.println();
        System.out.println();
        System.out.println("---------");
        System.out.print("Lua chon : ");
        option = sc.nextInt();
        
        switch(option){
                case 1:
                    dt.nhapThongTinDienThoai();
                    break;
                case 2:
                    dt.xuatThongTinDienThoai();
                    break;
                case 3:
                    dt.themMotDienThoai();
                    break;
                case 4:
                    do{
                    System.out.println("-----------SUA THONG TIN-------------");
                    System.out.println("1. Sua Ten Dien Thoai");
                    System.out.println("2. Sua He Dieu Hanh");
                    System.out.println("3. Sua Ram");
                    System.out.println("4. Sua So Luong");
                    System.out.println("5. Sua Don Gia");
                    System.out.println("6. Sua Cong Nghe Man Hinh");
                    System.out.println("7. Sua Cam Bien");
                    System.out.println("8. Sua Kich Thuoc Man Hinh");
                    System.out.println("9. Sua Trong Luong");
                    System.out.println("10. Thoat");
                    System.out.print("Lua chon : ");
                    option = sc.nextInt();
                        switch(option){
                            case 1:
                                dt.chinhSuaTenDienThoai();
                                break;
                            case 2:
                                dt.chinhSuaHeDieuHanh();
                                break;
                            case 3:
                                dt.chinhSuaRam();
                                break;
                            case 4:
                                dt.chinhSuaSoLuong();
                                break;
                            case 5:
                                dt.chinhSuaDonGia();
                                break;
                            case 6:
                                dt.chinhSuaCongNgheManHinh();
                                break;
                            case 7:
                                dt.chinhSuaCamBien();
                                break;
                            case 8:
                                dt.chinhSuaKichThuocManHinh();
                                break;
                            case 9:
                                dt.chinhSuaTrongLuong();
                                break;
                            case 10:
                                break;
                            default:
                                System.out.println("Vui long xem lai lua chon !");
                        }
                    }while(option !=10);
                    break;
                case 5:
                    dt.xoaDienThoai();
                    break;
                case 6:
                    dt.timKiemDienThoai();
                    break;
                case 7:
                    System.out.println("Cam on da su dung!!!");
                    dt.ghiFile();

                    return;
                default:
                     System.out.println("Phai nhap lua chon tu 1 -> 7 !!");
            }
        }
        while(true);
    }
}
