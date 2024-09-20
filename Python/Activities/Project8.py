from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait, Select
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.keys import Keys

driver = webdriver.Firefox()
driver.maximize_window()

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

driver.find_element(By.LINK_TEXT, "Apply Leave").click()
driver.find_element(By.LINK_TEXT, "Apply Leave").click()

select = Select(driver.find_element(By.ID, "applyleave_txtLeaveType"))
select.select_by_value("1")

from_date = driver.find_element(By.ID, "applyleave_txtFromDate")
from_date.clear()
from_date_value = "2024-10-21"
from_date.send_keys(from_date_value)
from_date.send_keys(Keys.TAB)

to_date = driver.find_element(By.ID, "applyleave_txtToDate")
to_date.clear()
to_date_value = "2024-10-25"
to_date.send_keys(to_date_value)
to_date.send_keys(Keys.TAB)

driver.find_element(By.ID, "applyBtn").click()

driver.find_element(By.ID, "menu_leave_viewMyLeaveList").click()
driver.find_element(By.ID, "menu_leave_viewMyLeaveList").click()

cal_from_date = driver.find_element(By.ID, "calFromDate")
cal_from_date.clear()
cal_from_date.send_keys(from_date_value)
cal_from_date.send_keys(Keys.TAB)

cal_to_date = driver.find_element(By.ID, "calToDate")
cal_to_date.clear()
cal_to_date.send_keys(to_date_value)
cal_to_date.send_keys(Keys.TAB)

driver.find_element(By.ID, "btnSearch").click()

cell = driver.find_element(By.XPATH, "//table[@id='resultTable']/tbody/tr/td[1]")
cell_value = cell.text
assert cell_value == f"{from_date_value} to {to_date_value}"

driver.quit()