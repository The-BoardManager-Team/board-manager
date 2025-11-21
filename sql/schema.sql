-- 데이터베이스 생성
CREATE DATABASE IF NOT EXISTS boardmanager
DEFAULT CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE boardmanager;

-- 1. 사용자 (users) 테이블
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL COMMENT '로그인 아이디',
    password VARCHAR(255) NOT NULL COMMENT '비밀번호 (평문)',
    student_id VARCHAR(20) COMMENT '학번',
    name VARCHAR(50) NOT NULL COMMENT '이름',
    age INT COMMENT '나이',
    gender ENUM('남', '여') COMMENT '성별',
    birth_date DATE COMMENT '생년월일',
    role ENUM('admin', 'president', 'member') DEFAULT 'member' NOT NULL COMMENT '권한',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '가입일',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일',
    INDEX idx_username (username),-- username을 빠르게 찾기 위한 index 추가. 
    INDEX idx_role (role)
) COMMENT='회원 정보'; 

-- 2. 스케줄 (schedules) 테이블
CREATE TABLE schedules (
    id INT PRIMARY KEY AUTO_INCREMENT,
    schedule_date DATE NOT NULL COMMENT '일정 날짜',
    location VARCHAR(100) COMMENT '장소',
    member_count INT DEFAULT 0 COMMENT '참가 인원 수',
    description TEXT NOT NULL COMMENT '활동 내용',
    participants TEXT COMMENT '참가자 명단 (쉼표 구분)',
    completed BOOLEAN DEFAULT FALSE COMMENT '완료 여부',
    created_by VARCHAR(50) COMMENT '등록자',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '등록일',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일',
    INDEX idx_schedule_date (schedule_date),
    INDEX idx_completed (completed)
) COMMENT='스케줄 관리';

-- 3. 활동 내역 (activities) 테이블
CREATE TABLE activities (
    id INT PRIMARY KEY AUTO_INCREMENT,
    activity_date DATE NOT NULL COMMENT '활동 날짜',
    location VARCHAR(100) COMMENT '장소',
    member_count INT DEFAULT 0 COMMENT '참가 인원 수',
    description TEXT NOT NULL COMMENT '활동 내용',
    participants TEXT COMMENT '참가자 명단 (쉼표 구분)',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '등록일',
    INDEX idx_activity_date (activity_date)
) COMMENT='완료된 활동 내역';

-- 4. 회비 관리 (dues) 테이블
CREATE TABLE dues (
    id INT PRIMARY KEY AUTO_INCREMENT,
    usage_date DATE NOT NULL COMMENT '사용 날짜',
    location VARCHAR(100) COMMENT '사용 장소',
    representative VARCHAR(50) COMMENT '대표자 이름',
    description TEXT NOT NULL COMMENT '사용 내용',
    amount INT NOT NULL COMMENT '사용 금액',
    created_by VARCHAR(50) COMMENT '등록자',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '등록일',
    INDEX idx_usage_date (usage_date)
) COMMENT='회비 사용 내역';

-- 5. 현재 회비 테이블 
CREATE TABLE dues_settings (
    id INT PRIMARY KEY AUTO_INCREMENT,
    current_dues INT NOT NULL COMMENT '현재 총 회비',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일'
) COMMENT='회비 설정';
