package DienThoai;

import java.util.Scanner;

public class ThuongHieu {
	private String mathuonghieu;
	private String tenthuonghieu;
	private String quocgia;
	private String trangthai;
	
	public ThuongHieu() {}
	public ThuongHieu(String mathuonghieu, String tenthuonghieu, String quocgia, String trangthai) {
		this.mathuonghieu = mathuonghieu;
		this.tenthuonghieu = tenthuonghieu;
		this.quocgia = quocgia;
		this.trangthai = trangthai;
	}
	public ThuongHieu(ThuongHieu th) {
		mathuonghieu = th.mathuonghieu;
		tenthuonghieu = th.tenthuonghieu;
		quocgia = th.quocgia;
		trangthai = th.trangthai;
	}
	
	public void nhap() {
		Scanner sc = new  Scanner(System.in);
		System.out.print("Nhap ma thuong hieu:");
		mathuonghieu = sc.nextLine();
		System.out.print("Nhap ten thuong hieu:");
		tenthuonghieu = sc.nextLine();
		System.out.print("Nhap quoc gia:");
		quocgia = sc.nextLine();
		System.out.print("Nhap trang thai:");
		trangthai = sc.nextLine();
	}
	
	public void xuat() {
		System.out.print("Ma thuong hieu:" + mathuonghieu + ", Ten thuong hieu:"+ tenthuonghieu + ", Quoc gia:"+ quocgia + ", Trang thai:"+ trangthai);
	}
	
	
	public String getMathuonghieu() {
		return mathuonghieu;
	}

	public void setMathuonghieu(String mathuonghieu) {
		this.mathuonghieu = mathuonghieu;
	}

	public String getTenthuonghieu() {
		return tenthuonghieu;
	}

	public void setTenthuonghieu(String tenthuonghieu) {
		this.tenthuonghieu = tenthuonghieu;
	}

	public String getQuocgia() {
		return quocgia;
	}

	public void setQuocgia(String quocgia) {
		this.quocgia = quocgia;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
}
