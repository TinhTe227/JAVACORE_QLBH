package vn.devpro.sale.cart;

import java.util.ArrayList;
import java.util.Scanner;

import vn.devpro.update.customer.CustomerManagement;
import vn.devpro.update.product.Product;
import vn.devpro.update.product.ProductManagement;



public class Cart {
	private int id;
	private int customerID;
	private ArrayList<Integer> listProduct;

	public static Scanner sc = new Scanner(System.in);

	public void display() {
		System.out.println("ID gio hang: " + this.id);
		System.out.println("ID khach hang: " + this.customerID);
		int index =CustomerManagement.findCustomerById(this.customerID);
		if (index == -1) {
			System.out.println("Khach hang khong co trong danh sach");
			return;
		}
		int stt = 1;

		System.out.println("\n--------------San pham co trong gio hang---------------");
		if (listProduct.size() == 0) {
			System.out.println("Gio hang chua co gi, them san pham vao gio");
			return;
		}
		System.out.printf("%3s %4s %-30s %9s %10s%n", "STT", "ID", "Ten san pham", "So luong", "Don gia");
		for (int i = 0; i < listProduct.size(); i++) {
			Product product = ProductManagement.getProductById(listProduct.get(i));
			ProductList productList = ProductListManagement.getProductListByID(listProduct.get(i), this.id);
			System.out.printf("%3d %4s %-30s %9s %10.2f%n", stt++, listProduct.get(i), product.getName(),
					productList.getAmount(), product.getPrice());
		}
		System.out.printf("\t\t\tTong tien phai thanh toan: %10.2f%n", this.tongTien());
	}


	public void update() {
		do {
			System.out.println("\n-----------Cap nhat gio hang-------------");
			System.out.println("\t1. Xem gio hang");
			System.out.println("\t2. Them san pham vao gio");
			System.out.println("\t3. Sua thong tin san pham trong gio");
			System.out.println("\t4. Xoa san pham khoi gio");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				display();
				break;
			case 2:
				addProduct();
				break;
			case 3:
				updateProduct();
				break;
			case 4:
				removeProduct();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le");
				break;
			}
		} while (true);
	}

	private void addProduct() {
		System.out.println("-----------Them san pham vao gio hang---------------");
		System.out.print("Nhap id san pham: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = ProductManagement.findProductById(id);
		if (index == -1) {
			System.out.println("San pham khong co trong danh sach");
			return;
		}
		Product x = ProductManagement.getProductById(id);
		int check = ProductListManagement.findProductListById(id, this.id);
		if (check != -1) {
			System.out.println("San pham da co trong danh sach");
			return;
		}
		System.out.print("Nhap so luong san pham: ");
		int amount = Integer.parseInt(sc.nextLine());

		if (amount > x.getAmount()) {
			System.out.println("Khong du san pham");
			return;
		}
		ProductListManagement.getListProduct().add(new ProductList(this.id, id, amount));
		listProduct.add(id);
		System.out.println("Them san pham vao gio thanh cong");

	}

	private void updateProduct() {
		System.out.println("--------------Sua thong tin san pham trong gio---------------");
		System.out.print("Nhap id san pham: ");
		int id = Integer.parseInt(sc.nextLine());
		Product x = ProductManagement.getProductById(id);
		int index = ProductListManagement.findProductListById(id, this.id);
		if (index == -1) {
			System.out.println("San pham chua co trong gio hang");
			return;
		}
		System.out.print("Nhap so luong san pham can sua: ");
		int amount = Integer.parseInt(sc.nextLine());
		if (amount > x.getAmount()) {
			System.out.println("Khong du so luong san pham");
			return;
		}
		ProductListManagement.getListProduct().get(index).setAmount(amount);
		System.out.println("Cap nhat so luong thanh cong");
	}

	private void removeProduct() {
		System.out.println("--------------Xoa san pham trong gio----------------------");
		System.out.print("Nhap id san pham: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = ProductListManagement.findProductListById(id, this.id);
		if (index == -1) {
			System.out.println("San pham chua co trong gio hang");
			return;
		}
		ProductListManagement.getListProduct().remove(index);
		listProduct.remove((Integer) id);
		System.out.println("Xoa san pham trong gio thanh cong");
	}
	
	public double tongTien() {
		double tongTien = 0;
		for (int i = 0; i < listProduct.size(); i++) {
			Product product = ProductManagement.getProductById(listProduct.get(i));
			ProductList productList = ProductListManagement.getProductListByID(listProduct.get(i), this.id);
			tongTien += productList.getAmount() * product.getPrice();
		}
		return tongTien;
	}

	public Cart() {
		super();
	}

	public Cart(int id, int customerID, ArrayList<Integer> listProduct) {
		super();
		this.id = id;
		this.customerID = customerID;
		this.listProduct = listProduct;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public ArrayList<Integer> getListProduct() {
		return listProduct;
	}

	public void setListProduct(ArrayList<Integer> listProduct) {
		this.listProduct = listProduct;
	}

}