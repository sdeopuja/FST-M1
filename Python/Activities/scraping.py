import requests
from bs4 import BeautifulSoup


res = requests.get("https://training-support.net/Table")
content = res.content

soup = BeautifulSoup(content,"html.parser")

table = soup.find("table")

for tr in table