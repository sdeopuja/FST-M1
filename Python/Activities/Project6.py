from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException
import logging

driver = webdriver.Firefox()
driver.get("http://alchemy.hguy.co/orangehrm")

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger()

driver.find_element(By.ID, "txtUsername").send_keys("orange")
driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
driver.find_element(By.ID, "btnLogin").click()
logger.info("Clicked on login button")

wait = WebDriverWait(driver, 10)

text = driver.find_element(By.XPATH, "//div[@id='panel_draggable_1_0']/fieldset/legend").text
assert text == "Employee Distribution by Subunit", "Expected 'Employee Distribution by Subunit', but got '{text}'"

element = driver.find_element(By.LINK_TEXT, "Assign Leave")
element.click()
logger.info("User is navigated to Dashboard")

element = driver.find_element(By.XPATH, "//a[@id='menu_directory_viewDirectory']")
element.click()

heading = driver.find_element(By.XPATH, "//div[@class='head']").text
assert heading == "Search Directory", "Expected 'Search Directory', but got '{heading}'"

driver.quit()
