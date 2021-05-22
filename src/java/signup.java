
import javax.faces.bean.ManagedBean;

@ManagedBean(name="signup")
public class signup {
    private String Email,Password,Cell_No,Address;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getCell_No() {
        return Cell_No;
    }

    public void setCell_No(String Cell_No) { 
        this.Cell_No = Cell_No;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    public void Sign_Up() {
        if(conn.Sign_Up(Email,Password,Cell_No,Address)){
            System.out.println("SignUp Done");
        }
        else{
            System.out.println("SignUp is fite munh");
            
        }
    }
    
    public void Login() {
        if(conn.Login(Email, Password)){
            System.out.println("Login Done");
        }
        else{
            System.out.println("Email or password is wrong");
        }
    }

}
