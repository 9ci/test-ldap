public class Person {
	Long id
	String username
	String password
	String name
	//String mail	= 'joe@example.com'

	static mapping = {
		table 'Users'
	}
}
