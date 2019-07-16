# -*- coding: utf-8 -*-
import random
import json
import urllib.request
from activity import _search_API_
from slack.web.classes.blocks import *
import urllib
from bs4 import BeautifulSoup
from main import *


# 크롤링 함수 구현하기
def search_movie():
    # message = SectionBlock(text="현재 강남역 주변 영화관 메가박스의 상영 중인 작품들은 다음과 같습니다.")
    url = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&qu" \
          "ery=%EB%A9%94%EA%B0%80%EB%B0%95%EC%8A%A4+%EA%B0%95%EB%82%A8&oquery=%EB%A" \
          "9%94%EA%B0%80%EB%B0%95%EC%8A%A4&tqi=UfjTNdp0Jy0ssjpgoGNssssstZs-073120"
    source_code = urllib.request.urlopen(url).read()
    soup = BeautifulSoup(source_code, "html.parser")
    blocks = []
    for i, tr in enumerate(soup.find("tbody", class_="_wrap_time_table").find_all("tr")):
        a_tag = tr.find("a")
        info_url = a_tag["href"]
        source_code = urllib.request.urlopen(info_url).read()
        info_soup = BeautifulSoup(source_code, "html.parser")
        scores = []
        for idx, star in enumerate(info_soup.find("div", class_="wide_info_area").find_all("div", class_="star_score")):
            if idx < 3:
                scores.append("".join(map(lambda em: em.get_text(), star.find_all("em"))))
        for idx, score in enumerate(scores):
            if score is "":
                scores[idx] = "없음"
        genres = []
        for a in info_soup.find("dl", class_="info_spec").find_all("a"):
            if "genre" in a["href"]:
                genres.append("# " + a.get_text())
        score = "관람객 평점: " + scores[0] + ", 기자 및 평론가 평점: " + scores[1] + ", 네티즌 평점: " + scores[2]
        img = info_soup.find("div", class_="poster").find("img")["src"]
        # blocks.append([SectionBlock(text="{}\n".format(a_tag["title"])),
        #                ImageBlock(image_url=img, alt_text="이미지가 없네요ㅜㅜ"),
        #                SectionBlock(),
        #                SectionBlock(text=score),
        #                SectionBlock(text=])
        blocks.append(SectionBlock(text="*{}*\n".format(a_tag["title"]) + "\n" + " ".join(genres) + "\n" + score + "\n" + "More Information: {}".format(info_url),
                                   accessory=ImageBlock(image_url=img, alt_text="이미지가 없네요ㅜㅜ")))
    n = random.sample(blocks, 1)
    return [n[0]]