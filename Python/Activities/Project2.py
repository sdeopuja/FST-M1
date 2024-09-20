from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Firefox()  
driver.maximize_window()
driver.get('http://alchemy.hguy.co/orangehrm')
image = driver.find_element(By.XPATH, "//div[@id='divLogo']/img")
URL = image.get_attribute("src")
print("URL of the header image: "+ URL)

driver.quit()
