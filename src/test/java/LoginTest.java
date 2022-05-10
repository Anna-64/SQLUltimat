import Page.LoginPage;
import com.codeborne.selenide.Configuration;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
    @AfterAll
    static void deletingDataFromTheDb() {
        DataHelper.DeleteInfo.deletingData();
    }

    @Test
    public void shouldAuthorizationIsSuccessful() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999"); //Открыть приложение
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.VerificationCode.getAuthCode(authInfo);
        verificationPage.validVerify(verificationCode);
    }

}

