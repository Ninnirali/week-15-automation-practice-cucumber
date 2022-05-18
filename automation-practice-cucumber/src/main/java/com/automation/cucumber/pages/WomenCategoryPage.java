package com.automation.cucumber.pages;

import com.automation.cucumber.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenCategoryPage extends Utility {

    private static final Logger log = LogManager.getLogger(WomenCategoryPage.class.getName());

    public WomenCategoryPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Women']")
    WebElement verifyWomenWord;

    @CacheLookup
    @FindBy(id = "group_1")
    WebElement selectSize;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Add to cart']")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
    WebElement confirmationText;

    @CacheLookup
    @FindBy(xpath = "//span[@title='Close window']")
    WebElement closeWindow;

    @CacheLookup
    @FindBy(xpath = "//input[@id='quantity_wanted']")
    WebElement qtyfield;

    @CacheLookup
    @FindBy(xpath = "//div[@class='layer_cart_product col-xs-12 col-md-6']")
    WebElement popUpBlock;

    public String verifyWomenText() {
         log.info("verify Women text" + verifyWomenWord.toString()+ "<br>");
        return getTextFromElement(verifyWomenWord);
    }

    public void setSelectProduct(String product) {
        log.info(" click on the product ' "+ product + " '"+ "<br>");
        clickOnElement(By.xpath("//a[normalize-space()='" + product + "']"));
    }

    public void enterQty(String quantity) {
        qtyfield.clear();
        log.info(" enter qty ' " + quantity + " '  into the" + qtyfield.toString() + "<br>");
        sendTextToElement(qtyfield, quantity);
    }

    public void setSelectSize(String size) {
         log.info(" select size ' " + size + " '" + "<br>");
        selectByVisibleTextFromDropDown(selectSize, size);
    }

    public void setSelectColour(String colour) {
        log.info(" select colour ' " + colour + " ' " + "<br>");
        clickOnElement(By.xpath("//a[@title='" + colour + "']"));
    }

    public void setAddToCartButton() {
       log.info("click on add to cart button" + addToCartButton.toString()+ "<br>"); 
        clickOnElement(addToCartButton);
    }

    public boolean verifyThatPopUpIsDisplayed() {
        waitUntilVisibilityOfElementLocated(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']"), 20);
        log.info("verify that pop up is displayed " + popUpBlock.toString() + "<br>");
        return popUpBlock.isDisplayed();
    }

    public String setConfirmationText() {
          log.info("get confirmation text" + confirmationText.toString()+ "<br>");
        return confirmationText.getText();
    }

    public void setCloseWindow() {
        log.info(" clicking to close the window " + closeWindow.toString() + "<br>");
        clickOnElement(closeWindow);
    }
}
