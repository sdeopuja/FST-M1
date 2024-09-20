from selenium import webdriver
from selenium.webdriver.common.by import By
import logging

logging.basicConfig(level=logging.DEBUG, format='%(asctime)s - %(levelname)s - %(message)s')

driver = webdriver.Firefox()  
driver.maximize_window()

driver.get("http://alchemy.hguy.co/orangehrm")
driver.find_element(By.ID, "txtUsername").send_keys("orange")
driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
driver.find_element(By.ID, "btnLogin").click()
logging.info("Clicked on login button")
dashboard = driver.find_element(By.XPATH, "//div[@class='head']/h1").text
assert dashboard, "Dashboard"
logging.info("User is navigated to Home page")
driver.quit()
