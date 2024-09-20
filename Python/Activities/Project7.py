from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.keys import Keys

driver = webdriver.Chrome()

driver.get("http://alchemy.hguy.co/orangehrm")

driver.find_element(By.ID, "txtUsername").send_keys("orange")
driver.find_element(By.ID, "txtPassword").send_keys("orangepassword123")
driver.find_element(By.ID, "btnLogin").click()
print("Clicked on login button")

text = driver.find_element(By.XPATH, "//div[@id='panel_draggable_1_0']/fieldset/legend").text
assert text == "Employee Distribution by Subunit"
print("User is navigated to Dashboard")

wait = WebDriverWait(driver, 10)
wait.until(EC.element_to_be_clickable((By.LINK_TEXT, "Assign Leave")))

wait.until(EC.element_to_be_clickable((By.XPATH, "//a[@id='menu_pim_viewMyDetails']")))
driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
print("User is navigated to My Info page")

driver.find_element(By.LINK_TEXT, "Qualifications").click()
driver.find_element(By.ID, "addWorkExperience").click()

driver.find_element(By.ID, "experience_employer").send_keys("IBM")
driver.find_element(By.ID, "experience_jobtitle").send_keys("Test Specialist")
driver.find_element(By.ID, "btnWorkExpSave").click()

print("Completed")
driver.quit()
