package vn.devpro.sale.cart;

import java.util.ArrayList;

public class ProductListManagement {
	private static ArrayList<ProductList> listProduct = new ArrayList<ProductList>();

	public static ArrayList<ProductList> getListProduct() {
		return listProduct;
	}

	public static void setListProduct(ArrayList<ProductList> listProduct) {
		ProductListManagement.listProduct = listProduct;
	}

	public static int findProductListById(int id, int idCart) {
		for (int i = 0; i < listProduct.size(); i++) {
			if (listProduct.get(i).getProductID() == id && listProduct.get(i).getCartID() == idCart) {
				return i;
			}
		}
		return -1;
	}

	public static ProductList getProductListByID(int id, int idCart) {
		for (ProductList x : listProduct) {
			if (x.getProductID() == id && x.getCartID() == idCart) {
				return x;
			}
		}
		return null;
	}
}
