public class Validator {
    
    public void validate(int age) throws InvalidAgeException {
        if (age < 15 || age > 65){
            throw new InvalidAgeException("Age must be between 15 and 65.");
        }
    }

    public void validate(String contactNo, String email) throws InvalidContactInfoException{
        if (contactNo != null && !contactNo.matches("(09\\d{9})")){
            throw new InvalidContactInfoException("Contact number must be 11 digits and start with 09.");    
        } 
        
        if (email != null && !email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")){
            throw new InvalidContactInfoException("Invalid email format.");
        }
    }
}
