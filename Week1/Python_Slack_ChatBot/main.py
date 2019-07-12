# -*- coding: utf-8 -*-
import urllib.request
import random
import json
import urllib.request

from config import *
from activity import _search_API_
from course import *
from movie import *
from food import *
from cafe import *
from flask import Flask
from slack import WebClient
from slackeventsapi import SlackEventAdapter
from slack.web.classes.blocks import *
from slack.web.classes import extract_json

app = Flask(__name__)
# /listening 으로 슬랙 이벤트를 받습니다.
slack_events_adaptor = SlackEventAdapter(SLACK_SIGNING_SECRET, "/listening", app)
slack_web_client = WebClient(token=SLACK_TOKEN)


# 크롤링 함수 구현하기
def _crawl_cafe_gangnam(text):
    text = " ".join(text.split()[1:])
    if "카페 추천" == text:
        return search_cafe()
    elif "음식 추천" == text:
        return search_food()
    elif "활동 추천" == text:
        return _search_API_()
    elif "영화 추천" == text:
        return search_movie()
    elif "코스 추천" == text:
        return search_course()
    elif text.startswith("코스") and not text.endswith("추천"):
        return make_course(text)
    else:
        return "@datebot [카페 추천|활동 추천|음식 추천|영화 추천|코스 추천]으로 입력해주세요!!"


# 챗봇이 멘션을 받았을 경우
@slack_events_adaptor.on("app_mention")
def app_mentioned(event_data):
    channel = event_data["event"]["channel"]
    text = event_data["event"]["text"]
    message = _crawl_cafe_gangnam(text)
    if not type(message) is str:
        slack_web_client.chat_postMessage(
            channel=channel,
            blocks=extract_json(message)
        )
    else:
        slack_web_client.chat_postMessage(
            channel=channel,
            text=message
        )


# / 로 접속하면 서버가 준비되었다고 알려줍니다.
@app.route("/", methods=["GET"])
def index():
    return "<h1>Server is ready.</h1>"


if __name__ == "__main__":
    app.run('0.0.0.0', port=707, debug=True)







