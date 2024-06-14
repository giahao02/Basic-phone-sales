/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DienThoai;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class DSDT {

    int soLuongDienThoai;
    DienThoai[] dt = new DienThoai[0];
    DienThoaiThongMinh tm = new DienThoaiThongMinh();
    DienThoaiPhoThong pt = new DienThoaiPhoThong();

    public DSDT() {

    }

    public int checkTrungMaDienThoai(String maDienThoai) throws IOException {
        for (int i = 0; i < soLuongDienThoai; i++) {
            if (maDienThoai.equals(dt[i].getMaDienThoai()) == true) {
                return 1;
            }
        }
        return 0;
    }

    public void nhapThongTinDienThoai() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Vui long nhap so luong dien thoai: ");
        soLuongDienThoai = sc.nextInt();
        dt = new DienThoai[soLuongDienThoai];
        for (int i = 0; i < soLuongDienThoai; i++) {
            System.out.print("Nhap thong tin dien thoai (1- Dien thoai thong minh , 2- Dien thoai pho thong) : ");
            int choose = sc.nextInt();
            if (choose == 1) {
                dt[i] = new DienThoaiThongMinh();
            }
            if (choose == 2) {
                dt[i] = new DienThoaiPhoThong();
            }
            if (choose != 1 && choose != 2) {
                System.out.print("Vui long xem lai lua chon !!");
                break;
            }
            dt[i].input();
        }
    }

    public void xuatThongTinDienThoai() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("1. Dien Thoai Thong Minh\n2. Dien Thoai Pho Thong\n3. Tat ca\n");
        System.out.print("Nhap lua chon : ");
        int choose = sc.nextInt();
        for (int i = 0; i < dt.length; i++) {
            if (choose == 1 && dt[i] instanceof DienThoaiThongMinh) {
                System.out.print(dt[i].toString());
            }
            if (choose == 2 && dt[i] instanceof DienThoaiPhoThong) {
                System.out.print(dt[i].toString());
            }
            if (choose == 3) {
                System.out.print(dt[i].toString());
            }
            if (choose != 1 && choose != 2 && choose != 3) {
                System.out.print("Vui long xem lai lua chon !!");
                break;
            }
        }
    }

    void ghiFile() throws IOException {
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream("dienthoai.txt"));
        for (int i = 0; i < soLuongDienThoai; i++) {
            if (dt[i] instanceof DienThoaiPhoThong) {
                dt[i].ghiFile();
            }
            if (dt[i] instanceof DienThoaiThongMinh) {
                dt[i].ghiFile();
            }
        }
        outStream.close();
    }

    void docFile() {
        int i = 0;
        int j = 0;
        try {
            DataInputStream inStream = new DataInputStream(new FileInputStream("dienthoai.txt"));
            try {
                while (true) { //xin cap phat them 
                    int maLoaiSanPham = inStream.readInt();
                    if (maLoaiSanPham == 2) {
                        String maDienThoai = inStream.readUTF();
                        String tenDienThoai = inStream.readUTF();
                        String maThuongHieu = inStream.readUTF();
                        String heDieuHanh = inStream.readUTF();
                        int ram = inStream.readInt();
                        int soLuong = inStream.readInt();
                        double donGia = inStream.readDouble();
                        String donViTinh = inStream.readUTF();
                        int kichThuocManHinh = inStream.readInt();
                        int trongLuong = inStream.readInt();

                        int n = dt.length;
                        dt = Arrays.copyOf(dt, dt.length + 1);
                        dt[n] = new DienThoaiPhoThong(maDienThoai, tenDienThoai, donGia, maThuongHieu, soLuong, donViTinh, heDieuHanh, ram, maLoaiSanPham, kichThuocManHinh, trongLuong);
                        j++;
//                        System.out.print("----------------\n" + "Ma dien thoai :" + maDienThoai + "\n" + "Ten dien thoai" + tenDienThoai + "\n" + "Ma thuong hieu : " + maThuongHieu + "\n"
//                                + "He dieu hanh : " + heDieuHanh + "\n" + "Ram : " + ram + "\n" + "So luong : " + soLuong + "\n"
//                                + "Don gia : " + donGia + "\n" + "Don vi tinh : " + donViTinh + "\n" + "Kich thuoc man hinh : " + kichThuocManHinh + "\n" + "Trong luong : " + trongLuong + "\n");
                    }
                    if (maLoaiSanPham == 1) {
                        String maDienThoai = inStream.readUTF();
                        String tenDienThoai = inStream.readUTF();
                        String maThuongHieu = inStream.readUTF();
                        String heDieuHanh = inStream.readUTF();
                        int ram = inStream.readInt();
                        int soLuong = inStream.readInt();
                        double donGia = inStream.readDouble();
                        String donViTinh = inStream.readUTF();
                        String congNgheManHinh = inStream.readUTF();
                        String camBien = inStream.readUTF();

                        int n = dt.length;
                        dt = Arrays.copyOf(dt, dt.length + 1);
                        dt[n] = new DienThoaiThongMinh(maDienThoai, tenDienThoai, donGia, maThuongHieu, soLuong, donViTinh, heDieuHanh, ram, maLoaiSanPham, congNgheManHinh, camBien);
                        j++;

//                        System.out.print("----------------\n" + "Ma dien thoai : " + maDienThoai + "\n" + "Ten dien thoai : " + tenDienThoai + "\n" + "Ma thuong hieu : " + maThuongHieu + "\n"
//                                + "He dieu hanh : " + heDieuHanh + "\n" + "Ram : " + ram + "\n" + "So luong : " + soLuong + "\n"
//                                + "Don gia : " + donGia + "\n" + "Don vi tinh : " + donViTinh + "\n" + "Cong nghe man hinh : " + congNgheManHinh + "\n" + "Cam bien : " + camBien + "\n");
                    }
                }
            } catch (EOFException e) {
            } finally {
                soLuongDienThoai = i;
                inStream.close();
            }
        } catch (IOException e) {
        }
    }
    
    
    public DienThoai timDienThoai(String madienthoai) {
    	for (int i = 0; i < dt.length; i++) {
            if (dt[i].getMaDienThoai().indexOf(madienthoai) != -1) {
            	return dt[i];
            }
    	}
        return null;
    }

    public void timKiemDienThoai() throws IOException {
        Scanner sc = new Scanner(System.in);
        if (dt.length < 1) {
            System.out.print("Ban khong co dien thoai nao ca.\n");
        } else {
            System.out.print("Vui long nhap ma dien thoai ban muon tim : ");
            String maDienThoai = sc.nextLine();
            for (int i = 0; i < dt.length; i++) {
                if (dt[i].getMaDienThoai().indexOf(maDienThoai) != -1) {
                    System.out.print("-------------");
                    System.out.print(dt[i].toString());
                } else {
                    System.out.print("Vui long xem lai lua chon !");
                    break;
                }
            }
        }
    }

    public void themMotDienThoai() throws IOException {
        Scanner sc = new Scanner(System.in);
        dt = Arrays.copyOf(dt, soLuongDienThoai + 1);
        System.out.print("Nhap lua chon (1- Dien thoai thong minh , 2- Dien thoai pho thong): ");
        int choose = sc.nextInt();
        if (choose == 1) {
            dt[soLuongDienThoai] = new DienThoaiThongMinh();
            dt[soLuongDienThoai].input();
        }
        if (choose == 2) {
            dt[soLuongDienThoai] = new DienThoaiPhoThong();
            dt[soLuongDienThoai].input();
        }
        if (choose != 1 && choose != 2) {
            System.out.print("Vui long xem lai lua chon !!");
        }
        soLuongDienThoai++;
    }

    public void chinhSuaTenDienThoai() throws IOException {
        Scanner sc = new Scanner(System.in);
        if (soLuongDienThoai < 1) {
            System.out.print("Ban khong co dien thoai nao ca.\n");
        } else {
            System.out.print("Vui long nhap ma dien thoai ban muon sua : ");
            String maDienThoai = sc.nextLine();
            boolean check = false;
            for (int i = 0; i < soLuongDienThoai; i++) {
                if (dt[i].getMaDienThoai().indexOf(maDienThoai) != -1) {
                    check = true;
                    System.out.print("Nhap ten ban muon sua : ");
                    dt[i].setTenDienThoai(sc.nextLine());
                }
            }
            if (check == false) {
                System.out.print("Vui long xem lai lua chon !\n");
            }
        }
    }

    public void chinhSuaHeDieuHanh() throws IOException {
        Scanner sc = new Scanner(System.in);
        if (soLuongDienThoai < 1) {
            System.out.print("Ban khong co dien thoai nao ca.\n");
        } else {
            System.out.print("Vui long nhap ma dien thoai ban muon sua : ");
            String maDienThoai = sc.nextLine();
            boolean check = false;
            for (int i = 0; i < soLuongDienThoai; i++) {
                if (dt[i].getMaDienThoai().indexOf(maDienThoai) != -1) {
                    check = true;
                    System.out.print("Nhap ten he dieu hanh ban muon sua : ");
                    dt[i].setHeDieuHanh(sc.nextLine());
                }
            }
            if (check == false) {
                System.out.print("Vui long xem lai ma dien thoai !\n");
            }
        }
    }

    public void chinhSuaRam() throws IOException {
        Scanner sc = new Scanner(System.in);
        if (soLuongDienThoai < 1) {
            System.out.print("Ban khong co dien thoai nao ca.\n");
        } else {
            System.out.print("Vui long nhap ma dien thoai ban muon sua : ");
            String maDienThoai = sc.nextLine();
            boolean check = false;
            for (int i = 0; i < soLuongDienThoai; i++) {
                if (dt[i].getMaDienThoai().indexOf(maDienThoai) != -1) {
                    check = true;
                    System.out.print("Nhap so ram ban muon sua : ");
                    dt[i].setRam(sc.nextInt());
                }
            }
            if (check == false) {
                System.out.print("Vui long xem lai ma dien thoai !\n");
            }
        }
    }

    public void chinhSuaSoLuong() throws IOException {
        Scanner sc = new Scanner(System.in);
        if (soLuongDienThoai < 1) {
            System.out.print("Ban khong co dien thoai nao ca.\n");
        } else {
            System.out.print("Vui long nhap ma dien thoai ban muon sua : ");
            String maDienThoai = sc.nextLine();
            boolean check = false;
            for (int i = 0; i < soLuongDienThoai; i++) {
                if (dt[i].getMaDienThoai().indexOf(maDienThoai) != -1) {
                    check = true;
                    System.out.print("Nhap so luong ban muon sua : ");
                    dt[i].setSoLuong(sc.nextInt());
                }
            }
            if (check == false) {
                System.out.print("Vui long xem lai ma dien thoai !\n");
            }
        }
    }

    public void chinhSuaDonGia() throws IOException {
        Scanner sc = new Scanner(System.in);
        if (soLuongDienThoai < 1) {
            System.out.print("Ban khong co dien thoai nao ca.\n");
        } else {
            System.out.print("Vui long nhap ma dien thoai ban muon sua : ");
            String maDienThoai = sc.nextLine();
            boolean check = false;
            for (int i = 0; i < soLuongDienThoai; i++) {
                if (dt[i].getMaDienThoai().indexOf(maDienThoai) != -1) {
                    check = true;
                    System.out.print("Nhap don gia ban muon sua : ");
                    dt[i].setDonGia(sc.nextDouble());
                }
            }
            if (check == false) {
                System.out.print("Vui long xem lai ma dien thoai !\n");
            }
        }
    }

    public void chinhSuaCongNgheManHinh() throws IOException {
        Scanner sc = new Scanner(System.in);
        if (soLuongDienThoai < 1) {
            System.out.print("Ban khong co dien thoai nao ca.\n");
        } else {
            System.out.print("Vui long nhap ma dien thoai ban muon sua : ");
            String maDienThoai = sc.nextLine();
            boolean check = false;
            for (int i = 0; i < soLuongDienThoai; i++) {
                if (dt[i] instanceof DienThoaiThongMinh) {
                    tm = new DienThoaiThongMinh();
                    tm = (DienThoaiThongMinh) dt[i];
                }
                if (tm.getMaDienThoai().indexOf(maDienThoai) != -1) {
                    check = true;
                    System.out.print("Nhap cong nghe man hinh ban muon sua : ");
                    tm.setCongNgheManHinh(sc.nextLine());
                }
            }
            if (check = false) {
                System.out.print("Vui long xem lai ma dien thoai !\n");
            }
        }
    }

    public void chinhSuaCamBien() throws IOException {
        Scanner sc = new Scanner(System.in);
        if (soLuongDienThoai < 1) {
            System.out.print("Ban khong co dien thoai nao ca.\n");
        } else {
            System.out.print("Vui long nhap ma dien thoai ban muon sua : ");
            String maDienThoai = sc.nextLine();
            boolean check = false;
            for (int i = 0; i < soLuongDienThoai; i++) {
                if (dt[i] instanceof DienThoaiThongMinh) {
                    tm = new DienThoaiThongMinh();
                    tm = (DienThoaiThongMinh) dt[i];
                }
                if (tm.getMaDienThoai().indexOf(maDienThoai) != -1) {
                    check = true;
                    System.out.print("Nhap ten cam bien ban muon sua : ");
                    tm.setCamBien(sc.nextLine());
                }
            }
            if (check == false) {
                System.out.print("Vui long xem lai ma dien thoai !\n");
            }
        }
    }

    public void chinhSuaKichThuocManHinh() throws IOException {
        Scanner sc = new Scanner(System.in);
        if (soLuongDienThoai < 1) {
            System.out.print("Ban khong co dien thoai nao ca.\n");
        } else {
            System.out.print("Vui long nhap ma dien thoai ban muon sua : ");
            String maDienThoai = sc.nextLine();
            boolean check = false;
            for (int i = 0; i < soLuongDienThoai; i++) {
                if (dt[i] instanceof DienThoaiPhoThong) {
                    pt = new DienThoaiPhoThong();
                    pt = (DienThoaiPhoThong) dt[i];
                }
                if (pt.getMaDienThoai().indexOf(maDienThoai) != -1) {
                    check = true;
                    System.out.print("Nhap kich thuoc ban muon sua : ");
                    pt.setKichThuocManHinh(sc.nextInt());
                }
            }
            if (check == false) {
                System.out.print("Vui long xem lai ma dien thoai !\n");
            }
        }
    }

    public void chinhSuaTrongLuong() throws IOException {
        Scanner sc = new Scanner(System.in);
        if (soLuongDienThoai < 1) {
            System.out.print("Ban khong co dien thoai nao ca.\n");
        } else {
            System.out.print("Vui long nhap ma dien thoai ban muon sua : ");
            String maDienThoai = sc.nextLine();
            boolean check = false;
            for (int i = 0; i < soLuongDienThoai; i++) {
                if (dt[i] instanceof DienThoaiPhoThong) {
                    pt = new DienThoaiPhoThong();
                    pt = (DienThoaiPhoThong) dt[i];
                }
                if (pt.getMaDienThoai().indexOf(maDienThoai) != -1) {
                    check = true;
                    System.out.print("Nhap trong luong ban mua sua : ");
                    pt.setTrongLuong(sc.nextInt());
                }
            }
            if (check == false) {
                System.out.print("Vui long xem lai ma dien thoai !\n");
            }
        }

    }

    public void xoaDienThoai() throws IOException {
        Scanner sc = new Scanner(System.in);
        if (soLuongDienThoai == 0) {
            System.out.print("Ban khong co dien thoai nao ca.\n");
        } else {
            System.out.print("Vui long nhap ma dien thoai ban muon xoa : ");
            String choose = sc.nextLine();
            boolean check = false;
            for (int i = 0; i < soLuongDienThoai; i++) {
                if (dt[i].getMaDienThoai().indexOf(choose) != -1) {
                    check = true;
                    dt[i] = dt[i + 1];
                    soLuongDienThoai--;
                    if (soLuongDienThoai == 0) {
                        System.out.print("Danh sach da rong !");
                        break;
                    }
                }
            }
            if (check == false) {
                System.out.print("Vui long xem lai ma dien thoai !\n");
            }
        }
    }
}
