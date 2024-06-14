package DienThoai;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DSChiTietHoaDon {
	private ChiTietHoaDon dschitiethoadon[] = new ChiTietHoaDon[0];
	private int n;
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so luong chi tiet hoa don:");
		n = sc.nextInt();
		dschitiethoadon = new ChiTietHoaDon[n];
		for(int i=0;i<n;i++) {
			dschitiethoadon[i] = new ChiTietHoaDon();
			dschitiethoadon[i].nhap();
		}
	}
	
	public void xuat() {
		for(int i=0;i<dschitiethoadon.length;i++) {
			dschitiethoadon[i].xuat();
		}
	}
	
	public void xuat(String mahoadon) {
		for(int i=0;i<dschitiethoadon.length;i++) {
			if(dschitiethoadon[i].getMahoadon().equals(mahoadon)==true)
				dschitiethoadon[i].xuat();
		}
	}
	
	public void ghiFile() throws IOException {
		DataOutputStream outStream 
			= new DataOutputStream(new FileOutputStream("chitiethoadon.txt"));
		outStream.writeInt(dschitiethoadon.length);
		for(int i=0;i<dschitiethoadon.length;i++) {
			dschitiethoadon[i].ghiFile();
		}
		outStream.close();
	}
		
	public void docFile() {
		int i = 0;
		try {
			DataInputStream inStream 
				= new DataInputStream (new FileInputStream("chitiethoadon.txt"));
			int n = inStream.readInt();
			dschitiethoadon = new ChiTietHoaDon[n];
			try {
				while(true) {
					String mahoadon = inStream.readUTF();
					String madienthoai = inStream.readUTF();
					double soluong = inStream.readDouble();
					double dongia = inStream.readDouble();
					double thanhtien = inStream.readDouble();
					double thue = inStream.readDouble();
					dschitiethoadon[i] = new ChiTietHoaDon(mahoadon,madienthoai,soluong,dongia,thanhtien,thue);
					i++;
				}
			}catch(EOFException e) {
			}	
			finally {
				inStream.close();
			}
		}catch(IOException e) {
		}
	}
	
	public void them(String mahoadon) {
		n = dschitiethoadon.length;
		dschitiethoadon = Arrays.copyOf(dschitiethoadon,n+1);
		dschitiethoadon[n] = new ChiTietHoaDon(mahoadon);
		dschitiethoadon[n].nhap();
//		n++;
	}
	
	public void them(ChiTietHoaDon x) {
		n= dschitiethoadon.length;
		dschitiethoadon = Arrays.copyOf(dschitiethoadon,n+1);
		dschitiethoadon[n] = new ChiTietHoaDon(x);
//		n++;
	}
	
	public void xoa () {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma hoa don can xoa:");
		String mahoadon = sc.nextLine();
		int pos = 0,check = 0;
		for(int i=0;i<dschitiethoadon.length;i++) {
			if( (mahoadon.equals(dschitiethoadon[i].getMahoadon()) )== true) {
				pos = i;
				check = 1;
			}
		}
		if(check == 1 ) xoa(mahoadon,pos);
		else  System.out.println("Khong tim thay");
		
	}
	
	public void xoa (String mahoadon,int p) {
		for(int i=p;i < dschitiethoadon.length-1;i++)
			dschitiethoadon[i] = dschitiethoadon[i+1];
		dschitiethoadon = Arrays.copyOf(dschitiethoadon, dschitiethoadon.length -1);
		n--;
	}

	public ChiTietHoaDon timMaHoaDon(String mahoadon) {
		for(int i=0;i<dschitiethoadon.length;i++)
			if( (mahoadon.equals(dschitiethoadon[i].getMahoadon()) )== true) {
				return dschitiethoadon[i];
			}
		return null;
	}

	
//	public static ChiTietHoaDon[] timMaHoaDon(String mahoadon) {
//		DSChiTietHoaDon ds1;
//		ds1.docFile();
//		int j = 0;
//		for(int i = 0;i<ds1.length;i++)
//			if(mahoadon.equals(dschitiethoadon[i].getMahoadon())== true) {
//				dscthd = Arrays.copyOf(dscthd, dscthd.length+1);
//				dscthd[j] = new ChiTietHoaDon();
//				dscthd[j] = dschitiethoadon[i];
//				j++;
//			}
//		return dscthd;
//	}
	

	public void suaMaDT(ChiTietHoaDon cthd1) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Sua ma dien thoai thanh:");
		String madienthoai = sc.nextLine();
		cthd1.setMadienthoai(madienthoai);
		for(int i=0;i<dschitiethoadon.length;i++) 
			if( (cthd1.getMahoadon().equals(dschitiethoadon[i].getMahoadon()) )== true) 
				dschitiethoadon[i].setMadienthoai(cthd1.getMadienthoai());
	}
	
	public void suaSoLuong(ChiTietHoaDon cthd1) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Sua so luong thanh:");
		double soluong = sc.nextDouble();
		cthd1.setSoluong(soluong);
		for(int i=0;i<dschitiethoadon.length;i++) 
			if( (cthd1.getMahoadon().equals(dschitiethoadon[i].getMahoadon()) )== true) 
				dschitiethoadon[i].setSoluong(cthd1.getSoluong());
	}
	
	public ChiTietHoaDon[] getChiTietHoaDon() {
		return dschitiethoadon;
	}
	
}
