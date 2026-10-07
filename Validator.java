public class Validator {
    private int age;
    private String contactNo;
    private String email;
    
    public void validate(int age, String contactNo, String email) throws InvalidAgeException, InvalidContactInfoException {
        if (age < 15 || age > 65){
            throw new InvalidAgeException("Age must be between 15 and 65.");
        }

        if (contactNo != null && !contactNo.matches("(09\\d{9}")){
            throw new InvalidContactInfoException("Contact number must be 11 digits and start with 09.");    
        } 
        
        if (email != null && !email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")){
            throw new InvalidContactInfoException("Invalid email format.");
        }
    }
}
