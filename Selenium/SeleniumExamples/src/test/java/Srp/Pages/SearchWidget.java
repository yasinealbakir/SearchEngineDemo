package Srp.Pages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SearchWidget extends AbstractComponent {
    @FindBy(name = "q")
    private WebElement searchBox;

    public SearchWidget(final WebDriver driver) {
        super(driver);
    }

    public void enter(String keyword) {
        this.searchBox.clear();
        for (char ch : keyword.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(200, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(String.valueOf(ch));
        }
    }

    @Override
    public boolean isDisplayed() {
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        return this.wait.until((drv) -> this.searchBox.isDisplayed());
    }
}
