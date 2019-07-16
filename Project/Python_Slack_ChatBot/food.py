from main import *
import urllib.request
import random
import json
import os
import urllib.request
import urllib
from bs4 import BeautifulSoup
from PIL import Image
from activity import _search_API_
from slack.web.classes.blocks import *


def search_food():
    message = []
    name = []
    category = []
    food_url = []
    a = []
    # 여기에 함수를 구현해봅시다.
    for i in range(1, 2):
        url = "https://www.seeon.kr/hot/location/main.do?&upHpAreaId=&nO=" + str(i)
        source_code = urllib.request.urlopen(url).read()
        soup = BeautifulSoup(source_code, "html.parser")
        for f_name in soup.find_all("li", class_="place-item"):
            for food_name in f_name.find_all("span", class_="pltit"):
                name.append(food_name.find("a").get_text())
        for f_name in soup.find_all("li", class_="place-item"):
            for food_name in f_name.find_all("span", class_="plmsg"):
                category.append(food_name.get_text())
        for f_name in soup.find_all("li", class_="place-item"):
            for food_name in f_name.find_all("span", class_="pltit"):
                food_url.append("https://www.siksinhot.com" + food_name.find("a")["href"])
        for f_name in soup.find_all("div", class_="gridBox"):
            for idx, food_name in enumerate(f_name.find_all("div", class_="pthumbImg crop cropHeight")):
                url = food_name.find("img", class_="cropImg")["src"]
                block3 = SectionBlock(
                    text="",
                    accessory=ImageBlock(
                        image_url=url,
                        alt_text="No Text"
                    )
                )
                message.append(block3)
        # print(message)
    for i in range(len(name)):
        message[i].text = "추천 맛집 : *" + name[i] + "*  /  " + category[i] + "\n자세히 보기(url) : " + food_url[i]
    random.shuffle(message)
    return [message[0]]