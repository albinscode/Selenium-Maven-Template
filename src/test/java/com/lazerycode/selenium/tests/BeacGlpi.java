package com.lazerycode.selenium.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.util.Query;

public class BeacGlpi extends DriverBase {
	
    @Test
    public void glpiExample() throws Exception {
        RemoteWebDriver driver = getDriver();

        // ouverture de la page GLPI
        driver.get("http://172.20.160.139/support/");
        
        // on remplit le formulaire
        new Query(By.id("login_name"), driver).findWebElement().sendKeys("post-only");
        new Query(By.id("login_password"), driver).findWebElement().sendKeys("111111");
        
        // on poste le formulaire
        new Query(By.name("submit"), driver).findWebElement().submit();

        WebDriverWait wait = new WebDriverWait(driver, 10, 100);
        wait.until(pageTitleStartsWith("LOGone - interface"));

        //driver.get("http://172.20.160.139/support/front/ticket.php");

        
    }

    private ExpectedCondition<Boolean> pageTitleStartsWith(final String searchString) {
        return driver -> driver.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
    }

    
}
