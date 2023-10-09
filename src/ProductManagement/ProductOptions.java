package ProductManagement;


public class ProductOptions {
	enum Productoption{
		ADD_PRODUCT(1),
		EDIT_PRODUCT(2),
		DELETE_PRODUCT(3),
		SEARCH_PRODUCT(4),
		QUIT(5);
		
		public final int options;
		Productoption(int options){
			this.options = options;
		}
	}

}