package DienThoai;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ChiTietHoaDon {
	private String mahoadon;
	private String madienthoai;
	private double soluong;
	private double dongia;
	private double thanhtien;
	private double thue;
	
	public ChiTietHoaDon() {}
	public ChiTietHoaDon(String mahoadon) {this.mahoadon = mahoadon;}
	public ChiTietHoaDon(String mahoadon, String madienthoai, double soluong, double dongia, double thanhtien, double thue) {
		this.mahoadon = mahoadon;
		this.madienthoai = madienthoai;
		this.soluong = soluong;
		this.dongia = dongia;
		this.thanhtien = thanhtien;	
		this.thue = thue;	
	}
	public ChiTietHoaDon(ChiTietHoaDon cthd1) {
		mahoadon = cthd1.mahoadon;
		madienthoai = cthd1.madienthoai;
		soluong = cthd1.soluong;
		dongia = cthd1.dongia;
		thanhtien = cthd1.thanhtien;
		thue = cthd1.thue;
	}
	public void ghiFile() throws IOException {
		DataOutputStream outStream 
			= new DataOutputStream(new FileOutputStream("chitiethoadon.txt",Boolean.TRUE));
		outStream.writeUTF(mahoadon);
		outStream.writeUTF(madienthoai);
		outStream.writeDouble(soluong);
		outStream.writeDouble(dongia);
		outStream.writeDouble(thanhtien);
		outStream.writeDouble(thue);
		outStream.close();
	}
	
	public void nhap() {
		Scanner sc = new  Scanner(System.in);
		if(mahoadon == null) {
			System.out.print("Nhap ma hoa don:");
			mahoadon = sc.nextLine();
		}
		DienThoai dt;
		int check = 1;
		while(check == 1) {
			System.out.print("Nhap ma dien thoai:");
			madienthoai = sc.nextLine();
			DSDT danhsachdienthoai = new DSDT(); 
			danhsachdienthoai.docFile();
			dt = danhsachdienthoai.timDienThoai(madienthoai);
			if(dt == null) System.out.println("Nhap sai ma dien thoai");
			else {
				check = 0;
				System.out.print("Nhap so luong:");
				soluong = sc.nextDouble();
				dongia = dt.getDonGia();
				thanhtien = dongia*soluong;	
				thue = dongia*soluong * 10/100;
			};
		}
//		System.out.print("Nhap don gia:");
			
//		System.out.print("Nhap thanh tien:");
			
//		System.out.print("Nhap thue:");
			
	}
	public void xuat() {
		System.out.println("Ma hoa don:" + mahoadon + ", Ma dien thoai:" + madienthoai +", So luong:"+soluong + ", Don gia:" + dongia + ", Thue:"+ thue + ", Thanh tien:" + thanhtien);
	}
	
	
	public String getMahoadon() {
		return mahoadon;
	}

	public void setMahoadon(String mahoadon) {
		this.mahoadon = mahoadon;
	}

	public String getMadienthoai() {
		return madienthoai;
	}

	public void setMadienthoai(String madienthoai) {
		this.madienthoai = madienthoai;
	}

	public double getSoluong() {
		return soluong;
	}

	public void setSoluong(double soluong) {
		this.soluong = soluong;
	}

	public double getDongia() {
		return dongia;
	}

	public void setDongia(double dongia) {
		this.dongia = dongia;
	}

	public double getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(double thanhtien) {
		this.thanhtien = thanhtien;
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}
}
