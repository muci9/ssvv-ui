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

    @FindBy(id = "my_cart")
    private WebElementFacade myCart;

    public void enter_keywords(String term) {
        searchBox.type(term);
    }

    public void lookup_terms() {
        searchBoxSubmit.click();
    }

    public List<String> getSearchResultsTitles() {
        WebElementFacade titlesGrid = find(By.id("card_grid"));
        return titlesGrid.findElements(By.className("card-item")).stream()
                .map(WebElement::getText)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    public void add_to_cart() {
        WebElementFacade resultList = find(By.id("card_grid"));

        resultList.find(By.className("card-footer")).find(By.tagName("form")).submit();
    }

    public String get_cart_item_title() {
        return find(By.cssSelector(".main-product-title-container .main-product-title")).getText();
    }



}
