package vn.devpro.sale.cart;

public class ProductList {
	private int cartID;
	private int productID;
	private int amount;

	public ProductList() {
		super();
	}

	public ProductList(int cartID, int productID, int amount) {
		super();
		this.cartID = cartID;
		this.productID = productID;
		this.amount = amount;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

}
