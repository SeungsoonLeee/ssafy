import json
import urllib.request
import random
import urllib
from config import *
from bs4 import BeautifulSoup
from slack.web.classes.blocks import *


def _search_API_():
    text = "강남역 놀거리"
    encText1 = urllib.parse.quote(text)
    url = "https://openapi.naver.com/v1/search/local.json"
    url += "?query=" + encText1 + "&display=30"

    request = urllib.request.Request(url)
    request.add_header("X-Naver-Client-Id", client_id)
    request.add_header("X-Naver-Client-Secret", client_secret)
    response = urllib.request.urlopen(request)
    rescode = response.getcode()

    if rescode == 200:
       response_body = response.read()
    else:
       print("Error Code:" + rescode)

    datas = json.loads(response_body.decode('utf-8'))
    print(datas)

    title = []
    link = []
    category = []
    description = []
    telephone = []
    roadAddress = []

    for data in datas['items']:
       title.append(data['title'].replace("<b>", "").replace("</b>", ""))
       link.append(data['link'].replace("<b>", "").replace("</b>", ""))
       category.append(data['category'].replace("<b>", "").replace("</b>", ""))
       description.append(data['description'].replace("<b>", "").replace("</b>", ""))
       telephone.append(data['telephone'].replace("<b>", "").replace("</b>", ""))
       roadAddress.append(data['roadAddress'].replace("<b>", "").replace("</b>", ""))

    contents = []
    for n in range(len(title)):
       contents.append("*%s*\n설명 : %s\n위치 : %s\n연락처 : %s\n링크 : %s" % (title[n], description[n], roadAddress[n], telephone[n], link[n]))

    blocks = []

    n = random.sample(contents, 1)

    blocks.append(SectionBlock(text=n[0]))

    # 한글 지원을 위해 앞에 unicode u를 붙혀준다.
    # 키워드 리스트를 문자열로 만듭니다.
    return blocks