from main import *
import urllib.request
import urllib
from bs4 import BeautifulSoup
import random
import json
import urllib.request
from activity import _search_API_
from slack.web.classes.blocks import *

def search_cafe():
    message = []
    name = []
    cafe_url = []
    category = []
    a = []
    # 여기에 함수를 구현해봅시다.
    url = "https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EA%B0%95%EB%82%A8%EC%97%AD+%EC%B9%B4%ED%8E%98"
    source_code = urllib.request.urlopen(url).read()
    soup = BeautifulSoup(source_code, "html.parser")
    for c_name in soup.find_all("span", class_="tit_inner"):
        name.append(c_name.find("a")["title"])
    for c_name in soup.find_all("span", class_="tit_inner"):
        cafe_url.append(c_name.find("a")["href"])
    for c_name in soup.find_all("span", class_="item"):
        category.append(c_name.get_text())
    for i, f_name in enumerate(soup.find_all("div", class_="thumb")):
        block3 = SectionBlock(
            text="추천 카페 : *" + name[i] + "*  /   " + category[i] + "\n자세히 보기(url) : " + cafe_url[i],
            accessory=ImageBlock(
                image_url=f_name.find("img")["src"],
                alt_text="No Photo"
            )
        )
        message.append(block3)

    # for i in range(len(name)):
    #     message.append(
    #         [a[i], SectionBlock(])

    n = random.sample(message, 1)
    return [n[0]]