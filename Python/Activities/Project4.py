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

driver.set_page_load_timeout(15)
driver.find_element(By.ID, "menu_pim_viewPimModule").click()
driver.find_element(By.ID, "menu_pim_viewPimModule").click()
employee_information = driver.find_element(By.XPATH, "//div[@class='head']/h1").text
assert employee_information, "Employee Information"
driver.find_element(By.XPATH, "//input[@id='btnAdd']").click()
logging.info("Adding new employee details")

first_name = "Robert"
last_name = "Junior"
driver.find_element(By.ID, "firstName").send_keys(first_name)
driver.find_element(By.ID, "lastName").send_keys(last_name)
employee_id = driver.find_element(By.ID, "employeeId").get_attribute("value")
driver.find_element(By.ID, "btnSave").click()
personal_information = driver.find_element(By.XPATH, "//div[@class='head']/h1").text
assert personal_information, "Personal Details"
logging.info("Added a new employee")

driver.find_element(By.ID, "menu_pim_viewPimModule").click()
driver.find_element(By.ID, "empsearch_employee_name_empName").send_keys(f"{first_name} {last_name}")
driver.find_element(By.ID, "searchBtn").click()

result_id = driver.find_element(By.XPATH, "//td[@class='left']/a").text
assert result_id, employee_id
logging.info("Employee added successfully with details as follows: ID={employee_id}, First Name={first_name}, Last Name={last_name}")

driver.quit()

