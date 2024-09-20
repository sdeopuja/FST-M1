from selenium import webdriver

driver = webdriver.Firefox()  
driver.maximize_window()
driver.get('http://alchemy.hguy.co/orangehrm')

title = driver.title

if title == "OrangeHRM":
        print("Title matches!")
else:
        print(f"Title does not match. Found: {title}")

driver.quit()
