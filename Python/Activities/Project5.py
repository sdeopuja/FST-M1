import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By
import logging
from selenium.webdriver.support.ui import WebDriverWait

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)

driver = webdriver.Firefox()
driver.maximize_window()
wait = WebDriverWait

driver.get("http://alchemy.hguy.co/orangehrm")
driver.find_element(By.ID, "txtUsername").send_keys("orange")
driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
driver.find_element(By.ID, "btnLogin").click()
logger.info("Clicked on login button")

text = driver.find_element(By.XPATH, "//div[@id='panel_draggable_1_0']/fieldset/legend").text
assert text, "Employee Distribution by Subunit"

driver.find_element(By.LINK_TEXT, "Assign Leave").click()
logger.info("User is navigated to Dashboard")

driver.find_element(By.XPATH, "//a[@id='menu_pim_viewMyDetails']").click
driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
logger.info("User is navigated to My Info page")

#driver.find_element(By.XPATH, "//div[@class='personalDetails']/div/h1")
driver.find_element(By.XPATH, "//input[@value='Edit']").click()
#wait.until(EC.visibility_of_element_located((By.ID, "personal_txtEmpMiddleName")))

edit_first_name = "Jill"
edit_last_name = "New"

first_name = driver.find_element(By.ID, "personal_txtEmpFirstName")
first_name.clear()
first_name.send_keys(edit_first_name)
logger.info(f"Edited firstName to {edit_first_name}")

last_name = driver.find_element(By.ID, "personal_txtEmpLastName")
last_name.clear()
last_name.send_keys(edit_last_name)
logger.info(f"Edited lastName to {edit_last_name}")

driver.find_element(By.ID, "personal_optGender_2").click()
driver.find_element(By.ID, "personal_cmbNation").send_keys("Canadian")
driver.find_element(By.XPATH, "//input[@value='Save']").click()
logger.info("Edited user information")

print(driver.find_element(By.ID, "personal_txtEmpFirstName").get_attribute("value"))
print(driver.find_element(By.ID, "personal_txtEmpLastName").get_attribute("value"))

driver.quit()