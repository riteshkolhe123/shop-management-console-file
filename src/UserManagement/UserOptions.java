package UserManagement;

public class UserOptions {
	enum Useroption{
		ADD_USER(1),
		EDIT_USER(2),
		SEARCH_USER(3),
		DELETE_USER(4),
		QUIT(5);
		
		public final int options;
		Useroption(int options){
			this.options = options;
		}
	}

}