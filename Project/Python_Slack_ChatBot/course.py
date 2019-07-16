import random
import json
import urllib.request
from activity import _search_API_
from slack.web.classes.blocks import *
import urllib
from bs4 import BeautifulSoup
from course import *
from movie import *
from food import *
from cafe import *
from main import *


def search_course():
    # 여기에 함수를 구현해봅시다.
    return "무엇을 하고 싶으신가요? (카페, 음식, 활동, 영화 : 중복 선택 가능)\n ex) @datebot 코스 카페 음식"


def make_course(text):
    courses = text.split()[1:]
    random.shuffle(courses)
    blocks = [SectionBlock(text="*다음과 같은 순서로 데이트를 해보는게 어떨까요?*")]
    for idx, course in enumerate(courses):
        if course == "영화":
            blocks.append(SectionBlock(text="*{}번째는 연인과 재미있는 영화 한번?*".format(idx + 1)))
            blocks.extend(search_movie())
        elif course == "음식":
            blocks.append(SectionBlock(text="*{}번째는 연인과 맛있는 식사를!!*".format(idx + 1)))
            blocks.extend(search_food())
        elif course == "활동":
            blocks.append(SectionBlock(text="*{}번째는 연인과 함께 하는 활동이라면 더 신나지 않을까요?*".format(idx + 1)))
            blocks.extend(_search_API_())
        elif course == "카페":
            blocks.append(SectionBlock(text="*{}번째는 분위기 좋은 카페에서 대화를!!*".format(idx + 1)))
            blocks.extend(search_cafe())
    return blocks