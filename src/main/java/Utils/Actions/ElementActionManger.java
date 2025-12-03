package Utils.Actions;

import Utils.Logs.LogsManager;
import Utils.WaitManger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementActionManger {
    private final WebDriver driver;
    private final WaitManger waitManger;

    public ElementActionManger(WebDriver driver) {
        this.driver = driver;
        this.waitManger = new WaitManger(driver);
    }

    // ✅ Wait until the page is completely loaded
    public void waitForPageToLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(d ->
                ((JavascriptExecutor) d)
                        .executeScript("return document.readyState")
                        .equals("complete"));

    }

    // ✅ Click method
    public ElementActionManger click(By locator) {
        waitForPageToLoad();
        waitManger.getFluentWait().until(d -> {
            int retries = 3;
            while (retries-- > 0) {
                try {
                    WebElement element = d.findElement(locator);
                    scrollToElementJS(locator);
                    element.click();
                    LogsManager.info("Clicked on element successfully: ", locator.toString());
                    waitForPageToLoad(); // if navigation happens
                    return true;
                } catch (StaleElementReferenceException e) {
                    LogsManager.warn("Stale element detected, retrying click: " + locator);

                } catch (ElementClickInterceptedException e) {
                    LogsManager.warn("Click intercepted, scrolling and retrying: " + locator);
                    scrollToElementJS(locator);

                } catch (Exception e) {
                    LogsManager.error("Failed to click element: " );
                    return false;
                }
            }
            return false;
        });
        return this;
    }


    // ✅ Send keys method
    public ElementActionManger type(By locator, String text) {
        waitForPageToLoad();
        waitManger.getFluentWait().until(d -> {
            int retries = 3;
            while (retries-- > 0) {
                try {
                    WebElement element = d.findElement(locator);
                    scrollToElementJS(locator);
                    element.clear();
                    element.sendKeys(text);
                    LogsManager.info("Typed into element successfully: ", text);
                    return true;
                } catch (StaleElementReferenceException e) {
                    LogsManager.warn("Stale element detected while typing, retrying: " + locator);

                } catch (ElementNotInteractableException e) {
                    LogsManager.warn("Element not interactable, retrying after scroll: " + locator);
                    scrollToElementJS(locator);

                } catch (Exception e) {
                    LogsManager.error("Failed to type into element: " );
                    return false;
                }
            }
            return false;
        });
        return this;
    }

    // ✅ Get text method
    public String getText(By locator) {
        waitForPageToLoad();
        return waitManger.getFluentWait().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                scrollToElementJS(locator);
                String text = element.getText();
                LogsManager.info("Retrieved text from element successfully: ", text);
                return !text.isEmpty() ? text : null;
            } catch (Exception e) {
                LogsManager.error("Failed to get text: " );
                return null;
            }
        });
    }

    // ✅ Scroll to element
    public ElementActionManger scrollToElement(By locator) {
        waitForPageToLoad();
        waitManger.getFluentWait().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                scrollToElementJS(locator);
                LogsManager.info("Scrolled to element successfully.", element.toString());
                return true;
            } catch (Exception e) {
                LogsManager.error("Failed to scroll: " );
                return false;
            }
        });
        return this;
    }

    // ✅ Scroll using JS
    public void scrollToElementJS(By locator) {
        ((JavascriptExecutor) driver)
                .executeScript("""
                        arguments[0].scrollIntoView({behavior:"auto",block:"center",inline:"center"});""",
                        findElement(locator));
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    // ✅ Upload file
    public ElementActionManger uploadFile(By locator, String filePath) {
        waitForPageToLoad();
        String absolutePath = System.getProperty("user.dir") + "/" + filePath;
        waitManger.getFluentWait().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                scrollToElementJS(locator);
                element.sendKeys(absolutePath);
                LogsManager.info("File uploaded successfully: ", absolutePath);
                return true;
            } catch (Exception e) {
                LogsManager.error("Failed to upload file: " );
                return false;
            }
        });
        return this;
    }

    // ✅ Select from dropdown
    public ElementActionManger selectFromDropDown(By locator, String option) {
        waitForPageToLoad();
        waitManger.getFluentWait().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                scrollToElementJS(locator);
                new Select(element).selectByVisibleText(option);
                LogsManager.info(option + " is selected successfully");
                waitForPageToLoad();
                return true;
            } catch (Exception e) {
                LogsManager.error("Failed to select dropdown: " );
                return false;
            }
        });
        return this;
    }

    // ✅ Hover method
    public ElementActionManger hover(By locator) {
        waitForPageToLoad();
        waitManger.getFluentWait().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                scrollToElementJS(locator);
                new Actions(d).moveToElement(element).perform();
                LogsManager.info("Hover on element done: ", locator.toString());
                return true;
            } catch (Exception e) {
                LogsManager.error("Failed to hover: " );
                return false;
            }
        });
        return this;
    }

    // ✅ Press ENTER key
    public ElementActionManger pressEnter(By locator) {
        waitForPageToLoad();
        waitManger.getFluentWait().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                scrollToElementJS(locator);
                element.click(); // focus
                new Actions(d).sendKeys(Keys.ENTER).perform();
                LogsManager.info("Pressed ENTER on element: " + locator);
                waitForPageToLoad();
                return true;
            } catch (Exception e) {
                LogsManager.error("Failed to press ENTER: " );
                return false;
            }
        });
        return this;
    }

    // ✅ Upload photo
    public ElementActionManger uploadPhoto(By locator, String photoPath) {
        waitForPageToLoad();
        waitManger.getFluentWait().until(d -> {
            try {
                String absolutePath = System.getProperty("user.dir") + "/" + photoPath;
                WebElement element = d.findElement(locator);
                scrollToElementJS(locator);
                element.sendKeys(absolutePath);
                LogsManager.info("Photo uploaded successfully: ", absolutePath);
                return true;
            } catch (Exception e) {
                LogsManager.error("Failed to upload photo: " + e.getMessage());
                return false;
            }
        });
        return this;
    }

    // ✅ Get alert text
    public String getAlertText() {
        waitForPageToLoad();
        return waitManger.getFluentWait().until(d -> {
            try {
                Alert alert = d.switchTo().alert();
                String alertText = alert.getText();
                LogsManager.info("Alert text retrieved successfully: ", alertText);
                return alertText;
            } catch (NoAlertPresentException e) {
                return null;
            } catch (Exception e) {
                LogsManager.error("Failed to get alert text: " );
                return null;
            }
        });
    }

    // ✅ Accept alert
    public ElementActionManger acceptAlert() {
        waitForPageToLoad();
        waitManger.getFluentWait().until(d -> {
            try {
                Alert alert = d.switchTo().alert();
                alert.accept();
                LogsManager.info("Alert accepted successfully.");
                waitForPageToLoad();
                return true;
            } catch (NoAlertPresentException e) {
                return false;
            } catch (Exception e) {
                LogsManager.error("Failed to accept alert: " );
                return false;
            }
        });
        return this;
    }
}
