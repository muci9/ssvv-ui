package com.ssvv.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@DefaultUrl("https://www.emag.ro/")
public class EmagPage extends PageObject {

    @FindBy(id = "searchboxTrigger")
    private WebElementFacade searchBox;

    @FindBy(className = "searchbox-submit-button")
    private WebElementFacade searchBoxSubmit;

    @FindBy(className = "btn btn-sm btn-primary btn-emag")
    private WebElementFacade addToCartButton;

    @FindBy(xpath = "/html/body/div[11]/div/div/div[2]/div/div[3]/a")
    private WebElementFacade cartDetailsButton;

    public void enter_keywords(String term) {
        searchBox.type(term);
    }

    public void lookup_terms() {
        searchBoxSubmit.click();
    }

    public List<String> getSearchResultsTitles() {
        try {
            WebElementFacade titlesGrid = find(By.id("card_grid"));
            return titlesGrid.findElements(By.className("card-item")).stream()
                    .map(WebElement::getText)
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());
        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    public void filter_by_brand(String brand) {
        Select brandSelect = new Select(super.getDriver().findElement(By.cssSelector("select[data-name='Brand']")));
        brandSelect.selectByVisibleText(brand);
    }



}
