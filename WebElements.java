package Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class WebElements {

    @FindBy(xpath = "//button[text()='Get Started']")
    private WebElement GetStarted;

    @FindBy(xpath = "//button[text()='Already have an account? Click here to sign in.']")
    private WebElement AlreadyAccount;

    @FindBys({
            @FindBy(id = "outlined-basic")
    })
    private List<WebElement> CredentialsFields;

    @FindBy(xpath = "//button[text()='Sign In']")
    private WebElement SignIn;

    @FindBy(xpath = "//h2[text()='Onboard OCN Node']")
    private WebElement Onboard;

    @FindBys({
            @FindBy(xpath = "//div[contains(@class,'MuiInputBase-root')]/input")
    })
    private List<WebElement> OCNNodeIDCredentials;

    @FindBy(xpath = "//button[text()='+ Add Node ']")
    private WebElement AddNode;

    @FindBy(xpath = "//button[text()='Next']")
    private WebElement Next;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement Submit;

    @FindBy(xpath = "//h2[text()='Launch OCN Child Network']")
    private WebElement LaunchOCN;

    public WebElement getGetStarted() {
        return GetStarted;
    }

    public WebElement getAlreadyAccount() {
        return AlreadyAccount;
    }

    public List<WebElement> getCredentialsFields() {
        return CredentialsFields;
    }

    public WebElement getSignIn() {
        return SignIn;
    }

    public WebElement getOnboard() {
        return Onboard;
    }

    public List<WebElement> getOCNNodeIDCredentials(){
        return OCNNodeIDCredentials;
    }

    public WebElement getAddNode() {
        return AddNode;
    }

    public WebElement getNext(){
        return Next;
    }

    public WebElement getSubmit(){
        return Submit;
    }

    public WebElement getLaunchOCN(){
        return LaunchOCN;
    }

}
