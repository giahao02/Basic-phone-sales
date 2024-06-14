package DienThoai;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class HoaDon {
	private String mahoadon;
	private String makh;
	private String manv;
	private String ngaylap;
	private double tongtien;
	
	
	public HoaDon() {}
	public HoaDon(String mahoadon, String makh) {this.mahoadon = mahoadon; this.makh = makh;}
	public HoaDon(String mahoadon, String makh, String manv, String ngaylap, double tongtien) {
		this.mahoadon = mahoadon;
		this.makh = makh;
		this.manv = manv;
		this.ngaylap = ngaylap;
		this.tongtien = tongtien;
	}
	public HoaDon(HoaDon hd1) {
		mahoadon = hd1.mahoadon;
		makh = hd1.makh;
		manv = hd1.manv;
		ngaylap = hd1.ngaylap;
		tongtien = hd1.tongtien;
	}
	
	public void nhap() {
		Scanner sc = new  Scanner(System.in);
//		System.out.print("Nhap ma hoa don:");
//		mahoadon = sc.nextLine();
//		System.out.print("Nhap ma khach hang:");
//		makh = sc.nextLine();
		System.out.print("Nhap ma nhan vien:");
		manv = sc.nextLine();
		System.out.print("Nhap ngay lap:");
		ngaylap = sc.nextLine();
//		System.out.print("Nhap tong tien:");
//		tongtien = sc.nextDouble();
	}
	
	public void ghiFile() throws IOException {
		DataOutputStream outStream 
			= new DataOutputStream(new FileOutputStream("hoadon.txt",Boolean.TRUE));
		outStream.writeUTF(mahoadon);
		outStream.writeUTF(makh);
		outStream.writeUTF(manv);
		outStream.writeUTF(ngaylap);
		outStream.writeDouble(tongtien);
		outStream.close();
	}
	
	
	
	public void xuat() {
		System.out.println("Ma hoa don:"+mahoadon + ", Ma Khach Hang:" + makh + ", Ma nhan vien:" + manv + ", Ngay lap:" + ngaylap + ", Tong tien:" + tongtien);
	}
	
	public String getMahoadon() {
		return mahoadon;
	}

	public void setMahoadon(String mahoadon) {
		this.mahoadon = mahoadon;
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getNgaylap() {
		return ngaylap;
	}

	public void setNgaylap(String ngaylap) {
		this.ngaylap = ngaylap;
	}

	public double getTongtien() {
		return tongtien;
	}

	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}
}
