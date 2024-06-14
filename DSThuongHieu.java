package DienThoai;

import java.util.Arrays;
import java.util.Scanner;

public class DSThuongHieu {
	private ThuongHieu dsth[] = new ThuongHieu[1];
	private int n;
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so luong thuong hieu:");
		n = sc.nextInt();
		dsth = new ThuongHieu[n];
		for(int i=0;i<n;i++) {
			dsth[i] = new ThuongHieu();
			dsth[i].nhap();
		}
	}
	public void xuat() {
		for(int i=0;i<dsth.length;i++) {
			dsth[i].xuat();
		}
	}
	public void them() {
		n = dsth.length;
		dsth = Arrays.copyOf(dsth,n+1);
		dsth[n] = new ThuongHieu();
		dsth[n].nhap();
//		n++;
	}
	
	public void them(ThuongHieu x) {
		n= dsth.length;
		dsth = Arrays.copyOf(dsth,n+1);
		dsth[n] = new ThuongHieu(x);
//		n++;
	}
	public void xoa () {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma thuong hieu can xoa");
		String mathuonghieu = sc.nextLine();
		int pos = 0,check = 0;
		for(int i=0;i<dsth.length;i++) {
			if( (mathuonghieu.equals(dsth[i].getMathuonghieu()) )== true) {
				pos = i;
				check = 1;
				break;
			}
		}
		if(check == 1 ) xoa(mathuonghieu,pos);
		else  System.out.println("Khong tim thay ma thuong hieu");
		
	}
	public void xoa (String mathuonghieu,int p) {
		for(int i=p;i < dsth.length-1;i++)
			dsth[i] = dsth[i+1];
		dsth = Arrays.copyOf(dsth, dsth.length -1);
		n--;
	}
	
	public void suaTenThuongHieu(ThuongHieu th1) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Sua ten thuong hieu thanh:");
		String tenthuonghieu = sc.nextLine();
		th1.setTenthuonghieu(tenthuonghieu);
		for(int i=0;i<dsth.length;i++) 
			if( (th1.getMathuonghieu().equals(dsth[i].getMathuonghieu()) )== true) 
				dsth[i].setTenthuonghieu(th1.getTenthuonghieu());
	}
	
	public void suaQuocGia(ThuongHieu th1) {
	}
}
