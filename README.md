# Quicklog

## 개요

Quicklog는 포스팅을 처음 시작하는 분들이나 어떻게 포스팅을 이어갈까 고민이 많으신 분들께 **쉽고 빠른 포스팅**을 위하여 AI를 이용하여 **다음 문장과 썸네일 이미지 등을 추천**해주는 서비스입니다.


## Table of Contents

- [1. 기획 및 설계](#1-기획-및-설계)
  - [1.1. 아이디어 배경 및 일정](#11-아이디어-배경-및-일정)
  - [1.2. UI 설계](#12-UI-설계)
  - [1.3. ERD 설계](#13-ERD-설계)
  - [1.4. 기술스택](#14-기술스택)
- [2. 주요 기능](#2-주요-기능)
  - [2.1. 포스팅 다음 문장 추천](#21-포스팅-다음-문장-추천)
  - [2.2. 썸네일 이미지 추천](#22-썸네일-이미지-추천)
  - [2.3. 포스팅](#23-포스팅)
  - [2.4. 피드](#24-포스팅)
  - [2.5. 인증](#25-인증)
- [3. CI/CD 구성 및 Commit Convention](#3-CI/CD-구성-및-Commit-Convention)
- [4. API Server](#4-API-Server)
  - [4.1. API Documentation](#41-API-Documentation)
  - [4.2. API Server Interaction](#42-API-Server-Interaction)


## 1. 기획 및 설계

### 1.1. 아이디어 배경 및 일정

Side Job이나 취미로 블로거들이 증가하고 있는 만큼 주로 유입되는 사람들을 위해 포스팅에 도움을 주고자 **Quicklog**를 기획하게 되었습니다.

#### 🗓️ 일정

| 날짜 |  할 일 | 진행 상황 | 특이사항/기타 | 파일/URL |  |
| --- | --- | --- | --- | --- | --- |
|  | 기능 나열 / 프로젝트 이름 정하기 | 완료 | |  |  |
| ~8월 18일 | UI 설계 + 기능 확정 | 완료 | |  |  |
| 8월 22일 |  Github Actions, AWS 환경 구성 | 완료 | |  |  |
| 8월 23일 | 기술 스택, IDE, Tool 선정
Prompter AI 계획 설정 및 UI 구성 | 완료 |  |  |  |
| 8월 24일 ~ 9월 1일 | AI 포스팅 자동완성 기능 개발 | 완료 | |  |  |
| 9월 6일 | API 명세서, 테이블 명세서 설계 | 완료 |  | https://www.erdcloud.com/d/98F2JeZYX75FFcuTy |  |
|  | 깃헙 커밋 + 코드 컨벤션, | 완료 |  |  |  |
| ~9월 10일 | Docker 환경 구성 |  |  |  |  |
| ~11월 12일 | 개발 진행~~ | 완료  | 
| ~11월 15일 | 마무리 | 완  |  |  |  |

### 1.2. UI 설계

**[Figma를 이용한 UI 설계]** (https://www.figma.com/file/AEBYNgoZTLpXZylWXUCtIq/ChatGPT-Blog?type=design&node-id=0%3A1&mode=design&t=XwpecIqyqgKWTS0E-1)

### 1.3. ERD 설계
<img src="https://github.com/ssafyteam/ssafy-toy-project/assets/71087271/df80f7ea-2d83-401e-bd6c-d5d419e26501">

### 1.4 기술 스택
<img src="https://github.com/ssafyteam/ssafy-toy-project/assets/71087271/a8347b52-8396-4474-848e-02b3ca0db76f">

## 2. 주요 기능

### 2.1. 포스팅 다음 문장 추천
- **특징**:
  - model: gpt-3.5-turbo
  - temperature: 0.5
  - max_tokens: 1000
- **설명**: 작성 중인 포스팅 내용과 사용자가 직전에 입력한 문장을 기반으로 다음 문장 추천

<br>
<img width="660" alt="image" src="https://github.com/ssafyteam/ssafy-toy-project/assets/71087271/8988ce42-ab7c-46bd-ab52-ed31bba8b013">
</br>

### 2.2. 썸네일 이미지 추천
- **특징**:
  - model: Dalle
- **설명**: 작성한 포스팅 내용이나 사용자의 키워드 입력에 따라 이미지 추천
  
### 2.3. 포스팅
- **설명**:
  - 포스팅 시, 태그와 카테고리 추가 가능하므로 글 분류를 자세히 할 수 있음
  - 글 공개, 비공개 설정 가능
  - 다음 문장 및 이미지 추천 기능이 포함되어 있음
    
### 2.4. 피드
- **설명**:
  - 전체 포스팅 글 소개
  - 내 피드 조회
  - Pagination 구현
    
### 2.5. 인증

#### 1) JWT Pipeline

<br>
<img src="https://github.com/ssafyteam/ssafy-toy-project/assets/71087271/43e93f63-53e9-4c56-bbc5-582bbe0a2388">
</br>

#### 2) OAuth2.0

<br>
<img src="https://github.com/ssafyteam/ssafy-toy-project/assets/71087271/59871c14-0197-4a31-8c16-b254db4797cb">
</br>

## 3. CI/CD 구성 및 Commit Convention

### 3.1. CI/CD Pipeline
<img src="https://github.com/ssafyteam/ssafy-toy-project/assets/71087271/f6c14b2a-156d-49c4-a2a9-438dda13de39">

### 3.2. Commit Convention
|이모지|태그|설명|
|:---:|:---:|:---:|
|sparkles|:sparkles: Feat:|새로운 기능을 추가하는 경우|
|zap|:zap: Update:|코드를 변경한 경우|
|fire|:fire: Remove:|코드나 파일을 삭제한 경우|
|bug|:bug: Fix:|버그를 고친 경우|
|memo|:memo: Docs:|문서를 수정한 경우|
|speech_ballon|:speech_balloon: Comment:|필요한 주석 추가 및 변경|
|twisted_rightwards_arrows|:twisted_rightwards_arrows: Merge:|브랜치 합병|
|lipstick|:lipstick: Design:|UI 디자인 변경|
|white_check_mark|:white_check_mark: Test:|테스트 추가, 테스트 리팩토링|

## 4. API Server

### 4.1. API Documentation
- Swagger를 통한 REST API 문서화
<img src="https://github.com/ssafyteam/ssafy-toy-project/assets/71087271/c4aa9557-f9c7-4386-b450-cec288cad391">
<br>
<img src="https://github.com/ssafyteam/ssafy-toy-project/assets/71087271/acd00a06-0b59-405e-9251-597825503321">
</br>

### 4.2. API Server Interaction

<img src="https://github.com/ssafyteam/ssafy-toy-project/assets/71087271/23cecfac-131c-4553-9b40-92cbfb81afff">
