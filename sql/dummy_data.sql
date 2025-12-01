-- 더미 데이터 삽입
USE boardmanager;

-- 1. 회비 설정 초기값
INSERT INTO dues_settings (current_dues) VALUES (500000);

-- 2. 관리자 및 회원 계정
INSERT INTO users (username, password, student_id, name, age, gender, birth_date, role) VALUES

-- 관리자 (담당 교수) - 학번 없음
('admin', 'admin1234', NULL, '김교수', 45, '남', '1980-03-15', 'admin'),

-- 부장 - 2022년 입학
('president', 'pres1234', '2022001', '홍길동', 22, '남', '2003-05-20', 'president'),

-- 평회원
('member1', 'mem1234', '2021001', '김철수', 21, '남', '2004-08-10', 'member'),
('member2', 'mem1234', '2022002', '이영희', 20, '여', '2005-11-05', 'member'),
('member3', 'mem1234', '2019001', '박민수', 23, '남', '2002-07-18', 'member'),
('member4', 'mem1234', '2021002', '정수진', 21, '여', '2004-02-28', 'member'),
('member5', 'mem1234', '2022003', '최우식', 22, '남', '2003-09-30', 'member');

-- 3. 스케줄 예시
INSERT INTO schedules (schedule_date, location, member_count, description, participants, completed) VALUES
('2025-12-05', '학생회관 201호', 5, '보드게임 정기 모임', '김철수,이영희,박민수,정수진,최우식', FALSE),
('2025-12-10', '카페 투썸', 3, '임원진 회의', '홍길동,김철수,이영희', FALSE),
('2025-12-15', '학생회관', 6, '신입생 환영회', '홍길동,김철수,이영희,박민수,정수진,최우식', FALSE);

-- 4. 완료된 활동 내역 예시
INSERT INTO activities (activity_date, location, member_count, description, participants) VALUES
('2025-11-15', '학생회관', 5, '보드게임 정기 모임', '홍길동,김철수,이영희,박민수,정수진'),
('2025-11-20', '스터디 카페', 4, 'MT 준비 회의', '홍길동,김철수,이영희,박민수');

-- 5. 회비 사용 내역 예시
INSERT INTO dues (usage_date, location, representative, description, amount) VALUES
('2025-11-01', '보드게임 카페', '홍길동', '보드게임 구입 (카탄, 스플렌더)', 85000),
('2025-11-10', '문구점', '김철수', '회의용 다과 및 음료', 25000),
('2025-11-20', '인터넷 쇼핑몰', '이영희', '동아리 티셔츠 제작', 150000);

-- 확인
SELECT '더미 데이터 삽입 완료' AS result;
SELECT CONCAT('총 ', COUNT(*), '명의 회원이 등록되었습니다.') FROM users;
SELECT CONCAT('현재 회비: ', current_dues, '원') FROM dues_settings WHERE id = 1;
